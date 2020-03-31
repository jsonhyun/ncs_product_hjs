package ncs_product_hjs.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ncs_product_hjs.dto.Product;
import ncs_product_hjs.dto.Sale;
import ncs_product_hjs.ui.list.SalesMoneyRankingTblPanel;
import ncs_product_hjs.ui.service.ProductUIService;
import ncs_product_hjs.ui.service.SaleUIService;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements KeyListener, ActionListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfPrice;
	private JTextField tfQty;
	private JTextField tfRate;
	private JTextField tfName;
	private ProductUIService pService;
	private JButton btnAdd;
	private SaleUIService sService;
	private JButton btnPrint1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		pService = new ProductUIService();
		sService = new SaleUIService();
		initialize();
	}
	private void initialize() {
		setTitle("판매실적 계산 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pInput = new JPanel();
		contentPane.add(pInput, BorderLayout.CENTER);
		pInput.setLayout(null);
		
		JLabel lblCode = new JLabel("제품코드 : ");
		lblCode.setFont(new Font("굴림", Font.PLAIN, 16));
		lblCode.setBounds(25, 20, 90, 30);
		pInput.add(lblCode);
		
		JLabel lblPrice = new JLabel("제품단가 :");
		lblPrice.setFont(new Font("굴림", Font.PLAIN, 16));
		lblPrice.setBounds(25, 70, 90, 30);
		pInput.add(lblPrice);
		
		JLabel lblQty = new JLabel("판매수량 :");
		lblQty.setFont(new Font("굴림", Font.PLAIN, 16));
		lblQty.setBounds(25, 120, 90, 30);
		pInput.add(lblQty);
		
		JLabel lblRate = new JLabel("마 진 율 :");
		lblRate.setFont(new Font("굴림", Font.PLAIN, 16));
		lblRate.setBounds(25, 170, 90, 30);
		pInput.add(lblRate);
		
		JLabel lblName = new JLabel("제품명 :");
		lblName.setFont(new Font("굴림", Font.PLAIN, 16));
		lblName.setBounds(255, 20, 65, 30);
		pInput.add(lblName);
		
		tfCode = new JTextField();
		tfCode.addKeyListener(this);
		tfCode.setBounds(110, 20, 130, 30);
		pInput.add(tfCode);
		tfCode.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(110, 70, 130, 30);
		pInput.add(tfPrice);
		
		tfQty = new JTextField();
		tfQty.setColumns(10);
		tfQty.setBounds(110, 120, 130, 30);
		pInput.add(tfQty);
		
		tfRate = new JTextField();
		tfRate.setColumns(10);
		tfRate.setBounds(110, 170, 130, 30);
		pInput.add(tfRate);
		
		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setColumns(10);
		tfName.setBounds(319, 20, 130, 30);
		pInput.add(tfName);
		
		JPanel pBtns = new JPanel();
		FlowLayout fl_pBtns = (FlowLayout) pBtns.getLayout();
		fl_pBtns.setHgap(40);
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("입력");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnPrint1 = new JButton("출력1");
		btnPrint1.addActionListener(this);
		pBtns.add(btnPrint1);
		
		JButton btnPrint2 = new JButton("출력2");
		pBtns.add(btnPrint2);
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == tfCode) {
			tfCodeKeyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	protected void tfCodeKeyPressed(KeyEvent e) {
		if(e.getKeyCode() == 10) {
			Product product = new Product(tfCode.getText().trim(), null);
			Product pName = pService.showProductByCode(product);
			tfName.setText(pName.getProductName());
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrint1) {
			btnPrint1ActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		if(tfPrice.getText().length()>8||tfQty.getText().length()>8||tfRate.getText().length()>2) {
			JOptionPane.showMessageDialog(null, "제품단가는 8자리 이내, 판매수량은 8자리 이내, 마진율은 2자리 이내의 정수로 작성해주세요.");
		}else {
			Sale sale = new Sale(0, new Product(tfCode.getText().trim(), null), Integer.parseInt(tfPrice.getText().trim()), 
								 Integer.parseInt(tfQty.getText().trim()), Integer.parseInt(tfRate.getText().trim()));
			sService.addSale(sale);
			clearTf();
			JOptionPane.showMessageDialog(null, "등록되었습니다.");
		}
	}

	private void clearTf() {
		tfCode.setText("");
		tfName.setText("");
		tfPrice.setText("");
		tfQty.setText("");
		tfRate.setText("");
	}
	protected void btnPrint1ActionPerformed(ActionEvent e) {
		SalesMoneyRankingFrame frame = new SalesMoneyRankingFrame();
		frame.setVisible(true);
		
	}
}
