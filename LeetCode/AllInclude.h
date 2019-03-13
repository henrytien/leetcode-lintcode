#pragma once
#ifndef __ALL_INCLUDE_H__
#define __ALL_INCLUDE_H__

// C standard
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

using namespace std;

#define MAX(A,B) ((A)>(B)?(A):(B))
#define MIN(A,B) ((A)<(B)?(A):(B))
#define SWAP(A, B) {(A) ^= (B); (B) ^= (A); (A) ^= (B);}

typedef unsigned int uint32_t;

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

#endif
