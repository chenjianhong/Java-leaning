package indi.chenjianhong.data_struct;


import org.omg.CORBA.Any;

/**
 * own search tree
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{

    private BinaryNode<AnyType> root;

    public BinarySearchTree(){

    }

    private static class BinaryNode<AnyType>{

        private BinaryNode<AnyType> left;
        private BinaryNode<AnyType> right;
        private AnyType data;

        public BinaryNode(BinaryNode<AnyType> left_node,BinaryNode<AnyType> right_node,AnyType element_value){
            left = left_node;
            right = right_node;
            data = element_value;
        }
    }


    public void insert(AnyType element_data){
        root = insert(element_data,root);
    }

    public BinaryNode<AnyType> insert(AnyType element_data,BinaryNode<AnyType> parent_node){
        if(parent_node == null){
            return new BinaryNode<AnyType>(null,null,element_data);
        }
        int compare_result = element_data.compareTo(parent_node.data);
        if(compare_result>0){
            parent_node.right = insert(element_data, parent_node.right);
        }
        else if(compare_result<0){
            parent_node.left = insert(element_data,parent_node.left);
        }
        return parent_node;
    }

    public boolean remove(AnyType element_data){
        return remove(element_data,root);
    }

    public boolean remove(AnyType element_data,BinaryNode<AnyType> node){
        if(node == null){
            return false;
        }
        int compare_result = element_data.compareTo(node.data);
        if(compare_result>0){
            return remove(element_data, node.right);
        }
        else if(compare_result<0){
            return remove(element_data, node.left);
        }
        else if(node.left != null && node.right != null) {
            node.data = find_min(node.left).data;
            return remove(node.data,node.left);
        }
        else {
            node = (node.left != null) ? node.left:node.right;
            return true;
        }
    }

    public boolean contains(AnyType x){
        return contains(x,root);
    }
    public boolean contains(AnyType x, BinaryNode<AnyType> node){
        if(node == null){
            return false;
        }
        int compare_result = x.compareTo(node.data);
        if(compare_result<0){
            return contains(x,node.left);
        }
        else {
            return compare_result == 0 || contains(x,node.right);
        }
    }

    public AnyType find_min(){
        return find_min(root).data;
    }

    public AnyType find_max(){
        return find_max(root).data;
    }

    public BinaryNode<AnyType> find_max(BinaryNode<AnyType> node){
        if(node.right == null){
            return node;
        }
        else {
            return find_max(node.right);
        }

    }

    public BinaryNode<AnyType> find_min(BinaryNode<AnyType> node){
        if(node.left == null){
            return node;
        }
        else {
            return find_min(node.left);
        }
    }

    public void print_tree(){
        print_tree(root);
    }

    public void print_tree(BinaryNode<AnyType> parent_node){
        System.out.println(String.format("%s",parent_node.data));
        if (parent_node.left!= null){
            System.out.println("print left");
            print_tree(parent_node.left);
        }
        if (parent_node.right!= null){
            System.out.println("print right");
            print_tree(parent_node.right);
        }
    }

    public static void main(String args[]){
        BinarySearchTree<Integer> b_tree = new BinarySearchTree<Integer>();
        b_tree.insert(1);
        b_tree.insert(2);
        b_tree.insert(3);
        b_tree.insert(4);
        b_tree.print_tree();
        System.out.println(String.format("%s",b_tree.contains(1)));
        System.out.println(String.format("%s",b_tree.contains(10)));
        System.out.println(String.format("%s",b_tree.find_min()));
        System.out.println(String.format("%s",b_tree.find_max()));
    }



}
