package indi.chenjianhong.data_struct;

/**
 * Created by mason on 2015/4/15.
 * avl 树是带有平衡条件的二叉查找树
 */
public class AvlBinarySearchTree<AnyType>{

    private AvlBinaryNode<AnyType> root;

    public static class AvlBinaryNode<AnyType>{

        private AvlBinaryNode<AnyType> pre;
        private AvlBinaryNode<AnyType> next;
        private AnyType data;

        public AvlBinaryNode(AvlBinaryNode<AnyType> pre_node,AvlBinaryNode<AnyType> next_node,AnyType node_data){
            pre = pre_node;
            next = next_node;
            data = node_data;
        }
    }

    public AvlBinarySearchTree(){

    }

    


}
