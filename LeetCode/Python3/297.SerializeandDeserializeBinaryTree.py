# https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


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
