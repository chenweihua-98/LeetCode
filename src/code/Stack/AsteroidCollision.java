package code.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：AsteroidCollision
 * 类 描 述：TODO 力扣题735 行星碰撞
 * 创建时间：2022/10/25 下午9:43
 * 创 建 人：chenweihua
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int aster : asteroids) {
            //判断该行星是否还存在
            boolean alive = true;
            while (alive && !stack.isEmpty() && aster < 0 && stack.peek() > 0) {
                alive = stack.peek() < -aster;
                if (stack.peek() <= -aster) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }

        int len = stack.size();
        int[] res = new int[len];
        while (!stack.isEmpty()) {
            res[--len] = stack.pop();
        }


        return res;


    }
}
