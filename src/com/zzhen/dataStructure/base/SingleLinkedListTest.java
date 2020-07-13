package com.zzhen.dataStructure.base;

import com.zzhen.dataStructure.base.HeroNode;
import com.zzhen.dataStructure.base.SingleLinkedList;

import java.util.Stack;

/**
 * <p>功能描述：单链表练习</p>
 * <p>类名称：com.zzhen.dataStructure.base.SingleLinkedListTest</p>
 * <p>创建时间：2020/6/20 12:38</p>
 * @author zzhen
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"李逵", "黑旋风");
        HeroNode heroNode4 = new HeroNode(4,"武松", "行者");
        HeroNode heroNode5 = new HeroNode(5,"林冲", "豹子头");

        //直接插入到尾部
   //     System.out.println("=========插入到尾部==========");
        singleLinkedList.addOrderNo(heroNode1);
        singleLinkedList.addOrderNo(heroNode2);
        singleLinkedList.addOrderNo(heroNode3);
        singleLinkedList.addOrderNo(heroNode5);
        singleLinkedList.addOrderNo(heroNode4);
     //   singleLinkedList.list();
//        int size = getSize(singleLinkedList);
//        System.out.printf("单链表的大小为：%d\n", size);
//        HeroNode node = getLastIndexNode(singleLinkedList, 1);
//        System.out.println("node = " + node);
//        System.out.println("=========链表反转==========");
//        reverseSingleLinkedList(singleLinkedList);
//        singleLinkedList.list();
//        System.out.println("=========逆序打印======");
//        reversePrint(singleLinkedList);

        System.out.println("=================合并链表==========");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        HeroNode heroNode11 = new HeroNode(1,"宋江", "及时雨");
        HeroNode heroNode12 = new HeroNode(2,"卢俊义", "玉麒麟");
        singleLinkedList1.addOrderNo(heroNode11);
        singleLinkedList1.addOrderNo(heroNode12);
        singleLinkedList1.list();
        System.out.println("=======1");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        HeroNode heroNode8 = new HeroNode(3,"李逵", "黑旋风");
        HeroNode heroNode9 = new HeroNode(4,"武松", "行者");
        HeroNode heroNode10 = new HeroNode(2,"无用", "智多星");
        singleLinkedList2.addOrderNo(heroNode8);
        singleLinkedList2.addOrderNo(heroNode9);
        singleLinkedList2.addOrderNo(heroNode10);
        singleLinkedList1.list();
        singleLinkedList2.list();
        System.out.println("========2");
        SingleLinkedList singleLinkedList3 = mergeSingleLinkedList(singleLinkedList1, singleLinkedList2);
        singleLinkedList3.list();
    }


    /**
     * 获取一个带头节点的单链表的大小
     * 不包含头节点
     */
    public static int getSize(SingleLinkedList singleLinkedList){
        HeroNode headNode = singleLinkedList.getHeadNode();
        if(headNode.nextNode == null){
            return 0;
        }
        HeroNode temp = headNode.nextNode;
        int total = 1;
        while (true) {
            if (temp.nextNode == null) {
                return total;
            }
            temp = temp.nextNode;
            total++;
        }
    }

    /**
     * 获取单链表倒数第几个节点
     */
    public static HeroNode getLastIndexNode(SingleLinkedList singleLinkedList, int lastIndex) {
        HeroNode headNode = singleLinkedList.getHeadNode();
        if (headNode.nextNode == null) {
            return null;
        }
        //获取链表的长度
        int size = getSize(singleLinkedList);
        if(lastIndex < 0 || lastIndex > size){
            return null;
        }
        HeroNode cur = headNode.nextNode;
        for (int i = 0; i < size - lastIndex; i++) {
            cur = cur.nextNode;
        }
        return cur;
    }

    /**
     * 链表反转
     */
    public static void reverseSingleLinkedList(SingleLinkedList singleLinkedList){
        HeroNode headNode = singleLinkedList.getHeadNode();
        if (headNode.nextNode == null | headNode.nextNode.nextNode == null) {
            System.out.println("单链表为空");
            return ;
        }
        //定义一个新的头节点，作为数据临时存放的位置
        HeroNode reverseNode = new HeroNode(0, "", "0");
        //临时变量，去实现原链表数据的遍历
        HeroNode cur = headNode.nextNode;
        //临时变量，作为交换的临时值
        HeroNode next;
        while (true) {
            if (cur == null) {
                break;
            }
            //接收cur后面所有的链表数据
            next = cur.nextNode;
            //将cur的下一个节点执行新链表的头节点的下一个节点
            cur.nextNode = reverseNode.nextNode;
            //将新链表的头节点的下一个节点修改到cur上
            reverseNode.nextNode = cur;
            //cur拿上剩下的节点数据
            cur = next;
        }
        //新旧链表交换
        headNode.nextNode = reverseNode.nextNode;
    }

    /**
     * 逆序打印单链表
     */
    public static void reversePrint(SingleLinkedList singleLinkedList){
        HeroNode headNode = singleLinkedList.getHeadNode();
        if (headNode.nextNode == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode cur = headNode.nextNode;
        Stack<HeroNode> stack = new Stack<>();
        while (true) {
            if (cur == null) {
                break;
            }
            stack.add(cur);
            cur = cur.nextNode;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序的链表
     */
    public static SingleLinkedList mergeSingleLinkedList(SingleLinkedList singleLinkedList, SingleLinkedList singleLinkedList1){
        HeroNode newHeadNode = new HeroNode(100, "", "");
        newHeadNode.nextNode = singleLinkedList.getHeadNode().nextNode;
        HeroNode tempNew = newHeadNode;
        HeroNode cur = singleLinkedList1.getHeadNode().nextNode;
        HeroNode temp;
        while (cur != null) {
            temp = cur.nextNode;
            cur.nextNode = null;
            while (true) {
                if (tempNew.nextNode == null) {
                    tempNew.nextNode = cur;
                    break;
                }
                if(tempNew.nextNode.hno == cur.hno){
                    System.out.printf("队列已经存在no=%d的节点\n", cur.hno);
                    break;
                }
                if(tempNew.nextNode.hno > cur.hno){
                    cur.nextNode = tempNew.nextNode;
                    tempNew.nextNode = cur;
                    break;
                }
                tempNew = tempNew.nextNode;
            }
            cur = temp;
        }
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.setHeadNode(newHeadNode);
        return singleLinkedList2;
    }


}
