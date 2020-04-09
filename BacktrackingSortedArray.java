public class BacktrackingSortedArray implements Array<Integer>, Backtrack {
    private Stack stack;
    private int[] arr;
    private int curr;

    // Do not change the constructor's signature
    public BacktrackingSortedArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
        this.curr = 0;
    }

    @Override
    public Integer get(int index) {
        // TODO: implement your code here
    }

    @Override
    public Integer search(int x) { //Nohaaaaa
        int right = curr - 1;
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
        for(int i= index + 1; i < curr; i= i + 1){
            arr[i-1] = arr[i];
        }
        curr = curr - 1;
    }

    @Override
    public Integer minimum() {
        // TODO: implement your code here
    }

    @Override
    public Integer maximum() { // noahhahha
        return(curr-1); // in a sorted array the maximum is at the last index
    }

    @Override
    public Integer successor(Integer index) {
        // TODO: implement your code here
    }

    @Override
    public Integer predecessor(Integer index) { //nohaaa
        if((index != 0) && (index < curr))
            return(index-1);
        return -1;
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
        for(int i=0; i<curr; i= i + 1){
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[curr-1]); // print the last element without an additional space
        }
    }

