package indi.chenjianhong.data_struct;

/**
 * my own queue
 */
public class MyQueue<AnyType> {

    private int size = 0;
    Node head_node;
    Node end_node;

    private class Node{

        private Node pre;

        private Node next;

        private AnyType value;

        public Node(Node pre_node,Node next_node,AnyType node_value){
            pre = pre_node;
            next = next_node;
            value = node_value;
        }
    }

    public MyQueue() {
        clear();
    }

    public void clear() {
        head_node = new Node(null,null,null);
        end_node = new Node(head_node,null,null);
    }


    public boolean add(AnyType value) {
        Node node = new Node(end_node.pre,end_node,value);
        end_node.pre.next = node;
        end_node.pre = node;
        size ++;
        return true;
    }

    public AnyType remove() {
        if (size() <= 0) {
            System.out.println(size());
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = head_node.next;
        head_node.next = node.next;
        node.next.pre = head_node;
        size --;
        return node.value;
    }

    public int size() {
        return size;
    }

    public static void main(String args[]) {
        MyQueue<String> my_queue = new MyQueue<String>();
        my_queue.add("1");
        my_queue.add("2");
        my_queue.add("3");
        my_queue.add("4");
        for (int i = my_queue.size(); i > 0; i--) {
            System.out.println(String.format("queue value:%s", my_queue.remove()));
            System.out.println(String.format("queue length:%s", my_queue.size()));
        }
    }
}