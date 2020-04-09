public class BacktrackingArray implements Array<Integer>, Backtrack {


    private Stack stack;
    private int[] arr;
    private int curr;

    // Do not change the constructor's signature
    public BacktrackingArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
        this.curr = 0;
    }

    public Integer get(int index){ // Nohaaaaa
        return arr[index];
    }

    public Integer search(int x) {
        // TODO: implement your  code here
    }

    public void insert(Integer x) {
         //pointer to the first unoccupied cell
            arr[curr] = x;
            curr = curr + 1;
    }

    public void delete(Integer index) {
        // TODO: implement your code here
    }

    public Integer minimum() {
        int min = arr[0];
        for(int i=1; 1<arr.length; i= i+1){
            if(arr[i] < min)           // if found a smaller element
                min= i;
        }
        return min;
    }

    public Integer maximum() {
        // TODO: implement your code here
    }

    @Override
    public Integer successor(Integer index) {
        // TODO: implement your code here      -Nohaaaaa
    }

    public Integer predecessor(Integer index) {
        // TODO: implement your code here
    }

    public void backtrack() {
        // TODO: implement your code here       -Nohaaaaa
    }

    public void retrack() {
        // Do not implement anything here!!
    }

    public void print() {
        // TODO: implement your code here
    }
}


