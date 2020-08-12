// Source : https://leetcode.com/problems/time-based-key-value-store/
// Author : zhangsl
// Date   : 2020-08-12
package main

import "fmt"

/*****************************************************************************************************
 *
 * Create a timebased key-value store class TimeMap, that supports two operations.
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 	Stores the key and value, along with the given timestamp.
 *
 * 2. get(string key, int timestamp)
 *
 * 	Returns a value such that set(key, value, timestamp_prev) was called previously, with
 * timestamp_prev <= timestamp.
 * 	If there are multiple such values, it returns the one with the largest timestamp_prev.
 * 	If there are no values, it returns the empty string ("").
 *
 * Example 1:
 *
 * Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs =
 * [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"]
 * Explanation:
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
 * kv.get("foo", 1);  // output "bar"
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and
 * timestamp 2, then the only value is at timestamp 1 ie "bar"
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // output "bar2"
 * kv.get("foo", 5); //output "bar2"
 *
 * Example 2:
 *
 * Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs =
 * [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * Output: [null,null,null,"","high","high","low","low"]
 *
 * Note:
 *
 * 	All key/value strings are lowercase.
 * 	All key/value strings have length in the range [1, 100]
 * 	The timestamps for all TimeMap.set operations are strictly increasing.
 * 	1 <= timestamp <= 10^7
 * 	TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per
 * test case.
 *
 ******************************************************************************************************/

// 思路：
// 基于时间戳查找，时间戳是严格递增的 所以就是对于有序数组的查找->二分
// 数据结构，map[key][]struct{time,val}
// 对于时间戳 有可能超出范围，如果超过右边界 则返回最后一个元素
// 						  如果超过左边界，返回空，
// 如果时间戳在范围内，进行二分查找
// 二分查找： 查找小于等于自己的。

// 封装时间戳和string值
//time 53.85 mem 100
type dataUnit struct {
	time int
	val  string
}
type TimeMap struct {
	mp map[string][]dataUnit
}

/** Initialize your data structure here. */
func Constructor() TimeMap {
	return TimeMap{mp: map[string][]dataUnit{}}
}

func (this *TimeMap) Set(key string, value string, timestamp int) {
	(*this).mp[key] = append((*this).mp[key], dataUnit{
		time: timestamp,
		val:  value,
	})
}

func (this *TimeMap) Get(key string, timestamp int) string {
	du := (*this).mp[key]
	// 如果不存在key 或者时间戳小于左边界 直接返回""
	if len(du) == 0 || timestamp < du[0].time {
		return ""
	}
	// 如果大于等于右边界 返回最大值
	if timestamp>=du[len(du)-1].time{
		return du[len(du)-1].val
	}

//	 开始二分查找
	var (
		l,r,mid = 0,len(du)-1,0
	)
	for l<=r{
		mid = l+(r-l)/2
		if du[mid].time == timestamp{
			return du[mid].val
		}else if du[mid].time<timestamp{
			l = mid // 仍然要包含左边界 有可能左边界就是答案
			if l+1==r{
				return du[mid].val
			}
		}else {
			r = mid-1
		}

	}
	return du[l-1].val
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Set(key,value,timestamp);
 * param_2 := obj.Get(key,timestamp);
 */

func main() {
	tm := Constructor()
	fmt.Println(len(tm.mp["test"]))
	tm.mp["test"] = append(tm.mp["test"], dataUnit{
		time: 0,
		val:  "sdf",
	})
	fmt.Println(tm.mp["test"])
}
