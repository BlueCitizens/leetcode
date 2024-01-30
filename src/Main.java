import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int longestConsecutive(int[] nums) {
        List list = new ArrayList();
        for(int x=0;x<nums.length;x++){
            if(!list.contains(nums[x])){
                list.add(nums[x]);
            }
        }

        nums = new int[list.size()];

        for (int i = 0; i < list.size(); i ++) {
            nums[i] = (int)list.get(i);
        }



        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int current = 0;
        int maxSetStart = 0;
        int maxSetEnd = 0;
        int currentEnd = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i != nums.length - 1) {
                if (nums[i] + 1 == nums[i + 1]) {
                    currentEnd = i + 1;
                } else {
                    if ((currentEnd - current) >= (maxSetEnd - maxSetStart)) {
                        maxSetStart = current;
                        maxSetEnd = currentEnd;
                        maxLength = maxSetEnd - maxSetStart + 1;
                    }
                    current = i + 1;
                }
            } else {
                if ((currentEnd - current) >= (maxSetEnd - maxSetStart)) {
                    maxSetStart = current;
                    maxSetEnd = currentEnd;
                    maxLength = maxSetEnd - maxSetStart + 1;
                    System.out.println(maxSetStart + " " +maxSetEnd);
                }
            }

        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}