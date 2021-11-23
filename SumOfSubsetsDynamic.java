public class SumOfSubsetsDynamic {
    public static void main(String args[]) {
        int arr[] = {4, 1, 10, 12, 5, 2};
        int k = 9;
        int n = arr.length;

        if (isSubsetSum(arr, n, k) == true) {
            System.out.println("The set " + toString(arr) + " contains the sum " + k);
        }
        else {
            System.out.println("The set " + toString(arr) + " does not contain the sum " + k);
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
    
    public static boolean isSubsetSum(int givenArr[], int n, int sum)
    {
        boolean matrix[][] = new boolean[sum + 1][n + 1];
        
        for (int i = 0; i <= sum; i++)
        {
            matrix[i][0] = false; // fill first row with false
        }
        
        for (int i = 0; i <= n; i++) {
            matrix[0][i] = true; // fill first column with true
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = matrix[i][j - 1];
                if (i >= givenArr[j - 1] && matrix[i - givenArr[j - 1]][j - 1]) {
                    matrix[i][j] = true;
                }
            }
        }
 
        // print boolean array
        for (int i = 0; i <= sum; i++)
        {
            for (int j = 0; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        return matrix[sum][n];
    }

}
