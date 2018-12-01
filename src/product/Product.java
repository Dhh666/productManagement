package product;

import java.util.Date;

public class Product {
	private int id;   //商品Id
	private String name; //商品名
	private double price;  //商品单价
	private int count; //商品数量
	private boolean status;//状态
	private Date date;
	
	public Product() {
		super();
	}
	
	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(int id, String name, double price, int count, boolean status, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.status = status;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
