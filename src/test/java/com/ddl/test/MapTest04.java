package com.ddl.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest04 {

	public static void main(String[] args) {
		// 1.创建HashMap
		HashMap<String, String> hm = new HashMap<String, String>();
		// 2.使用put添加元素
		hm.put("黄晓明", "Baby");
		hm.put("邓超", "孙俪");
		hm.put("张三", "李四");
		hm.put("王五", "赵六");
		// 3.使用put修改元素
		String v1 = hm.put("张三", "白百合");
		// 4.使用get获取元素
		String string = hm.get("王五");
		// 5.使用remove删除元素
		String v2 = hm.remove("王五");
		System.out.println(v2);
		// 6.打印集合中的元素
		System.out.println(hm);
	}
}
