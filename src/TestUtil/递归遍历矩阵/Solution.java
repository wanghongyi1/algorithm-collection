package TestUtil.递归遍历矩阵;

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,char[] words,int i,int j,int index){
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return false;
        }
        if(board[i][j]!=words[index]){
            return false;
        }
        if(index==words.length-1){
            return true;
        }

        board[i][j]='\0';
        boolean res=dfs(board,words,i+1,j,index+1)||dfs(board,words,i-1,j,index+1)||dfs(board,words,i,j+1,index+1)||dfs(board,words,i,j-1,index+1);
        board[i][j]=words[index];
        return res;
    }
}