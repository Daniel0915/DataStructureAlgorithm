package BinarySearchTree;

import BinarySearchTree.BinarySearchTree;

public class Program {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();

        Node node = new Node(50);

        // 삽입
        binarySearchTree.insertRecursive(node, 30);
        binarySearchTree.insertRecursive(node, 24);
        binarySearchTree.insertRecursive(node, 5);
        binarySearchTree.insertRecursive(node, 28);
        binarySearchTree.insertRecursive(node, 45);
        binarySearchTree.insertRecursive(node, 98);
        binarySearchTree.insertRecursive(node, 52);
        binarySearchTree.insertRecursive(node, 60);

//        binarySearchTree.traversePreOrderRecursive(node);

        binarySearchTree.traverseSucOrderRecursive(node);
    }

}
