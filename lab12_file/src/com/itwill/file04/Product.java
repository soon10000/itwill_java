package com.itwill.file04;

import java.io.Serializable;

public class Product implements Serializable{
	private int code; // 상품번호
	private String name; // 상품명
	private int price; // 상품가격
	
	public Product() {}

	public Product(int code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	

}
