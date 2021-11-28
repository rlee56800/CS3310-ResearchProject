import java.util.Scanner;


public class SubsetSumRecursion {
	public static boolean isSubsetSum(int set[], int n, int sum)
	{
		if (sum == 0) //If sum is 0 when we keep subtracting, it means there's an exact sum for it
			return true;
		if (n == 0) //If n = 0, then that means we ran out of indexes that doesn't sum to 0
			return false;
		
		if (set[n - 1] > sum) //If it's greater than the sum, just ignore it
			return isSubsetSum(set, n - 1, sum);
		
		System.out.println("Iterating through: (" + n + ", " + sum + ").");
	

		return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]); //Else, recursively iterate.
	}
	
	public static void main(String args[]) {
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the total sum: ");
		int sum = kb.nextInt();
		
		kb.nextLine();
		
		System.out.print("Enter the set separated by space: ");
		String[] setInput = kb.nextLine().split(" ");
		
		int[] set = new int[setInput.length];
		for(int i = 0;i < setInput.length;i++)
		{
			set[i] = Integer.parseInt(setInput[i]);
		}
		
		int n = set.length;
		
		if (isSubsetSum(set, n, sum) == true) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("Found a subset with given sum");
		}
		else {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("No subset with given sum");
		}
	}
	
	//Example: Sum = 9, Set = 3, 34, 4, 12, 5, 2
	//Non-working example: Sum = 30, Set = 10, 25, 15
}