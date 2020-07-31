# Source : https://leetcode.com/problems/binary-tree-right-side-view/
# Author : yhwhu
# Date   : 2020-07-30

##################################################################################################### 
#
# Given a binary tree, imagine yourself standing on the right side of it, return the values of the 
# nodes you can see ordered from top to bottom.
# 
# Example:
# 
# Input: [1,2,3,null,5,null,4]
# Output: [1, 3, 4]
# Explanation:
# 
#    1            <---
#  /   \
# 2     3         <---
#  \     \
#   5     4       <---
#####################################################################################################


class Solution:
    def rightSideView_bfs(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return res
        queue = deque()
        queue.append(root)
        while queue:
            is_first = True
            for _ in range(len(queue)):
                node = queue.popleft()
                if is_first:
                    res.append(node.val)
                    is_first = False
                if node.right:
                    queue.append(node.right)
                if node.left:
                    queue.append(node.left)
        return res

    def rightSideView_dfs(self, root: TreeNode) -> List[int]:
        res = []
        self._dfs(res, 0, root)
        return res

    def _dfs(self, res, step, node):
        if not node:
            return
        if len(res) == step:
            res.append(node.val)
        self._dfs(res, step + 1, node.right)
        self._dfs(res, step + 1, node.left)

