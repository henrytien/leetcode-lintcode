# Source : https://leetcode.com/problems/remove-invalid-parentheses/submissions/
# Author : yhwhu
# Date   : 2020-08-01

##################################################################################################### 
#
# Remove the minimum number of invalid parentheses in order to make the input string valid. Return 
# all possible results.
# 
# Note: The input string may contain letters other than the parentheses ( and ).
# 
# Example 1:
# 
# Input: "()())()"
# Output: ["()()()", "(())()"]
# 
# Example 2:
# 
# Input: "(a)())()"
# Output: ["(a)()()", "(a())()"]
# 
# Example 3:
# 
# Input: ")("
# Output: [""]
#####################################################################################################

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        queue = {s}
        while True:
            new_queue = set()
            # for pre_str in queue:
            #     if self.is_valid(pre_str):
            #         res.append(pre_str)
            res = list(filter(self.is_valid, queue))
            if res:
                return res
            for pre_str in queue:
                for i in range(len(pre_str)):
                    if pre_str[i] in "()":
                        new_queue.add(pre_str[:i] + pre_str[i + 1:])
            queue = new_queue

    def is_valid(self, s):
        count = 0
        for ss in s:
            if ss == "(":
                count += 1
            elif ss == ")":
                count -= 1
                if count < 0:
                    return False
        return count == 0

    def removeInvalidParentheses_record_unvalid_num(self, s: str) -> List[str]:
        queue = {s}
        res = []
        while True:
            min_queue = set()
            min_unvalid_num = float('inf')
            for pre_str in queue:
                unvalid_num = self.record_unvalid_num(pre_str)
                if unvalid_num == 0:
                    res.append(pre_str)
                elif res == [] and unvalid_num <= min_unvalid_num:
                    min_queue.add(pre_str)
                    min_unvalid_num = unvalid_num
            if res:
                return res
            new_queue = set()
            for pre_str in min_queue:
                for i in range(len(pre_str)):
                    if pre_str[i] in "()":
                        new_queue.add(pre_str[:i] + pre_str[i + 1:])
            queue = new_queue

    def record_unvalid_num(self, s: str) -> int:
        count = 0
        num_unvalid = 0
        for c in s:
            if c == '(':
                count += 1
            elif c == ')':
                count -= 1
                if count < 0:
                    num_unvalid += 1
                    count = 0
        return count + num_unvalid