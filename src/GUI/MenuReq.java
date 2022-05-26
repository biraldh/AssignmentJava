package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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
import ConLib.MenuLibdata;
import ConLib.ReqMenuLib;
import ConLib.ServiceLibdata;

public class MenuReq implements MouseListener  {
	JFrame frame;
	DefaultTableModel model;
	JTable tablemenu;
	int menuid;
	public MenuReq() {

		frame = new JFrame();
		frame.setSize(1120, 600);
		frame.setLocationRelativeTo(null);

		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(1, 60));
		north.setLayout(null);
		north.setBackground(new Color(201, 229, 255));
		frame.add(north, BorderLayout.NORTH);

		JLabel lbltitle = new JLabel("LUTON HOTEL");
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbltitle.setForeground(Color.BLACK);
		lbltitle.setBounds(400, 15, 200, 30);
		north.add(lbltitle);

		// west panel
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(400, 10));
		west.setLayout(null);
		west.setBackground(new Color(255, 178, 102));
		frame.add(west, BorderLayout.WEST);

		JLabel lbltitle2 = new JLabel("MENU");
		lbltitle2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbltitle2.setForeground(Color.BLACK);
		lbltitle2.setBounds(175, 5, 100, 30);
		west.add(lbltitle2);

		JSeparator s1 = new JSeparator();
		s1.setBounds(0, 35, 500, 5);
		west.add(s1);



		JLabel lblitem = new JLabel("Item");
		lblitem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblitem.setForeground(Color.BLACK);
		lblitem.setBounds(40, 110, 100, 25);
		west.add(lblitem);

		String[] fooditem = { "Breakfast Buffet","Lunch Buffet","Dinner Buffet","Latte","Coffee","Cold Beverages"};
		JComboBox txtitem = new JComboBox(fooditem);
		txtitem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtitem.setForeground(Color.BLACK);
		txtitem.setBounds(110, 110, 170, 25);
		west.add(txtitem);


		JLabel lblquantity = new JLabel("Quantity");
		lblquantity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblquantity.setForeground(Color.BLACK);
		lblquantity.setBounds(40, 160, 100, 25);
		west.add(lblquantity);

		JTextField txtquantity = new JTextField();
		txtquantity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtquantity.setForeground(Color.BLACK);
		txtquantity.setBounds(110, 160, 170, 25);
		west.add(txtquantity);

		JLabel lbltype = new JLabel("Type");
		lbltype.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbltype.setForeground(Color.BLACK);
		lbltype.setBounds(40, 210, 100, 25);
		west.add(lbltype);

		String type[] = { "Restaurant", "Bar" };
		JComboBox cmbtype = new JComboBox(type);
		cmbtype.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbtype.setBounds(110, 210, 170, 25);
		cmbtype.setFocusable(false);
		west.add(cmbtype);


		JLabel lbldate = new JLabel("Date");
		lbldate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbldate.setForeground(Color.BLACK);
		lbldate.setBounds(40, 260, 100, 25);
		west.add(lbldate);

		JDateChooser caldate = new JDateChooser();
		caldate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		caldate.setDateFormatString("yyyy-MM-dd");
		caldate.setBounds(110, 260, 170, 25);
		west.add(caldate);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.setBackground(new Color(255, 255, 255));
		btnConfirm.setBounds(30, 340, 100, 20);
		btnConfirm.setFocusable(false);
		west.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid =  Global.loginCred.getId();
				//int userid = Integer.parseInt(txtid.getText());
				String  quantity = txtquantity.getText();
				 String item = txtitem.getSelectedItem().toString();
				 String type= cmbtype.getSelectedItem().toString();
				 String date = ((JTextField) caldate.getDateEditor().getUiComponent()).getText();
				try {
						Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e1) {

					}				 				
				   Random rand = new Random(); //instance of random class
				      int upperbound = 100;
				        //generate random values from 0-99
				      int randomno = rand.nextInt(upperbound);
				 int menuid = userid*randomno; 
				 JDBC jdbc = new JDBC();
				 ReqMenuLib lib = new ReqMenuLib( userid,menuid, item,quantity,  date,type );
				 jdbc.ReqMenu(lib);
				 
				 jdbc.addMenuBook(lib);
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setBounds(150, 340, 100, 20);
		btnUpdate.setFocusable(false);
		west.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//initialize and declare variables
				int userid =  Global.loginCred.getId();
				
				String  quantity = txtquantity.getText();
				 String item = txtitem.getSelectedItem().toString();
				 String type= cmbtype.getSelectedItem().toString();
				 String date = ((JTextField) caldate.getDateEditor().getUiComponent()).getText();
				try {
						Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e1) {

					}				 				
				  // sending data to middleware
				 JDBC jdbc = new JDBC();
				 ReqMenuLib lib1 = new ReqMenuLib();
				 lib1.setUid(userid);
				 lib1.setMenuid(menuid);
				 System.out.println(menuid);
				 
				 
				 ReqMenuLib lib = new ReqMenuLib( userid,menuid, item,quantity,  date,type );
				 boolean result1 = jdbc.requpdateMenue(lib);
				 
				 
			}
		});
		

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBounds(270, 340, 100, 20);
		btnDelete.setFocusable(false);
		west.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				int userid =  Global.loginCred.getId();	
				//sending uid and menuid to middleware for deleting the data
				 JDBC jdbc1 = new JDBC();
				 ReqMenuLib lib1 = new  ReqMenuLib();
				 lib1.setUid(userid);
				 lib1.setMenuid(menuid);	 
				 ReqMenuLib result = jdbc1.menuId(lib1);	 
				 boolean result1 = jdbc1.deleteMenuinbook(lib1);
				 boolean result2 = jdbc1.deleteMenu(lib1);
				 
				
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
		CENTER.setBackground(new Color(50, 50, 50));
		frame.getContentPane().add(CENTER, BorderLayout.CENTER);

		 model = new DefaultTableModel();
		model.addColumn("Customer ID");
		model.addColumn("Menu ID");
		model.addColumn("Item");
		model.addColumn("Menu Status");
		model.addColumn("Quantity");
		model.addColumn("Date");
		
		 tablemenu = new JTable(model);
		tablemenu.addMouseListener(this);
		
		JButton btnsearch = new JButton("Refresh");
		btnsearch.setBounds(20, 20, 100, 25);
		btnsearch.setFocusable(false);
		btnsearch.setBackground(new Color(106, 101, 101));
		btnsearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnsearch.setForeground(Color.white);
		CENTER.add(btnsearch);
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				model.setRowCount(0);//deleting rows of the table
				JDBC jdbc = new JDBC();				
				int id = Global.loginCred.getId();
				//sending uid to middleware and retriving data to be displayed in the table
				MenuLibdata menu1 = new MenuLibdata();
				menu1.setUid(id);									
				ArrayList search = jdbc.menuview(menu1);
				if (search.size() > 0) {
					for (int i = 0; i < search.size(); i++) {
						menu1 = (MenuLibdata) search.get(i);

						Object[] tmp = { menu1.getUid(),menu1.getMenuid(),menu1.getItem(),menu1.getStatu(),menu1.getQuantity(),menu1.getDate() };
						model.addRow(tmp);

					}
				}
			}
		});
		

	
		JScrollPane sroll = new JScrollPane(tablemenu);
		sroll.setBounds(20, 50, 670, 400);
		CENTER.add(sroll);

		frame.setVisible(true);
		frame.setResizable(false);

	}

	public static void main(String[] args) {
		new MenuReq();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rows =tablemenu.getSelectedRow();
		 String menuID =model.getValueAt(rows, 1).toString();
		menuid = Integer.parseInt(menuID);
		System.out.println(menuid);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}}



		
	

