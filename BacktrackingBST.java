public class BacktrackingBST implements Backtrack, ADTSet<BacktrackingBST.Node> {
    private Stack stack;
    private Stack redoStack;
    BacktrackingBST.Node root = null;
    private boolean redoDone;
    private BacktrackingBST.Node redoSucc = null;

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
        redoStack.clear();
    }

    private void deleteUpToChild(Node toRemove) {
        //Cases 1+2, if both null, 'child' will remain null and we'll update the parent accordingly
        Boolean isRoot = toRemove == root;
        Node child = null;
        //find 1 child if exist
        if (toRemove.left != null) {
            child = toRemove.left;
        } else if (toRemove.right != null) {
            child = toRemove.right;
        }
        if (isRoot) {  //in case toRemove is the root, set root to child (even if null);
            root = child;
            if (child != null) child.parent = null;
        } else { //if not root, set parent's relevant son to 'child' (both directions)
            if (toRemove.parent.left == toRemove) {
                toRemove.parent.left = child;
            } else toRemove.parent.right = child;
            if (child != null) {
                child.parent = toRemove.parent;
            }
        }
    }

    private Node successorForDelete(Node x) {//Side function to get the successor, making sure that in cases of retrack, we won't calculate it again
        if (redoSucc == null)
            return successor(x);
        else {
            Node succ = redoSucc;
            redoSucc = null;
            return succ;
        }
    }

    public void delete(Node x) {
        /* split delete function into 2 functions:
            delete main function - choose relevant node to delete based on 0-2 children of x:
            if 0 or 1 children, call  ,deleteUpToChild, to remove x
            if 2 children, look for successor (using side function), remove it from tree (using deleteUpToChild) and place it in X's place in the tree
         */
        if (!redoDone)
            redoStack.clear();
        else
            redoDone = false;
        BSTTrackingData log = new BSTTrackingData(x, x.left, x.right, x.parent, null, 'd');
        Boolean isRoot = x == root;
        Node toRemove = x;
        Node succ = null;
        if (x.left != null & x.right != null) { //if Case 3 - PartA change toRemove to the successor and remove it from the tree
            succ = successorForDelete(x); //use side function to get the successor (adjusted to improve retrack runtime)
            toRemove = succ;
            log.setSuccParent(succ.parent); //update log accordingly
        }
        stack.push(log);
        deleteUpToChild(toRemove); //function to handle removal of node with up to 1 child.
        if (succ != null) { //Case 3 part B - Place the successor in x's location in the tree.
            //update parent
            succ.parent = x.parent;
            if (isRoot) {
                root = succ;
            } else {
                if (x.parent.right == x) x.parent.right = succ;
                else x.parent.left = succ;
            }
            //update both children
            succ.right = x.right;
            if (x.right != null)
                x.right.parent = succ;
            succ.left = x.left;
            if (x.left != null)
                x.left.parent = succ;
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

    public void backtrack() {
        if (!stack.isEmpty()) {
            BSTTrackingData last_op = (BSTTrackingData) stack.pop();
            redoStack.push(last_op); // pushing last_op into redoStack to redo this operation
            Node bktCurr = last_op.getCurr();
            Node bktLeft = last_op.getLeft();
            Node bktRight = last_op.getRight();
            Node bktParent = last_op.getParent();
            Node bktSuccParent = last_op.getSuccParent();
            char bktOperation = last_op.getOperation();

            if(bktOperation == 'd') { // last operation was a delete
                /*
                find successor
                if curr was root - update root (both sides)
                reconnect parent and curr (both sides)
               */
                Node succ = bktLeft.parent;
                if ((bktParent == null)) { //curr was root
                    root = bktCurr;
                    bktCurr.parent = null;
                } else{ // reconnect curr with parent
                     if (bktParent.getKey() > bktCurr.getKey()) { // checking if curr was right or left son
                        bktParent.left = bktCurr;
                    } else { // bktCurr was right son
                        bktParent.right = bktCurr;
                    }
                    bktCurr.parent = bktParent; //reconnect parent with curr
                }


                if ((bktLeft != null) | (bktRight != null)) {
                 /*
                 Case 2 + 3
                 reconnect curr and child/children (both sides)
                 */
                    if (bktRight != null) { // curr had a right son
                        bktRight.parent = bktCurr;
                        bktCurr.right = bktRight;
                    }if (bktLeft != null) { // curr had a left son
                        bktLeft.parent = bktCurr;
                        bktCurr.left = bktLeft;
                    }
                }

                if ((bktLeft != null) & (bktRight != null)) {
                    /*
                    Case 3 - curr had 2 children
                    place successor under it's succParent
                    */
                    if (bktSuccParent.getKey() < succ.getKey()) { // reconnecting succ to it's parent
                        bktSuccParent.right = succ;
                    } else {
                        bktSuccParent.left = succ;
                    }
                    succ.parent = bktSuccParent;
                }
            }
            else { // last operation was an insert
                deleteUpToChild(bktCurr); // delete bktCurr - case 1
            }
            System.out.println("backtracking performed");
        }
    }

    public void retrack() {
        if (!redoStack.isEmpty()) {
            BSTTrackingData redoOp = (BSTTrackingData) redoStack.pop();
            Node reParent = redoOp.getParent();
            Node reCurr = redoOp.getCurr();

            //manually redo operation of *insert*, manually and leave log. Avoid using Insert function to avoid unnecessary runtime
            if (redoOp.getOperation() == 'i') {
                reCurr.parent = reParent;
                if (reParent == null) {
                    root = reCurr;
                } else {
                    if (reParent.getKey() > reCurr.getKey()) {
                        reParent.left = reCurr;
                    } else {
                        reParent.right = reCurr;
                    }
                }
                stack.push(redoOp);
            }

            /*redo delete operation.
            We've adjusted the delete function (Case 3), not to search for the successor (using successor function)
            in case we've committed a retrack.
            We'll calculate the successor based on the log's details, and update the class' field accordingly, avoiding
            unnecessary runtime (making the delete operation for retrack purpose O(1));
            */
            else {
                Node reLeft = redoOp.getLeft();
                Node reRight = redoOp.getRight();
                if (reLeft != null & reRight != null) {
                    Node succParent = redoOp.getSuccParent();
                    //figure out which of it's child is the successor based on key comparision with curr;
                    if (succParent.right == null) redoSucc = succParent.left;
                    else if (succParent.left == null) redoSucc = succParent.right;
                    else {
                        if (succParent.left.key > succParent.right.key) {
                            if (succParent.right.key > reCurr.key) redoSucc = succParent.right;
                            else redoSucc = succParent.left;
                        } else {
                            if (succParent.left.key > reCurr.key) redoSucc = succParent.left;
                            else redoSucc = succParent.right;
                        }
                    }
                }
                redoDone = true;
                delete(reCurr); //use the delete function for the removal.
            }

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
                    pre=current;
                    current = current.parent;
                    if(current!=null&&current.right==pre)
                        upFromRight=true;
                    else upFromRight = false;
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

        private void preOrderPrint() { //New recursive function created to ease the tree's preOrderPrint
            System.out.print(" " + key);
            if (left != null) left.preOrderPrint();
            if (right != null) right.preOrderPrint();
        }
    }


}
