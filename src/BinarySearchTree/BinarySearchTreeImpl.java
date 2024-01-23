package BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinarySearchTreeImpl implements BinarySearchTree {

    @Override
    public Node getNodeOrNull(final Node node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            return node;
        }

        if (data < node.data) {
            return getNodeOrNull(node.left, data);
        }
        return getNodeOrNull(node.right, data);
    }

    @Override
    public Node insertRecursive(final Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    @Override
    public void traverseInOrderRecursive(final Node node) {
        if (node == null) {
            return;
        }

        traverseInOrderRecursive(node.left);
        System.out.println(node.data);
        traverseInOrderRecursive(node.right);
    }

    @Override
    public void traverseInOrderRecursiveDesc(final Node node) {
        if (node == null) {
            return;
        }

        traverseInOrderRecursiveDesc(node.right);
        System.out.println(node.data);
        traverseInOrderRecursiveDesc(node.left);
    }

    @Override
    public void traverseInOrder(final Node node) {
        if (node == null) {
            return;
        }

        Node current = node;

        Stack<Node> nodes = new Stack<>();

        while (!nodes.empty() || current != null) {
            if (current != null) {
                nodes.push(current);
                current = current.left;
            } else {
                current = nodes.pop();
                System.out.println(current.data);
                current = current.right;
            }
        }
    }

    @Override
    public void traverseInOrderDesc(final Node node) {
        if (node == null) {
            return;
        }

        Node current = node;

        Stack<Node> nodes = new Stack<>();

        while (!nodes.isEmpty() || current != null) {
            if (current != null) {
                nodes.push(current);
                current = current.right;
            } else {
                current = nodes.pop();
                System.out.println(current.data);
                current = current.left;
            }
        }
    }

    @Override
    public Node findPredecessorOrNull(final Node node) {
        if (node.left == null) {
            return null;
        }

        Node preNode = node.left;

        while (preNode.right != null) {
            preNode = preNode.right;
        }
        return preNode;
    }

    @Override
    public Map<String, Object> findMapPredecessorPredecessorParent(Node node) {
        Map<String ,Object> result = new HashMap<>();

        if (node.left == null) {
            return null;
        }

        Node preParent = node;
        Node preNode = node.left;

        while (preNode.right != null) {
            preParent = preNode;
            preNode = preNode.right;
        }

        result.put("preParent", preParent);
        result.put("preNode", preNode);
        return result;
    }

    @Override
    public Node findPredecessorOrNullRecursive(final Node node) {
        if (node.left == null) {
            return null;
        }

        return findPredecessorOrNullRecursiveTail(node);
    }

    private Node findPredecessorOrNullRecursiveTail(final Node node) {
        if (node.right == null) {
            return node;
        }

        return findPredecessorOrNullRecursiveTail(node);
    }

    @Override
    public Node findSuccessorOrNull(final Node node) {
        if (node == null) {
            return null;
        }

        Node sucNode = node.right;

        while (sucNode.left != null) {
            sucNode = sucNode.left;
        }

        return sucNode;
    }

    @Override
    public Map<String, Object> findMapSuccessorSuccessorParent(Node node) {
        Map<String ,Object> result = new HashMap<>();

        if (node == null) {
            return null;
        }

        Node sucParent = node;
        Node sucNode = node.right;

        while (sucNode.left != null) {
            sucParent = sucNode;
            sucNode = sucNode.left;
        }

        result.put("sucParent", sucParent);
        result.put("sucNode", sucNode);

        return result;
    }

    @Override
    public Node findSuccessorOrNullRecursive(final Node node) {
        if (node == null) {
            return null;
        }

        return findSuccessorOrNullRecursiveTail(node.right);
    }

    private Node findSuccessorOrNullRecursiveTail(final Node node) {
        if (node.left == null) {
            return node;
        }

        return findSuccessorOrNullRecursiveTail(node);
    }

    @Override
    public Node findParentNodeOrNull(final Node root, final int childData) {
        // 현재 노드의 부모를 저장할 포인터
        Node parent = null;

        // 루트 노드로 시작
        Node current = root;

        // 아래 while 은 자식 data 의 노드와 부모 노드를 동시에 찾을 수 있음.
        // BST 에서 자식 data 를 검색하고 부모 포인터를 설정합니다.
        while (current != null && current.data != childData) {
            // 부모를 현재 노드로 업데이트
            parent = current;

            // 주어진 data 가 현재 노드보다 작으면 왼쪽 하위 트리로 이동합니다.
            // 그렇지 않으면 오른쪽 하위 트리로 이동
            if (childData < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return parent;
    }

    @Override
    public Node findParentNodeOrNullRecursive(final Node root, final int childData) {
        if (root == null) {
            return null;
        }

        // childData is root data case
        if (root.data == childData) {
            return null;
        }

        if (root.left != null) {
            if (childData == root.left.data) {
                return root;
            }
        }

        if (root.right != null) {
            if (childData == root.right.data) {
                return root;
            }
        }

        if (childData < root.data) {
            return findParentNodeOrNullRecursive(root.left, childData);
        }
        return findParentNodeOrNullRecursive(root.right, childData);
    }

    @Override
    public Node deleteNode(final Node root, final int data) {
        // 지울 대상의 부모 노드 찾기
        if (data < root.data) {
            root.left = deleteNode(root.left, data);
            return root;
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
            return root;
        }
        /**
         * [삭제 대상 노드 대상을 지울 4가지 경우]
         * 1. 왼쪽 하위 노드가 1개만 있는 경우
         * 2. 오른쪽 하위 노드가 1개만 있는 경우
         * 3. 왼쪽, 오른쪽 하위 노드가 다 없는 경우
         */
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }
        /**
         * 4. 왼쪽, 오른쪽 하위 노드가 모두 있는 경우
         */
        else {
            Node succParent = root;

            // Find successor
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // succParent 가 삭제 노드와 다른 경우
            if (succParent != root) {
                succParent.left = succ.right;
            }
            // succParent 가 삭제 노드와 같은 경우
            else {
                succParent.right = succ.right;
            }

            // Copy Successor Data to root
            root.data = succ.data;

            // Delete Successor and return root
            return root;
        }
    }

    @Override
    public void traversePreOrderRecursive(final Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        traversePreOrderRecursive(node.left);
        traversePreOrderRecursive(node.right);
    }

    @Override
    public void traverseSucOrderRecursive(final Node node) {
        if (node == null) {
            return;
        }

        traverseSucOrderRecursive(node.left);
        traverseSucOrderRecursive(node.right);
        System.out.println(node.data);
    }
}
