// Source : https://leetcode.com/problems/count-of-smaller-numbers-after-self/
// Author : Kris
// Date   : 2020-07-28

/***************************************************************************************************** 
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has 
 * the property where counts[i] is the number of smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Input: [5,2,6,1]
 * Output: [2,1,1,0] 
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 ******************************************************************************************************/

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null) {
            return null;
        }
        
        var result = new int[nums.length];
        var nodes = new Node[nums.length];
        for (var i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        
        mergeSort(nodes, 0, nums.length - 1, new Node[nums.length], result);
        
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
    
    void mergeSort(Node[] nodes, int start, int end, Node[] helper, int[] result) {
        if (start >= end) {
            return;
        }
        
        var mid = start + (end - start) / 2;
        mergeSort(nodes, start, mid, helper, result);
        mergeSort(nodes, mid + 1, end, helper, result);
        merge(nodes, start, mid, end, helper, result);
    }
    
    void merge(Node[] nodes, int start, int mid, int end, Node[] helper, int[] result) {
        var i = 0;
        var p1 = start;
        var p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            // = 非常重要，
            // 因为相等的时候，已经有逆序对产生了
            // 并且应该先让左边的数组++，防止重复计算
            if (nodes[p1].val <= nodes[p2].val) {
                result[nodes[p1].index] += p2 - (mid + 1);
                helper[i++] = nodes[p1++];
            } else {
                helper[i++] = nodes[p2++];
            }
        }
        
        while (p1 <= mid) {
            result[nodes[p1].index] += end - (mid + 1) + 1;
            helper[i++] = nodes[p1++];
        }
        
        while (p2 <= end) {
            helper[i++] = nodes[p2++];
        }
        
        i = 0;
        while (start <= end) {
            nodes[start++] = helper[i++];
        }
    }
}

public class Node {
    int val;
    int index;
    
    public Node(int val, int index) {
        this.val = val;
        this.index = index;
    }
}