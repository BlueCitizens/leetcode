package basic;

import java.util.Arrays;

/**
 * @author: BlueCitizen
 * @description 快速排序 https://blog.csdn.net/qq_39181839/article/details/109478094
 * @date: 2024/1/6 11:11
 */
public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {
        	// 记录中心点 空出交换位
            int pivot = nums[low];
            // 初始化快慢指针 保留端点记录
            int start = low, end = high;
            while (low < high) {
            	// 快指针左移
                while (low < high && nums[high] >= pivot) {
                    high--;
                }
                // 空位插入 空出交换位
                nums[low] = nums[high];
                // 慢指针右移
                while (low < high && nums[low] <= pivot) {
                    low++;
                }
                // 空位插入 空出交换位
                nums[high] = nums[low];
            }
            // 指针重叠 中心点插入
            nums[low] = pivot;

            // 分别递归左右侧
            quickSort(nums, start, low - 1);
            quickSort(nums, low + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] test = {11, 2, 30, 11, 2, 65, 20};
        quickSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
}
