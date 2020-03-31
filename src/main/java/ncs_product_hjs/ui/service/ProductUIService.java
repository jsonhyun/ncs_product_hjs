package ncs_product_hjs.ui.service;

import java.util.List;

import ncs_product_hjs.dao.ProductDao;
import ncs_product_hjs.dao.impl.ProductDaoImpl;
import ncs_product_hjs.dto.Product;

public class ProductUIService {
	private ProductDao dao = ProductDaoImpl.getInstance();
	
	public List<Product> showProductList(){
		return dao.selectProductByAll();
	}
	
	public Product showProductByCode(Product product) {
		return dao.selectProductByCode(product);
	}
	
	public int insertProduct(Product product) {
		return dao.insertProduct(product);
	}
}
