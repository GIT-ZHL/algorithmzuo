package com.haoliang.algorithm.link;

import java.util.Stack;

public class Link07_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println(isPalindromeUseStack(head));
        System.out.println(isPalindromeUseVar(head));
        printNode(head);
    }

    private static void printNode(Node head) {
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static boolean isPalindromeUseStack(Node head) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = head;
        while (current != null) {
            nodeStack.push(current);
            current = current.next;
        }
        while (head != null) {
            if (nodeStack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeUseVar(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1、获取链表的中点
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) { // find mid node
            slow = slow.next; // slow -> mid
            fast = fast.next.next; // fast -> end
        }
        // 2、中点到链表结尾翻转
        fast = slow.next; // fast -> right part first node
        slow.next = null; // mid.next -> null
        Node last = null;
        while (fast != null) { // right part convert
            last = fast.next; // n3 -> save next node
            fast.next = slow; // next of right node convert
            slow = fast; // slow move
            fast = last; // fast move
        }
        // 3、判断回文
        last = slow; // n3 -> save last node
        fast = head;// fast -> left first node
        boolean res = true;
        while (slow != null && fast != null) { // check palindrome
            if (slow.value != fast.value) {
                res = false;
                break;
            }
            slow = slow.next; // left to mid
            fast = fast.next; // right to mid
        }
        // 4、中点到链表结尾再次翻转
        slow = last.next;
        last.next = null;
        while (slow != null) { // recover list
            fast = slow.next;
            slow.next = last;
            last = slow;
            slow = fast;
        }
        return res;
    }
}
