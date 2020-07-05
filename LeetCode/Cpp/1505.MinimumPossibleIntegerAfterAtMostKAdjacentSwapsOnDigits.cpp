// Source : https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/
// Author : henrytine
// Date   : 2020-07-05

/***************************************************************************************************** 
 *
 * Given a string num representing the digits of a very large integer and an integer k.
 * 
 * You are allowed to swap any two adjacent digits of the integer at most k times.
 * 
 * Return the minimum integer you can obtain also as a string.
 * 
 * Example 1:
 * 
 * Input: num = "4321", k = 4
 * Output: "1342"
 * Explanation: The steps to obtain the minimum integer from 4321 with 4 adjacent swaps are shown.
 * 
 * Example 2:
 * 
 * Input: num = "100", k = 1
 * Output: "010"
 * Explanation: It's ok for the output to have leading zeros, but the input is guaranteed not to have 
 * any leading zeros.
 * 
 * Example 3:
 * 
 * Input: num = "36789", k = 1000
 * Output: "36789"
 * Explanation: We can keep the number without any swaps.
 * 
 * Example 4:
 * 
 * Input: num = "22", k = 22
 * Output: "22"
 * 
 * Example 5:
 * 
 * Input: num = "9438957234785635408", k = 23
 * Output: "0345989723478563548"
 * 
 * Constraints:
 * 
 * 	1 <= num.length <= 30000
 * 	num contains digits only and doesn't have leading zeros.
 * 	1 <= k <= 10^9
 ******************************************************************************************************/
// Solution from here. https://bit.ly/31L9IOn
#include"ac.h"

typedef long long ll;
const int N =30010;
ll w[N];
ll st[N];

struct Node {
    ll l,r;
    ll minv, idx, sum;
} tree[4*N];

void push_up(Node& a, Node& b, Node & c) {
    if(b.minv <= c.minv) {
        a.minv = b.minv;
        a.idx = b.idx;
    } else {
        a.minv = c.minv;
        a.idx = c.idx;
    }
    a.sum = b.sum + c.sum;
}

void push_up(ll u) {
    push_up(tree[u], tree[2*u], tree[2*u+1]);
}

void build(ll u, ll l, ll r) {
    tree[u].l = l;
    tree[u].r = r;
    if(l == r) {
        ll b = w[l];
        tree[u].minv = b;
        tree[u].idx = l;
        tree[u].sum = st[l];
    } else {
        ll mid = (l + r) / 2;
        build(2*u, l, mid);
        build(2*u+1, mid+1, r);
        push_up(u);
    }
}

void update(ll u, ll idx, ll x) {
    if(tree[u].l == tree[u].r) {
        tree[u].minv = x;
        tree[u].sum = 0;
        st[tree[u].l] = 0;
    } else {
        ll mid = (tree[u].l + tree[u].r)/2;
        if(idx <= mid) update(2*u, idx, x);
        else update(2*u+1, idx, x);
        push_up(u);
    }
}

Node query(ll u, ll l, ll r) {
    if(tree[u].l >= l && tree[u].r <= r) {
        return tree[u];
    } else {
        ll mid = (tree[u].l + tree[u].r)/2;
        if(l > mid) {
            return query(2*u+1, l, r);
        } else if (r <= mid) {
            return query(2*u, l, r);
        } else {
            auto left = query(2*u, l, r);
            auto right = query(2*u+1, l, r);
            Node res;
            push_up(res, left, right);
            return res;
        }
    }
}

int get_idx(int presum, int len) {
    int l = 1;
    int r = len;
    int res = len;
    while(l <= r) {
        int mid = (l + r) / 2;
        if(query(1, 1, mid).sum >= presum) {
            res = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return res;
}

class Solution {
public:
    string minInteger(string num, int k) {
        int n = num.size();
        if(k > n*(n-1)/2) {
            sort(num.begin(), num.end());
            return num;
        }
        return solve(num, k);
    }
    void init(string & num) {
        // build the SegTree;
        int n = num.size();
        memset(tree, 0, sizeof tree);
        for(int i = 1; i <= n; i ++) w[i] = num[i-1] - '0';
        for(int i = 1; i <= n; i ++) st[i] = 1;
        build(1, 1, n);
    }
    string solve(string & num, int k) {
        init(num);
        string res;
        while(k) {
            int max_sum = min(k+1, (int)num.size());
            int threshold = get_idx(max_sum, num.size());
            Node curr = query(1, 1, threshold);
            if(curr.minv == 10) break;
            res.push_back(curr.minv + '0');
            update(1, curr.idx, 10);
            k -= query(1, 1, curr.idx).sum;
        }
        for(int i = 1; i <= num.size(); i ++) {
            if(st[i] == 1) {
			// unused digits
                res.push_back(num[i-1]);
            }
        }
        return res;
    }
};