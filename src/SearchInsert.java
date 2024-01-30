public class SearchInsert {

    public static int searchInsert1(int[] nums, int target) {
        int length = nums.length;

        int med = nums.length / 2 - 1;
        if (nums[med] > target) {
            return search(nums, 0, med, target);

        } else if (nums[med] == target) {
            return med;
        } else {
            return search(nums, med + 1, length - 1, target);
        }
    }

    public static int search(int[] nums, int l, int r, int target) {
        if (l < r) {
            int med = (r - l) / 2;
            if (nums[med] > target) {
                return search(nums, l, med, target);
            } else if (nums[med] == target) {
                return med;
            } else {
                return search(nums, med + 1, r, target);
            }
        } else {
            if (nums[r] < target) {
                return r + 1;
            } else if (nums[l] > target) {
                return 0;

            } else {
                return l;
            }
        }
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int med = (r + l) / 2;
            if (nums[med] >= target) {
                r = med - 1;
            }else {
                l = med + 1;
            }
        }
        if (target > nums[nums.length-1]) {
            return l + 1;
        } else if (target < nums[0]) {
            return 0;
        } else {
            return l;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 7, 8, 9};
        int target = 10;
        System.out.println(searchInsert(nums, target));
    }
}
