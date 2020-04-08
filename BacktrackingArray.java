public class BacktrackingArray implements Array<Integer>, Backtrack {


    private Stack stack;
    private int[] arr;
    // TODO: implement your code here

    // Do not change the constructor's signature
    public BacktrackingArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
    }

    @Override
    public Integer get(int index){ // Nohaaaaa
        return arr[index];
    }

    @Override
    public Integer search(int x) {
        // TODO: implement your code here
    }

    @Override
    public void insert(Integer x) { // noahah
        int count = 0;

    }

    @Override
    public void delete(Integer index) {
        // TODO: implement your code here
    }

    @Override
    public Integer minimum() { // noaahhhh
        int min = arr[0];
        for(int i=1; 1<arr.length; i= i+1){
            if(arr[i] < min)           // if found a smaller element
                min= arr[i];
        }
        return min;
    }

    @Override
    public Integer maximum() {
        // TODO: implement your code here
    }

    @Override
    public Integer successor(Integer index) {
        // TODO: implement your code here      -Nohaaaaa
    }

    @Override
    public Integer predecessor(Integer index) {
        // TODO: implement your code here
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here       -Nohaaaaa
    }

    @Override
    public void retrack() {
        // Do not implement anything here!!
    }

    @Override
    public void print() {
        // TODO: implement your code here
    }
}


