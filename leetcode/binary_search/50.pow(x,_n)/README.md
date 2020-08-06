# [50. Pow(x, n)](https://leetcode.com/problems/powx-n/)

## 法一：快速幂+迭代

给定x和n，最原始的就是将x乘以n次，但是实现快速幂乘，可以利用中间产生的量，比如x^2基础上乘以x^2或者其他的。这样不难联想到十进制二进制之间的转化。

思路与[29. Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)有异曲同工之妙