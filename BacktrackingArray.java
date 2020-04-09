public class BacktrackingArray implements Array<Integer>, Backtrack {


    private Stack stack;
    private int[] arr;
    private int currSize;

    // Do not change the constructor's signature
    public BacktrackingArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
        this.currSize = 0;
    }

    public Integer get(int index) {
        return arr[index];
    }

    public Integer search(int x) {
        for (int i = 0; i < currSize - 1; i = i + 1) {
            if (x == arr[i]) return i;
        }
        return -1;
    }

    public void insert(Integer x) {
        //pointer to the first unoccupied cell
        arr[currSize] = x;
        currSize = currSize + 1;
    }

    public void delete(Integer index) {
        if (index < currSize) {
            arr[index] = arr[currSize - 1];
            currSize = currSize - 1;
        }

    }

    public Integer minimum() {
        if (currSize == 0) return -1;
        else {
            int min = arr[0]; // minimum value
            int minIndex = 0; // index of the minimum value
            for (int i = 1; 1 < currSize; i = i + 1) {
                if (arr[i] < min) {          // if found a smaller element
                    min = arr[i];
                    minIndex = i;
                }
            }
            return minIndex;
        }
    }

    public Integer maximum() {
        if (currSize == 0) return -1;
        else {
            int max = arr[0]; // maximum value
            int maxIndex = 0; // index of the maximum value
            for (int i = 1; 1 < currSize; i = i + 1) {
                if (arr[i] > max) {          // if found a bigger element
                    max = arr[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
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
        for (int i = 0; i < currSize - 1; i = i + 1) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[currSize - 1]); // print the last element without an additional space
    }
}
}


