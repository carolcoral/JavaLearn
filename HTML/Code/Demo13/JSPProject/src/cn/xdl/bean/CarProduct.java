package cn.xdl.bean;

public class CarProduct {
	private int car_id;
	private String name;
	private double price;
	private int num;
	private double total;
	private boolean flag;
	public CarProduct(String name, double price, int num, double total, boolean flag) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
		this.total = total;
		this.flag = flag;
	}
	public CarProduct() {
		super();
	}
	
	public CarProduct(int car_id) {
		super();
		this.car_id = car_id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "CarProduct [name=" + name + ", price=" + price + ", num=" + num + ", total=" + total + ", flag=" + flag
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + car_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarProduct other = (CarProduct) obj;
		if (car_id != other.car_id)
			return false;
		return true;
	}
	
	
}
