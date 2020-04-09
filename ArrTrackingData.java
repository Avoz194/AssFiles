public class ArrTrackingData {
    private int index;
    private int value;
    private char operation ; //d for delete, i for insert

    public ArrTrackingData(int index, int value, char operation){
        this.index = index;
        this.value=value;
        this.operation=operation;
    }
    public int getIndex(){
        return index;
    }
    public int getValue(){
        return value;
    }
    public char getOperation(){
        return operation;
    }

}
