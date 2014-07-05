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
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        return buildTree(postorder.begin(), postorder.end(), inorder.begin(), inorder.end());
    }
    
    TreeNode* buildTree(It pbegin, It pend, It ibegin, It iend) {
        if (pbegin == pend) return NULL;
        int val = *(pend -1);
        It ipos;
        for (ipos = ibegin; ipos!= iend; ++ipos) {
            if (*ipos == val) break;
        }
        int nleft = ipos - ibegin;
        It ppos = pbegin + nleft;
        
        TreeNode* n = new TreeNode(val);
        n->left = buildTree(pbegin, ppos, ibegin, ipos);
        n->right = buildTree(ppos, pend - 1, ipos + 1, iend);
        return n;
    }
};
