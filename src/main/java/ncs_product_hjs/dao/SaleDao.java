package ncs_product_hjs.dao;

import java.util.List;

import ncs_product_hjs.dto.Sale;
import ncs_product_hjs.dto.SalesMoneyRanking;

public interface SaleDao {
	List<SalesMoneyRanking> selectSaleMoney();
	List<SalesMoneyRanking> selectMarginMoney();
	
	void insertSale(Sale sale);
	
}
