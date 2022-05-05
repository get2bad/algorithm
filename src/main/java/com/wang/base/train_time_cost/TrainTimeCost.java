package com.wang.base.train_time_cost;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王帅
 * @date 2022-05-05 23:26:58
 * @description:
 */
public class TrainTimeCost {

    @Test
    public void test() {
        int[] sources = {1, 3, 2};
        System.out.println(trainCost(sources, 2.7));
    }

    public int trainCost(int[] nums, double hour) {
        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(nums, mid, hour)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return check(nums, left, hour) ? left : -1;
    }

    public boolean check(int[] nums, int speed, double hour) {
        double total = 0d;
        for (int i = 0; i < nums.length; i++) {
            double cost = nums[i] * 1.0 / speed;
            total += (i == nums.length - 1) ? cost : Math.ceil(cost);
        }
        return total <= hour;
    }
}
