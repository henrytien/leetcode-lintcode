// Source : https://leetcode.com/problems/course-schedule/
// Author : Kris
// Date   : 2020-10-31

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
        
        // initialize graph
        for (var i = 0; i < numCourses; i++) {
            graph.add(new Node(i));
        }
        
        for (var i = 0; i < prerequisites.length; i++) {
            var node = graph.get(prerequisites[i][1]);
            var neighbor = graph.get(prerequisites[i][0]);
            
            node.neighbors.add(neighbor);
            neighbor.indegree++;
        }
        
        // add indegree == 0 nodes in queue
        var queue = new LinkedList<Node>();
        graph.stream()
            .filter(node -> node.indegree == 0)
            .forEach(queue::offer);

        // bfs
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                for (var neighbor : cur.neighbors) {
                    if (--neighbor.indegree == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        // graph.stream().forEach(
        //     node -> System.out.println(node.id + ":" + node.indegree));
        
        return graph.stream().allMatch(node -> node.indegree == 0);
    }
}

class Node {
    int id;
    List<Node> neighbors;
    int indegree;
    
    public Node(int id) {
        this.id = id;
        this.neighbors = new ArrayList<Node>();
    }
}