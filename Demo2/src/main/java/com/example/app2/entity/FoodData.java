package com.example.app2.entity;

/**
 * 
 * @author Administrator
 * 
 */
public class FoodData {
	private int type;// 类型 根据类型显示标题
	private String name;// 菜的名字
	private String title;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public FoodData(int type, String name, String title) {
		super();
		this.type = type;
		this.name = name;
		this.title = title;
	}

}
