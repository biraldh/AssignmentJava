package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import ConLib.BillLib;
import ConLib.Billdata;
import ConLib.JDBC;
import ConLib.ReceiptLib2;

public class bill {
	JFrame frame;

	public bill() {
		frame = new JFrame();
		frame.setSize(1100, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Bill");
		frame.setLayout(new BorderLayout());

		// north panel
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(1, 60));
		north.setLayout(null);
		north.setBackground(new Color(204, 204, 255));
		frame.add(north, BorderLayout.NORTH);

		JLabel lbltitle = new JLabel("LUTON HOTEL");
		lbltitle.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lbltitle.setForeground(Color.black);
		lbltitle.setBounds(430, 15, 250, 30);

		north.add(lbltitle);

		JButton backbtn = new JButton("Back");
		backbtn.setBounds(850, 20, 100, 30);
		backbtn.setFocusable(false);
		backbtn.setBackground(new Color(196, 195, 135));
		backbtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		backbtn.setForeground(Color.black);
		backbtn.setFocusable(false);
		north.add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				Dashboard reg = new Dashboard();
				reg.setVisible(true);
				frame.dispose();

			}

		});

		// west panel
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(360, 10));
		west.setLayout(null);
		west.setBackground(new Color(195, 195, 195));
		frame.add(west, BorderLayout.WEST);

		JLabel subtitle = new JLabel("Hotel Invoice");
		subtitle.setBounds(120, 8, 200, 25);
		subtitle.setForeground(new Color(0, 0, 0));
		subtitle.setFont(new Font("Bauhaus 93", Font.PLAIN, 27));
		west.add(subtitle);

		JSeparator s1 = new JSeparator();
		s1.setBounds(0, 30, 500, 10);
		west.add(s1);

		JLabel lblBid = new JLabel("Booking ID : ");
		// lblBid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblBid.setForeground(Color.WHITE);
		lblBid.setBounds(30, 60, 80, 25);
		west.add(lblBid);

		JTextField txtBid = new JTextField();
		txtBid.setFont(new Font("Times  New Roman", Font.PLAIN, 14));
		txtBid.setBounds(110, 60, 200, 25);
		west.add(txtBid);

		JLabel lblitem = new JLabel("Item : ");
		// lblname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblname.setForeground(Color.WHITE);
		lblitem.setBounds(30, 100, 90, 20);
		west.add(lblitem);

		JTextField txtitem = new JTextField();
		txtitem.setFont(new Font("Times  New Roman", Font.PLAIN, 14));
		txtitem.setBounds(110, 100, 200, 25);
		west.add(txtitem);

		JLabel lblquantity = new JLabel("Quantity : ");
		// lblBcost.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblBcost.setForeground(Color.WHITE);
		lblquantity.setBounds(30, 140, 80, 20);
		west.add(lblquantity);

		JTextField txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Times  New Roman", Font.PLAIN, 14));
		txtQuantity.setBounds(110, 140, 200, 25);
		west.add(txtQuantity);

		JLabel lblBstatus = new JLabel("Bill Status : ");
		// lblBstatus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblBstatus.setForeground(Color.WHITE);
		lblBstatus.setBounds(30, 180, 80, 20);
		west.add(lblBstatus);

		JTextField txtBstatus = new JTextField();
		txtBstatus.setFont(new Font("Times  New Roman", Font.PLAIN, 14));
		txtBstatus.setBounds(110, 180, 200, 25);
		west.add(txtBstatus);

		JLabel lblBdate = new JLabel("Date: ");
		// lblBdate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblBdate.setForeground(Color.WHITE);
		lblBdate.setBounds(30, 220, 80, 20);
		west.add(lblBdate);

		JDateChooser cdate = new JDateChooser();
		cdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cdate.setDateFormatString("yyyy-mm-dd");
		cdate.setBounds(110, 220, 200, 25);
		west.add(cdate);

		JLabel lbltotal = new JLabel("Total : ");
		// lbltotal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lbltotal.setForeground(Color.WHITE);
		lbltotal.setBounds(30, 300, 90, 20);
		west.add(lbltotal);

		JTextField txttotal = new JTextField();
		txttotal.setFont(new Font("Times  New Roman", Font.PLAIN, 15));
		txttotal.setBounds(110, 300, 200, 25);
		west.add(txttotal);
		
		JLabel lblRate = new JLabel("Rate : ");
		// lblroomNo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblroomNo.setForeground(Color.WHITE);
		lblRate.setBounds(30, 260, 80, 20);
		west.add(lblRate);

		JTextField txtRate = new JTextField();
		txtRate.setFont(new Font("Times  New Roman", Font.PLAIN, 14));
		txtRate.setBounds(110, 260, 200, 25);
		west.add(txtRate);
		txtRate.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				float rato = Integer.parseInt(txtRate.getText());
				float v = 13;
				float v1 = 100;
				float rateno= (float) (v/v1 * rato);
				System.out.println(rateno);
				int total = (int) (rato +rateno); 
				txttotal.setText(Integer.toString(total));
				
					
		}});

		JLabel lblVat = new JLabel("Vat Charged on all items : ");
		// lblcheckin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblcheckin.setForeground(Color.WHITE);
		lblVat.setBounds(20, 450, 150, 20);
		west.add(lblVat);

		JLabel lblVat1 = new JLabel("13%");
		// lblcheckin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblcheckin.setForeground(Color.WHITE);
		lblVat1.setBounds(180, 450, 200, 25);
		west.add(lblVat1);
	
	
		

		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnInsert.setForeground(Color.black);
		btnInsert.setBackground(new Color(196, 195, 135));
		btnInsert.setBounds(60, 350, 80, 30);
		btnInsert.setFocusable(false);
		west.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bokid = Integer.parseInt(txtBid.getText());
				Random rand = new Random(); // instance of random class
				int upperbound = 100;
				// generate random values from 0-99
				int randomno = rand.nextInt(upperbound);
				int detailid = bokid + randomno;
				String status = txtBstatus.getText();
				String rate1 = txtRate.getText();
				String quantity = txtQuantity.getText();
				String total = txttotal.getText();
				String vat = lblVat1.getText();
				String item = txtitem.getText();
				String date = ((JTextField) cdate.getDateEditor().getUiComponent()).getText();
				try {
					Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
				} catch (ParseException e1) {

				}
				JDBC jdbc = new JDBC();
				BillLib lib = new BillLib(bokid, detailid, item, quantity, rate1, date, status, vat, total);
				jdbc.detailstaf(lib);
				jdbc.invoicestaf(lib);

			}

		});

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(new Color(106, 101, 101));
		btnClear.setBounds(230, 350, 80, 30);
		btnClear.setFocusable(false);
		west.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				txtBid.setText(null);
				lblquantity.setText(null);
				txtBstatus.setText(null);
				txtitem.setText(null);
				cdate.setCalendar(null);
				txtRate.setText(null);
				txttotal.setText(null);

			}

		});

		JSeparator s2 = new JSeparator();
		s2.setBounds(0, 480, 500, 5);

		west.add(s2);

		JLabel lbllink = new JLabel("www.lutonhotel.com");
		lbllink.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbllink.setBounds(130, 480, 200, 20);
		west.add(lbllink);

		// Centre panel
		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(480, 10));
		center.setLayout(null);
		center.setBackground(new Color(0, 0, 0));
		frame.add(center, BorderLayout.CENTER);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("BookingID");
		model.addColumn("RoomNo");
		model.addColumn("Services");
		model.addColumn("Menu");
		model.addColumn("Quantity");
		model.addColumn("Date");
		
		JTable table = new JTable(model);
		
		JDBC jdbc1 = new JDBC();
		Billdata billl = new Billdata();
		ArrayList search = jdbc1.billtable(billl);
		if (search.size() > 0) {
			for (int i = 0; i < search.size(); i++) {
				billl = (Billdata) search.get(i);				
				Object[] tmp = {  billl.getBookingid(), billl.getRoom(), billl.getService(),billl.getMenu(),billl.getQuantity(),billl.getDate(),};
				model.addRow(tmp);
			}}

	
		JTableHeader h1 = table.getTableHeader();		
		h1.setFont(new Font("Verdana", Font.BOLD, 14));
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);

		table.setBackground(Color.white);
		center.add(table);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(2, 2, 724, 498);
		center.add(scroll);

		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new bill();
	}

}