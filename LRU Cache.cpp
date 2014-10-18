class LRUCache{
    struct Node {
        Node* prev;
        Node* next;
        int key;
        int val;
        Node():prev(NULL), next(NULL) {}
    };
    
    struct List {
        Node* head;
        Node* tail;
        List():head(NULL), tail(NULL){}
        void moveToHead(Node* p) {
            if (p==head) return;
            if (p==tail) {
                tail = tail->prev;
            }
            p->prev->next = p->next;
            if (p->next) p->next->prev = p->prev;
            head->prev = p;
            p->next = head;
            p->prev = NULL;
            head = p;
        }
        
        void insert(Node* p) {
            p->prev = NULL;
            p->next = head;
            if (head) head->prev = p;
            head = p;
            if (!tail) tail = p;
        }
    };
    
    unordered_map<int, Node*> hash;
    List list;
    int size;
    int capacity;
    vector<Node> nodes;
    
public:
    LRUCache(int capacity) {
        size = 0;
        this->capacity = capacity; 
        nodes.resize(max(capacity,1));
    }
    
    int get(int key) {
        unordered_map<int, Node*>::iterator it = hash.find(key);
        if (it==hash.end()) return -1;
        list.moveToHead(it->second);
        return list.head->val;
    }
    
    void set(int key, int value) {
        unordered_map<int, Node*>::iterator it = hash.find(key);
        if (it!=hash.end()) {
            list.moveToHead(it->second);
            list.head->val = value;
            return;
        }
        
        if (size>=capacity && list.tail) {
            hash.erase(list.tail->key);
            list.tail->key = key;
            list.tail->val = value;
            hash[key] = list.tail;
            list.moveToHead(list.tail);
        } else {
            Node* p = &nodes[size];
            p->key = key;
            p->val = value;
            hash[key] = p;
            list.insert(p);
            ++size;
        }
    }
};