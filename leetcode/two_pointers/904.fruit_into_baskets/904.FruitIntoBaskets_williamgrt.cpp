class Solution {
public:
  int totalFruit(vector<int> &tree) {
    int l = 0, r = 0, n = tree.size();
    int a, b;
    int cnt[40001];
    memset(cnt, 0, sizeof(int) * 40001);
    int count = 0;
    int res = 0;
    while (r < n) {
      int c1 = tree[r];
      if (cnt[c1] == 0) {
        count++;
      }
      cnt[c1]++;
      ++r;
      while (count >= 3) {
        int c2 = tree[l];
        cnt[c2]--;
        if (cnt[c2] == 0) {
          count--;
        }
        ++l;
      }

      res = max(res, r - l);
    }
    return res;
  }
};