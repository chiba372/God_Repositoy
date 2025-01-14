package bean;

import java.io.Serializable;

/**
 * Itemクラス：ショッピングカート内の1件分のデータを表すBean
 *
 * @author s_yajima
 *
 */
public class Item implements Serializable {
	// 商品
	private Product product;
	// 個数
	private int count;

	public Product getProduct() {
		return product;
	}

	public int getCount() {
		return count;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
