package org.example.algorithm.tree;

public class BinaryTree {

    private int data;
    private  BinaryTree left;
    private  BinaryTree right;


    public BinaryTree() {
    }

    public BinaryTree(int data) {
        this.data = data;
    }

    public BinaryTree(BinaryTree left, BinaryTree right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
