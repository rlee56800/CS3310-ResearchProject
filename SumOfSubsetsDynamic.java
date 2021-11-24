public class SumOfSubsetsDynamic {
    public static void main(String args[]) {
        int arr[] = {4, 1, 10, 12, 5, 2};
        int k = 9;

        /* // for returning array of elements
        int[] ssMatrix = isSubsetSum(arr, arr.length, k);
        if(ssMatrix[0] != -1) {
            System.out.println("The set " + toString(arr) + " contains the sum k = " + k);
            String outMsg = "The elements used are: ";

            // appends all elements used to make the sum
            for(int i = 0; i < ssMatrix.length; i++)
            {
                outMsg += ssMatrix[i] + " ";
            }
            System.out.println(outMsg);
        } else {
            System.out.println("The set " + toString(arr) + " does not contain the sum k = " + k);
        }*/

        /* // for returning a string of elememts
        String outMsg = isSubsetSum(arr, arr.length, k);
        if(!outMsg.isEmpty()) {
            System.out.println("The set " + toString(arr) + " contains the sum k = " + k);
            System.out.println("The elements used are: " + outMsg);
        } else {
            System.out.println("The set " + toString(arr) + " does not contain the sum k = " + k);
        }*/

        if(isSubsetSum(arr, arr.length, k)) {
            System.out.println("The set " + toString(arr) + " contains the sum k = " + k);
        } else {
            System.out.println("The set " + toString(arr) + " does not contain the sum k = " + k);
        }
    }
            

    public static String toString(int[] arr) {
        String str = "[";

        for(int i = 0; i < arr.length-1; i++) {
            str += arr[i] + ", ";
        }

        str += arr[arr.length-1] + "]";
        return str;
    }
    
    public static boolean isSubsetSum(int set[], int n, int k) {
        boolean matrix[][] = new boolean[n + 1][k + 1];
 
        // sets first row false
        for(int i = 0; i <= k; i++) {
            matrix[0][i] = false;
        }
        
        // sets first column true
        for(int i = 0; i <= n; i++) {
            matrix[i][0] = true;
        }

        // logic
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(set[i-1] > j) {
                    // if element is greater than element, take value of above row (same column)
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    // else take either above row (same column) or above row, element columns left
                    // if element == sum, gets value from sum = 0
                    matrix[i][j] = matrix[i-1][j] || matrix[i - 1][j - set[i - 1]];
                }
                System.out.print(matrix[i][j] + " "); // prints out element just entered
            }
            System.out.println(); // breaks row
        }
        System.out.println(); // space between matrix and statement
 

        /*// print matrix (iterates through matrix again)
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        /*if(matrix[n][k])
        {
            return "yoo";
        } else {
            return "";
        }*/
        return matrix[n][k];
    }

}
