# Source : https://leetcode.com/problems/lru-cache/
# Author : zheyuuu
# Date   : 2020-07-19

##################################################################################################### 
#
# Design and implement a data structure for Least Recently Used (LRU) cache. It should support the 
# following operations: get and put.
# 
# get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
# otherwise return -1.
# put(key, value) - Set or insert the value if the key is not already present. When the cache reached 
# its capacity, it should invalidate the least recently used item before inserting a new item.
# 
# The cache is initialized with a positive capacity.
# 
# Follow up:
# Could you do both operations in O(1) time complexity?
# 
# Example:
# 
# LRUCache cache = new LRUCache( 2 /* capacity */ );
# 
# cache.put(1, 1);
# cache.put(2, 2);
# cache.get(1);       // returns 1
# cache.put(3, 3);    // evicts key 2
# cache.get(2);       // returns -1 (not found)
# cache.put(4, 4);    // evicts key 1
# cache.get(1);       // returns -1 (not found)
# cache.get(3);       // returns 3
# cache.get(4);       // returns 4
# 
#####################################################################################################

class Node:
    def __init__(self, key=None, val=None, **kwargs):
        self.pre = None
        self.next = None
        self.key = key
        self.val = val


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.mapping = {}
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.pre = self.head

    def get(self, key: int) -> int:
        if key not in self.mapping:
            return -1
        if key in self.mapping:
            self.moveToHead(key)
        return self.mapping[key].val

    def put(self, key: int, value: int) -> None:
        if key in self.mapping:
            self.moveToHead(key)
            node = self.mapping[key]
            node.val = value
        else:
            if len(self.mapping) == self.capacity:
                tmp = self.tail.pre
                self.mapping.pop(tmp.key)
                tmp.pre.next = self.tail
                self.tail.pre = tmp.pre
            node = Node(key, value)
            tmp = self.head.next
            self.head.next = node
            node.pre = self.head

            node.next = tmp
            tmp.pre = node

            self.mapping[key] = node


    
    def moveToHead(self, key):
        node = self.mapping[key]
        node.pre.next = node.next
        node.next.pre = node.pre
        node.pre = self.head
        node.next = self.head.next
        self.head.next.pre = node
        self.head.next = node