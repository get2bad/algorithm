package com.wang;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王帅
 * @date 2022-05-05 22:59:40
 * @description:
 */
public class Example {

    @Test
    public void FindTargetRange(){
        int[] sources = {1,2,3,4,5,5,5,5,6,71};
        System.out.println(Arrays.toString(find(sources, 5)));
    }

    public int[] find(int[] nums,int target){
        int left = findByMiddle(nums,target);
        int right = findByMiddle(nums,target + 1);
        return left >= nums.length || left >= right? new int[]{-1,1}:new int[]{left,right - 1};
    }

    private int findByMiddle(int[] nums, int target) {
        int left = 0,right = nums.length;
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
