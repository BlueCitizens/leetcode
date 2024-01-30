public class Medium {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int med = (nums1.length + nums2.length) / 2;
        int pvt1 = 0, pvt2 = 0;
        int max = Math.max(nums1.length, nums2.length);
        int i = 0;
        while (i < max) {
            if (nums1[pvt1] > nums2[pvt2]) {
                pvt1++;
            } else {
                pvt2++;
            }

            if (pvt1 + pvt2 == med) {
                break;
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
