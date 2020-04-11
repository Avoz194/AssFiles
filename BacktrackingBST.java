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
        // TODO: implement your code here
    }

    public Node minimum() {        ///Nohaaaa
        // TODO: implement your code here
    }

    public Node maximum() {
        if (root ==null)
            return null;
        else{
            Node max = root;
            while (max.right!=null){
                max = max.right;
            }
            return max;
        }
    }

    public Node successor(Node x) {     ///Nohaaaa
        // TODO: implement your code here
    }

    public Node predecessor(Node x) {
                if(x==null) //if x is null, return null
            return null;
        else {
            Node pre =x.left;
            if(pre!=null){ //if has a left child - return the maximum value in the subtree of left child (didn't build new subtree to avoid memory waste;
                while (pre.right!=null){
                    pre=pre.right;
                }
                return pre;
                /* Alternative solution - build BST based on the pre.left node and run maximum. Seems like it's a waste of space.
                 BacktrackingBST bsLeft = new BacktrackingBST(new Stack(),new Stack());
                bsLeft.insert(pre);
                return bsLeft.maximum();
                */
            }
            else{ //else, return the lowest ancestor of x whose right child is also an ancestor of x.
                pre = x.parent;
                while(pre!=null&&pre.left==x){
                    x=pre;
                    pre=x.parent;
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

    public void printPreOrder(){
        // TODO: implement your code here
    }

    @Override
    public void print() {
        // TODO: implement your code here
    }

    public static class Node{
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
    }

}

