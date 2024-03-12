package com.itheima;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("眼瞅着你不是真正的高兴");
        list.add("温油");
        list.add("离开俺们这旮表面");
        list.add("伤心的人别扭秧歌");
        list.add("私奔到东北");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("温油".equals(s)) {
                it.add("哈哈");  		// 迭代器的添加操作：没问题
                it.remove();
                //list.add("哈哈"); 	// 集合本身的添加操作：报错
                //list.remove("温油"); 	// 集合本身的删除操作：报错
            }
        }
        System.out.println(list);
    }
}
