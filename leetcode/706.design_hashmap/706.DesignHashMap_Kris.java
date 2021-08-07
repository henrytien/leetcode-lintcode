// Source : https://leetcode.com/problems/design-hashmap/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * Design a HashMap without using any built-in hash table libraries.
 * 
 * To be specific, your design should include these functions:
 * 
 * 	put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists 
 * in the HashMap, update the value.
 * 	get(key): Returns the value to which the specified key is mapped, or -1 if this map 
 * contains no mapping for the key.
 * 	remove(key) : Remove the mapping for the value key if this map contains the mapping for the 
 * key.
 * 
 * Example:
 * 
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);         
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1 
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found) 
 * 
 * Note:
 * 
 * 	All keys and values will be in the range of [0, 1000000].
 * 	The number of operations will be in the range of [1, 10000].
 * 	Please do not use the built-in HashMap library.
 * 
 ******************************************************************************************************/

class MyHashMap {
    private Node[] table;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        var code = key % table.length;
        var cur = table[code];
        
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }
        if (cur == null) {
            var node = new Node(key, value, table[code]);
            table[code] = node;
        } else {
            cur.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        var code = key % table.length;
        var cur = table[code];
        
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }
        if (cur == null) {
            return -1;
        } else {
            return cur.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        var code = key % table.length;
        Node pre = null;
        var cur = table[code];
        
        while (cur != null && cur.key != key) {
            pre = cur;
            cur = cur.next;
        }
        
        if (cur == null) {
            return;
        } else if (pre == null) {
            table[code] = cur.next;
            return;
        } else {
            pre.next = cur.next;
            return;
        }
    }
}

class Node {
    int key;
    int val;
    Node next;
    
    public Node(int key, int val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */