public class Kmax {

    public static int kMax(int[] nums, int lb, int rb, int k) {
        if (lb == rb) return nums[k];
        int l = lb;
        int r = rb;
        int x = nums[lb];
        while (l < r) {
            while (nums[l] < nums[lb]) {
                l++;
            }
            while (nums[r] > nums[lb]) {
                r--;
            }
            swap(nums[l], nums[r]);
        }
        if (k >= r) {
            return kMax(nums, r, rb, k);
        } else {
            return kMax(nums, lb, r - 1, k);
        }

    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return kMax(nums, 0, n - 1, n - k);
    }

    public static void swap(int aa, int bb) {
        int cc = aa;
        aa = bb;
        bb = cc;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
