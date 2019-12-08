package com.focus.yueqing.front.learn.leetcode.node;


import com.alibaba.fastjson.JSON;

/**
 * 链表相关算法 leetCode  206，141，21，19，876
 */
public class ListNodeAlgorithm {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(3);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node5;
        ListNode nodeTwo = getTestListNode();

        //System.out.println("node: "+JSON.toJSONString(toArray(node)));
        //System.out.println(JSON.toJSONString(toArray(removeNthFromEnd(node,3))));
        //System.out.println("nodeTwo: "+JSON.toJSONString(toArray(nodeTwo)));
        //System.out.println("mergeTwoLists: "+JSON.toJSONString(toArray(mergeTwoLists2(node,nodeTwo))));
        //System.out.println("reverseList: "+JSON.toJSONString(toArray(reverseList2(node))));
        //System.out.println("hasCycleLisNode: "+hasCycleLisNode(node));
        System.out.println("getCycleLisNode: "+JSON.toJSONString(getCycleLisNode(node).val));

        //System.out.println("middleNode: "+JSON.toJSONString(toArray(middleNode(node))));
        System.out.println("isPalindrome: "+JSON.toJSONString(isPalindrome(node)));

    }

    private static ListNode getTestListNode(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
        //ListNode node4 = new ListNode(11);
        //ListNode node5 = new ListNode(12);
        //ListNode node6 = new ListNode(13);
        node.next = node2;
        node2.next = node3;
       // node3.next = node4;
       // node4.next = node5;
        //node5.next = node6;
        return node;
    }

    /**
     * 删除链表的倒数第N个结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempNode = new ListNode(0);
        tempNode.next = head;
        ListNode nodeOne = tempNode;
        ListNode nodeTwo = tempNode;
        while (n>0){
            nodeOne = nodeOne.next;
            n--;
        }
        while (nodeOne.next!=null){
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next;
        }
        nodeTwo.next = nodeTwo.next.next;
        return tempNode.next;
    }

    /**
     * 合并两个有序数组
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          //双循环
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode preNode = preHead;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                preNode.next = l1;
                l1 = l1.next;
            }else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        if(l1==null){
            preNode.next = l2;
        }else {
            preNode.next = l1;
        }
        return preHead.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l2.next,l1);
            return l2;
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode!=null){
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode tempNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return tempNode;
    }

    /**
     * 是否有环结点
     * @param head
     * @return
     */
    public static boolean hasCycleLisNode(ListNode head) {
        if(head==null || head.next==null){
           return false;
        }
        ListNode fastNode = head.next;
        ListNode node = head;
        while (node!=fastNode){
            if(fastNode==null || fastNode.next==null){
                return false;
            }
            fastNode = fastNode.next.next;
            node = node.next;
        }
        return true;
    }

    /**
     * 如果有环 获取环入口
     * @param head
     * @return
     */
    public static ListNode getCycleLisNode(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode fastNode = head;
        ListNode node = head;
        while (fastNode!=null && fastNode.next!=null){
            fastNode = fastNode.next.next;
            node = node.next;
            if(fastNode == node){
                break;
            }
        }
        if(fastNode==null || fastNode.next==null){
            return null;
        }
        node = head;
        while (node!=fastNode){
            node = node.next;
            fastNode = fastNode.next;
        }
        return node;
    }


    /**
     * 查找链表的中间结点
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode quickNode = head;
        ListNode showNode = head;
        while (quickNode!=null && quickNode.next!=null){
            quickNode = quickNode.next.next;
            showNode = showNode.next;
        }
        return showNode;
    }

    /**
     * 是否回文数
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head){
        if(head==null){
            return false;
        }
        if(head.next==null){
            return true;
        }
        ListNode quickNode = head;
        ListNode showNode = head;
        ListNode preNode = null;
        while (quickNode!=null && quickNode.next!=null){
            quickNode = quickNode.next.next;
            ListNode next = showNode.next;
            showNode.next = preNode;
            preNode = showNode;
            showNode = next;
        }
        if(quickNode!=null){
            showNode = showNode.next;
        }
        while (showNode!=null){
            if(showNode.val!=preNode.val){
                return false;
            }
            showNode = showNode.next;
            preNode = preNode.next;
        }
        return true;
    }


    public static int[] toArray(ListNode node){
        int[] array = new  int[6];
        int i = 0;
        for(ListNode curNode = node; curNode!=null; curNode = curNode.next){
            if(curNode.val==0){
                continue;
            }
            array[i++] = curNode.val;
        }
        return array;
    }

}
