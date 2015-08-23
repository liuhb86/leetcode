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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> result;
        path.clear();
        _binaryTreePaths(root, result);
        return result;
    }
    
    void _binaryTreePaths(TreeNode* root, vector<string>& result) {
        if (!root) return;
        if(path.empty()) path.push_back(to_string(root->val));
        else {
            path.push_back(path.back() + "->" + to_string(root->val));
        }
        if (root->left == NULL && root->right==NULL) result.push_back(path.back());
        _binaryTreePaths(root->left, result);
        _binaryTreePaths(root->right, result);
        path.pop_back();
    }
    
    vector<string> path;
};
