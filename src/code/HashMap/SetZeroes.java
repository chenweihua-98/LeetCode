package code.HashMap;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SetZeroes
 * 类 描 述：TODO 矩阵置0 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0
 * 创建时间：2022/10/28 下午7:38
 * 创 建 人：chenweihua
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        // 第一行是否有零
        for(int i = 0;i<col;i++){
            if (matrix[0][i]==0){
                row0_flag =true;
                break;
            }
        }
        //第一列是否有零
        for (int i =0;i<row;i++){
            if (matrix[i][0]==0){
                col0_flag = true;
                break;
            }
        }

        //遍历除第一列第一行外的矩阵找0用第一列、第一行来存
        for(int i = 1;i<row;i++){
            for (int j = 1;j<col;j++){
                if (matrix[i][j]==0){
                    //将该元素所在第一行以及第一列该数置为0
                    matrix[0][j]=matrix[i][0] = 0;
                }
            }
        }

        //置0
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                //如果第一行或者第一列某个元素为0 将该列改行全置为0
                if(matrix[0][j]==0||matrix[i][0]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        //判断第一行
        if (row0_flag){
            for(int i = 0;i<col;i++){
                matrix[0][i] = 0;
            }
        }
        //判断第一列
        if (col0_flag){
            for(int i = 0;i<row;i++){
                matrix[i][0] = 0;
            }
        }

    }




}
