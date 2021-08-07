// Source : https://leetcode.com/problems/lru-cache
// Author : zhangsl
// Date   : 2020-07-20
package main

import "fmt"

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
 * LRUCache cache = new LRUCache( 2  capacity )
*
* cache.put(1, 1)
* cache.put(2, 2)
* cache.get(1)    // returns 1
* cache.put(3, 3) // evicts key 2
* cache.get(2)    // returns -1 (not found)
* cache.put(4, 4) // evicts key 1
* cache.get(1)    // returns -1 (not found)
* cache.get(3)    // returns 3
* cache.get(4)    // returns 4
*
******************************************************************************************************/
//思路
// 双向链表+map
//todo need to optimize @zhangshillin
type Node struct {
	key,val  int
	pre  *Node
	next *Node
}

type LRUCache struct {
	capacity int
	size     int
	head     *Node
	tail     *Node
	mp       map[int]*Node
}

// head tail为逻辑节点，不参与运算
func Constructor(capacity int) LRUCache {
	l := LRUCache{}
	l.capacity = capacity
	l.size = 0
	l.head = &Node{}
	l.tail = &Node{}
	l.mp = map[int]*Node{}
	l.head.next = l.tail
	l.tail.pre = l.head
	return l
}
func (this *LRUCache) AddHead(node *Node) {
	head := this.head
	node.next = head.next
	node.pre = head
	head.next.pre = node
	head.next = node
}
func (this *LRUCache) Remove(key int) *Node {
	node := this.mp[key]
	node.pre.next = node.next
	node.next.pre = node.pre
	return node
}
func (this *LRUCache) RemoveTail()*Node{
	t:=this.tail.pre
	t.pre.next = t.next
	t.next.pre = t.pre
	return t
}

func (this *LRUCache) Get(key int) int {
	if _, ok := this.mp[key]; ok {
		//更新位置
		node:=this.Remove(key)
		this.AddHead(node)
		return this.mp[key].val
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {

	_, ok := this.mp[key]
	if ok { //如果存在，移动到头部 -》 删除节点，增加头部节点
		node := this.Remove(key)
		node.val = value
		this.AddHead(node)
	} else { // 如果不存在 添加到头部，如果超出容量，移除尾部元素
		newNode := &Node{
			key: key,
			val:  value,
			pre:  nil,
			next: nil,
		}
		this.mp[key] = newNode
		this.AddHead(newNode)
		this.size++
		if this.size>this.capacity{

			node:=this.RemoveTail()
			delete(this.mp,node.key)
			this.size--
		}
	}
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */

func main() {
	cache:=Constructor(2)
	cache.Put(1,1)
	cache.Put(2,2)
	cache.Put(3,3)
	fmt.Println(cache.mp)
}