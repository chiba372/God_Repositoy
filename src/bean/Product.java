package bean;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String name;
	private int price;
	private String image;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
