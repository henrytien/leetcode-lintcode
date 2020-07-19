# [190. Reverse Bits](https://leetcode-cn.com/problems/reverse-bits/)

## 逐位颠倒

从右到左遍历输入整数的位字符串（即 `n=n>>1`）。要检索整数的最右边的位，应用与运算（`n&1`）

对于每个位，我们将其反转到正确的位置（即`（n&1）<<power`）。然后添加到最终结果。

当 `n==0` 时，我们终止迭代。