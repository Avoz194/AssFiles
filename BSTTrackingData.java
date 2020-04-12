public class BSTTrackingData {
    private BacktrackingBST.Node curr;
    private BacktrackingBST.Node left;
    private BacktrackingBST.Node right;
    private BacktrackingBST.Node parent;

    private char operation ; //d for delete, i for insert

    public BSTTrackingData(BacktrackingBST.Node curr, BacktrackingBST.Node left, BacktrackingBST.Node right, BacktrackingBST.Node parent, char operation){
        this.curr = curr;
        this.left = left;
        this.right=right;
        this.parent=parent;
        this.operation=operation;
    }
    public BacktrackingBST.Node getCurr(){
        return curr;
    }
    public BacktrackingBST.Node getLeft(){
        return left;
    }
    public BacktrackingBST.Node getRight(){
        return right;
    }
    public BacktrackingBST.Node getParent(){ return parent;}
    public char getOperation(){ return operation; }

}
