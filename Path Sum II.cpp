/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        vector<vector<int> > result;
        vector<int> path;
        findPathSum(root, sum, path, result);
        return result;
    }
    
    void findPathSum(TreeNode *root, int sum, vector<int>& path, vector<vector<int> >& result) {
        if (!root) return;
        if (!root->left && !root->right)
        {
            if (sum == root->val)
            {
                result.push_back(vector<int>());
                for (vector<int>::iterator it = path.begin(); it != path.end(); ++it)
                {
                    result.back().push_back(*it);
                }
                result.back().push_back(root->val);
            }
            return;
        }
        path.push_back(root->val);
        findPathSum(root->left, sum - root->val, path, result);
        findPathSum(root->right, sum - root->val, path, result);
        path.pop_back();
    }
};
