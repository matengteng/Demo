package com.example.bean;

public class Commodity {

	private String name;

	private double price;

	private int count;

	private String imgSrc;

	private double totalPrice;

	public Commodity(String name, double price, int count, String imgSrc) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
		this.imgSrc = imgSrc;
		this.totalPrice = count * price;
	}

	public Commodity() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
