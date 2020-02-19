// https://www.lintcode.com/problem/insert-delete-getrandom-o1/description?_from=ladder&&fromId=1
class RandomizedSet {
public:
    RandomizedSet() {
        hashMap.clear();
        vec.clear();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    bool insert(int val) {
        if(hashMap.count(val) != 0){
            return false;
        }
        vec.emplace_back(val);
        hashMap[val] = vec.size() - 1;
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    bool remove(int val) {
        if(hashMap.find(val) == hashMap.end()){
            return false;
        }
        int size = vec.size();
        int index = hashMap[val];
        // last one element
        if(index == size -1){
            vec.pop_back();
            hashMap.erase(val);
            return true;
        }
        
        vec[index] = vec[size-1];
        hashMap.erase(val);
        vec.pop_back();
        return true;
        
    }

    /*
     * @return: Get a random element from the set
     */
    int getRandom() {
        return vec[rand()%vec.size()];
    }
    
private:
    // value to index
    unordered_map<int,int> hashMap;
    std::vector<int> vec;
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param = obj.insert(val);
 * bool param = obj.remove(val);
 * int param = obj.getRandom();
 */