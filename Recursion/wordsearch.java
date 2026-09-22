class Solution {
    public boolean rec(int i, int j, int n, int m, String word, char[][] board, int in) {
        if (i < 0 || i >= n || j < 0 || j >= m || (board[i][j]!=word.charAt(in))||board[i][j]=='#') {
            return false;
            }
        if(board[i][j]==word.charAt(in)) {
            if(in==word.length()-1) {
                return true;
            }
        }   
        char prev=board[i][j];
        board[i][j]='#';
       boolean res1 = rec(i - 1, j, n, m, word,board,in+1);
       boolean res2 = rec(i + 1, j, n, m, word, board,in+1);
       boolean res3 = rec(i, j - 1, n, m, word,board,in+1);
       boolean res4 = rec(i, j + 1, n, m, word, board, in+1);
       board[i][j]=prev;

        return res1||res2||res3||res4;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]==word.charAt(0)) {
                    boolean res=rec(i,j,n,m,word,board,0);
                    if(res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}