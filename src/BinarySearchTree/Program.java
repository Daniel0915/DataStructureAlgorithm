package BinarySearchTree;

import BinarySearchTree.BinarySearchTree;

public class Program {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();

        Node node = new Node(6);

        // 삽입
        binarySearchTree.insertRecursive(node, 4);
        binarySearchTree.insertRecursive(node, 2);
        binarySearchTree.insertRecursive(node, 10);

        // 중위 순회(오름차순)
        binarySearchTree.traverseInOrderRecursive(node);
        System.out.println();
        // 중위 순회(내림차순)
        binarySearchTree.traverseInOrderRecursiveDesc(node);
        System.out.println();


        binarySearchTree.traverseInOrder(node);
        System.out.println();

        binarySearchTree.traverseInOrderDesc(node);
        System.out.println();

        System.out.println(binarySearchTree.findParentNodeOrNullRecursive(node, 6).data);


    }

}
