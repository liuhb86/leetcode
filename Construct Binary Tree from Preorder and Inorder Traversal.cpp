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
    typedef vector<int>::iterator It;
public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        return buildTree(preorder.begin(), preorder.end(), inorder.begin(), inorder.end());
    }
    
    TreeNode* buildTree(It pbegin, It pend, It ibegin, It iend) {
        if (pbegin == pend) return NULL;
        int val = *pbegin;
        It ipos;
        for (ipos = ibegin; ipos!= iend; ++ipos) {
            if (*ipos == val) break;
        }
        int nleft = ipos - ibegin;
        It ppos = pbegin + 1 + nleft;
        
        TreeNode* n = new TreeNode(*pbegin);
        n->left = buildTree(pbegin + 1, ppos, ibegin, ipos);
        n->right = buildTree(ppos, pend, ipos + 1, iend);
        return n;
    }
};
