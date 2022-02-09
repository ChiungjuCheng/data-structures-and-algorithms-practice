package heap.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-(quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.)
 * 參考
 * https://leetcode.com/problems/sort-an-array/
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * 
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * @author user
 *
 */
public class SortArrayByHeapSort {
	
	public static void main(String[] args) {
		int[] nums = {5,1,1,2,0,0};
		heapSort(nums);

		Arrays.stream(nums).boxed().collect(Collectors.toList()).forEach(System.out::print);
	}
	

    private static void heapSort(int[] nums) {
    	// build max-heap array 從倒數第二層一個個將最重的移到
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length - 1);
        }
        // building ordered 
        for (int i = nums.length - 1; i >= 1; i--) {
        	// 將最大值移到陣列後面
            swap(nums, 0, i);
            // 維持heap結構，拿最後一個值填補剛移走的root
            heapify(nums, 0, i - 1);
        }
    }
    
    /**
     *  將最小的移到最下層
     * @param nums
     * @param i
     * @param end
     */
    private static void heapify(int[] nums, int i, int end) {
        while (i <= end) {
            int l = 2 * i + 1, r = 2 * i + 2;
            int maxIndex = i;
            if (l <= end && nums[l] > nums[maxIndex]) maxIndex = l;
            if (r <= end && nums[r] > nums[maxIndex]) maxIndex = r;
            if (maxIndex == i) break;
            swap(nums, i, maxIndex);
            i = maxIndex;
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
