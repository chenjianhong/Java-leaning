import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Object;
import java.lang.String;
import java.lang.System;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by User on 2015/3/19.
 */
public class MyArrayList<AnyType>{
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

    public static void main(String args[]){
        MyArrayList my_array_list = new MyArrayList<String>();
        System.out.println("ok");
    }

}