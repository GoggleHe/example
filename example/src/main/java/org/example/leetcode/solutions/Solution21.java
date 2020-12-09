package org.example.leetcode.solutions;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1242 👎 0

/**
 *
 **/
public class Solution21 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode node = null;
        while(l1 != null && l2 != null){
            ListNode temp = null;
            if(l1.val <= l2.val){
                node = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            if(res == null && temp != null){
                res = temp;
                node = res;
            } else {
                node.next = temp;
                node = node.next;
            }

        }
        while(l1 != null){
            node = new ListNode(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            node = new ListNode(l2.val);
            l2 = l2.next;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
