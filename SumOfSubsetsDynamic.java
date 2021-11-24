public class SumOfSubsetsDynamic {
    public static void main(String args[]) {
        int arr[] = {3, 4, 5, 2};//{4, 1, 10, 12, 5, 2};
        int k = 6;//9;
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
    
    static boolean isSubsetSum(int set[], int n, int sum)

    {
        boolean subset[][] = new boolean[n + 1][sum + 1];
 

        for (int i = 0; i <= sum; i++)

            subset[0][i] = false;
        
        // If sum is 0, then answer is true

        for (int i = 0; i <= n; i++)

            subset[i][0] = true;
 

 

        // Fill the subset table in bottom

        // up manner

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= sum; j++) {

                subset[i][j] = subset[i][j - 1];

                if (j >= set[i - 1])

                    subset[i][j] = subset[i][j]
                    || subset[j - set[i - 1]][j - 1];

            }

        }
 

        // print boolean array
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= sum; j++) {
                System.out.print(subset[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
 

        return subset[n][sum];

    }

}
