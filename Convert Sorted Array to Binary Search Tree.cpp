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
    TreeNode *sortedArrayToBST(vector<int> &num) {
        return sortedArrayToBST(num.begin(), num.end());
    }
    
    TreeNode* sortedArrayToBST(It begin, It end) {
        if (begin == end) return NULL;
        int k = (end-begin) / 2;
        It middle = begin + k;
        TreeNode* n = new TreeNode(*middle);
        n->left = sortedArrayToBST(begin, middle);
        n->right = sortedArrayToBST(middle + 1, end);
        return n;
    }
};
