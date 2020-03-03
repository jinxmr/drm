package com.ddl.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 1.定义汽车类.包含名称和价格属性,重写hashCode和equals方法
class Car {

	private String name;

	private String color;

	public Car() {
	}

	public Car(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Car)) return false;

		Car car = (Car) o;

		if (name != null ? !name.equals(car.name) : car.name != null) return false;
		return color != null ? color.equals(car.color) : car.color == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (color != null ? color.hashCode() : 0);
		return result;
	}
}

public class MapTest03 {
	public static void main(String[] args) {
		// 2.创建HashMapkey保存汽车对象,value是汽车价格
		HashMap<Car, Integer> hm = new HashMap<>();

		// 3.添加汽车到HashMap中
		Car c1 = new Car("长安奔奔", "黄色");
		Car c3 = new Car("奇瑞QQ", "黑色");
		Car c2 = new Car("铃木奥拓", "白色");

		hm.put(c1, 10000);
		hm.put(c2, 20000);
		hm.put(c3, 30000);

		// 4.使用keySet方式遍历Map
		Set<Car> keySet = hm.keySet();
		for (Car c : keySet) {
			// 根据key获取value
			Integer value = hm.get(c);
			System.out.println(c.getName() + "," + c.getColor() + " - " + value);
		}

		System.out.println("-------------");

		// 5.使用entrySet方式遍历Map
		Set<Map.Entry<Car, Integer>> entrySet = hm.entrySet();
		for (Map.Entry<Car, Integer> entry : entrySet) {
			Car key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key.getName() + "," + key.getColor() + " - " + value);
		}
	}
}
