package indi.chenjianhong.data_struct;

import org.omg.CORBA.Any;

/**
 * own search tree
 */
public class BinarySearchTree<AnyType>{

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


    public boolean insert(AnyType element_data){

    }

    public boolean insert(AnyType element_data,BinaryNode<AnyType> parent_node){

    }



}
