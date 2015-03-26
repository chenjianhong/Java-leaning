package indi.chenjianhong.data_struct;

/**
 * my own stack in 2015/3/26.
 */
public class MyArrayStack<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;

    private AnyType[] theItems;

    private int current=0;

    public MyArrayStack(){
        clear();
    }

    public void clear(){
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void ensureCapacity(int newCapacity){
        theItems = (AnyType[]) new Object[newCapacity];
    }

    public boolean push(AnyType value){
        theItems[current++] = value;
        return true;
    }

    public AnyType pop(){
        if (size()<=0){
            System.out.println(size());
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[--current];
    }

    public int size(){
        return current;
    }

    public static void main(String args[]){
        MyArrayStack<String> my_stack = new MyArrayStack<String>();
        my_stack.push("1");
        my_stack.push("2");
        my_stack.push("3");
        my_stack.push("4");
        for(int i=my_stack.size();i>0;i--){
            System.out.println(String.format("%s", my_stack.pop()));
        }
    }

}
