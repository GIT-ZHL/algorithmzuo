package com.haoliang.algorithm.link;

/**
 * 打印链表
 */
public class Link01_LinkLearn {
    public static class Node {
        public Node next;
        public String value;
        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node("1");
        head.next = new Node("2");
        head.next.next = new Node("3");
        head.next.next.next = new Node("4");
        head.next.next.next.next = new Node("5");
        head.next.next.next.next.next = new Node("6");
        head.next.next.next.next.next.next = new Node("7");
        head.next.next.next.next.next.next.next = new Node("8");
        head.next.next.next.next.next.next.next.next = new Node("9");
        traverseLink(head);
    }

    private static void traverseLink(Node head) {
        if (head != null) {
            while (head != null) {
                System.out.print(head.value+" ");
                head = head.next;
            }
        }
    }
}
