# https://leetcode.com/problems/n-ary-tree-level-order-traversal/
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res, queue = [], [root]

        while any(queue):
            res.append([node.val for node in queue])
            queue = [
                children for node in queue for children in node.children if children]
        return res
