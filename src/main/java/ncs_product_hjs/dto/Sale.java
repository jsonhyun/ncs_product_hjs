package ncs_product_hjs.dto;

public class Sale {
	private int no;
	private Product productCode;
	private int price;
	private int saleCnt;
	private int marginRate;

	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale(int no, Product productCode, int price, int saleCnt, int marginRate) {
		this.no = no;
		this.productCode = productCode;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	@Override
	public String toString() {
		return String.format("Sale [no=%s, productCode=%s, price=%s, saleCnt=%s, marginRate=%s]", no, productCode,
				price, saleCnt, marginRate);
	}

}
