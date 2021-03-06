public class Warmup {

    public static int backtrackingSearch(int[] arr, int x, int fd, int bk, Stack myStack) {
        //assuming fd>bk (as instructed in the forum)
        int countSteps = 0; //counts number of steps
        for (int i = 0; i < arr.length; i = i + 1) {
            if (x == arr[i])
                return i;
            myStack.push(i);
            countSteps = countSteps + 1;
            if (countSteps == fd) { // fd steps were made
                countSteps = 0;
                for (int j = bk; j > 0; j = j - 1) { //clearing bk elements from the stack
                    myStack.pop();
                    i = i - 1;
                }
            }
        }
        return -1; //x was not found in the array
    }

    public static int consistentBinSearch(int[] arr, int x, Stack myStack) {
        //We'll push to myStuck the value of first and last for each step we pass
        // and pop both values as a part of the isConsistent check.
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int undo = isConsistent(arr);
            while (undo > 0 & !myStack.isEmpty()) {
                last = (int) myStack.pop();
                first = (int) myStack.pop();
                undo = undo - 1;
            }
            int mid = (last + first) / 2;
            if (arr[mid] == x)
                return mid;
            myStack.push(first);
            myStack.push(last);
            if (arr[mid] < x) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }


    private static int isConsistent(int[] arr) {
        double res = Math.random() * 100 - 75;

        if (res > 0) {
            return (int) Math.round(res / 10);
        } else {
            return 0;
        }
    }

}

