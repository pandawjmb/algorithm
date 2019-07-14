package cn.ipanda.linkedlist.test;
import cn.ipanda.linkedlist.domain.LinkedListDemo;
/***
 * 1.1如何实现链表的逆序
 */
public class Test {
    public static void Reverse(LinkedListDemo head) {
        /*方法的功能：对链表的进行逆序输入参数：head：链表头的结点*/
        if (head == null || head.next ==null)
            return;
        LinkedListDemo precurrentnodesorNode=null;  //前驱结点
        LinkedListDemo currentnoderentnode=null;    //当前结点
        LinkedListDemo next=null;           //后继结点
        //把链表的首结点变成尾结点
        currentnoderentnode=head.next;
        next=currentnoderentnode.next;
        currentnoderentnode.next=null;
        precurrentnodesorNode=currentnoderentnode;
        currentnoderentnode=next;
        //使用当前的遍历到结点currentnode指向前驱结点
        while (currentnoderentnode.next!=null){
            next=currentnoderentnode.next;
            currentnoderentnode.next=precurrentnodesorNode;
            precurrentnodesorNode=currentnoderentnode;
            currentnoderentnode=currentnoderentnode.next;
            currentnoderentnode=next;
        }
        //结点最后的一个结点指向倒数第二个结点
        currentnoderentnode.next=precurrentnodesorNode;
        //链表的头结点指向原来链表的尾结点
        head.next=currentnoderentnode;
    }

    public static void main(String[] args) {
        LinkedListDemo head = new LinkedListDemo();
        head.next = null;
        LinkedListDemo tmp = null;
        LinkedListDemo currentnode = head;
        //构造单链表
        for (int i =0; i < 8; i++) {
            tmp = new LinkedListDemo();
            tmp.data = i;
            tmp.next = null;
            currentnode.next = tmp;
            currentnode = tmp;
        }
        System.out.println("逆序前:");
        for (currentnode = head.next; currentnode != null; currentnode = currentnode.next)
            System.out.print(currentnode.data + " ");
        System.out.println("\n逆序后: ");
        Reverse(head);
        for (currentnode = head.next; currentnode != null; currentnode = currentnode.next) {
            System.out.print(currentnode.data + " ");
        }
    }
}
