
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ConLib.JDBC;
import ConLib.LoginLibs;
import ConLib.ReceiptLib;
import ConLib.ReceiptLib2;

public class billReceipt {
	JFrame frame;
	JButton payment;
	public billReceipt() {

		frame = new JFrame();
		frame.setSize(700, 720);
		frame.setLocationRelativeTo(null);

		frame.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(1, 90));
		north.setLayout(null);
		north.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(north, BorderLayout.NORTH);

		JLabel lbltitle = new JLabel("HOTEL  RECEIPT");
		lbltitle.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		lbltitle.setForeground(Color.BLACK);
		lbltitle.setBounds(240, 15, 300, 30);
		north.add(lbltitle);

		JLabel lblcontact = new JLabel("lutonhotel99@gmail.com | 9887654321, 01-7654321");
		lblcontact.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblcontact.setForeground(Color.BLACK);
		lblcontact.setBounds(200, 45, 300, 30);
		north.add(lblcontact);

		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 178, 102));
		pn1.setBounds(0, 70, 1000, 10);
		frame.getContentPane();
		pn1.setLayout(null);
		north.add(pn1);

		// Center panel
		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(100, 100));
		center.setLayout(null);
		center.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(center, BorderLayout.CENTER);

		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 178, 102));
		pn2.setBounds(0, 15, 70, 30);
		center.add(pn2);

		JLabel billTo = new JLabel("Bill To ");
		billTo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		billTo.setForeground(Color.BLACK);
		billTo.setBounds(80, 15, 80, 20);
		center.add(billTo);

		JLabel Name = new JLabel("Guest Name");
		Name.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Name.setForeground(Color.BLACK);
		Name.setBounds(80, 40, 200, 20);
		center.add(Name);

		JLabel cName = new JLabel("a");
		cName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cName.setForeground(Color.BLACK);
		cName.setBounds(80, 60, 200, 20);
		center.add(cName);

		JLabel billno = new JLabel("Bill Number");
		billno.setFont(new Font("Times New Roman", Font.BOLD, 14));
		billno.setForeground(Color.BLACK);
		billno.setBounds(480, 40, 200, 20);
		center.add(billno);

		JLabel cbillno = new JLabel("aa");
		cbillno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbillno.setForeground(Color.BLACK);
		cbillno.setBounds(480, 60, 200, 20);
		center.add(cbillno);

		JLabel vat = new JLabel("VAT(13%) ");
		vat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		vat.setForeground(Color.BLACK);
		vat.setBounds(80, 90, 200, 20);
		center.add(vat);

		JLabel cvat = new JLabel("999");
		cvat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cvat.setForeground(Color.BLACK);
		cvat.setBounds(80, 110, 200, 20);
		center.add(cvat);

		JLabel billdate = new JLabel("Bill Date");
		billdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		billdate.setForeground(Color.BLACK);
		billdate.setBounds(480, 90, 200, 20);
		center.add(billdate);

		JLabel cbilldate = new JLabel("---");
		cbilldate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbilldate.setForeground(Color.BLACK);
		cbilldate.setBounds(480, 110, 200, 20);
		center.add(cbilldate);


		JLabel checkin = new JLabel("Check In Date");
		checkin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		checkin.setForeground(Color.BLACK);
		checkin.setBounds(480, 130, 200, 20);
		center.add(checkin);

		JLabel ccheckin = new JLabel("---");
		ccheckin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ccheckin.setForeground(Color.BLACK);
		ccheckin.setBounds(480, 150, 200, 20);
		center.add(ccheckin);

		JLabel checkout = new JLabel("Check Out Date");
		checkout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		checkout.setForeground(Color.BLACK);
		checkout.setBounds(480, 170, 200, 20);
		center.add(checkout);

		JLabel ccheckout = new JLabel("---");
		ccheckout.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ccheckout.setForeground(Color.BLACK);
		ccheckout.setBounds(480, 190, 200, 20);
		center.add(ccheckout);

		JLabel paymethod = new JLabel("Payment Method");
		paymethod.setFont(new Font("Times New Roman", Font.BOLD, 14));
		paymethod.setForeground(Color.BLACK);
		paymethod.setBounds(80, 210, 200, 20);
		center.add(paymethod);

		JLabel cpaymethod = new JLabel("Credit Card");
		cpaymethod.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cpaymethod.setForeground(Color.BLACK);
