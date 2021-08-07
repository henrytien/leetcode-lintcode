// Source : https://leetcode.com/problems/construct-string-from-binary-tree/
// Author : henrytine
// Date   : 2020-11-19

/***************************************************************************************************** 
 *
 * You need to construct a string consists of parenthesis and integers from a binary tree with the 
 * preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the 
 * empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string 
 * and the original binary tree.
 * 
 * Example 1:
 * 
 * Input: Binary tree: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /    
 *   4     
 * 
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to omit all the 
 * unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)".
 * 
 * Example 2:
 * 
 * Input: Binary tree: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \  
 *       4 
 * 
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we can't omit the first parenthesis pair 
 * to break the one-to-one mapping relationship between the input and the output.
 * 
 ******************************************************************************************************/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    string tree2str(TreeNode* t) {
        if (!t) return "";
        
        const string s = to_string(t->val);
        const string l = tree2str(t->left);
        const string r = tree2str(t->right);
        
        if(!t->left && !t->right) 
            return s;
        if (!t->right) 
            return s + "(" + l + ")";
        // general case
        return s + "(" + l + ")" + "(" + r + ")";
    }
};/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    string tree2str(TreeNode* t) {
        if (!t) return "";
        
        const string s = to_string(t->val);
        const string l = tree2str(t->left);
        const string r = tree2str(t->right);
        
        if(!t->left && !t->right) 
            return s;
        if (!t->right) 
            return s + "(" + l + ")";
        // general case
        return s + "(" + l + ")" + "(" + r + ")";
    }
};