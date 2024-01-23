package BackJun.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test5639 {

    static class Node {
        int date;
        Node left;
        Node right;

        Node(int date) {
            this.date = date;
        }

        Node(int date, Node left, Node right) {
            this.date = date;
            this.left = left;
            this.right = right;
        }

        Node insertRecursive(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }

            if (data < root.date) {
                root.left = insertRecursive(root.left, data);
            } else {
                root.right = insertRecursive(root.right, data);
            }

            return root;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        Node node = new Node(Integer.parseInt(reader.readLine()));
        while (true) {
            input = reader.readLine();

            if (Objects.equals(input, "exit")) {
                break;
            }

            node = node.insertRecursive(node, Integer.parseInt(input));
        }

        traverseSucOrderRecursive(node);

    }

    static void traverseSucOrderRecursive(Node node) {
        if (node == null)
            return;

        traverseSucOrderRecursive(node.left);
        traverseSucOrderRecursive(node.right);
        System.out.println(node.date);
    }



}
