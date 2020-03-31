package ncs_product_hjs.dto;

public class SalesMoneyRanking {
	private int rankingNo;
	private Product productCode;
	private Product productName;
	private Sale price;
	private Sale saleCnt;
	private int supMoney;
	private int tex;
	private int saleMoney;
	private Sale marginRate;
	private int marginMoney;

	public SalesMoneyRanking() {
		// TODO Auto-generated constructor stub
	}

	public SalesMoneyRanking(Product productCode, Product productName, Sale price, Sale saleCnt, int supMoney, int tex,
			int saleMoney, Sale marginRate, int marginMoney) {
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.saleCnt = saleCnt;
		this.supMoney = supMoney;
		this.tex = tex;
		this.saleMoney = saleMoney;
		this.marginRate = marginRate;
		this.marginMoney = marginMoney;
	}

	public SalesMoneyRanking(int rankingNo, Product productCode, Product productName, Sale price, Sale saleCnt,
			int supMoney, int tex, int saleMoney, Sale marginRate, int marginMoney) {
		this.rankingNo = rankingNo;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.saleCnt = saleCnt;
		this.supMoney = supMoney;
		this.tex = tex;
		this.saleMoney = saleMoney;
		this.marginRate = marginRate;
		this.marginMoney = marginMoney;
	}

	public int getRankingNo() {
		return rankingNo;
	}

	public void setRankingNo(int rankingNo) {
		this.rankingNo = rankingNo;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public Product getProductName() {
		return productName;
	}

	public void setProductName(Product productName) {
		this.productName = productName;
	}

	public Sale getPrice() {
		return price;
	}

	public void setPrice(Sale price) {
		this.price = price;
	}

	public Sale getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(Sale saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getSupMoney() {
		return supMoney;
	}

	public void setSupMoney(int supMoney) {
		this.supMoney = supMoney;
	}

	public int getTex() {
		return tex;
	}

	public void setTex(int tex) {
		this.tex = tex;
	}

	public int getSaleMoney() {
		return saleMoney;
	}

	public void setSaleMoney(int saleMoney) {
		this.saleMoney = saleMoney;
	}

	public Sale getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(Sale marginRate) {
		this.marginRate = marginRate;
	}

	public int getMarginMoney() {
		return marginMoney;
	}

	public void setMarginMoney(int marginMoney) {
		this.marginMoney = marginMoney;
	}

	@Override
	public String toString() {
		return String.format(
				"SalesMoneyRanking [rankingNo=%s, productCode=%s, productName=%s, price=%s, saleCnt=%s, supMoney=%s, tex=%s, saleMoney=%s, marginRate=%s, marginMoney=%s]",
				rankingNo, productCode, productName, price, saleCnt, supMoney, tex, saleMoney, marginRate, marginMoney);
	}

}
