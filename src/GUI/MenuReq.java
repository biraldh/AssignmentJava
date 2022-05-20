package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ConLib.JDBC;
import ConLib.LibServiceReq;
import ConLib.ReqMenuLib;

public class MenuReq {
	JFrame frame;

	public MenuReq() {

		frame = new JFrame();
		frame.setSize(1000, 600);
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

//		JLabel lblid = new JLabel("User ID");
//		lblid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		lblid.setForeground(Color.BLACK);
//		lblid.setBounds(40, 60, 100, 25);
//		west.add(lblid);
//
//		JTextField txtid = new JTextField();
//		txtid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtid.setForeground(Color.BLACK);
//		txtid.setBounds(110, 60, 170, 25);
//		west.add(txtid);

		JLabel lblitem = new JLabel("Item");
		lblitem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblitem.setForeground(Color.BLACK);
		lblitem.setBounds(40, 110, 100, 25);
		west.add(lblitem);

		JTextField txtitem = new JTextField();
		txtitem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtitem.setForeground(Color.BLACK);
		txtitem.setBounds(110, 110, 170, 25);
		west.add(txtitem);

//		JLabel lblrate = new JLabel("Rate");
//		lblrate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		lblrate.setForeground(Color.BLACK);
//		lblrate.setBounds(40 , 160, 100, 25);
//		west.add(lblrate);
//		
//		JTextField txtrate = new JTextField();
//		txtrate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtrate.setForeground(Color.BLACK);
//		txtrate.setBounds(110 , 160, 170, 25);
//		west.add(txtrate);

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

		String type[] = { "Resturant", "Bar" };
		JComboBox cmbtype = new JComboBox(type);
		cmbtype.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbtype.setBounds(110, 210, 170, 25);
		cmbtype.setFocusable(false);
		west.add(cmbtype);

//		JLabel lblstatus = new JLabel("Status");
//		lblstatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		lblstatus.setForeground(Color.BLACK);
//		lblstatus.setBounds(40 , 310, 100, 25);
//		west.add(lblstatus);
//		
//		String status[] = {"confirmed","unconfirmed"};
//		JComboBox cmbstatus = new JComboBox(status);
//		cmbstatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		cmbstatus.setBounds(110,310,170,25);
//		cmbstatus.setFocusable(false);
//		west.add(cmbstatus);

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
				 String item = txtitem.getText();
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
				int userid =  Global.loginCred.getId();
				//int userid = Integer.parseInt(txtid.getText());
				String  quantity = txtquantity.getText();
				 String item = txtitem.getText();
				 String type= cmbtype.getSelectedItem().toString();
				 String date = ((JTextField) caldate.getDateEditor().getUiComponent()).getText();
				try {
						Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e1) {

					}				 				
				  
				 JDBC jdbc = new JDBC();
				 ReqMenuLib lib1 = new ReqMenuLib();
				 lib1.setUid(userid);
				 lib1.setItem(item);
				 boolean result = jdbc.menuId(lib1) != null;
				 int menuid = lib1.getMenuid();
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
				//int userid = Integer.parseInt(txtid.getText());				
				 String item = txtitem.getText();
				 
				 JDBC jdbc1 = new JDBC();
				 ReqMenuLib lib1 = new  ReqMenuLib();
				 lib1.setUid(userid);
				 lib1.setItem(item);
				 
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

//		set image
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 50, 585, 400);
		lblImage.setIcon(new ImageIcon("menu.jpg"));
		frame.getContentPane();
		CENTER.add(lblImage);

		frame.setVisible(true);
		frame.setResizable(false);

	}

	public static void main(String[] args) {
		new MenuReq();

	}

}