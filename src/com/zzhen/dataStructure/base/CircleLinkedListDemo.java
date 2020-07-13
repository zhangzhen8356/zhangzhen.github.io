package com.zzhen.dataStructure.base;


/**
 * <p>功能描述：单向环形链表（约瑟夫问题）</p>
 * <p>类名称：com.zzhen.dataStructure.base.CircleLinkedListDemo</p>
 * <p>创建时间：2020/6/24 10:41</p>
 * @author zzhen
 */
public class CircleLinkedListDemo {

    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.create(5);
        circleLinkedList.list();
        System.out.println("======小孩出圈======");
        circleLinkedList.countNum(1,2,5);
    }
}
class CircleLinkedList {
    private kidNode firstNode = new kidNode(-1);

    /**
     * 小孩出圈的顺序
     * @param start  开始的位置
     * @param number  数数的次数
     * @param kidNum  链表的大小
     */
    public void countNum(int start, int number, int kidNum) {
        if (number < 1 || kidNum < 2 || start < 1 ||start > kidNum) {
            System.out.println("参数有问题");
            return;
        }
        //创建一个辅助指针，帮助完成小孩出圈，指向这个first节点的前一个位置
        kidNode helper = firstNode;
        //需要先把辅助指针移动到first指针的前一个位置
        while (true) {
            if (helper.getNextKid() == firstNode) {
                break;
            }
            helper = helper.getNextKid();
        }
        //移动到start小孩
        for (int i = 0; i < start -1; i++) {
            firstNode = firstNode.getNextKid();
            helper = helper.getNextKid();
        }

        //报数操作
        while (true) {
            //说明圈中只有一个节点了
            if (firstNode == helper) {
                System.out.printf("这是最后一个kid,id为%d", firstNode.getNo());
                break;
            }
            for (int i = 0; i < number; i++) {
                if (i == number - 1) {
                    System.out.printf("编号为:%d的kid出圈\n", firstNode.getNo());
                    firstNode = firstNode.getNextKid();
                    helper.setNextKid(firstNode);
                } else {
                    firstNode = firstNode.getNextKid();
                    helper = helper.getNextKid();
                }
            }
        }
    }

    /**
     * 遍历
     */
    public void list(){
        if (firstNode.getNextKid() == null) {
            System.out.println("链表为空~");
            return;
        }
        kidNode temp = firstNode;
        while (true) {
            System.out.println(temp);
            if (temp.getNextKid() == firstNode) {
                break;
            }
            temp = temp.getNextKid();
        }
    }

    /**
     * 给一个kid的个数，初始化链表
     */
    public void create(int num){
        if (num < 2) {
            System.out.println("创建kid的个数必须大于2");
            return;
        }
        kidNode cur = firstNode;
        for (int i = 1; i <= num; i++) {
            kidNode kidNode = new kidNode(i);
            if (i == 1) {
                firstNode = kidNode;
                cur = kidNode;
            } else {
                cur.setNextKid(kidNode);
                cur.getNextKid().setNextKid(firstNode);
                cur = cur.getNextKid();
            }
        }
    }
}

class kidNode {
    private int no;
    private kidNode nextKid;

    public kidNode(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public kidNode getNextKid() {
        return nextKid;
    }

    public void setNextKid(kidNode nextKid) {
        this.nextKid = nextKid;
    }

    @Override
    public String toString() {
        return "kidNode{" +
                "no=" + no +
                '}';
    }
}