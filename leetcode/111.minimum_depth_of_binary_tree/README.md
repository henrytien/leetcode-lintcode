# [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

## DFS

![image.png](assets/1597965016-AJnkxL-image.png)

在这个递归过程中，需要做以下判断递归结束条件：

* 如果当前节点是NULL，返回0，因为没有节点不再有深度增加
* 如果当前节点左右指针都为NULL，说明是叶节点，返回1，深度加一
* 如果当前左右指针有一个为NULL，那么需要注意，**因为为NULL的那一边不算有叶子节点**！所以深度只能算不是NULL的那一边:
  比如测试用例[1,2]，根节点1只有左子为2，返回的深度是1+左子节点返回的1=2，而不是1+右子节点返回的0=0。
* 剩下的是普通继续递归的情况，也就是左子和右子中较小的一方深度+1

## BFS

![image.png](assets/1597965123-xvjTsn-image.png)

BFS递归返回比较简单，只需要当前节点不存在左子和右子就可以返回