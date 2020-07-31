// Source : https://leetcode.com/problems/course-schedule/
// Author : zmillionaire
// Date   : 2020-07-30
package main
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

// 思路
// 课->节点 ，每个节点有[0,n-1]个依赖节点，转化为每个节点的入度问题，如果一个节点入度为0，则可以选择，
// 选择这个节点时，相关节点，入度-1，-1后如果为0又可以修，不断重复下去，如果选择的节点入度不为零，
// 无法修完，如果全部为邻，全部修完
//
//
// 编码
// 需要一个队列，和一个关系维护
// todo @zhangshilin wait to complete
func canFinish(numCourses int, prerequisites [][]int) bool {
//	入参检查
	if numCourses==0{
		return true
	}
	if prerequisites ==nil{
		return true
	}
	var (
		que = []int{}


		)
}