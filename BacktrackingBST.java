public class BacktrackingBST implements Backtrack, ADTSet<BacktrackingBST.Node> {
    private Stack stack;
    private Stack redoStack;
    BacktrackingBST.Node root = null;

    // Do not change the constructor's signature
    public BacktrackingBST(Stack stack, Stack redoStack) {
        this.stack = stack;
        this.redoStack = redoStack;
    }

    public Node getRoot() {
        return root;
    }

    public Node search(int x) {     ///Nohaaaa
        // TODO: implement your code here
    }

    public void insert(BacktrackingBST.Node z) {     ///Nohaaaa
        // TODO: implement your code here
    }

    public void delete(Node x) {
        /*
        Case 1 - x is a leaf - no children;
        Case 2 - x has 1 child;
        Case 3 - x has 2 children;
         */
        Node toRemove = x;
        if(toRemove.left!=null & toRemove.right!=null){
            /*Case 3 - we'll change x's key and value based on it's successor and remove the successor from the tree.
             We'll use Cases 1 or 2 to remove y from the tree ('toRemove' variable will point on y - the successor); */
            Node y = successor(x);
            x.key=y.key;
            x.value=y.value;
            toRemove=y;
        }
        if (toRemove.left != null |toRemove.right != null) {
            //Cases 1+2, if both null, 'Child' will remain null and we'll update the parent accordingly;
            Node Child = null;
            if (toRemove.left != null) {
                Child = toRemove.left;
            } else if (toRemove.right != null) {
                Child = toRemove.right;
            }
            else if(toRemove==root) //in case there is no child and 'toRemove' is the root, set root to null;
                root = null;
            if (toRemove.parent.left == toRemove) toRemove.parent.left = Child;
            else toRemove.parent.right = Child;
        }
    }

    public Node minimum() {        ///Nohaaaa
        // TODO: implement your code here
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

    public Node successor(Node x) {     ///Nohaaaa
        // TODO: implement your code here
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

    @Override
    public void backtrack() {
        // TODO: implement your code here
    }

    @Override
    public void retrack() {
        // TODO: implement your code here
    }

    public void printPreOrder() {
        //We'll print the tree using recursive function created in the node class;
        //We've decided not to use a String to build the tree's PreOrder to avoid use of extra memory.
        if(root==null){ //TODO: Make sure if we need to print empty tree
            System.out.println("");
        }
        else{
            Node x = root;
            System.out.print(x.key);
            if (x.left!=null) x.left.preOrderPrint();
            if(x.right!=null) x.right.preOrderPrint();
            System.out.println();
        }
    }

    public void print() {
        printPreOrder();
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
        public void preOrderPrint(){ //New recursive function created to ease the tree's preOderPrint
            System.out.print(" "+key);
            if(left!=null) left.preOrderPrint();
            if(right!=null) right.preOrderPrint();
        }
    }

}

