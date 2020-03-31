package ncs_product_hjs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ncs_product_hjs.dao.ProductDao;
import ncs_product_hjs.ds.MySqlDataSource;
import ncs_product_hjs.dto.Product;
import ncs_product_hjs.util.LogUtil;

public class ProductDaoImpl implements ProductDao {
	private static final ProductDaoImpl Instance = new ProductDaoImpl();
    
	private ProductDaoImpl() {}

	public static ProductDaoImpl getInstance() {
		return Instance;
	}
	@Override
	public List<Product> selectProductByAll() {
		String sql = "select * from product";
		try (Connection con = MySqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			List<Product> list = new ArrayList<Product>();
			while(rs.next()) {
				list.add(getProduct(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		String productCode = rs.getString(1);
		String productName = rs.getString(2);
		return new Product(productCode, productName);
	}

	@Override
	public Product selectProductByCode(Product product) {
		String sql = "select * from product where product_code = ?";
		try(Connection con = MySqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, product.getProductCode());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getProduct(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	@Override
	public int insertProduct(Product product) {
		String sql = "insert into product values(?,?)";
		int res = -1;
		try(Connection con = MySqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, product.getProductCode());
			pstmt.setString(2, product.getProductName());
			LogUtil.prnLog(pstmt);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return res;
	}


}
