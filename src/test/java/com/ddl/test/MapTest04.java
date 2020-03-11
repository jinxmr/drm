package com.ddl.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest04 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		map.put("d", "4");
		map.remove("a");
		Set<Map.Entry<String, String>> set = map.entrySet();

		set.forEach(key -> {
			System.out.println(key);
		});
	}
}
