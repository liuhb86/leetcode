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
    vector<vector<int> > levelOrder(TreeNode *root) {
        deque<vector<TreeNode*> > bfs;
        vector<vector<int> > result;
        int level = 0;
        if (root == NULL) return result;
        bfs.push_back(vector<TreeNode*>());
        bfs.back().push_back(root);
        while(!bfs.back().empty()) {
            bfs.push_back(vector<TreeNode*>());
            vector<TreeNode*>& last = bfs[level];
            ++level;
            for (vector<TreeNode*>::iterator it = last.begin(); it!= last.end(); ++it) {
                TreeNode* n = *it;
                if (n->left != NULL) bfs.back().push_back(n->left);
                if (n->right != NULL) bfs.back().push_back(n->right);
            }
        }
        result.resize(bfs.size()-1);
        for(int i = 0; i < result.size(); ++i) {
            result[i].resize(bfs[i].size());
            for (int j=0; j< result[i].size();++j) {
                result[i][j] = bfs[i][j]->val;
            }
        }
        return result;
    }
};
