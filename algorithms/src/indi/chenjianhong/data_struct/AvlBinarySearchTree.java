package indi.chenjianhong.data_struct;

/**
 * Created by mason on 2015/4/15.
 * avl 树是带有平衡条件的二叉查找树
 */
public class AvlBinarySearchTree<AnyType extends Comparable<? super AnyType>>{

    private AvlBinaryNode<AnyType> root;

    public static class AvlBinaryNode<AnyType>{

        private AvlBinaryNode<AnyType> left;
        private AvlBinaryNode<AnyType> right;
        private AnyType data;
        private int height;

        public AvlBinaryNode(AvlBinaryNode<AnyType> left_node,AvlBinaryNode<AnyType> right_node,AnyType node_data){
            left = left_node;
            right = right_node;
            data = node_data;
            height = 0;
        }
    }

    public AvlBinarySearchTree(){

    }

    public AvlBinaryNode<AnyType> insert(AnyType data){
        root = insert(data,root);
        return root;
    }

    private int height(AvlBinaryNode<AnyType> node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    private int height(){
        return height(root);
    }

    private int max(int a,int b){
        return a>b?a:b;
    }

    private AvlBinaryNode<AnyType> leftLeftRotation(AvlBinaryNode<AnyType> k2){
        /*
        *           k2                   k1
        *          /  \                 / \
        *         k1   z       ->     x    k2
        *        /  \                /     / \
        *       x    y              x1    x   z
        *      /
        *     x1
        */
        AvlBinaryNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(height(k2.left),height(k2.right))+1;
        k1.height = max(height(k1.left),height(k1.right))+1;

        return k1;
    }

    private AvlBinaryNode<AnyType> rightRightRotation(AvlBinaryNode<AnyType> k2){
        /*
        *           k2                    k1
        *          /  \                 /   \
        *         z   k1       ->     k2    y
        *             /  \            / \    \
        *            x    y          z   x    y1
        *                 \
        *                  y1
        */
        AvlBinaryNode<AnyType> k1 = k2.right;
        k2.right = k2.left;
        k1.left = k2;

        k2.height = max(height(k2.left),height(k2.right))+1;
        k1.height = max(height(k1.left),height(k1.right))+1;

        return k1;
    }

    private AvlBinaryNode<AnyType> leftRightRotation(AvlBinaryNode<AnyType> k3){
        /*
        *           k3                   k3
        *          /  \                 / \
        *         k1   z       ->     k2    z   ->      k2
        *        /  \                / \              /   \
        *       x    k2            k1   x1           k1    k3
        *           /  \          / \               / \    / \
        *          y   x1        x  y              x  y  x1   z
        */
        k3.left = rightRightRotation(k3.left);
        return leftLeftRotation(k3);
    }


    private AvlBinaryNode<AnyType> rightLeftRotation(AvlBinaryNode<AnyType> k3){
        /*
        *           k3                   k3
        *          /  \                 / \
        *         z   k1       ->     z    k2   ->           k2
        *             / \                 / \              /   \
        *            k2  x               y  k1            k3    k1
        *           /  \                   / \           / \    / \
        *          y   x1                 x1  x         z  y  x1   x
        */
        k3.right = leftLeftRotation(k3.right);
        return rightRightRotation(k3);
    }

    public AvlBinaryNode<AnyType> insert(AnyType data,AvlBinaryNode<AnyType> node){
        if(node==null){
            return new AvlBinaryNode<AnyType>(null,null,data);
        }
        int compare_result = data.compareTo(node.data);
        if(compare_result<0){
            node.left = insert(data,node.left);
            if (height(node.left)-height(node.right)==2){
                if(data.compareTo(node.left.data)<0){
                    node = leftLeftRotation(node);
                }
                else {
                    node = leftRightRotation(node);
                }
            }
        }
        else if(compare_result>0){
            node.right = insert(data,node.right);
            if (height(node.right)-height(node.left)==2){
                if(data.compareTo(node.right.data)<0){
                    node = rightRightRotation(node);
                }
                else {
                    node = rightLeftRotation(node);
                }
            }
        }
        else {
            return node;
        }
        return node;
    }



}
