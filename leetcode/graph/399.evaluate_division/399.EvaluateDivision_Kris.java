// Source : https://leetcode.com/problems/evaluate-division/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where 
 * equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is 
 * a string that represents a single variable.
 * 
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you 
 * must find the answer for Cj / Dj = ?.
 * 
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * 
 * Note: The input is always valid. You may assume that evaluating the queries will not result in 
 * division by zero and that there is no contradiction.
 * 
 * Example 1:
 * 
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = 
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation: 
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 
 * Example 2:
 * 
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = 
 * [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * 
 * Example 3:
 * 
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * 
 * Constraints:
 * 
 * 	1 <= equations.length <= 20
 * 	equations[i].length == 2
 * 	1 <= Ai.length, Bi.length <= 5
 * 	values.length == equations.length
 * 	0.0 < values[i] <= 20.0
 * 	1 <= queries.length <= 20
 * 	queries[i].length == 2
 * 	1 <= Cj.length, Dj.length <= 5
 * 	Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 ******************************************************************************************************/

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var graph = new HashMap<String, Node>();
        for (var i = 0; i < equations.size(); i++) {
            var first = equations.get(i).get(0);
            var second = equations.get(i).get(1);
            graph.putIfAbsent(first, new Node(first));
            graph.putIfAbsent(second, new Node(second));
            
            if (!first.equals(second)) {
                graph.get(first).neighbors.put(graph.get(second), values[i]);
                graph.get(second).neighbors.put(graph.get(first), 1 / values[i]);
            }
        }
        
        var res = new double[queries.size()];
        var visit = new HashSet<Node>();
        for (var i = 0; i < queries.size(); i++) {
            visit.clear();
            var first = graph.get(queries.get(i).get(0));
            var second = graph.get(queries.get(i).get(1));
            res[i] = dfs(visit, first, second);
        }
        
        return res;
    }
    
    double dfs(Set<Node> visit, Node start, Node end) {
        if (start == null || end == null) {
            return -1d;
        }
        
        if (start == end) {
            return 1d;
        }
        
        visit.add(start);
        for (var neighbor : start.neighbors.entrySet()) {
            if (!visit.contains(neighbor.getKey())) {
                var res = dfs(visit, neighbor.getKey(), end);
                if (res > 0) {
                    return neighbor.getValue() * res;
                }
            }
        }
        
        return -1d;
    }
    
    static class Node {
        String key;
        Map<Node, Double> neighbors;
        
        Node(String key) {
            this.key = key;
            this.neighbors = new HashMap<Node, Double>();
        }
    }
}