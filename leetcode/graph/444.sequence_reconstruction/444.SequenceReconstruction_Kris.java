// Source : https://leetcode.com/problems/sequence-reconstruction/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * null
 ******************************************************************************************************/

public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Node> graph = buildGraph(seqs);
        if (org.length != graph.size()) {
            return false;
        }
        
        for (int i = 0; i < org.length; i++) {
            Node node = graph.get(org[i]);
            if (node == null) {
                return false;
            }
            
            // 需要判断下，刚开始只有开始的 node indegree 是 0
            if ((i == 0 && node.indegree != 0) || (i != 0 && node.indegree == 0)) {
                return false;
            }
        }

        for (int o : org) {
            Node node = graph.get(o);
            if (node.indegree != 0) {
                return false;
            }
            
            // 唯一确定，所以每一次不能有超过 1 个 node indegree 变成 0
            // 如果是最后一个 node，那么 count == 0，因为没有 neighbor 了
            int count = 0; 
            for (int neighbor : node.neighbors) {
                if (--graph.get(neighbor).indegree == 0) {
                    count++;
                }
            }
            
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
    
    Map<Integer, Node> buildGraph(int[][] seqs) {
        Map<Integer, Node> graph = new HashMap<Integer, Node>();
        
        for (int[] seq : seqs) {
            // 考虑 [1], [[1]] 的场景，这里不能写 seq.length - 1，否则无法创建 node
            for (int i = 0; i < seq.length; i++) {
                graph.putIfAbsent(seq[i], new Node());
                Node node = graph.get(seq[i]);
                
                if (i + 1 == seq.length || node.neighbors.contains(seq[i + 1])) {
                    continue;
                }
                
                node.neighbors.add(seq[i + 1]);
                graph.putIfAbsent(seq[i + 1], new Node());
                graph.get(seq[i + 1]).indegree++;
            }
        }
        
        return graph;
    }
    
    static class Node {
        Set<Integer> neighbors;
        int indegree;
        
        Node() {
            this.neighbors = new HashSet<Integer>();
        }
    }
}