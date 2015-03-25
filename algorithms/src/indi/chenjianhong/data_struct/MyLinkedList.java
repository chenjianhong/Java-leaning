package indi.chenjianhong.data_struct;

import java.lang.Iterable;
import java.lang.String;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    Node<AnyType> head_node;
    Node<AnyType> end_node;
    int the_size;

    private static class Node<AnyType>{
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(Node<AnyType> prev_node,Node<AnyType> next_node,AnyType value){
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
        Node<AnyType> pre_node = get_node(idx).prev;
        Node<AnyType> next_node = get_node(idx);
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
            for(int i=size();i>idx;i--){
                temp_node = temp_node.prev;
            }
        }
        else{
            temp_node = head_node.next;
            for(int i=0;i<idx;i++){
                temp_node = temp_node.next;
            }
        }
        return temp_node;
    }

    public AnyType get(int idx){
        Node<AnyType> node = get_node(idx);
        return node.data;
    }

    public void remove(int idx){
        Node<AnyType> current_node = get_node(idx);
        remove(current_node);
    }

    public void remove(Node<AnyType> current_node){
        current_node.prev.next = current_node.next;
        current_node.next.prev = current_node.prev;
    }

    public Iterator<AnyType> iterator(){
        return new <AnyType>MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements java.util.Iterator<AnyType>{

        private Node<AnyType> current = head_node.next;

        public boolean hasNext(){
            return current != end_node;
        }

        public AnyType next(){
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            AnyType next_item = current.data;
            current = current.next;
            return next_item;
        }

        public void remove(){
            MyLinkedList.this.remove(current.prev);
        }
    }

    public static void main(String args[]){
        MyLinkedList<String> my_linked_list = new MyLinkedList<String>();
        Logger logger = Logger.getLogger(MyLinkedList.class);
        logger.debug("begin to print:");
        my_linked_list.add("2");
        my_linked_list.add("3");
        my_linked_list.add("4");
        for(int i=0;i<my_linked_list.size();i++){
            System.out.println(my_linked_list.get(i));
        }
        my_linked_list.remove(2);
        logger.debug("begin to for each print:");
        for(String i:my_linked_list){
            System.out.println(i);
        }

    }
}