/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTGenerator {
public:
	BSTGenerator(int begin,int end) : left(NULL),right(NULL) {
		reset(begin, end);
	}
	~BSTGenerator() {
		if (left) delete left;
		if (right) delete right;
	}
	void reset(int begin, int end) {
		this->begin = begin;
		this->end = end;
		this->root = begin;
		if (begin>=end) {
			if (left) {delete left; left = NULL;}
			if (right) {delete right; right = NULL;}
		} else {
			if (!left) left = new BSTGenerator(begin,begin);
			else left->reset(begin,begin);
			if (!right) right = new BSTGenerator(begin + 1, end);
			else right->reset(begin + 1,end);
		}
	}
	TreeNode* gen() {
		if (begin>=end) return NULL;
		TreeNode* root = new TreeNode(this->root);
		root->left = left->gen();
		root->right = right->gen();
		return root;
	}
	bool next() {
		if (begin>=end) return false;
		if (right->next()) return true;
		if (left->next()) {
			right->reset(root+1, end);
			return true;
		}
		++root;
		if (root>=end) return false;
		left->reset(begin, root);
		right->reset(root+1,end);
		return true;
	}
private:
	int begin;
	int end;
	int root;
	BSTGenerator* left;
	BSTGenerator* right;
};

class Solution {
public:
	vector<TreeNode *> generateTrees(int n) {
		vector<TreeNode*> result;
		BSTGenerator g(1,n+1);
		do {
			result.push_back(g.gen());
		} while (g.next());
		return result;
	}
	static void main() {
		Solution s;
		s.generateTrees(0);
	}
};
