/* You are given a 0-indexed array nums consisting of positive integers, representing targets on a number line... You are also given an integer space... You have a machine which can destroy targets. Seeding the machine with some nums[i] allows it to destroy all targets with values that can be represented as nums[i] + c * space, where c is any non-negative integer... You want to destroy the maximum number of targets in nums... Return the minimum value of nums[i] you can seed the machine with to destroy the maximum number of targets...
 * Eg 1: nums = [3,7,8,1,1,5]     space = 2        Output = 1
 * Eg 2: nums = [1,3,5,2,4,6]     space = 2        Output = 1
 *  Explanation of above case -> {Seeding the machine with nums[0], or nums[3] destroys 3 targets. It is not possible to destroy more than 3 targets. Since nums[0] is the minimal integer that can destroy 3 targets, we return 1.}
  */
import java.util.*;
public class Destroy
{
    public int MaximumHits(int nums[], int space)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(space, 1);
        for(int a = 0;a < nums.length; a++)     // Iterating over the entire array...
        {
            int rem = nums[a] % space;    // Finding the remainder...
            if(map.containsKey(rem))    // If Map contains the current key, update the count of that remainder...
                map.put(rem, map.get(rem)+1);
            else    // Otherwise add the remainder and its base count to the Map...
                map.put(rem, 1);
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> set: map.entrySet())    // Iterating over a Map...
        {
            if(set.getValue() > max)     // Evaluating maximum...
                max = set.getKey();    // Using the Get Key function since we want the number and not total occurrences of the value...
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the length of the array : ");
        x = sc.nextInt();
        int nums[] = new int[x];
        for(int i : nums)
        {
            System.out.print("Enter "+(i+1)+" th target value : ");
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the value of spaces : ");
        x = sc.nextInt();
        Destroy destroy = new Destroy();     // object creation...
        System.out.println("The Minimum value from the Target Array to seed the Machine : "+destroy.MaximumHits(nums, x));
        sc.close();
    }
}

// Time Complexity  - O(n + m) time...       m = spaces, n = nums array size...
// Space Complexity - O(m) space...

/* DEDUCTIONS :- 
 * 1. Since any target which can be derived by the given formula, nums[i] + c * space, we can get the target values...
 * 2. We evaluate their remainders, any number which have same remainder when subtracted with nums[i] will be divisible by space...
 * 3. Now we need to evaluate the maximum count of the distinct remainders, so we use a Hashmap...
 * 4. Also, the value of entire array will now be shrinked to 0 to space-1 values... 
*/