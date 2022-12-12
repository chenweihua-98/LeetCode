package code.HashMap;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：TicTacToe
 * 类 描 述：TODO LeetCode348 设计井字棋
 * 创建时间：2022/10/31 下午1:45
 * 创 建 人：chenweihua
 */
public class TicTacToe {

    private  int n;
    private  int[] rows;
    private  int[] cols;
    private int dia1,dia2;

    public TicTacToe(int n){
        this.n = n;
        int[] rows = new int[n];
        int[] cols = new int[n];
        dia1 = 0;
        dia2 = 0;
    }

    public int move(int row, int col, int player){
        int cell = player==1?1:-1;
        int sum = player==1?n:-n;
        //行
        rows[row]+=cell;
        if (rows[row]==sum){
            return player;
        }
        //列
        cols[col]+=cell;
        if (cols[col]==sum){
            return player;
        }
        //主对角线
        if(row==col){
            dia1+=cell;
            if (dia1==sum){
                return player;
            }
        }
        //副对角线
        if(row+col==n-1){
            dia2+=cell;
            if (dia2==sum){
                return player;
            }
        }

        return 0;
    }


}
