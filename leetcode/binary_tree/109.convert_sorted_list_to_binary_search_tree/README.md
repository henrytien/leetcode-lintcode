# [109. Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)

## 先转成有序数组 

先将有序链表转成有序数组，如下图，想象成一条绳，提起中点作为根节点，分出左右两部分，再提起各自的中点作为根节点……不断分治，这根绳就“提”成了个 BST 的模样

<img src="assets/b1fa4b53b441012493e96bde10833e4b997446d403ea04794a32df36a2d1f06e-image.png" alt="image.png" style="zoom:50%;" />

时O(N)，空O(N)

## 