package code.DFS;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：NumIslands
 * 类 描 述：TODO
 * 创建时间：2022/12/4 下午10:28
 * 创 建 人：chenweihua
 */
public class NumIslands {
    //统计岛屿数量
    private int count;

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfsGrid(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsGrid(char[][] grid, int row, int col) {
        //将所有格子内情况分为3部分 0海洋 1陆地 2遍历过的陆地
        //防止超出岛屿（上下左右）的范围。特别注意当遍历到不是第一次遍历到的陆地的时候也退出循环
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] != '1') {
            return;
        }
        //修改格子状态
        grid[row][col] = '2';
        //遍历格子周围
        dfsGrid(grid, row - 1, col);
        dfsGrid(grid, row + 1, col);
        dfsGrid(grid, row, col - 1);
        dfsGrid(grid, row, col + 1);


    }

}
