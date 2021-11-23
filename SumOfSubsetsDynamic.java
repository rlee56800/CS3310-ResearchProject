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
        boolean matrix[][] = new boolean[k + 1][n + 1];
        
        for (int i = 0; i <= k; i++)
        {
            matrix[i][0] = false; // fill first row with false
        }
        
        for (int i = 0; i <= n; i++) {
            matrix[0][i] = true; // fill first column with true
        }

        for (int sum = 1; sum <= k; sum++) {
            System.out.print("\nsum = " + sum);
            for (int index = 1; index <= givenArr.length; index++) {
                System.out.print("; index = " + index);
                /*matrix[i][j] = matrix[i][j - 1];
                if (i >= givenArr[j - 1] && matrix[i - givenArr[j - 1]][j - 1]) {
                    matrix[i][j] = true;

                    subset[i][j] = subset[i][j - 1];
                    if (i >= set[j - 1])
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }*/
                if(givenArr[index-1] < sum) { // if current element in array is less than sum
                    matrix[index][sum] = matrix[index - 1][sum]; // take the same value as above
                } else {
                    matrix[index][sum] = matrix[index-1][sum] || matrix[index - 1][sum - givenArr[index - 1]];
                    // else either take value from above OR go up 1, left by current element units
                    // if current element == sum, should go to 0 (i.e. true)
                }
            }
        }
 
        // print boolean array
        for (int i = 0; i <= k; i++)
        {
            for (int j = 0; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        return matrix[k][n];
    }

}
