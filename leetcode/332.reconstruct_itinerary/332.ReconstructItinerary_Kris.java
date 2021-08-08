// Source : https://leetcode.com/problems/reconstruct-itinerary/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, 
 * the itinerary must begin with JFK.
 * 
 * Note:
 * 
 * 	If there are multiple valid itineraries, you should return the itinerary that has the 
 * smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has 
 * a smaller lexical order than ["JFK", "LGB"].
 * 	All airports are represented by three capital letters (IATA code).
 * 	You may assume all tickets form at least one valid itinerary.
 * 	One must use all the tickets once and only once.
 * 
 * Example 1:
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * Example 2:
 * 
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 ******************************************************************************************************/

class Solution {
    static final String JFK = "JFK";
    
    // 题目里没写的要点：
    // 1. 必然能够用完所有的票
    // 2. 在能够用完所有票的前提下，优先走字母顺序靠前的
    // 3. 没有走不完的情况 （说明最多只有 1 个死胡同）
    public List<String> findItinerary(List<List<String>> tickets) {
        var result = new ArrayList<String>();
        
        var graph = new HashMap<String, Node>();
        for (var ticket : tickets) {
            var start = graph.getOrDefault(ticket.get(0), new Node(ticket.get(0)));
            var end = graph.getOrDefault(ticket.get(1), new Node(ticket.get(1)));
            
            start.ends.offer(end);
            graph.put(ticket.get(0), start);
            graph.put(ticket.get(1), end);
        }
        
        var jfk = graph.get(JFK);
        if (jfk != null) {
            dfs(result, jfk);
        }
        
        return result;
    }
    
    void dfs(List<String> result, Node node) {
        while (!node.ends.isEmpty()) {
            dfs(result, node.ends.poll());
        }

        // 不能在函数刚开始的时候 result.add(node.name);
        // 对于环形的场景，和放在前面没有区别
        // 这是为了处理 死胡同 的场景，如果先走的路径是死胡同，先把它们记录在最后
        result.add(0, node.name);
    }
    
    static class Node {
        String name;
        Queue<Node> ends;
        
        Node(String name) {
            this.name = name;
            this.ends = new PriorityQueue<Node>((a, b) -> a.name.compareTo(b.name));
        }
    }
}