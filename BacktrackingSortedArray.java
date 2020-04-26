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
        if (index < currSize) {
            return arr[index];
        } else
            return null;
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
        int index = 0;
        if (currSize > 0) {
            //search for index
            while (index < currSize && arr[index] < x) {
                index = index + 1;
            }
        }
        //push all values from index and on one cell forward, and insert x to arr[index]
        for (int i = currSize - 1; i >= index; i = i - 1)
            arr[i + 1] = arr[i];
        arr[index] = x;
        currSize = currSize + 1;
        stack.push(new ArrTrackingData(index, x, 'i'));

    }

    public void delete(Integer index) {
        if (index < currSize) {
            stack.push(new ArrTrackingData(index, arr[index], 'd')); //insert
            for (int i = index + 1; i < currSize; i = i + 1) {
                arr[i - 1] = arr[i];
            }
            currSize = currSize - 1;
        }
    }

    public Integer minimum() {
        if (currSize == 0)
            return -1;
        else
            return (0); // in a sorted array the minimum is in the first index
    }

    public Integer maximum() {
        if (currSize == 0)
            return -1;
        else
            return (currSize - 1); // in a sorted array the maximum is in the last index
    }

    public Integer successor(Integer index) {
        if (index < currSize-1)
            return (index + 1);
        return -1;
    }

    public Integer predecessor(Integer index) {
        if ((index != 0) && (index < currSize))
            return (index - 1);
        return -1;
    }

    public void backtrack() {
        if (!stack.isEmpty()) {
            ArrTrackingData last_op = (ArrTrackingData) stack.pop();
            if (last_op.getOperation() == 'd') {
                /*Backtrack delete operations. Didn't use the 'insert' function as we want to make sure
                 we insert the value back to the correct index
                 (might not happen in case we have duplicate values in the array )*/
                for (int i = currSize - 1; i >= last_op.getIndex(); i = i - 1) {
                    arr[i + 1] = arr[i];
                }
                arr[last_op.getIndex()] = last_op.getValue();
                currSize = currSize + 1;
            } else {
                /*Backtrack insert operations, use the delete function and make sure to 'pop'
                 the delete operation we've create (by using the delete function) from the stack*/
                delete(last_op.getIndex());
                stack.pop();
            }

            System.out.println("backtracking performed");
        }


    }

    public void retrack() {
        // Do not implement anything here!!
    }

    public void print() {
        if(currSize == 0){
            System.out.println("");
        } else {
            for (int i = 0; i < currSize - 1; i = i + 1) {
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[currSize - 1]); // print the last element without an additional space
        }
    }
}

