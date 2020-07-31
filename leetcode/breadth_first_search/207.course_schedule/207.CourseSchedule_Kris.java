// Source : https://leetcode.com/problems/course-schedule/
// Author : Kris
// Date   : 2020-07-31

/***************************************************************************************************** 
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to 
 * finish all courses?
 * 
 * Example 1:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 *              To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * 
 * Constraints:
 * 
 * 	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
 * Read more about how a graph is represented.
 * 	You may assume that there are no duplicate edges in the input prerequisites.
 * 	1 <= numCourses <= 10^5
 ******************************************************************************************************/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = new ArrayList<Node>();
        // node to indegree map
        var indegreeMap = new HashMap<Node, Integer>();
        
        // initialize graph and indegree map
        for (var i = 0; i < numCourses; i++) {
            var node = new Node(i);
            graph.add(node);
            indegreeMap.put(node, 0);
        }
        
        for (var i = 0; i < prerequisites.length; i++) {
            var neighbor = graph.get(prerequisites[i][0]);
            var node = graph.get(prerequisites[i][1]);
            
            node.neighbors.add(neighbor);
            indegreeMap.put(neighbor, indegreeMap.get(neighbor) + 1);
        }
        
        // add indegree == 0 nodes in queue
        var queue = new LinkedList<Node>();
        indegreeMap.entrySet().stream()
            .filter(entry -> entry.getValue() == 0)
            .forEach(entry -> queue.offer(entry.getKey()));

        // bfs
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                for (var neighbor : cur.neighbors) {
                    var count = indegreeMap.get(neighbor) - 1;
                    indegreeMap.put(neighbor, count);
                    if (count == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        // indegreeMap.entrySet().stream().forEach(
        //     entry -> System.out.println(entry.getKey().id + ":" + entry.getValue()));
        
        return !indegreeMap.values().stream().anyMatch(count -> count != 0);
    }
}

class Node {
    int id;
    List<Node> neighbors;
    
    public Node(int id) {
        this.id = id;
        this.neighbors = new ArrayList<Node>();
    }
}