package com.guomn.leetcode;

import java.util.*;

/**
 * Created by GuoMengnan on 2018/8/13.
 */

public class Demo3 {

	public int lengthOfLongestSubstring(String s) {
		int maxCount = 0;
		int buoy = 0;
		int begin = 0;
		int end = 0;
		// 字符和最后一次出现的位置
		Map<Character, Integer> map = new HashMap<>();
		char[] charArray = s.toCharArray();
		if(charArray.length <= 1){
			return charArray.length;
		}
		int i = 0;
		while (i< charArray.length) {
			if(map.get(charArray[i]) == null){
				map.put(charArray[i], i);
				begin ++;
				i++;
				continue;
			} else {
				maxCount = maxCount < (i - map.get(charArray[i])) ? (i - map.get(charArray[i])) : maxCount;
				map.put(charArray[i], i);
				buoy ++;
				i = buoy;
				end = charArray.length - buoy;
				map.clear();
				maxCount = maxCount < begin ? begin : maxCount;
				begin = 0;
				continue;
			}
		}
		maxCount = maxCount < begin ? begin : maxCount;
		maxCount = maxCount < end ? end : maxCount;
		return maxCount;
	}

	public int lengthOfLongestSubstring2(String s) {
		int maxCount = 0;
		// 游标指示最后一个重复出现的字符位置
		int buoy = 0;
		int begin = 0;
		int end = 0;
		// 字符和最后一次出现的位置
		Map<Character, Integer> map = new HashMap<>();
		char[] charArray = s.toCharArray();
		if(charArray.length <= 1){
			return charArray.length;
		}
		int i = 0;
		while (i< charArray.length) {
			if(map.get(charArray[i]) == null){
				map.put(charArray[i], i);
				i++;
				continue;
			} else {
				maxCount = maxCount < (i - map.get(charArray[i])) ? (i - map.get(charArray[i])) : maxCount;
				map.put(charArray[i], i);
				if(buoy == 0){
					begin = i;
				}
				end = charArray.length - map.get(charArray[i]) - 1;
				buoy = i;
				i++;
				continue;
			}
		}
		if(buoy == 0){
			begin = s.length();
		}
		maxCount = maxCount < begin ? begin : maxCount;
		maxCount = maxCount < end ? end : maxCount;
		return maxCount;
	}

	public static void main(String[] args) {
		String s = "abba";
		System.out.println(new Demo3().lengthOfLongestSubstring2(s));
	}
}
