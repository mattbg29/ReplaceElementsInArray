/* *****************************************************************************
 * My solution to leetCode 2295
 * See problem description here: https://leetcode.com/contest/weekly-contest-296/problems/replace-elements-in-an-array/
 * In the below, i create an array where each index is the left side of each operation, and each value is
 * the value of the index at the right side of the operation.
 * The trick is to fill the array by iterating through operations backwards, so that you maintain
 * the correct order.
 * The downside to this approach is that it requires initializing an array the size of the max allowable
 * integer input, 1 million.  A cleaner approach would be to create a dictionary / hashmap and only
 * input the key-value pairs that appear.  I will tackle this approach next.
 **************************************************************************** */

public class ReplaceElementsInArray {

    public static int[] arrayChange(int[] nums, int[][] operations) {
        int[] array = new int[1000001];
        for (int i = 0; i <= 1000000; i++) {
            array[i] = i;
        }
        for (int i = operations.length - 1; i >= 0; i--) {
            array[operations[i][0]] = array[operations[i][1]];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = array[nums[i]];
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6 };
        int[][] operations = { { 1, 3 }, { 4, 7 }, { 6, 1 } };
        int[] solution = arrayChange(nums, operations);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
