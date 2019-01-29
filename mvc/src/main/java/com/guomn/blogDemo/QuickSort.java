package com.guomn.blogDemo;

import org.apache.commons.lang.ArrayUtils;

/**
 * Created by GuoMengnan on 2018/10/30.
 */

public class QuickSort {
	private final int LENGTH = 10;
	int[] args = new int[LENGTH];
	private void setArgs(){
		for (int i = 0; i < LENGTH; i++){
			args[i] = (int) (Math.random()*100/1);
		}
	}
	private int[] sort(int[] input){
		int[] left = new int[0];
		int[] right = new int[0];
		int[] mid = new int[0];
		int midle = input[(input.length-1)/2];

		for (int i: input) {
			if (i < midle) {
				left = ArrayUtils.add(left, i);
			} else if(i > midle){
				right = ArrayUtils.add(right, i);
			} else if(i == midle){
				mid = ArrayUtils.add(mid, i);
			}
		}
		if(left.length > 1){
			left = sort(left);
		}
		if(right.length > 1){
			right = sort(right);
		}

		return ArrayUtils.addAll(ArrayUtils.addAll(left ,mid), right);
	}
	private void print(){
		for (int i : this.args){
			System.out.print(i + ", ");
		}

	}

	public static void main(String[] args) {
		QuickSort instance = new QuickSort();
		instance.setArgs();
		System.out.println("before sort:");
		instance.print();
		instance.args =instance.sort(instance.args);
		System.out.println("\nafter sort:");
		instance.print();
	}
}
