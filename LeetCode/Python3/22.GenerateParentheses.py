# https://leetcode.com/problems/generate-parentheses/


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        str = ""
        self.generate(0, 0, n, str, res)
        return res

    def generate(self, left, right, n, str, res):
        # terminator
        if left == n and right == n:
            res.append(str)
            return
        # process current logic : left, right

        # drill down
        if left < n:
            self.generate(left + 1, right, n, str + "(", res)
        # first have left
        if left > right:
            self.generate(left, right + 1, n, str + ")", res)
        # reverse states
