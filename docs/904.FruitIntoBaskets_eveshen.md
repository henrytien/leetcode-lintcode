# 904. Fruit Into Baskets

In a row of trees, the `i`-th tree produces fruit with type `tree[i]`.

You **start at any tree of your choice**, then repeatedly perform the following steps:

1. Add one piece of fruit from this tree to your baskets. If you cannot, stop.
2. Move to the next tree to the right of the current tree. If there is no tree to the right, stop.

Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

**Example 1:**

```
Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].
```

**Example 2:**

```
Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
```

**Example 3:**

```
Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
```

**Example 4:**

```
Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.
```

 

**Note:**

1. `1 <= tree.length <= 40000`
2. `0 <= tree[i] < tree.length`

## Ideas

Longest Subarray of 2 Elements.

1st pointer is used to record the last index of the previous tree type. 2nd pointer keeps moving forward whenever the value is the same as the previous one. When it's different, move the 1st pointer to the previous one and compare the length to the maximum of the length so far.

## Highlights

**Initialization**

**Corner case**: 

* Be careful when there're only 2 elements, such as [1, 2, 1]. When there's only 1 tree type, which means the 1st pointer hasn't been changed, then it can store the tree type. 
* The maximum is only calculated when we meet the third type, so don't forget to calculate the maximum in the end for other cases.

## Code

```java
# Source : https://leetcode.com/problems/fruit-into-baskets/
# Author: Eve
# Date: 2020-07-18
    
class Solution {
    public int totalFruit(int[] tree) {
        int max = 0;
        int i = -1;
        int j = 1;
        int cnt = 1;
        while (j < tree.length) {
            if (tree[j] == tree[j - 1]) {
                j++;
                cnt++;
            } else if (i == -1 || tree[j] == tree[i]) {
                i = j - 1;
                j++;
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = j - i;
                i = j - 1;
                j++;
            }
        }
        max = Math.max(max, cnt); 
        return max;
    }
} 
```