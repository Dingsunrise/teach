package com.focus.yueqing.front.learn.node;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 单向链表
 * @author dingliming
 * @param <T>
 */
public class SimpleLinkList<T> {

    private Node<T> head;
    private Node<T> last;
    private int size;

    public boolean addNode(T t){
        Node<T> oldLast = last;
        Node<T> newNode =  new Node<>(t);
        last = newNode;
       if(head==null){
           head = newNode;
       }else {
           oldLast.next = newNode;
       }
       size++;
       return true;
    }

    public boolean addNode(int index,T t){
        Node<T> newNode = new Node<T>(t);
        if(index==0){
            Node<T> oldHead = head;
            head = newNode;
            newNode.next = oldHead;
            size++;
            return true;
        }
        Node<T> tNode = indexNode(index-1);

        if(tNode==null || tNode.next==null){
            Node<T> oldLast = last;
            last = newNode;
            oldLast.next = newNode;
        }else {
            newNode.next = tNode.next;
            tNode.next = newNode;
        }
        size++;
        return false;
    }

    public T getNode(int index){
        Node<T> tNode = indexNode(index);
        return tNode==null?null:tNode.data;
    }

    public boolean removeNode(T t){
        if(size==0){
            return false;
        }
        if(head.data == t){
            return removeFirstNode();
        }
        Node<T> preNode = head;
        Node<T> node = head.next;
        while (node!=null){
            if(node.data.equals(t)){
                break;
            }
            preNode = node;
            node = node.next;
        }
        if(node==null){
            return false;
        }
        node.data = null;
        if(node.next==null){
            preNode.next = null;
            last = preNode;
        }else {
            preNode.next = node.next;
            node.next = null;
        }
        size--;
        return true;
    }

    public boolean removeNode(int index){
        if(index==0){
            return removeFirstNode();
        }
        Node<T> preNode = indexNode(index-1);
        if(preNode==null || preNode.next==null){
            return false;
        }
        Node<T> node = preNode.next;
        node.data = null;
        if(node.next==null){
            preNode.next = null;
            last = preNode;
        }else {
            preNode.next = node.next;
            node.next = null;
        }
        size--;
        return true;
    }

    public boolean removeFirstNode(){
        if(head==null){
            return false;
        }
        Node<T> oldHead = head;
        head = oldHead.next;
        oldHead.next = null;
        oldHead.data = null;
        size--;
        return true;
    }

    public Object[] toArray(){
        Object[] array = new  Object[size];
        int i = 0;
        for(Node<T> node = head;node!=null;node = node.next){
            array[i++] = node.data;
        }
        return array;
    }


    /**
     * 取中间结点
     * @return
     */
    public T getMiddleNode(Node<T> head){
        if(head==null){
            return null;
        }
        Node<T> quickNode = head;
        Node<T> slowNode = head;
        while (quickNode.next!=null){
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode.data;
    }


    /**
     * 回文数
     * @return
     */
    public boolean isPalindrome(Node<T> head){
        if(head==null){
            return false;
        }
        if(head.next == null){
            return true;
        }
        Node<T> quickNode = head;
        Node<T> slowNode = head;
        Node<T> preNode = null;
        while (quickNode!=null && quickNode.next!=null){
            quickNode = quickNode.next.next;
            Node<T> slowNodeNext = slowNode.next;
            slowNode.next = preNode;
            preNode = slowNode;
            slowNode = slowNodeNext;
        }
        if(quickNode!=null){
            slowNode = slowNode.next;
        }
        while (slowNode!=null){
            if(!slowNode.data.equals(preNode.data)){
                return false;
            }
            slowNode = slowNode.next;
            preNode = preNode.next;
        }
        return true;
    }

    /**
     * 反转数据
     * @param head
     * @return
     */
    public Node<T> reverseIteratively(Node<T> head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        Node<T> node = head;
        Node<T> temp = null;
        while (node.next!=null){
            Node<T> nextNode = node.next;
            if(nextNode.next==null){
                head = nextNode;
            }
            node.next = temp;
            temp = node;
            node = nextNode;
        }
        return head;
    }

    /**
     * 判断是否是环
     * @return
     */
    public boolean isRing(Node<T> head){
        if(head==null){
            return false;
        }
        Node<T> quickNode = head.next;
        Node<T> slowNode = head;
        while (slowNode!=null && quickNode!=null){
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if(quickNode.equals(slowNode)){
                return true;
            }
        }
        return false;
    }

    //todo 查找倒数第index个元素

    public T getLastIndex(Node<T> head,int index){
        // 反转 再查
        if(head==null || index<0){
            return null;
        }
        if(head.next==null){
            return head.data;
        }
        int i = 0;
        Node<T> preNode = head;
        Node<T> node = head;
        while (i<index){
            preNode = preNode.next;
        }
        while (preNode!=null){
            preNode = preNode.next;
            node = node.next;
        }
        return node.data;
    }


    private Node<T> indexNode(int index){
        if(index<0 || index>size-1){
            throw new NoSuchElementException("");
        }
        if(index==0){
            return head;
        }
        if(index==size-1){
            return last;
        }
        int i = 1;
        Node<T> pNode = head.next;
        while (i<index && pNode!=null){
            pNode = pNode.next;
            i++;
        }
        return pNode;
    }

    private Node<T> indexPreNode(int index){
        if(index<1 || index>size-2){
            throw new NoSuchElementException("");
        }
        return indexNode(index-1);
    }


    private static class Node<T>{
         Node<T> next;
         T data;

        public Node(Node<T> next, T data) {
            this.next = next;
            this.data = data;
        }

        public Node(T data) {
            this.data = data;
        }
    }
}
