package cn.ipanda.linkedlist.test;
import cn.ipanda.linkedlist.domain.LNode;
/***
 * 1.1如何实现链表的逆序
 */
public class Test {
    /*方法的功能：对链表的进行逆序输入参数：head：链表头的结点*/
    public static void Reverse(LNode head) {
        //判断链表是否为空
        if (head == null || head.next == null)
            return;
        LNode pre = null;//前驱节点
        LNode cur = null;//当前结点
        LNode next = null;//后继节点
        //把链表首结点变为尾结点
        cur = head.next;
        next = cur.next;
        cur.next = null;
        pre = cur;
        cur = next;
        //使用当前的遍历到结点cur指向前驱结点
        while (cur.next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur.next;
            cur = next;
        }
        cur.next = pre;
        head.next = cur;
    }
    public static void main(String[] args) {
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;
        //构造单链表
        for (int i =0; i < 8; i++) {
            tmp = new LNode();
            tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.println("逆序前:");
        for (cur = head.next; cur != null; cur = cur.next)
            System.out.print(cur.data + " ");
            System.out.println("\n逆序后: ");
            Reverse(head);
            for (cur = head.next; cur != null; cur = cur.next) {
                System.out.print(cur.data + " ");
            }

    }
}
