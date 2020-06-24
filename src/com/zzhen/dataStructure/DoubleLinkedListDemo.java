package com.zzhen.dataStructure;


/**
 * <p>功能描述：双向链表</p>
 * <p>类名称：com.zzhen.dataStructure.DoubleLinkedListDemo</p>
 * <p>创建时间：2020/6/22 9:23</p>
 * @author zzhen
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 heroNode1 = new HeroNode2(1,"宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2,"卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3,"李逵", "黑旋风");
        HeroNode2 heroNode4 = new HeroNode2(4,"武松", "行者");
        HeroNode2 heroNode5 = new HeroNode2(5,"林冲", "豹子头");
//        doubleLinkedList.add(heroNode1);
//        doubleLinkedList.add(heroNode2);
//        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.add(heroNode4);
//        doubleLinkedList.add(heroNode5);
//        doubleLinkedList.list();

        System.out.println("============按照英雄编号顺序去插入数据===============");
        doubleLinkedList.addOrderNo(heroNode1);
        doubleLinkedList.addOrderNo(heroNode3);
        doubleLinkedList.addOrderNo(heroNode2);
        doubleLinkedList.addOrderNo(heroNode5);
        doubleLinkedList.addOrderNo(heroNode4);
        doubleLinkedList.list();

        HeroNode2 heroNode6 = new HeroNode2(4,"武松", "打虎英雄");
        doubleLinkedList.update(heroNode6);
        System.out.println("=============修改之后的英雄列表============");
        doubleLinkedList.list();

        HeroNode2 heroNode7 = new HeroNode2(4,"武松", "打虎英雄");
        doubleLinkedList.del(heroNode7);
        System.out.println("=============删除之后的英雄列表============");
        doubleLinkedList.list();

    }

}
class DoubleLinkedList {
    /**
     * 头节点
     */
    private HeroNode2 headNode = new HeroNode2(0,"","");

    /**
     * 遍历
     */
    public void list(){
        if (headNode.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = headNode.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 添加
     */
    public void add(HeroNode2 heroNode2){
        HeroNode2 temp = headNode;
        while (true){
            if(temp.next == null){
                temp.next = heroNode2;
                heroNode2.pre = temp;
                break;
            }
            temp = temp.next;
        }

    }

    /**
     * 添加按照英雄编号
     */
    public void addOrderNo(HeroNode2 heroNode2){
        HeroNode2 temp = headNode;
        while (true) {
            //遍历到最后了，直接插入到最后一个
            if (temp.next == null) {
                temp.next = heroNode2;
                heroNode2.pre = temp;
                break;
            }
            if(heroNode2.no < temp.next.no){
                heroNode2.next = temp.next;
                temp.next.pre = heroNode2;
                heroNode2.pre = temp;
                temp.next = heroNode2;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除
     */
    public void del(HeroNode2 heroNode2){
        if (headNode.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = headNode.next;
        while (true) {
            if (temp == null) {
                System.out.printf("不存在英雄编号为%d的英雄", heroNode2.no);
                break;
            }
            if (temp.no == heroNode2.no){
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改
     */
    public void update(HeroNode2 heroNode2){
        if (headNode.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = headNode.next;
        while (true) {
            if (temp.next == null) {
                System.out.printf("不存在英雄编号为%d的英雄", heroNode2.no);
                break;
            }
            if (temp.next.no == heroNode2.no){
                temp.next.name = heroNode2.name;
                temp.next.nickName = heroNode2.nickName;
                break;
            }
            temp = temp.next;
        }
    }
}
class HeroNode2 {

    /**
     * 编号
     */
    public int no;

    /**
     * 名称
     */
    public String name;

    /**
     * 绰号
     */
    public String nickName;

    /**
     * 后一个节点对象
     */
    public HeroNode2 next;

    /**
     * 前一个节点对象
     */
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
