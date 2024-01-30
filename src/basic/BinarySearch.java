package basic;
/**
 * @author: BlueCitizen
 * @description 二分查找
 * @date: 2024/1/6 17:09
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (true) {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            }
            if (right - left == 1) {
                return -1;
            }
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,6,7,8,9};
        System.out.println(binarySearch(nums, 9));
    }
}
