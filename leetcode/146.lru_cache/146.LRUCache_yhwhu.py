# Source : https://leetcode.com/problems/lru-cache/
# Author : yhwhu
# Date   : 2020-07-21

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

class ListNode:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.hashmap = dict()
        self.head = ListNode()
        self.tail = ListNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    # 将node放到末尾
    def move_node_to_end(self, key):
        node = self.hashmap[key]
        node.prev.next = node.next
        node.next.prev = node.prev

        node.next = self.tail
        node.prev = self.tail.prev
        self.tail.prev.next = node
        self.tail.prev = node

    def get(self, key):
        if key in self.hashmap:
            self.move_node_to_end(key)
            return self.hashmap[key].value
        return -1

    def put(self, key, value):
        if key in self.hashmap:
            self.hashmap[key].value = value
            self.move_node_to_end(key)
        else:
            if len(self.hashmap) == self.capacity:  # 超过容量，需要删掉第一个结点
                self.hashmap.pop(self.head.next.key)  # key 用在这里，找第一个结点的key

                self.head.next = self.head.next.next
                self.head.next.prev = self.head

            new = ListNode(key, value)
            new.next = self.tail
            new.prev = self.tail.prev

            self.hashmap[key] = new
            self.tail.prev.next = new
            self.tail.prev = new