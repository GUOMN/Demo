package com.guomn.leetcode;

import java.util.*;

/**
 * Created by GuoMengnan on 2018/8/10.
 */

public class Demo1 {

	int[] nums = {3, 3};
	int target = 6;

	/**
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 *
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 所以返回 [0, 1]
	 */



	public int[] twoSumV1(int[] nums, int target) {
		int size = nums.length;
		for (int i = 0 ; i < size ; i++){
			for (int j = 0 ; j < size ; j++){
				if(nums[i] + nums[j] == target && i != j){
					int[] result = {i , j};
					return result;
				}
			}
		}
		return null;
	}


	public int[] twoSumV2(int[] nums, int target) {
		Map map = new HashMap();
		for (int i = 0; i < nums.length; i++){
			int temp = target - nums[i];
			if (map.containsKey(temp) && (Integer) map.get(temp) != i){
				int[] result = {i ,  (Integer) map.get(temp)};
				return result;
			}
			map.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		Demo1 demo = new Demo1();
		int[] result = demo.twoSumV2(demo.nums , demo.target);
		System.out.println(result[0] + "," + result[1]);
	}
}
