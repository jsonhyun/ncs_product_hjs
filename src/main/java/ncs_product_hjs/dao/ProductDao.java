package ncs_product_hjs.dao;

import java.util.List;

import ncs_product_hjs.dto.Product;

public interface ProductDao {
	Product selectProductByCode(Product product);
	List<Product> selectProductByAll();
	
	int insertProduct(Product product);
}
