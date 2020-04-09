public class BacktrackingSortedArray implements Array<Integer>, Backtrack {
    private Stack stack;
    private int[] arr;
    private int currSize;

    // Do not change the constructor's signature
    public BacktrackingSortedArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
        this.currSize = 0;
    }

    public Integer get(int index) {
        return arr[index];
    }

    public Integer search(int x) {
        int right = currSize - 1;
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
        return -1; // x was not found
    }

    public void insert(Integer x) {
        // TODO: implement your code here
    }

    public void delete(Integer index) {
        for (int i = index + 1; i < currSize; i = i + 1) {
            arr[i - 1] = arr[i];
        }
        currSize = currSize - 1;
    }

    public Integer minimum() {
        if (currSize==0)
            return -1;
        else
            return (0); // in a sorted array the maximum is at the last index
    }

    public Integer maximum() {
        if(currSize==0)
            return -1;
        else
            return (currSize - 1); // in a sorted array the maximum is at the last index
    }

    public Integer successor(Integer index) {
        if(index < currSize)
            return(index+1);
        return -1;
    }

    public Integer predecessor(Integer index) {
        if((index != 0) && (index < currSize))
            return(index-1);
        return -1;
    }

    public void backtrack() {
        // TODO: implement your code here
    }

    @Override
    public void retrack() {
        // Do not implement anything here!!
    }

    public void print() {
        for (int i = 0; i < currSize - 1; i = i + 1) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[currSize - 1]); // print the last element without an additional space
    }
}

