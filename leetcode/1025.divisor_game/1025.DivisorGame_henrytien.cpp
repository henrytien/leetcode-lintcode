// Source : https://leetcode.com/problems/divisor-game/
// Author : henrytien
// Date   : 2021-08-16

/***************************************************************************************************** 
 *
 * Alice and Bob take turns playing a game, with Alice starting first.
 * 
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move 
 * consisting of:
 * 
 * 	Choosing any x with 0 < x < n and n % x == 0.
 * 	Replacing the number n on the chalkboard with n - x.
 * 
 * Also, if a player cannot make a move, they lose the game.
 * 
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * 
 * Example 2:
 * 
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 * 
 * Constraints:
 * 
 * 	1 <= n <= 1000
 ******************************************************************************************************/
#include <iostream>
#include <vector>
#include <string.h>
using namespace std;


/// Mathematics
/// Prove can be see here: https://leetcode.com/problems/divisor-game/discuss/274606/JavaC%2B%2BPython-return-N-2-0
///
/// Time Complexity: O(1)
/// Space Complexity: O(1)
class Solution {

public:
    // bool divisorGame(int N) {
    //     return N % 2 == 0;
    // }
    Solution(){
        memset(dp,0,1001);
    }
    bool divisorGame(int N) {
        if (dp[N] == 0) {
            for (int i = 1; dp[N] != 1 && i <= N/2; i++) {
                dp[N] = (N % i == 0)? divisorGame(N - i) ? -1:1:-1;
            }
            
        }
        return dp[N] == 1;
    }
private:
    int dp[1001];
};


int main() {

    cout << Solution().divisorGame(2) << endl; // true
    cout << Solution().divisorGame(3) << endl; // false
    cout << Solution().divisorGame(9) << endl; // false

    return 0;
}

