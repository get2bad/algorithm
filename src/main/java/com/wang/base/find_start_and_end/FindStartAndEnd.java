package com.wang.base.find_start_and_end;

import java.util.Arrays;

/**
 * @author 王帅
 * @date 2022-05-05 22:29:15
 * @description:
 */
public class FindStartAndEnd {

    public static void main(String[] args) {
        int[] sources = {1,2,3,4,5,5,5,5,6,71};
        System.out.println(Arrays.toString(find(sources, 5)));
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     * 使用二分法
     * 步骤是：
     * 1. 找出目标值的最小值，我们使用二分法 + 位运算来找出目标值的最小索引
     * 2。 找出目标值+1的最小值代表的就是目标值的最大索引+1(因为找到的肯定比目标值的索引大1)
     * 3. 然后判断进行返回即可
     */
    public static int[] find(int[] nums,int target){
        // 二分法骨架
        int l = search(nums, target);
        // 为什么要 + 1 因为我们的search方法是寻找数组内最小的target + 1就是 target最后的元素+1的索引
        int r = search(nums, target + 1);
        return l == nums.length || l >= r ? new int[]{-1, -1} : new int[]{l, r - 1};
    }

    public static int search(int[] nums,int target){
        int left = 0, right = nums.length;
        // 构建二分法骨架
        while (left < right) {
            // 求中间值
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
