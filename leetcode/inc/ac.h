//
//  ac.h
//  Ac
//
//  Created by Henry on 2020/1/5.
//  Copyright © 2020 Henry. All rights reserved.
//
#pragma once
#ifndef ac_h
#define ac_h

#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include <memory.h>

#include <string>
#include <iostream>
#include <fstream>
#include <sstream>

// STL
#include <map>
#include <vector>
#include <set>
#include <queue>
#include <algorithm>
#include <deque>
#include <functional>
#include <iterator>
#include <list>
#include <memory>
#include <numeric>
#include <stack>
#include <utility>
#include <unordered_map>
#include <unordered_set>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void print(ListNode *node){
    while(node){
        cout << node->val << " ";
        node = node->next;
    }
}
void print_vec(const vector<int>& vec){
    for(auto &&iter: vec)
        cout << iter << " ";
    cout << endl;
}
#endif /* ac_h */
