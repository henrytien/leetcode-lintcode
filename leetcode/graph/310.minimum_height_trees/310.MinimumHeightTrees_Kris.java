// Source : https://leetcode.com/problems/minimum-height-trees/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other 
 * words, any connected graph without simple cycles is a tree.
 * 
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, 
 * bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can 
 * choose any node of the tree as the root. When you select a node x as the root, the result tree has 
 * height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called 
 * minimum height trees (MHTs).
 * 
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 * 
 * The height of a rooted tree is the number of edges on the longest downward path between the root 
 * and a leaf.
 * 
 * Example 1:
 * 
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is 
 * the only MHT.
 * 
 * Example 2:
 * 
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 * 
 * Example 3:
 * 
 * Input: n = 1, edges = []
 * Output: [0]
 * 
 * Example 4:
 * 
 * Input: n = 2, edges = [[0,1]]
 * Output: [0,1]
 * 
 * Constraints:
 * 
 * 	1 <= n <= 2 * 104
 * 	edges.length == n - 1
 * 	0 <= ai, bi < n
 * 	ai != bi
 * 	All the pairs (ai, bi) are distinct.
 * 	The given input is guaranteed to be a tree and there will be no repeated edges.
 ******************************************************************************************************/

class Solution {
    // o(n), 类似求入度，把 leaf node 依次移除，最后剩下的就是最中心的 node
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        var res = new ArrayList<Integer>();
        if (n <= 2) {
            for (var i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        
        var graph = new ArrayList<Set<Integer>>();
        for (var i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }
        
        for (var edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        var queue = new LinkedList<Integer>();
        for (var i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                queue.offer(i);
            }
        }
        
        // 结果是 1 - 2 个
        while (n > 2) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                n--;
                for (var neighbor : graph.get(cur)) {
                    graph.get(neighbor).remove(cur);
                    if (graph.get(neighbor).size() == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }
    
    
    // TLE o(n^2)
    public List<Integer> findMinHeightTrees_tle(int n, int[][] edges) {
        var graph = new ArrayList<Set<Integer>>();
        for (var i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }
        
        for (var edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        var steps = new int[n];
        var min = Integer.MAX_VALUE;
        for (var i = 0; i < n; i++) {
            steps[i] = bfs(graph, i);
            min = Math.min(steps[i], min);
        }
        
        var res = new ArrayList<Integer>();
        for (var i = 0; i < n; i++) {
            if (steps[i] == min) {
                res.add(i);
            }
        }
        return res;
    }
    
    int bfs(List<Set<Integer>> graph, int node) {
        var step = 0;
        var visit = new HashSet<Integer>();
        var queue = new LinkedList<Integer>();
        queue.offer(node);
        visit.add(node);
        
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.pop();
                for (var neighbor : graph.get(cur)) {
                    if (visit.contains(neighbor)) {
                        continue;
                    }
                    
                    queue.offer(neighbor);
                    visit.add(neighbor);
                }
            }
            
            step++;
        }
        
        return step;
    }
}