package com.pwx.algorithm.offer;


import java.util.LinkedList;

/**
 * 剑指offer第一天
 * @author 彭伟鑫#A04154
 * @date 2022.6.23
 */
public class Day01Test {
}


/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 */
class CQueue {

    LinkedList<Integer> popList ;
    LinkedList<Integer> pushList ;

    public CQueue() {
        popList = new LinkedList<>();
        pushList = new LinkedList<>();
    }

    public void appendTail(int value) {
        pushList.add(value);
    }

    public int deleteHead() {
        if(!popList.isEmpty()){
            return popList.pop();
        }

        if(pushList.isEmpty()){
            return -1;
        }

        while (!pushList.isEmpty()){
            popList.add(pushList.pop());
        }
        return popList.pop();
    }
}

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 */
class MinStack {

    private final Node head;

    /** initialize your data structure here. */
    public MinStack() {
        head = new Node(-1);
    }

    public void push(int x) {
        Node node;
        if(head.next == null){
            node = new Node(x, x);
            head.next = node;
        }else{
            node = new Node(x, Math.min(x, head.next.min));
            node.next = head.next;
            head.next = node;
        }
    }

    public void pop() {
        if(head.next != null){
            head.next = head.next.next;
        }
    }

    public int top() {
        return head.next != null ? head.next.value : -1;
    }

    public int min() {
        return head.next != null ? head.next.min : -1;
    }

    private class Node {
        int value;
        Node next;
        int min;

        public Node(int value){
            this.value = value;
            this.next = null;
            this.min = Integer.MAX_VALUE;
        }

        public Node(int value, int min){
            this.value = value;
            this.next = null;
            this.min = min;
        }
    }
}