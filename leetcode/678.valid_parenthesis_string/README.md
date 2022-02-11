# [678. Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/)

This solution from [@softwareshortcut](https://leetcode.com/problems/valid-parenthesis-string/solution/257775).

There is another simple O(n) solution with O(1) space complexity, not very intuitive like the greedy approach, but it's nice to know about it. We can rephrase the problem by listing all the valid cases. There are 3 valid cases:

1. There are more open parenthesis but we have enough '*' so we can balance the parenthesis with ')' 
2. There are more close parenthesis but we have enough '*' so we can balance the parenthesis with '('
3. There are as many '(' than ')' so all parenthesis are balanced, we can ignore the extra '*'

**Algorithm**:

You can parse the String twice, once from left to right by replacing all '*' by '(' and once from right to left by replacing all '*' by ')'. For each of the 2 loops, if there's an iteration where you end up with a negative count (SUM['('] - SUM[')'] < 0) then you know the parenthesis were not balanced. You can return false. After these 2 checks (2 loops), you know the string is balanced because you've satisfied all the 3 valid cases mentioned above. Voila!

Code from [@eli215](https://leetcode.com/problems/valid-parenthesis-string/solution/1083637)

```python
def checkValidString(self, s: str) -> bool:
    min_open = 0    # Current minimum possible unclosed left braces
    max_open = 0    # Current maximum possible unclosed left braces

    for c in s:
        if '(' == c:
            min_open += 1
            max_open += 1
        elif ')' == c:
            min_open -= 1
            max_open -= 1
        else: # '*' == c 
            min_open -= 1   # if used as ')'
            max_open += 1   # if used as '('

        if max_open < 0:
            # We have a ')' with no possible matching '(' before it
            # i.e. the num of ')'s > the num of '('s and '*'s.
            return False
        elif min_open < 0:
            # min_open can become negative because we COULD in theory use
            # a '*' as a ')' even when there is no previous '(' to match with it.
            # However, we don't want to do this because it would give us an invalid
            # string. This check serves as a guarantee that we won't ever perform 
            # this unwanted '*' substitution.
            min_open = 0

    if min_open == 0:
        # It is possible to close all open left braces
        return True
    else:
        # It is NOT possible to close all open left braces
        return False
```