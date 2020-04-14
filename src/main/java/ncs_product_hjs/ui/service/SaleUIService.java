package ncs_product_hjs.ui.service;

import java.util.List;

import ncs_product_hjs.dao.SaleDao;
import ncs_product_hjs.dao.impl.SaleDaoImpl;
import ncs_product_hjs.dto.Sale;
import ncs_product_hjs.dto.SalesMoneyRanking;

public class SaleUIService {
	private SaleDao dao = SaleDaoImpl.getInstance();
	
	public void addSale(Sale sale) {
		dao.insertSale(sale);
	}
	
	public List<SalesMoneyRanking> showSalesMoneyRankingList(){
		return dao.selectSaleMoney();
	}
	
	public List<SalesMoneyRanking> showMarginMonyRankingList(){
		return dao.selectMarginMoney();
	}
}
