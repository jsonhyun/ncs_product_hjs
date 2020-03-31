package ncs_product_hjs.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ncs_product_hjs.ui.list.SalesMoneyRankingTblPanel;
import ncs_product_hjs.ui.service.SaleUIService;

@SuppressWarnings("serial")
public class SalesMoneyRankingFrame extends JFrame {

	private SalesMoneyRankingTblPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesMoneyRankingFrame frame = new SalesMoneyRankingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public SalesMoneyRankingFrame() {
		SaleUIService service = new SaleUIService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 473);
		contentPane = new SalesMoneyRankingTblPanel();
		contentPane.loadData(service.showSalesMoneyRankingList());
		setContentPane(contentPane);
	}

}
