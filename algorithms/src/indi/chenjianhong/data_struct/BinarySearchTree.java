package indi.chenjianhong.data_struct;


/**
 * own search tree
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{

    private BinaryNode<AnyType> root;

    public BinarySearchTree(){
        root = null;
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

    public void print_tree(){
        print_tree(root);
    }

    public void print_tree(BinaryNode<AnyType> parent_node){
        System.out.println(String.format("%s",parent_node.data));
        if (parent_node.right!= null){
            print_tree(parent_node.right);
        }
        if (parent_node.left!= null){
            print_tree(parent_node.left);
        }
    }

    public static void main(String args[]){
        BinarySearchTree<Integer> b_tree = new BinarySearchTree<Integer>();
        b_tree.insert(1);
        b_tree.insert(2);
        b_tree.insert(3);
        b_tree.insert(4);
        b_tree.print_tree();
    }



}
