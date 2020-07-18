// https://www.lintcode.com/problem/n-queens/description

// dfs

class Solution {
public:

    bool isValid(vector<string>& board, int row, int col) {
        for (int k = 1; k <= row; ++k) {
            if (board[row - k][col] == 'Q') return false;
            if (col - k >= 0 && board[row - k][col - k] == 'Q') return false; 
            if (col + k < board.size() && board[row - k][col + k] == 'Q') return false;
        }
        return true;
    }
    
    void dfs(vector<vector<string>>& results, vector<string>& board, int index) {
        if (index == board.size()) results.push_back(board);
        for (int i = 0; i != board.size(); ++i) {
            if (!isValid(board, index, i)) continue;
            board[index][i] = 'Q';
            dfs(results, board, index + 1);
            board[index][i] = '.';
        }
    }
    
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> results;
        vector<string> board = vector<string>(n, string(n, '.'));
        dfs(results, board, 0);
        return results; 
    }
};