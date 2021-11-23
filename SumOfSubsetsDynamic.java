public class SumOfSubsetsDynamic {
    public static void main(String args[]) {
        int arr[] = {4, 1, 10, 12, 5, 2};
        int k = 9;
        int n = arr.length;

        if (isSubsetSum(arr, n, k) == true) {
            System.out.println("The set " + toString(arr) + " contains the sum k = " + k);
        }
        else {
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
    
    public static boolean isSubsetSum(int givenArr[], int n, int k)
    {
        boolean matrix[][] = new boolean[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++)
        {
            matrix[i][0] = false; // fill first row with false
        }
        
        for (int i = 0; i <= k; i++) {
            matrix[0][i] = true; // fill first column with true
        }

        for (int i = 1; i <= n; i++) {
            System.out.print("\ni = " + i);
            for (int j = 1; j <= k; j++) {
                System.out.print("; j = " + j);
                /*matrix[i][j] = matrix[i][j - 1];
                if (i >= givenArr[j - 1] && matrix[i - givenArr[j - 1]][j - 1]) {
                    matrix[i][j] = true;

                    subset[i][j] = subset[i][j - 1];
                    if (i >= set[j - 1])
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }*/
                if(givenArr[i-1] < j) {
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = matrix[i-1][j] || matrix[i-1][j - givenArr[i - 1]];
                }
            }
        }
 
        // print boolean array
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= k; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        return matrix[n][k];
    }

}
