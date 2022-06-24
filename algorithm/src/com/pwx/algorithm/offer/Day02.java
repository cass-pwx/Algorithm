package com.pwx.algorithm.offer;

/**
 *
 * @author 彭伟鑫#A04154
 * @date 2020.6.23
 */
public class Day02 {
    /*public static void main(String[] args) {
        Day02Solution2 solution2 = new Day02Solution2();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = solution2.reverseList2(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }*/

    public static void main(String[] args) {
        Day02Solution3 solution3 = new Day02Solution3();
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        head.next = node1;
        head.random = null;
        node1.next = node2;
        node1.random = head;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node1;
        node4.next = null;
        node4.random = head;
        solution3.copyRandomList(head);
    }
}

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x,ListNode next){val = x; this.next = next;}
}
class Day02Solution {
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode node = head;
        while(node != null){
            size ++;
            node = node.next;
        }
        int[] arr = new int[size];
        for (int i = size - 1; i >= 0; i--){
            arr[i] = head.val;
            head = head.next;
        }
        return arr;
    }
}

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * Definition for singly-linked list.
 */
class Day02Solution2 {
    /**
     * 方法1：直接使用新的节点，消耗大量的空间，编码简单
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        while (head != null){
            if(dummyHead.next == null){
                dummyHead.next = new ListNode(head.val);
                head = head.next;
            }else{
                ListNode node = new ListNode(head.val);
                node.next = dummyHead.next;
                dummyHead.next = node;
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 方法2：切点，然后接上一个新的虚拟节点
     */
    public ListNode reverseList2(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        while (head != null){
            if(dummyHead.next == null){
                ListNode p = head;
                head = head.next;
                cutNode(p);
                dummyHead.next = p;
            }else{
                ListNode node = head;
                head = head.next;
                cutNode(node);
                node.next = dummyHead.next;
                dummyHead.next = node;
            }
        }
        return dummyHead.next;
    }

    private void cutNode(ListNode head){
        head.next = null;
    }
}

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 不能直接输出原来的。
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Day02Solution3 {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node node = head;
        while (node != null){
            Node p = new Node(node.val);
            p.next = node.next;
            node.next = p;
            node = node.next.next;
        }

        node = head;
        while(node != null && node.next != null){
            node.next.random = node.random != null ? node.random.next : null;
            node = node.next.next;
        }

        Node oriNode = head;
        Node dummyNode = head.next;
        node = dummyNode;
        while(oriNode != null && oriNode.next != null){
            oriNode.next = oriNode.next.next;
            oriNode = oriNode.next;
            if(node != null && node.next != null){
                node.next = oriNode.next;
                node = node.next;
            }
        }
        return dummyNode;
    }
}