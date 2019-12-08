package com.focus.yueqing.front.learn.node;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

public class LinkListTest {

    public static void main(String[] args) {
        SimpleLinkList<String> list = new SimpleLinkList<>();
        list.addNode("aa");
        list.addNode("bb");
        list.addNode("cc");
        print(list);
        list.addNode(1,"dd");
        print(list);
        list.addNode(0,"ee");
        print(list);
        list.addNode(5,"ff");
        print(list);

        list.removeNode("aa");
        print(list);
        list.removeNode(3);
        print(list);
        System.out.println(list.getNode(3));

        LinkedList linkedList = new LinkedList();
        linkedList.add(1,null);

    }

    private static void print(SimpleLinkList<String> list){
        System.out.println(JSON.toJSONString(list.toArray()));
    }
}
