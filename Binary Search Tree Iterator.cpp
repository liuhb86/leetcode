/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
public:
    BSTIterator(TreeNode *root) {
        pushTree(root);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    int next() {
        if (stack.empty()) return -1;
        int result = stack.back()->val;
        if (stack.back()->right) {
            pushTree(stack.back()->right);
            return result;
        }
        while (true) {
            TreeNode* p = stack.back();
            stack.pop_back();
            if (stack.empty()) return result;
            if (p==stack.back()->left) return result;
        }
        return result;
    }
private:

    void pushTree(TreeNode* p) {
        while(p) {
            stack.push_back(p);
            p = p->left;
        }
    }
    deque<TreeNode*> stack;
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
