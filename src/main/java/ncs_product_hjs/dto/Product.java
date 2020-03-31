package ncs_product_hjs.dto;

public class Product {
	private String productCode;
	private String productName;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productCode, String productName) {
		this.productCode = productCode;
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return String.format("Product [productCode=%s, productName=%s]", productCode, productName);
	}

}
