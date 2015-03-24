package indi.chenjianhong.data_struct;
import java.io.UnsupportedEncodingException;
import java.lang.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Character;
import java.lang.Object;
import java.lang.String;
import java.lang.System;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by User on 2015/3/19.
 */
public class MyArrayList<AnyType> implements java.lang.Iterable<AnyType>{
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList(){
        clear();
    }

    public void clear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void ensureCapacity(int newCapacity){
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for(int i=0;i<size();i++){
            theItems[i]=old[i];
        }
    }

    public int size(){
        return theSize;
    }

    public AnyType get(int idx){
        if(idx<0 || idx>=size()){
            throw new ArrayIndexOutOfBoundsException("a ha");
        }
        return theItems[idx];
    }

    public AnyType set(int idx, AnyType newVal){
        if(idx<0 || idx>=size()){
            throw new ArrayIndexOutOfBoundsException("a ha");
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public boolean add(AnyType x){
        add(size(),x);
        return true;
    }

    public boolean add(int idx, AnyType x){
        if(theItems.length == size()){
            ensureCapacity(size()*2 +1);
        }
        for(int i=theSize;i>idx;i--){
            theItems[i] = theItems[i-1];
        }
        theItems[idx] = x;
        theSize ++;
        return true;
    }

    public AnyType remove(int idx){
        AnyType remove_item = theItems[idx];
        for(int i=idx;i<size();i++){
            theItems[i] = theItems[i+1];
        }
        theSize--;
        return remove_item;
    }

    public java.util.Iterator<AnyType> iterator(){
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements java.util.Iterator<AnyType>{
        private int current = 0;

        public boolean hasNext(){
            return current < size();
        }

        public AnyType next(){
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            return theItems[current++];
        }

        public void remove(){
            MyArrayList.this.remove(--current);
        }
    }

    public static void main(String args[]){
        MyArrayList<String> my_array_list = new MyArrayList();
        try {
            String encoding = System.getProperty("file.encoding");
            System.out.println(encoding);
            System.out.println("中文");
            String str = "我是 :1";
            str = new String(str.getBytes("GBK"), "GBK");
            my_array_list.add(str);
        }catch (UnsupportedEncodingException e){

        }
        my_array_list.add("2");
        my_array_list.add("3");
        my_array_list.add("4");
        my_array_list.set(2, "wo shi 2");
        my_array_list.remove(2);

        for(int i=0;i<my_array_list.size();i++){
            System.out.println(my_array_list.get(i));
        }
        for(String i:my_array_list){
            System.out.println(i);
        }

        MyArrayList<Character> my_array_list_2 = new MyArrayList<Character>();
        System.out.println("ok 2");
        my_array_list_2.add('5');
        my_array_list_2.add('6');
        my_array_list_2.add('7');
        my_array_list_2.add('8');
        my_array_list_2.remove(2);
        for(int i=0;i<my_array_list_2.size();i++){
            System.out.println(my_array_list_2.get(i));
        }
        for(Character i:my_array_list_2){
            System.out.println(i);
        }

    }

}