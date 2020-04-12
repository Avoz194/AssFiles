public class BacktrackingBST implements Backtrack, ADTSet<BacktrackingBST.Node> {
    private Stack stack;
    private Stack redoStack;
    BacktrackingBST.Node root = null;
    private boolean redoDone;

    // Do not change the constructor's signature
    public BacktrackingBST(Stack stack, Stack redoStack) {
        this.stack = stack;
        this.redoStack = redoStack;
        this.redoDone = false;
    }

    public Node getRoot() {
        return root;
    }

    public Node search(int x) {
        Node curr = root;
        while ((curr != null) && (curr.key != x)) {
            if (x < curr.key) { // the requested node is in the left sub tree
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null)
            return null;
        return curr;
    }

    public void insert(BacktrackingBST.Node z) {
        Node prev = null;
        Node curr = root;
        while (curr != null) {
            prev = curr;
            if (z.key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        z.parent = prev;
        if (prev == null) { // if the tree is empty
            root = z;
        } else if (z.key < prev.key) { // z should be prev left son
            prev.left = z;
        } else {
            prev.right = z;
        }
        stack.push(new BSTTrackingData(z, null, null, prev, null, 'i'));
        if (!redoDone)
            redoStack.clear();
        else
            redoDone = false;
    }

    public void delete(Node x) {
        /*
        Case 1 - x is a leaf - no children;
        Case 2 - x has 1 child;
        Case 3 - x has 2 children;
         */
        if (!redoDone)
            redoStack.clear();
        else
            redoDone = false;
        BSTTrackingData log = new BSTTrackingData(x, x.left, x.right, x.parent, null, 'd');
        Boolean isRoot = x == root;
        Node toRemove = x;
        Node y = null;
        if (x.left != null & x.right != null) {
            /*Case 3 part A - toRemove to point on it's successor.
             We'll remove the successor and later place it in x's position in the tree;
             We'll use Cases 1 or 2 to remove the successor from the tree.
             (Please note that in case option 3 is relevant, 'toRemove' parameter in the code for Cases 1 and 2 will actually point on the successor.)
             */
            y = successor(x);
            toRemove = y;
            log.setSuccParent(y.parent);
        }
        stack.push(log);
        if (toRemove.left != null | toRemove.right != null) { //Cases 1+2, if both null, 'Child' will remain null and we'll update the parent accordingly
            Node Child = null;
            if (toRemove.left != null) {
                Child = toRemove.left;
            } else if (toRemove.right != null) {
                Child = toRemove.right;
            } else if (toRemove == root & y == null) //in case there is no child and toRemove is the root, set root to null;
                root = null;
            if (isRoot & y == null) {
                root = Child;
            } else {
                if (toRemove.parent.left == toRemove) toRemove.parent.left = Child;
                else toRemove.parent.right = Child;
            }
        }
        if (y != null) { //Case 3 part B - Place y to replace x's location in the tree.
            y.right = x.right;
            if (x.right != null)
                x.right.parent = y;
            y.left = x.left;
            if (x.left != null)
                x.left.parent = y;
            y.parent = x.parent;
            if (x.parent != null) {
                if (x.parent.right == x) x.parent.right = y;
                else x.parent.left = y;
            } else root = y;
        }

    }

    public Node minimum() {
        if (root == null)
            return null;
        else {
            Node min = root;
            while (min.left != null) {
                min = min.left;
            }
            return min;
        }
    }

    public Node maximum() {
        if (root == null)
            return null;
        else {
            Node max = root;
            while (max.right != null) {
                max = max.right;
            }
            return max;
        }
    }

    public Node successor(Node x) {
        if (x == null) //if x is null, return null
            return null;
        else {
            Node succ = x.right;
            if (succ != null) { //if x has a right child - return the minimum value in the subtree of right child
                while (succ.left != null) {
                    succ = succ.left;
                }
                return succ;
            } else {
                succ = x.parent;
                while (succ != null && succ.right == x) {
                    x = succ;
                    succ = x.parent;
                }
                return succ;
            }
        }
    }

    public Node predecessor(Node x) {
        if (x == null) //if x is null, return null
            return null;
        else {
            Node pre = x.left;
            if (pre != null) { //if has a left child - return the maximum value in the subtree of left child (didn't build new subtree to avoid memory waste);
                while (pre.right != null) {
                    pre = pre.right;
                }
                return pre;
                /* Alternative solution - build BST based on the pre.left node and run maximum. Seems like it's a waste of space.
                 BacktrackingBST bsLeft = new BacktrackingBST(new Stack(),new Stack());
                bsLeft.insert(pre);
                return bsLeft.maximum();
                */
            } else { //else, return the lowest ancestor of x whose right child is also an ancestor of x.
                pre = x.parent;
                while (pre != null && pre.left == x) {
                    x = pre;
                    pre = x.parent;
                }
                return pre;
            }
        }
    }

        public void backtrack () {
            if(!stack.isEmpty()) {
                BSTTrackingData last_op = (BSTTrackingData) stack.pop();
                redoStack.push(last_op); // pushing last_op into redoStack to redo this operation
                if (last_op.getOperation() == 'i') { // last operation was an insert
                    redoDone=true;
                     delete(last_op.getCurr());
                     stack.pop();
                }else{ // last operation was a delete
                    /*
                     Case 1 - last_op was a leaf - no children;
                     Case 2 - last_op had 1 child;
                     Case 3 - last_op had 2 children;
                   */
                    if((last_op.getParent() == null)){ //this is going to be the new root
                        root = last_op.getCurr();
                    }
                    if((last_op.getLeft() != null) & (last_op.getRight() != null)) { // Case 3 - last_op had 2 children
                        Node succ = last_op.getLeft().parent;
                        last_op.getRight().parent = last_op.getCurr();
                        last_op.getLeft().parent = last_op.getCurr();
                        if(last_op.getParent() != null){
                            if(last_op.getParent().getKey() < last_op.getCurr().getKey()){ //updating location of curr in relation to parent
                                last_op.getParent().right = last_op.getCurr();
                            } else {
                                last_op.getParent().left = last_op.getCurr();
                            }
                        }if(last_op.getSuccParent().getKey() < succ.getKey()){ // updating location of succ in relation to succParent
                            last_op.getSuccParent().right = succ;
                        } else {
                            last_op.getSuccParent().left = succ;
                        } succ.parent = last_op.getSuccParent();
                    }
                    else if((last_op.getLeft() != null) | (last_op.getRight() != null)){ //Case 2 - last_op had 1 child
                        Node child = null;
                        boolean isRight = false; // marks if child is a right son or not.
                        if(last_op.getRight() != null) { // had a right son
                            child = last_op.getRight();
                            isRight = true;
                            child.parent = last_op.getCurr();
                        }else if(last_op.getLeft() != null){ // had a left son
                            child = last_op.getLeft();
                            child.parent = last_op.getCurr();
                        }
                        if(last_op.getParent().left == child) { // last_op.getCurr was a left son
                            last_op.getParent().left = last_op.getCurr();
                            if (isRight) last_op.getCurr().right = child;
                            else last_op.getCurr().left = child;
                        }
                        else { //last_op.getCurr was a right son
                            last_op.getParent().right = last_op.getCurr();
                            if(isRight) last_op.getCurr().right = child;
                            else last_op.getCurr().left = child;
                        }
                    }
                    if((last_op.getLeft() == null) & (last_op.getRight() == null)){ // case 1 - last_op was a leaf

                        if(last_op.getParent().getKey() > last_op.getCurr().getKey()){ // curr.key is smaller than parent.key
                            last_op.getParent().left = last_op.getCurr();
                        } else { // curr.key is bigger than parent.key
                            last_op.getParent().right = last_op.getCurr();
                        }
                        last_op.getCurr().parent = last_op.getParent();
                    }
                }
                System.out.println("backtracking performed");
            }
        }

    public void retrack() {
        if (!redoStack.isEmpty()) {
            BSTTrackingData redoAct = (BSTTrackingData) redoStack.pop();
            redoDone = true;
            if (redoAct.getOperation() == 'r') {
                delete(redoAct.getCurr());
            } else
                insert(redoAct.getCurr());
        }
    }

    public void printPreOrder() {
        //We'll print the tree using recursive function created in the node class;
        //We've decided not to use a String to build the tree's PreOrder to avoid use of extra memory.
        if (root == null) { //TODO: Make sure if we need to print empty tree
            System.out.println("");
        } else {
            Node x = root;
            System.out.print(x.key);
            if (x.left != null) x.left.preOrderPrint();
            if (x.right != null) x.right.preOrderPrint();
            System.out.println();
        }
    }

    public void printPreOrder2() {
        //Alternative no-memory using print function
        if (root == null) { //TODO: Tests it
            System.out.println("");
        } else {
            Node current = root;
            System.out.print(current.key);
            Node pre = null;
            boolean upFromRight = false;
            while (current != null) {
                if (pre != current & current != root)
                    System.out.print(" " + current.key);
                if (current.left != null & (pre != current)) {
                    pre = current;
                    current = current.left;
                } else if (current.right != null & !upFromRight) {
                    pre = current;
                    current = current.right;
                } else {
                    if (current == pre.right | (current == pre & upFromRight == true)) upFromRight = true;
                    else upFromRight = false;
                    current = current.parent;
                    pre = current;
                }
            }
            System.out.println();
        }
    }

    public void print() {
        printPreOrder2();
    }

    public static class Node {
        //These fields are public for grading purposes. By coding conventions and best practice they should be private.
        public BacktrackingBST.Node left;
        public BacktrackingBST.Node right;

        private BacktrackingBST.Node parent;
        private int key;
        private Object value;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void preOrderPrint() { //New recursive function created to ease the tree's preOrderPrint
            System.out.print(" " + key);
            if (left != null) left.preOrderPrint();
            if (right != null) right.preOrderPrint();
        }
    }


}
