// Source : https://leetcode.com/problems/lru-cache/
// Author : henrytine
// Date   : 2020-07-26

/***************************************************************************************************** 
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the 
 * following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached 
 * its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity  );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 ******************************************************************************************************/
// Very clearly.
class LRUCache {
public:
    LRUCache(int capacity):size(capacity) {
        lru.clear();
        mp.clear();
        kv.clear();
    }
    
    int get(int key) {
        if (kv.count(key) == 0) return -1;
        update_lru(key);
        return kv[key];
    }
    
    void put(int key, int value) {
        if (kv.size() == size && kv.count(key) == 0) {
            evict(lru.back());
        }
        update_lru(key);
        kv[key] = value;
    }
    
    void update_lru(int key) {
        if (kv.count(key)) {
            lru.erase(mp[key]);
        }
        lru.push_front(key);
        mp[key] = lru.begin();
    }
    
    void evict(int key) {
        mp.erase(key);
        kv.erase(key);
        lru.pop_back();
    }
private:
    int size;
    list<int> lru;      // All keys
    unordered_map<int, list<int>::iterator> mp;  // key-->iterator
    unordered_map<int, int> kv; // key-->val
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */