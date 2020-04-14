package ncs_product_hjs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ncs_product_hjs.dao.SaleDao;
import ncs_product_hjs.ds.MySqlDataSource;
import ncs_product_hjs.dto.Product;
import ncs_product_hjs.dto.Sale;
import ncs_product_hjs.dto.SalesMoneyRanking;
import ncs_product_hjs.util.LogUtil;

public class SaleDaoImpl implements SaleDao {
	private static final SaleDaoImpl Instance = new SaleDaoImpl();
    
	private SaleDaoImpl() {}

	public static SaleDaoImpl getInstance() {
		return Instance;
	}
	
	@Override
	public List<SalesMoneyRanking> selectSaleMoney() {
		String sql = "select p.product_code, p.product_name, s.price, s.sale_cnt, round((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11)) as '공급가액', " 
	               + "round(s.price * s.sale_cnt/11) as '부가세액', (s.price * s.sale_cnt) as '판매금액', s.margin_rate, " 
				   + "round(((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11))*(s.margin_rate*0.01)) as '마진액' " 
	               + "from sale s left join product p on s.product_code = p.product_code order by s.price * s.sale_cnt desc";
		try(Connection con = MySqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			List<SalesMoneyRanking> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getSaleRanking(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private SalesMoneyRanking getSaleRanking(ResultSet rs) throws SQLException {
		Product productCode = new Product(rs.getString(1), rs.getString(2));
		Product productName = new Product(rs.getString(1), rs.getString(2));
		Sale price = new Sale(0, null, rs.getInt(3), rs.getInt(4), rs.getInt(8));
		Sale saleCnt = new Sale(0, null, rs.getInt(3), rs.getInt(4), rs.getInt(8));
		int supMoney = rs.getInt(5);
		int tex = rs.getInt(6);
		int saleMoney = rs.getInt(7);
		Sale marginRate = new Sale(0, null, rs.getInt(3), rs.getInt(4), rs.getInt(8));
		int marginMoney = rs.getInt(9);
		
		return new SalesMoneyRanking(productCode, productName, price, saleCnt, supMoney, tex, saleMoney, marginRate, marginMoney);
	}

	@Override
	public List<SalesMoneyRanking> selectMarginMoney() {
		String sql = "select p.product_code, p.product_name, s.price, s.sale_cnt, round((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11)) as '공급가액', " 
	               + "round(s.price * s.sale_cnt/11) as '부가세액', (s.price * s.sale_cnt) as '판매금액', s.margin_rate, " 
				   + "round(((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11))*(s.margin_rate*0.01)) as '마진액' " 
	               + "from sale s left join product p on s.product_code = p.product_code order by round(((s.price * s.sale_cnt)-(s.price * s.sale_cnt/11))*(s.margin_rate*0.01)) desc";
		try(Connection con = MySqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			List<SalesMoneyRanking> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getSaleRanking(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertSale(Sale sale) {
		String sql = "insert into sale values(null,?,?,?,?)";
		try (Connection con = MySqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, sale.getProductCode().getProductCode());
			pstmt.setInt(2, sale.getPrice());
			pstmt.setInt(3, sale.getSaleCnt());
			pstmt.setInt(4, sale.getMarginRate());
			LogUtil.prnLog(pstmt);
			pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
