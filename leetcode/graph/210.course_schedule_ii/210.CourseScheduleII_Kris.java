// Source : https://leetcode.com/problems/course-schedule-ii/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you 
 * must take the course bi before the course ai.
 * 
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the 
 * ordering of courses you should take to finish all courses.
 * 
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, 
 * return an empty array.
 * 
 * Example 1:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished 
 * course 0. So the correct course order is [0,1].
 * 
 * Example 2:
 * 
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both 
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * 
 * Example 3:
 * 
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 * 
 * Constraints:
 * 
 * 	1 <= numCourses <= 2000
 * 	0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * 	prerequisites[i].length == 2
 * 	0 <= ai, bi < numCourses
 * 	ai != bi
 * 	All the pairs [ai, bi] are distinct.
 ******************************************************************************************************/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var result = new ArrayList<Integer>();
        
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
            .forEach(node -> {
                queue.offer(node);
                result.add(node.id);
            });

        // bfs
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                for (var neighbor : cur.neighbors) {
                    if (--neighbor.indegree == 0) {
                        queue.offer(neighbor);
                        result.add(neighbor.id);
                    }
                }
            }
        }
        
        // graph.stream().forEach(
        //     node -> System.out.println(node.id + ":" + node.indegree));
        
        return graph.stream().allMatch(node -> node.indegree == 0)
            ? result.stream().mapToInt(Integer::intValue).toArray()
            : new int[0];
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