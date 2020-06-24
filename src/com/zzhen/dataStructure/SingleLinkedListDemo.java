package com.zzhen.dataStructure;


/**
 * <p>功能描述：单向链表</p>
 * <p>类名称：com.zzhen.dataStructure.SingleLinkedListDemo</p>
 * <p>创建时间：2020/6/19 19:31</p>
 * @author zzhen
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"李逵", "黑旋风");
        HeroNode heroNode4 = new HeroNode(4,"武松", "行者");
        HeroNode heroNode5 = new HeroNode(5,"林冲", "豹子头");

        //直接插入到尾部
        System.out.println("=========插入到尾部==========");
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode4);
        singleLinkedList.list();
        //按照no顺序插入
        System.out.println("=========按照no顺序插入==========");
        singleLinkedList.addOrderNo(heroNode1);
        singleLinkedList.addOrderNo(heroNode3);
        singleLinkedList.addOrderNo(heroNode4);
        singleLinkedList.addOrderNo(heroNode2);
        singleLinkedList.addOrderNo(heroNode5);
        singleLinkedList.list();

        System.out.println("========删除==========");
        singleLinkedList.del(heroNode1);
        singleLinkedList.del(heroNode2);
        singleLinkedList.list();

        System.out.println("========修改==========");
        HeroNode heroNode = new HeroNode(3,"无用", "及时雨");
        singleLinkedList.update(heroNode);
        singleLinkedList.list();
    }
}

class SingleLinkedList {
    /**
     * 头节点
     */
    private HeroNode headNode = new HeroNode(0,"", "");

    public void setHeadNode(HeroNode headNode) {
        this.headNode = headNode;
    }

    public HeroNode getHeadNode() {
        return headNode;
    }

    /**
     * 直接往最后添加
     */
    public void add(HeroNode heroNode){
        HeroNode temp = headNode;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = heroNode;
    }

    /**
     * 按照no的顺序进行排序
     */
    public void addOrderNo(HeroNode heroNode){
        HeroNode temp = headNode;
        while (true) {
            if (temp.nextNode == null) {  //说明已经到链表的最后了
                temp.nextNode = heroNode;
                break;
            }
            if(temp.nextNode.hno == heroNode.hno){  //添加的heroNode编号已经存在
                System.out.printf("列表中no = %d已经存在，不能添加\n", heroNode.hno);
                break;
            }
            if(temp.nextNode.hno > heroNode.hno){  // 位置找到，就在temp的后面插入
                heroNode.nextNode = temp.nextNode;
                temp.nextNode = heroNode;
                break;
            }
            temp = temp.nextNode;
        }
    }

    /**
     * 删除节点
     */
    public void del(HeroNode heroNode){
        if(headNode.nextNode == null){
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = headNode;
        while (true) {
            if (temp.nextNode == null) {
                System.out.println("不存在要删除的节点");
                break;
            }
            if(temp.nextNode.hno == heroNode.hno){
                temp.nextNode = temp.nextNode.nextNode;
                break;
            }
            temp = temp.nextNode;
        }
    }

    /**
     * 更新
     */
    public void update(HeroNode heroNode){
        if(headNode.nextNode == null){
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = headNode;
        while (true) {
            if (temp.nextNode == null) {
                System.out.println("不存在要修改的节点");
                break;
            }
            if(temp.nextNode.hno == heroNode.hno){
                temp.nextNode.name = heroNode.name;
                temp.nextNode.nickname = heroNode.nickname;
                break;
            }
            temp = temp.nextNode;
        }
    }

    /**
     * 展示链表数据
     */
    public void list(){
        if (headNode.nextNode == null) {
            System.out.println("链表数据为空");
            return;
        }
        HeroNode temp = headNode.nextNode;
        while (true) {
            System.out.println(temp);
            if (temp.nextNode == null) {
                break;
            }
            temp = temp.nextNode;
        }
    }
}

class HeroNode {
    /**
     * 编号
     */
    public int hno;

    /**
     * 名字
     */
    public String name;

    /**
     * 绰号
     */
    public String nickname;

    /**
     * 下一个节点
     */
    public HeroNode nextNode;

    public HeroNode(int no, String name, String nickname){
        this.hno = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "hno=" + hno +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
