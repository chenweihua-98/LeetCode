package code.BFS;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Exist
 * 类 描 述：TODO 力扣题79单词搜索
 * 创建时间：2022/12/4 下午8:54
 * 创 建 人：chenweihua
 */
public class Exist {
    private Boolean find;
    public boolean exist(char[][] board, String word) {
        if(board==null) return false;
        int m = board.length,n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        find = false;
        for(int i = 0;i<m;++i){
            for (int j = 0;j<n;++j){
                backtracking(i,j,board,word,visited,0); // 从左上角开始遍历棋盘每个格子
            }
        }
        return find;
    }
    /**
     * i,j,board：棋盘格及当前元素的坐标
     * word: 要搜索的目标单词
     * visited：记录当前格子是否已被访问过
     * pos: 记录目标单词的字符索引，只有棋盘格字符和pos指向的字符一致时，才有机会继续搜索接下来的字符；如果pos已经过了目标单词的尾部了，那么便说明找到目标单词了
     */

    private void backtracking(int i, int j, char[][] board, String word, boolean[][] visited, int pos) {
        // 超出边界、已经访问过、已找到目标单词、棋盘格中当前字符已经和目标字符不一致了
        if(i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(pos)||find){
            return;
        }
        if (pos==word.length()-1){
            find = true;
            return;
        }

        visited[i][j]=true; // 修改当前节点状态
        backtracking(i+1,j,board,word,visited,pos+1);//遍历旁边节点
        backtracking(i-1,j,board,word,visited,pos+1);
        backtracking(i,j+1,board,word,visited,pos+1);
        backtracking(i,j-1,board,word,visited,pos+1);
        visited[i][j] = false;//撤销修改

    }
}
