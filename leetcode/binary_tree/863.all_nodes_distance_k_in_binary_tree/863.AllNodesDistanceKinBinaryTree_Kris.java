// Source : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * 
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer 
 * can be returned in any order.
 * 
 * Example 1:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 
 * Output: [7,4,1]
 * 
 * Explanation: 
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * 
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * 
 * Note:
 * 
 * 	The given tree is non-empty.
 * 	Each node in the tree has unique values 0 <= node.val <= 500.
 * 	The target node is a node in the tree.
 * 	0 <= K <= 1000.
 * 
 ******************************************************************************************************/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || target == null) {
            return null;
        }
        
        var graph = new HashMap<TreeNode, TreeNode>();
        buildGraph(graph, root, null);
        
        return bfs(graph, target, K);
    }
    
    void buildGraph(HashMap<TreeNode, TreeNode> graph, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        
        buildGraph(graph, root.left, root);
        buildGraph(graph, root.right, root);
        graph.put(root, parent);
    }
    
    List<Integer> bfs(HashMap<TreeNode, TreeNode> graph, TreeNode target, int K) {
        var result = new ArrayList<Integer>();
        var visit = new HashSet<TreeNode>();
        
        var queue = new LinkedList<TreeNode>();
        var step = 0;
        queue.offer(target);
        visit.add(target);
        
        while (!queue.isEmpty() && step <= K) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.pop();
                if (cur.left != null && !visit.contains(cur.left)) {
                    queue.offer(cur.left);
                    visit.add(cur.left);
                }
                if (cur.right != null && !visit.contains(cur.right)) {
                    queue.offer(cur.right);
                    visit.add(cur.right);
                }
                var parent = graph.get(cur);
                if (parent != null && !visit.contains(parent)) {
                    queue.offer(parent);
                    visit.add(parent);
                }
                
                if (step == K) {
                    result.add(cur.val);
                }
            }
            
            step++;
        }
        
        return result;
    }
}