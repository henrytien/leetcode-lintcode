# [1504. Count Submatrices With All Ones](https://leetcode.com/problems/count-submatrices-with-all-ones/)

## [C++ O(m*m*n) solution using dp (dp[m][n]: is the number of left ones starting from (m,n))](https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720214/C%2B%2B-O(m*m*n)-solution-using-dp-(dpmn%3A-is-the-number-of-left-ones-starting-from-(mn)))

> Actually, I've done so many DP problems. When I see this problem, I thought that it's a DP, and I was sure that it's a DP when I saw the data size (1<=m<=150 and 1<=n<=150).
The time complexity can be at most mxmxn or mxnxn (if the number of calculations is greater than 10000^2, then it's very likely to exceed the time limits).
I then thought how I can recorded the previous calculations and used it to lower the complexity.
When trying to lower the complexity, it's always a great way to start from thinking about the constraints of the problem (In this case, each row of an rectangle should be the same length (so the minimum number of the left ones on a straight line is the number of rectangle that can be made with that line height)).
I then learned that if I can first know how many left ones are there starting from (m,n), I can easily accumulated the number of rectangles with the bottom right one being (m,n).
I can make the rectangles with the right edge extended from mat[i][j] to mat[k][j] and accumulated the result.
That's how I solved this problem.

