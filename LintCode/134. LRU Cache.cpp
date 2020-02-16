// https://www.lintcode.com/problem/lru-cache/description?_from=ladder&&fromId=1

// unordered_map<int,list<LRUNode>::iterator> hashMap;
// list<LRUNode> nodes;

#include<list>
class LRUCache {
public:
    struct LRUNode{
        int key;
        int value;
        LRUNode(int k,int v) :key(k),value(v){};
    };
    
    // LRUCache(int capacity):cap(capacity){};

    /*
    * @param capacity: An integer
    */LRUCache(int capacity) {
        cap = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    int get(int key) {
        if(!hashMap.count(key)){
            return -1;
        }
        move_front(key);
        return nodes.front().value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    void set(int key, int value) {
        if(!hashMap.count(key)){
           nodes.emplace_front(key,value);
           hashMap[key] = nodes.begin();
           if(nodes.size() > cap){
               hashMap.erase(nodes.back().key);
               nodes.pop_back();
           }
        }else{
            hashMap[key]->value = value;
            move_front(key);
        }
    }
    
private:
    int move_front(int key){
        nodes.splice(nodes.begin(),nodes,hashMap[key]);
        hashMap[key] = nodes.begin();
    }
    
private:
    int cap;
    std::list<LRUNode> nodes;
    unordered_map<int,list<LRUNode>::iterator> hashMap;
};