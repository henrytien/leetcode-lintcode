# https://leetcode.com/problems/n-ary-tree-preorder-traversal/
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res, stack = [], [root]
        while stack:
            node = stack.pop()
            if node:
                # extend() faster than append() when have many items
                stack.extend(node.children[::-1])
                res.append(node.val)
        return res
