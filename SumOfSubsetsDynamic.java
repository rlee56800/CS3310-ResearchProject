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
    
    static boolean isSubsetSum(int set[],

                               int n, int sum)

    {

        // The value of subset[i][j] will be

        // true if there is a subset of

        // set[0..j-1] with sum equal to i

        boolean subset[][] = new boolean[sum + 1][n + 1];
 

        // If sum is 0, then answer is true

        for (int i = 0; i <= n; i++)

            subset[0][i] = true;
 

        // If sum is not 0 and set is empty,

        // then answer is false

        for (int i = 1; i <= sum; i++)

            subset[i][0] = false;
 

        // Fill the subset table in bottom

        // up manner

        for (int i = 1; i <= sum; i++) {

            for (int j = 1; j <= n; j++) {

                subset[i][j] = subset[i][j - 1];

                if (i >= set[j - 1])

                    subset[i][j] = subset[i][j]

                                   || subset[i - set[j - 1]][j - 1];

            }

        }
 

        // print boolean array
        for (int i = 0; i <= sum; i++)
        {
            for (int j = 0; j <= n; j++) {
                System.out.print(subset[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        return subset[sum][n];
        /* // uncomment this code to print table

        for (int i = 0; i <= sum; i++)

        {

        for (int j = 0; j <= n; j++)

            System.out.println (subset[i][j]);

        }
 

        return subset[sum][n]; */

    }
}
