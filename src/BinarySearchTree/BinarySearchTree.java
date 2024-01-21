package BinarySearchTree;

import java.util.Map;

public interface BinarySearchTree {
    Node getNodeOrNull(final Node node, int data);

    Node insertRecursive(final Node node, int data);

    // 재귀 중위 순회(왼쪽 하위 트리 -> 현재 노드 -> 오른쪽 하위 트리), 오름차순
    void traverseInOrderRecursive(final Node node);

    // 재귀 중위 순회(왼쪽 하위 트리 -> 현재 노드 -> 오른쪽 하위 트리), 내림차순
    void traverseInOrderRecursiveDesc(final Node node);

    // 스택 중위 순회(왼쪽 하위 트리 -> 현재 노드 -> 오른쪽 하위 트리), 오름차순
    void traverseInOrder(final Node node);

    // 스택 중위 순회(왼쪽 하위 트리 -> 현재 노드 -> 오른쪽 하위 트리), 내림차순
    void traverseInOrderDesc(final Node node);

    // 이전 노드(while 문) 찾기
    Node findPredecessorOrNull(final Node node);

    // 이전 노드와 다음 노드의 부모 찾기
    Map<String, Object> findMapPredecessorPredecessorParent(final Node node);

    // 이전 노드(재귀함수) 찾기
    Node findPredecessorOrNullRecursive(final Node node);

    // 다음 노드(while 문) 찾기
    Node findSuccessorOrNull(final Node node);

    // 다음 노드와 다음 노드의 부모 찾기
    Map<String, Object> findMapSuccessorSuccessorParent(final Node node);

    // 다음 노드(재귀함수) 찾기
    Node findSuccessorOrNullRecursive(final Node node);

    // 부모 노드(while 문) 찾기
    Node findParentNodeOrNull(final Node root, final int childData);

    // 부모 노드(재귀 함수) 찾기
    Node findParentNodeOrNullRecursive(final Node root, final int childData);

    // 노드 삭제
    Node deleteNode(final Node root, final int data);
}
