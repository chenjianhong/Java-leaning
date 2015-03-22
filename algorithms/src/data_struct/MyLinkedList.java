import org.omg.CORBA.Any;

import java.lang.Iterable;
import java.lang.String;
import java.util.Iterator;
import java.util.NoSuchElementException;

//public class MyLinkedList<AnyType> implements Iterable<AnyType> {
public class MyLinkedList<AnyType>{

    Node<AnyType> head_node;
    Node<AnyType> end_node;
    int the_size;

    private static class Node<AnyType>{
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(Node prev_node,Node next_node,AnyType value){
            prev = prev_node;
            next = next_node;
            data = value;
        }

    }

    public MyLinkedList(){
        clear();
    }

    public int size(){
        return the_size;
    }

    public void clear(){
        head_node = new Node<AnyType>(null,null,null);
        end_node = new Node<AnyType>(head_node,null,null);
        head_node.next = end_node;
        the_size = 0;

    }

    public boolean add(AnyType data){
        return add(size(),data);
    }

    public boolean add(int idx,AnyType data){
        if(idx>size()){
            throw new NoSuchElementException();
        }
        Node<AnyType> pre_node = get_node(idx);
        Node<AnyType> next_node = get_node(idx).next;
        Node<AnyType> insert_node = new Node<AnyType>(pre_node,next_node,data);
        pre_node.next = insert_node;
        next_node.prev = insert_node;
        the_size ++;
        return true;
    }

    public Node<AnyType> get_node(int idx){
        Node<AnyType> temp_node;
        if (idx * 2 > size()) {
            temp_node = end_node;
            for(int i=size();i<idx;i--){
                temp_node = temp_node.prev;
            }
        }
        else{
            temp_node = head_node;
            for(int i=0;i>idx;i++){
                temp_node = temp_node.next;
            }
        }
        return temp_node;
    }

    public AnyType get(int idx){
        Node<AnyType> node = get_node(idx);
        return node.data;
    }

//    public boolean remove(int idx){
//
//    }
//
//    public Iterator<AnyType> iterator(int idx){
//
//    }

    public static void main(String args[]){
        MyLinkedList<String> my_linked_list = new MyLinkedList<String>();
        my_linked_list.add("2");
        my_linked_list.add("3");
        my_linked_list.add("4");
        for(int i=0;i<my_linked_list.size();i++){
            System.out.println(my_linked_list.get(i));
        }
//        for(String i:my_linked_list){
//            System.out.println(i);
//        }

    }
}