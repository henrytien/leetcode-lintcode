# [279. Perfect Squares](https://leetcode.com/problems/perfect-squares/)



#### Approach 4: Greedy + BFS (Breadth-First Search)

**Intuition**

As we mentioned in the complexity analysis in the above Greedy approach, the trace of the call stack forms a N-ary tree where each node represents a call to the `is_divided_by(n, count)` function. Based on the above intuition, again we could reformulate the original problem as follows:

> Given a N-ary tree, where each node represents a **remainder** of the number `n` subtracting a combination of square numbers, our task is to find a node in the tree, which should meet two conditions: 1). the value of the node (*i.e.* the remainder) should be a square number as well. 2). the distance between the node and the root should be minimal among all nodes that meet the condition (1).

Here is an example how the tree would look like.

![pic](https://leetcode.com/problems/perfect-squares/Figures/279/279_greedy_tree.png)

In the previous Approach #3, due to the *Greedy* strategy that we perform the calls, we were actually constructing the N-ary tree level-by-level from top to down. And the we were traversing it in a ***BFS\*** (Breadth-First Search) manner. At each level of the N-ary tree, we were enumerating the combinations that are of the same size.

The order of traversing is of BFS, rather than DFS (Depth-First Search), is due to the fact that before exhausting all the possibilities of decomposing a number `n` with a fixed amount of squares, we would not explore any potential combination that needs more elements.

**Algorithm**

- Again, first of all, we prepare a list of square numbers (named `square_nums`) that are less than the given number `n`.
- We then create a `queue` variable which would keep all the remainders to enumerate at each level.
- In the main loop, we iterate over the `queue` variable. At each iteration, we check if the remainder is one of the square numbers. If the remainder is not a square number, we subtract it with one of the square numbers to obtain a new remainder and then add the new remainder to the `next_queue` for the iteration of the next level. We break out of the loop once we encounter a remainder that is of a square number, which also means that we find the solution.

***Note\***: in a typical BFS algorithm, the `queue` variable usually would be of array or list type. However, here we use the set type, in order to eliminate the redundancy of remainders within the same level. As it turns out, this tiny trick could even provide a 5 times speedup on running time.

In the following graph, we illustrate the layout of the queue, on the example of `numSquares(7)`.

![pic](https://leetcode.com/problems/perfect-squares/Figures/279/279_greedy_bfs.png)

Here are some sample implementations. In particular, the Python implementation inspired from the post of [ChrisZhang12240](https://leetcode.com/problems/perfect-squares/discuss/71475/Short-Python-solution-using-BFS) took ~200 ms which was faster than ~72% of submission at that time.

Java 


```java
class Solution {
  public int numSquares(int n) {

    ArrayList<Integer> square_nums = new ArrayList<Integer>();
    for (int i = 1; i * i <= n; ++i) {
      square_nums.add(i * i);
    }

    Set<Integer> queue = new HashSet<Integer>();
    queue.add(n);

    int level = 0;
    while (queue.size() > 0) {
      level += 1;
      Set<Integer> next_queue = new HashSet<Integer>();

      for (Integer remainder : queue) {
        for (Integer square : square_nums) {
          if (remainder.equals(square)) {
            return level;
          } else if (remainder < square) {
            break;
          } else {
            next_queue.add(remainder - square);
          }
        }
      }
      queue = next_queue;
    }
    return level;
  }
}
```



**Complexity**

- Time complexity: \mathcal{O}( \frac{\sqrt{n}^{h+1} - 1}{\sqrt{n} - 1} ) = \mathcal{O}(n^{\frac{h}{2}})O(*n*−1*n**h*+1−1)=O(*n*2*h*) where `h` is the height of the N-ary tree. One can see the detailed explanation on the previous Approach #3.
- Space complexity: \mathcal{O}\Big((\sqrt{n})^h\Big)O((*n*)*h*), which is also the maximal number of nodes that can appear at the level `h`. As one can see, though we keep a list of `square_nums`, the main consumption of the space is the `queue` variable, which keep track of the remainders to visit for a given level of N-ary tree.