public class BacktrackingSortedArray implements Array<Integer>, Backtrack {
    private Stack stack;
    private int[] arr;
    // TODO: implement your code here

    // Do not change the constructor's signature
    public BacktrackingSortedArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
    }

    @Override
    public Integer get(int index) {
        // TODO: implement your code here
    }

    @Override
    public Integer search(int x) { //Nohaaaaa
        int right = arr.length - 1;
        int left = 0;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (arr[mid] == x) // if x was found
                return mid;
            if (arr[mid] < x)  // x is bigger than the element in arr[mid]
                left = mid + 1;
            else // x is smaller than the element in arr[mid]
                right = mid - 1;
        }
        return-1; // x was not found
    }

    @Override
    public void insert(Integer x) {
        // TODO: implement your code here
    }


    @Override
    public void delete(Integer index) { // noaahaha
        for(int i= index + 1; i < arr.length; i= i + 1){
            arr[i-1] = arr[i];
        }
    }

    @Override
    public Integer minimum() {
        // TODO: implement your code here
    }

    @Override
    public Integer maximum() { // noahhahha
        return(arr[arr.length-1]); // in a sorted array the maximum is the last element
    }

    @Override
    public Integer successor(Integer index) {
        // TODO: implement your code here
    }

    @Override
    public Integer predecessor(Integer index) {
        // TODO: implement your code here           -Nohaaaaa
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here
    }

    @Override
    public void retrack() {
        // Do not implement anything here!!
    }

    @Override
    public void print() { // noahah
        for(int i=0; i<arr.length-1; i= i + 1){
            System.out.print(arr[i] + " ");
            System.out.print(arr[arr.length-1]); // print the last element without an additional space
        }
    }
}
