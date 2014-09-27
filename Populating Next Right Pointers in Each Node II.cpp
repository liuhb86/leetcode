/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
 
TreeLinkNode* const INVALID_P = (TreeLinkNode*) -1;
class Solution {
public:
    void connect(TreeLinkNode *root) {
       morrisTranverse(root, clearLink);
       morrisTranverse(root, linkChild);
    }
    
    static void linkChild(TreeLinkNode* p) {
        if (!p->left && !p->right) return;
        TreeLinkNode* next = NULL;
        TreeLinkNode* sib = p->next;
        while(sib) {
            if (sib->left) {next = sib->left; break;}
            if (sib->right) {next = sib->right; break;}
            sib = sib->next;
        }
        if (p->right) {
            p->right->next = next;
            next = p->right;
        }
        if (p->left) {
            if (p->left->next == INVALID_P) {
                p->left->next = next;
            }
        }
    }
    
    static void morrisTranverse(TreeLinkNode* root, void (*callback)(TreeLinkNode*)) {
        if (!root) return;
        root->next = NULL;
        TreeLinkNode* current = root;
        while (current) {
            if (!current->right) {
                callback(current);
                current = current->left;
                continue;
            }
            
            TreeLinkNode* prev = current->right;
            while(prev->left != NULL && prev->left != current) prev = prev->left;
            
            if (prev->left == NULL) {
                callback(current);
                prev->left = current;
                current = current->right;
                continue;
            }
            
            prev->left = NULL;
            current = current->left;
        }
    }
    
    static void clearLink(TreeLinkNode* p) {
        p->next = INVALID_P;
    }
};
