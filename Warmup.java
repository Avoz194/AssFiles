public class Warmup {
    public static int backtrackingSearch(int[] arr, int x, int fd, int bk, Stack myStack) {
        int countSteps=0; //counts number of steps
        for(int i=0; i<arr.length; i++){
            myStack.push(arr[i]);
            if(x==arr[i]){
                return i;
                break;
            }
            countSteps++;
            if(countSteps==fd){ // fd steps were made
                i=i-bk;
                countSteps=0;
                for(int j=0; j<bk; j--){ //clearing bk elements from the stack
                    myStack.pop();
                }
            }
        }
        return -1; //x was not found in the array
    }

    public static int consistentBinSearch(int[] arr, int x, Stack myStack) {
        int r = arr.length - 1;
        int l = 0;
        while (r >= l) {
            int mid = (r + l) / 2;
            myStack.push(arr[mid]);
            while (isConsistent(arr) != 0) // the array is not consistent
                myStack.push();
            if (arr[mid] == x) { // if x was found
                return mid;
                break;
            }
            if (arr[mid] < x) { // x is bigger than the element in arr[mid]
                l = mid + 1;
             else // x is smaller than the element in arr[mid]
                r = mid - 1;
            }
        }
        return -1; // x was not found
    }

    private static int isConsistent(int[] arr) {
        double res = Math.random() * 100 - 75;

        if (res > 0) {
            return (int)Math.round(res / 10);
        } else {
            return 0;
        }
    }
}
