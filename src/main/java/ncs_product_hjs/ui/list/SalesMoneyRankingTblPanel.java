package ncs_product_hjs.ui.list;

import javax.swing.SwingConstants;

import ncs_product_hjs.dto.SalesMoneyRanking;

@SuppressWarnings("serial")
public class SalesMoneyRankingTblPanel extends AbstractTblPanel<SalesMoneyRanking> {

	public SalesMoneyRankingTblPanel() {
	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(100,100,100,100,100,100,100,100,100,100);
		tableCellAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6,7,8,9);
		
	}

	@Override
	protected String[] getColNames() {
		return new String[] {"순위","제품코드","제품명","제품단가","판매수량","공급가액","부가세액","판매금액","마진율","마진액"};
	}

	@Override
	protected Object[] toArray(SalesMoneyRanking item) {
		return new Object[] {
				item.getRankingNo(),
				item.getProductCode().getProductCode(),
				item.getProductName().getProductName(),
				String.format("%,d", item.getPrice().getPrice()),
				item.getSaleCnt().getSaleCnt(),
				String.format("%,d", item.getSupMoney()),
				String.format("%,d", item.getTex()),
				String.format("%,d", item.getSaleMoney()),
				item.getMarginRate().getMarginRate(),
				String.format("%,d", item.getMarginMoney())
		};
	}

	@Override
	public void updateRow(SalesMoneyRanking item, int updateIdx) {
		// TODO Auto-generated method stub
	}

	

}
