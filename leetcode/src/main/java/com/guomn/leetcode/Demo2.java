package com.guomn.leetcode;

/**
 * Created by GuoMengnan on 2018/8/10.
 */

public class Demo2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		if(l1.val == 0){
//			return l2;
//		}if(l2.val == 0 ){
//			return l1;
//		}
		return addTwoNumbers(l1, l2, 0);

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryFlag) {
		ListNode result = new ListNode((l1.val + l2.val + carryFlag) % 10 );

		// 进位
		int carry = (l1.val + l2.val + carryFlag) / 10;

		if (l1.next == null && l2.next == null) {
			if (carry != 0){
				result.next = new ListNode(carry);
			}
		} else if (l1.next != null || l2.next != null) {
			result.next = addTwoNumbers(l1.next == null ? new ListNode(0) : l1.next, l2.next == null ? new ListNode(0) : l2.next, carry);
		}
		return result;
	}


	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(4);


		ListNode result = new Demo2().addTwoNumbers(l1, l2);
		System.out.println(result.val);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);

	}


}


class ListNode {
	int val;

	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}
