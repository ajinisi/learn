package datastructure;
/*
 力扣 https://leetcode.cn/problems/design-hashset/
 */
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet {

    // 哈希表的大小
    private static final int base = 769;
    // 链地址法
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[base];
        for (int i = 0;i<base;i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {

        int a = key % base;

        Iterator<Integer> iterable = data[a].iterator();
        while (iterable.hasNext()) {
            if (key == iterable.next()) {
                return;
            }
        }
        data[a].offerLast(key);

    }

    public void remove(int key) {

        int h = key % base;
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer v = iterator.next();
            if (key == v) {
                // 注意remove方法的参数类型，导致不同的行为
                data[h].remove(v);
                return;
            }
        }

    }

    public boolean contains(int key) {

        int h = key % base;
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            if (key == iterator.next()) {
                return true;
            }
        }
        return false;
    }

}
