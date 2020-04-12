public class BSTTrackingData {
    private BacktrackingBST.Node curr;
    private BacktrackingBST.Node left;
    private BacktrackingBST.Node right;
    private BacktrackingBST.Node parent;
    private BacktrackingBST.Node succParent;


    private char operation ; //d for delete, i for insert

    public BSTTrackingData(BacktrackingBST.Node curr, BacktrackingBST.Node left, BacktrackingBST.Node right, BacktrackingBST.Node parent,BacktrackingBST.Node succParent, char operation){
        this.curr = curr;
        this.left = left;
        this.right=right;
        this.parent=parent;
        this.succParent = succParent;
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
    public BacktrackingBST.Node getSuccParent(){ return succParent;}
    public char getOperation(){ return operation; }
    public void setSuccParent(BacktrackingBST.Node succParent){ this.succParent=succParent;}

}
