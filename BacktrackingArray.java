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
        if(currSize < arr.length - 1) { //insert only if array is not full
            arr[currSize] = x;
            currSize = currSize + 1;
            stack.push(new ArrTrackingData(currSize-1, x, 'i')); //insert into stack
        }
    }

    public void delete(Integer index) {
        if (index < currSize) {
            stack.push(new ArrTrackingData(index,arr[index],'d')); //insert into stack
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

    public Integer successor(Integer index) {
        int closestInd = -1;
        if (index < currSize) {
            for (int i = 0; i < currSize; i = i + 1) {
                if (arr[i] > arr[index] & (closestInd == -1 || arr[closestInd] > arr[i])) //looking for a value between arr[closetedInd] and arr[index]
                    closestInd = i;
            }
        }
        return closestInd;
    }

    public Integer predecessor(Integer index) {
        int closestInd = -1;
        if (index < currSize) {
            for (int i = 0; i < currSize; i = i + 1) {
                if (arr[i] < arr[index] & (closestInd == -1 || arr[closestInd] < arr[i])) //looking for a value between arr[index] and arr[closetedInd]
                    closestInd = i;
            }
        }
        return closestInd;
    }

    public void backtrack() {
        if(!stack.isEmpty()){
            ArrTrackingData last_op = (ArrTrackingData)stack.pop();
            if(last_op.getOperation()=='d'){ // the last operation was "delete"
               arr[currSize] = arr[last_op.getIndex()];
               arr[last_op.getIndex()] = last_op.getValue();
               currSize = currSize + 1;
            }
            else // the last operation was "insert"
                currSize = currSize-1;
            System.out.println("backtracking performed");
        }
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



