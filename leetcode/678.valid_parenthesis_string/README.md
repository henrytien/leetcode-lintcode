# [678. Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/)

This solution from [@softwareshortcut](https://leetcode.com/problems/valid-parenthesis-string/solution/257775).

#### Approach #1 : Greedy **[Accepted]**

**Intuition**

There is another simple O(n) solution with O(1) space complexity, not very intuitive like the greedy approach, but it's nice to know about it. We can rephrase the problem by listing all the valid cases. There are 3 valid cases:

1. There are more open parenthesis but we have enough '*' so we can balance the parenthesis with ')' 
2. There are more close parenthesis but we have enough '*' so we can balance the parenthesis with '('
3. There are as many '(' than ')' so all parenthesis are balanced, we can ignore the extra '*'

**Algorithm**

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



#### Approach #2 : Greedy [Accepted]

This solution from [leetcode](https://leetcode.com/problems/valid-parenthesis-string/solution/).

**Intuition**

When checking whether the string is valid, we only cared about the "`balance`": the number of extra, open left brackets as we parsed through the string. For example, when checking whether '(()())' is valid, we had a balance of `1, 2, 1, 2, 1, 0` as we parse through the string: `'('` has 1 left bracket, `'(('` has 2, `'(()'` has 1, and so on. This means that after parsing the first `i` symbols, (which may include asterisks,) we only need to keep track of what the `balance` could be.

For example, if we have string `'(***)'`, then as we parse each symbol, the set of possible values for the `balance` is `[1]` for `'('`; `[0, 1, 2]` for `'(*'`; `[0, 1, 2, 3]` for `'(**'`; `[0, 1, 2, 3, 4]` for `'(***'`, and `[0, 1, 2, 3]` for `'(***)'`.

Furthermore, we can prove these states always form a contiguous interval. Thus, we only need to know the left and right bounds of this interval. That is, we would keep those intermediate states described above as `[lo, hi] = [1, 1], [0, 2], [0, 3], [0, 4], [0, 3]`.

**Algorithm**

Let `lo, hi` respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.

If we encounter a left bracket (`c == '('`), then `lo++`, otherwise we could write a right bracket, so `lo--`. If we encounter what can be a left bracket (`c != ')'`), then `hi++`, otherwise we must write a right bracket, so `hi--`. If `hi < 0`, then the current prefix can't be made valid no matter what our choices are. Also, we can never have less than `0` open left brackets. At the end, we should check that we can have exactly 0 open left brackets.

```c++
class Solution {
public:
    bool checkValidString(string s) {
        int min_open = 0, max_open = 0;
        for (auto &&iter : s)
        {
            min_open += iter == '(' ? 1:-1;
            max_open += iter != ')' ? 1:-1;
            if (max_open < 0) break;
            min_open = max(min_open,0);
        }
        return min_open == 0;
    }
};
```

**Complexity Analysis**

- Time Complexity: O(*N*), where N is the length of the string. We iterate through the string once.
- Space Complexity: O*(1)*, the space used by our `lo` and `hi` pointers. However, creating a new character array will take O(*N*) space.