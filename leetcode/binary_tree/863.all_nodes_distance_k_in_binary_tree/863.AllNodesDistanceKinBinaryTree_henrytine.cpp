// Source : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// Author : henrytine
// Date   : 2020-08-21

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
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> distanceK(TreeNode* root, TreeNode* target, int K) {
        if (root == NULL) {
            return {};
        }
        
        findParent(root);
        dfs(target, K);
        return ans;
    }
    
    void findParent(TreeNode* node) {
        if (!node) return;
        if (node->left) {
            parent[node->left] = node;
            findParent(node->left);
        }
        
        if (node->right) {
            parent[node->right] = node;
            findParent(node->right);
        }
    }
    
    void dfs(TreeNode *node, int K) {
        if (!node) return;
        if (visited.count(node)) {
            return;
        }
        
        visited.insert(node);
        
        if (K == 0) {
            ans.push_back(node->val);
            return;
        }
        dfs(node->left, K-1);
        dfs(node->right, K-1);
        dfs(parent[node], K-1);
    }
    
private:
    unordered_map<TreeNode*, TreeNode*> parent;
    set<TreeNode*> visited;
    vector<int> ans;
};