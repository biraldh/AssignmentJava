 package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ConLib.JDBC;
import ConLib.MenuLib;
import ConLib.MenuLibdata;
import ConLib.ReqMenuLib;
import ConLib.ServiceLib;
import ConLib.ServiceLibdata;

public class Menu {
JFrame frame;
	public Menu() {
		
		frame= new JFrame();
		frame.setSize(1150,600);
		frame.setLocationRelativeTo(null);
		
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(1,60));
		north.setLayout(null);
		north.setBackground(new Color(201,229,255));
		frame.add(north, BorderLayout.NORTH);
		
		JLabel lbltitle = new JLabel("LUTON HOTEL");
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbltitle.setForeground(Color.BLACK);
		lbltitle.setBounds(400 , 15, 200, 30);
		north.add(lbltitle);
		
		//west panel
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(400,10));
		west.setLayout(null);
		west.setBackground(new Color(255,178,102));
		frame.add(west, BorderLayout.WEST);
		
		JLabel lbltitle2 = new JLabel("MENU");
		lbltitle2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbltitle2.setForeground(Color.BLACK);
		lbltitle2.setBounds(175 , 5, 100, 30);
		west.add(lbltitle2);
		
		JSeparator s1 = new JSeparator();
		s1.setBounds(0,35,500,5);
		west.add(s1);
		
		JLabel lblid = new JLabel("Menu ID");
		lblid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblid.setForeground(Color.BLACK);
		lblid.setBounds(40 , 60, 100, 25);
		west.add(lblid);
		
		JTextField txtid = new JTextField();
		txtid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtid.setForeground(Color.BLACK);
		txtid.setBounds(110 , 60, 170, 25);
		west.add(txtid);
		
		JLabel lblitem = new JLabel("Item");
		lblitem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblitem.setForeground(Color.BLACK);
		lblitem.setBounds(40 , 110, 100, 25);
		west.add(lblitem);
		
		JTextField txtitem = new JTextField();
		txtitem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtitem.setForeground(Color.BLACK);
		txtitem.setBounds(110 , 110, 170, 25);
		west.add(txtitem);
		
		JLabel lblrate = new JLabel("Rate");
		lblrate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblrate.setForeground(Color.BLACK);
		lblrate.setBounds(40 , 160, 100, 25);
		west.add(lblrate);
		
		JTextField txtrate = new JTextField();
		txtrate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtrate.setForeground(Color.BLACK);
		txtrate.setBounds(110 , 160, 170, 25);
		west.add(txtrate);
		
		JLabel lblquantity = new JLabel("Quantity");
		lblquantity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblquantity.setForeground(Color.BLACK);
		lblquantity.setBounds(40 , 210, 100, 25);
		west.add(lblquantity);
		
		JTextField txtquantity = new JTextField();
		txtquantity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtquantity.setForeground(Color.BLACK);
		txtquantity.setBounds(110 , 210, 170, 25);
		west.add(txtquantity);
		
		JLabel lbltype = new JLabel("Type");
		lbltype.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbltype.setForeground(Color.BLACK);
		lbltype.setBounds(40 , 260, 100, 25);
		west.add(lbltype);
		
		String type[] = {"Resturant","Bar"};
		JComboBox cmbtype = new JComboBox(type);
		cmbtype.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbtype.setBounds(110,260,170,25);
		cmbtype.setFocusable(false);
		west.add(cmbtype);
		
		JLabel lblstatus = new JLabel("Status");
		lblstatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblstatus.setForeground(Color.BLACK);
		lblstatus.setBounds(40 , 310, 100, 25);
		west.add(lblstatus);
		
		String status[] = {"confirmed","unconfirmed"};
		JComboBox cmbstatus = new JComboBox(status);
		cmbstatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbstatus.setBounds(110,310,170,25);
		cmbstatus.setFocusable(false);
		west.add(cmbstatus);
		
		JLabel lbldate = new JLabel("Date");
		lbldate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbldate.setForeground(Color.BLACK);
		lbldate.setBounds(40 , 360, 100, 25);
		west.add(lbldate);
		
		JDateChooser caldate = new JDateChooser();
		caldate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		caldate.setDateFormatString("yyyy-MM-dd");
		caldate.setBounds(110, 360, 170, 25);
		west.add(caldate);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.setBackground(new Color(255, 255, 255));
		btnConfirm.setBounds(30, 420, 100, 20);
		btnConfirm.setFocusable(false);
		west.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ex) {

			String Menu = txtitem.getText();
			String rate = txtrate.getText();
			String Status = cmbstatus.getSelectedItem().toString();
			String date = ((JTextField) caldate.getDateEditor().getUiComponent()).getText();
			
			int menuid = Integer.parseInt(txtid.getText());
			try {
				Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
			} catch (ParseException e1) {

			}
			String type = cmbtype.getSelectedItem().toString();
			String quantity = txtquantity.getText();
			JDBC jdbc = new JDBC();
			MenuLib lib = new MenuLib(menuid, Menu, rate, quantity, type, Status, date);
			boolean result = jdbc.SaveMenu(lib);

		}
	});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setBounds(150, 420, 100, 20);
		btnUpdate.setFocusable(false);
		west.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				String Menu = txtitem.getText();
				String rate = txtrate.getText();
				String Status = cmbstatus.getSelectedItem().toString();
				String date = ((JTextField) caldate.getDateEditor().getUiComponent()).getText();
				
				int menuid = Integer.parseInt(txtid.getText());
				try {
					Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
				} catch (ParseException e1) {

				}
				String type = cmbtype.getSelectedItem().toString();
				String quantity = txtquantity.getText();
				JDBC jdbc = new JDBC();
				MenuLib lib = new MenuLib(menuid, Menu, rate, quantity, type, Status, date);
				boolean result = jdbc.SaveMenu(lib);

			}
		});
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBounds(270, 420, 100, 20);
		btnDelete.setFocusable(false);
		west.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				
				int Menuid = Integer.parseInt(txtid.getText());				
				
				 
				 JDBC jdbc1 = new JDBC();
				 MenuLib lib1 = new  MenuLib();
				 lib1.setmenuId(Menuid);			 			 
				 boolean result1 = jdbc1.deleteMenuinbookstaf(lib1);
				 boolean result2 = jdbc1.deleteMenustaf(lib1);
				 
				
			}});
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(0, 465, 500, 5);
		west.add(s2);
		
		JLabel lbllink = new JLabel("www.lutonhotel.com");
		lbllink.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbllink.setForeground(Color.BLACK);
		lbllink.setBounds(130, 470, 200, 20);
		west.add(lbllink);
		
		JPanel CENTER = new JPanel();
		CENTER.setPreferredSize(new Dimension(400, 10));
		CENTER.setLayout(null);
		CENTER.setBackground(new Color(50,50,50));
		frame.getContentPane().add(CENTER, BorderLayout.CENTER);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Customer ID");
		model.addColumn("Menu ID");
		model.addColumn("Item");
		model.addColumn("Menu Status");
		model.addColumn("Quantity");
		model.addColumn("Date");
		JTable tableRoom = new JTable(model);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBounds(20, 20, 90, 25);
		btnsearch.setFocusable(false);
		btnsearch.setBackground(new Color(106, 101, 101));
		btnsearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnsearch.setForeground(Color.white);
		CENTER.add(btnsearch);
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				JDBC jdbc = new JDBC();
				MenuLibdata menu1 = new MenuLibdata();
				ArrayList search = jdbc.menudata(menu1);
				if (search.size() > 0) {
					for (int i = 0; i < search.size(); i++) {
						menu1 = (MenuLibdata) search.get(i);

						Object[] tmp = { menu1.getUid(),menu1.getMenuid(),menu1.getItem(),menu1.getStatu(),menu1.getQuantity(),menu1.getDate() };
						model.addRow(tmp);

					}
				}
			}
		});
		
		JLabel mes = new JLabel("All the rooms are displayed");
		mes.setBounds(340, 470, 250, 23);
		mes.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mes.setForeground(Color.black);
		mes.setVisible(false);


	
		JScrollPane sroll = new JScrollPane(tableRoom);
		sroll.setBounds(20, 50, 700, 400);
		CENTER.add(sroll);
		
		frame.setVisible(true);
		frame.setResizable(false);
		
		
	}
	
	public static void main(String[] args) {
		new Menu();

	}

}