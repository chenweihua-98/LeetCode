package code.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ZigzagIterator
 * 类 描 述：TODO 力扣题281
 * 创建时间：2022/11/22 下午10:29
 * 创 建 人：chenweihua
 */
public class ZigzagIterator {
    List<Integer> list;
    int size;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<Integer>();
        int index1 = 0, index2 = 0;
        while (index1 < v1.size() || index2 < v2.size()) {
            if (index1 < v1.size()) {
                list.add(v1.get(index1++));
            }

            if (index2 < v2.size()) {
                list.add(v2.get(index2++));
            }

        }
    }

    public int next() {
        if (hasNext()) {
            return list.get(size++);
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        return size < list.size();
    }
}
