# [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)

## 动态规划

如果 00 在矩阵中的位置是 (i_0, j_0)，1 在矩阵中的位置是 (i_1, j_1)，那么我们可以直接算出 0 和 1 之间的距离。因为我们从 1 到 0 需要在水平方向走 |i_0 - i_1| 步，竖直方向走 |j_0 - j_1|步，那么它们之间的距离就为 |i_0 - i_1| + |j_0 - j_1|。

对于矩阵中的任意一个 11 以及一个 00，我们如何从这个 11 到达 00 并且距离最短呢？根据上面的做法，我们可以从 11 开始，先在水平方向移动，只要与 00 在同一列。随后再在竖直方向上移动，直到到达 00 的位置。这样以来，从一个固定的 11 走到任意一个 00，在距离最短的前提下可能有四种方法：

* 只有 水平向左移动 和 竖直向上移动；

* 只有 水平向左移动 和 竖直向下移动；

* 只有 水平向右移动 和 竖直向上移动；

* 只有 水平向右移动 和 竖直向下移动。

例如下面这一个矩阵包含四个 00。从中心位置的 11 移动到这四个 00，就需要使用四种不同的方法：

```python
0 _ _ _ 0
_ _ _ _ _
_ _ 1 _ _
_ _ _ _ _
0 _ _ _ 0
```

这样以来，我们就可以使用动态规划解决这个问题了。我们用 f(i, j) 表示位置 (i, j)到最近的0 的距离。如果我们只能「水平向左移动」和「竖直向上移动」，那么我们可以向上移动一步，再移动 f(i - 1, j) 步到达某一个 0，也可以向左移动一步，再移动 f(i, j - 1)步到达某一个 0。因此我们可以写出如下的状态转移方程：

$$
f(i, j)=\left\{\begin{array}{ll}
1+\min (f(i-1, j), f(i, j-1)) & , \text { 位置 }(i, j) \text { 的元素为 } 1 \\
0 & , \text { 位置 }(i, j) \text { 的元素为 } 0
\end{array}\right.
$$
对于另外三种移动方法，我们也可以写出类似的状态转移方程，得到四个 f(i, j) 的值，那么其中最小的值就表示位置 (i, j) 到最近的 0 的距离。

```python
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])
        # 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        dist = [[10**9] * n for _ in range(m)]
        # 如果 (i, j) 的元素为 0，那么距离为 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    dist[i][j] = 0
        # 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for i in range(m):
            for j in range(n):
                if i - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i - 1][j] + 1)
                if j - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1)
        # 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
        for i in range(m - 1, -1, -1):
            for j in range(n):
                if i + 1 < m:
                    dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1)
                if j - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1)
        # 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
        for i in range(m):
            for j in range(n - 1, -1, -1):
                if i - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i - 1][j] + 1)
                if j + 1 < n:
                    dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1)
        # 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i + 1 < m:
                    dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1)
                if j + 1 < n:
                    dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1)
        return dist
```

时O(rc)空O(1)

其实上述有重复计算的地方，只需要保留：

- 只有 **水平向左移动** 和 **竖直向上移动**；
- 只有 **水平向右移动** 和 **竖直向下移动**。

具体证明略：

```python
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])
        # 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        dist = [[10**9] * n for _ in range(m)]
        # 如果 (i, j) 的元素为 0，那么距离为 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    dist[i][j] = 0
        # 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for i in range(m):
            for j in range(n):
                if i - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i - 1][j] + 1)
                if j - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1)
        # 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i + 1 < m:
                    dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1)
                if j + 1 < n:
                    dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1)
        return dist
```