//		cpaymethod.setBackground(new Color(255, 178, 102));
		cpaymethod.setBounds(200, 210, 200, 20);
		center.add(cpaymethod);

		JPanel paypanel = new JPanel();
		paypanel.setBackground(new Color(255, 178, 102));
		paypanel.setBounds(190, 210, 92, 20);
		center.add(paypanel);

		JLabel total = new JLabel("Total Amount");
		total.setFont(new Font("Times New Roman", Font.BOLD, 14));
		total.setForeground(Color.BLACK);
		total.setBounds(400, 500, 200, 20);
		center.add(total);

		JLabel ctotal = new JLabel("15000");
		ctotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ctotal.setForeground(Color.BLACK);
		ctotal.setBounds(510, 500, 80, 20);
		center.add(ctotal);
		
		JLabel discount = new JLabel("(for corporate only)Discount (10%)");
		discount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		discount.setForeground(Color.BLACK);
		discount.setBounds(350, 470, 700, 20);
		center.add(discount);

		JLabel cdiscount = new JLabel("0.0");
		cdiscount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cdiscount.setForeground(Color.BLACK);
		cdiscount.setBounds(580, 470, 80, 20);
		center.add(cdiscount);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("SNo");
		model.addColumn("Item");
		model.addColumn("Quantity");
		model.addColumn("Total");

		JTable table = new JTable(model);
		//Retrieving data from middleware and setting it into the jtable
		JDBC jdbc1 = new JDBC();
		ReceiptLib2 billl = new ReceiptLib2();
		int userid1 = Global.loginCred.getId();
		billl.setUid(userid1);
		ArrayList search1 = jdbc1.receiptdata2(billl);
		if (search1.size() > 0) {
			for (int i1 = 0; i1 < search1.size(); i1++) {
				billl = (ReceiptLib2) search1.get(i1);
				Object[] tmp = { ((i1)), billl.getItem(), billl.getQuantity(), billl.getTotal() };
				model.addRow(tmp);
			}
		}
		
		  

		JTableHeader h1 = table.getTableHeader();
		h1.setFont(new Font("Verdana", Font.BOLD, 14));
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);

		table.setBackground(Color.white);
		center.add(table);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(80, 260, 500, 200);
		center.add(scroll);
		float dis = 0;
		 int sum = 0;
	        for(int i = 0; i < table.getRowCount(); i++)
	        {
	            sum = sum + Integer.parseInt(table.getValueAt(i, 3).toString());
	            float v = 10;
				float v1 = 100;
				 dis= (float) (v/v1 * sum);	           
	            System.out.println(dis);
	        }
	        {
	        	
	        	int sumdis = (int) (sum - dis);
	        	int userid = Global.loginCred.getId();
	        	LoginLibs user = new LoginLibs();
	        	user.setId(userid);
	        	user = new JDBC().billCust(user);
	        	if(user.gettype().equals("Customer")) {
	        		cvat.setText(Integer.toString(sum));
	        		ctotal.setText(Integer.toString(sum));
	        	}else {
	        	cdiscount.setText(Float.toString(dis));	
	        	ctotal.setText(Integer.toString(sumdis));
	        	}
	    }

		
	    payment = new JButton("Pay");
	    payment.setBounds(1,20,67,20);
	    payment.setFocusable(false);
	    payment.setBackground(new Color(106, 101, 101));
	    payment.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    payment.setForeground(Color.white);
	    payment.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e) {
				int userid1 = Global.loginCred.getId();// value of uid from global class
				JDBC jdbc = new JDBC();
				ReceiptLib2 lib = new ReceiptLib2();
				lib.setUid(userid1);//setting uid to ReceiptLib2
				jdbc.invoicestatus(lib);//sending data to middleware
				
			}
	    	
	    });
	        
		JPanel totalpanel = new JPanel();
		totalpanel.setBackground(new Color(255, 178, 102));
		totalpanel.setBounds(490, 500, 80, 20);
		center.add(totalpanel);

		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(70, 10));
		east.setLayout(null);
		east.setBackground(new Color(255, 178, 102));
		frame.getContentPane().add(east, BorderLayout.EAST);
		
		east.add(payment);
		
		frame.setVisible(true);

		JDBC jdbc = new JDBC();
		ReceiptLib lib = new ReceiptLib();
		lib.setUid(userid1);
		jdbc.receiptdata(lib);
		cbilldate.setText(lib.getBilldate());
		cbillno.setText(Integer.toString(lib.getBillno()));
		ccheckin.setText(lib.getCheckindate());
		ccheckout.setText(lib.getCheckoutdate());
		cName.setText(lib.getName());
		frame.setResizable(false);

	}

	public static void main(String[] args) {
		new billReceipt();

	}

}