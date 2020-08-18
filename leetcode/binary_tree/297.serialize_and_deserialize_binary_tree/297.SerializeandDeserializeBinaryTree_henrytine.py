# Source : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
# Author : henrytine
# Date   : 2020-08-18

##################################################################################################### 
#
# Serialization is the process of converting a data structure or object into a sequence of bits so 
# that it can be stored in a file or memory buffer, or transmitted across a network connection link 
# to be reconstructed later in the same or another computer environment.
# 
# Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
# serialization/deserialization algorithm should work. You just need to ensure that a binary tree can 
# be serialized to a string and this string can be deserialized to the original tree structure.
# 
# Example: 
# 
# You may serialize the following tree:
# 
#     1
#    / \
#   2   3
#      / \
#     4   5
# 
# as "[1,2,3,null,null,4,5]"
# 
# Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not 
# necessarily need to follow this format, so please be creative and come up with different approaches 
# yourself.
# 
# Note: Do not use class member/global/static variables to store states. Your serialize and 
# deserialize algorithms should be stateless.
#####################################################################################################


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        res = []
        self.helper(root, res)
        return ' '.join(res)

    def helper(self, node, res):
        if node:
            res.append(str(node.val))
            self.helper(node.left, res)
            self.helper(node.right, res)
        else:
            res.append('#')

        # def doit(node):
        #     if node:
        #         vals.append(str(node.val))
        #         doit(node.left)
        #         doit(node.right)
        #     else:
        #         vals.append('#')
        # vals = []
        # doit(root)
        # return ' '.join(vals)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        def doit():
            val = next(vals)
            if val == '#':
                return None
            node = TreeNode(int(val))
            node.left = doit()
            node.right = doit()
            return node
        vals = iter(data.split())
        return doit()


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
