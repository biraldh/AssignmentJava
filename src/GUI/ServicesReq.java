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
import ConLib.ServiceLib;

public class ServicesReq {
	JFrame frame;
	JComboBox comboBox;

	public ServicesReq() {
		frame = new JFrame();
		frame.setSize(450, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(1, 60));
		north.setLayout(null);
		north.setBackground(new Color(150, 255, 255));
		frame.getContentPane().add(north, BorderLayout.NORTH);

		JLabel lbltitle = new JLabel("Luton Hotel");
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbltitle.setForeground(Color.black);
		lbltitle.setBounds(150, 20, 200, 35);
		north.add(lbltitle);

		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(450, 10));
		west.setLayout(null);
		west.setBackground(new Color(21, 159, 133));
		frame.getContentPane().add(west, BorderLayout.WEST);

		JLabel titlelbl1 = new JLabel("Services");
		titlelbl1.setFont(new Font("Bauhaus 93", Font.PLAIN, 22));
		titlelbl1.setForeground(Color.white);
		titlelbl1.setBounds(160, 10, 300, 35);
		west.add(titlelbl1);

		JSeparator s1 = new JSeparator();
		s1.setBounds(0, 40, 450, 20);
		west.add(s1);

		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 100, 200);
		lblImage.setIcon(new ImageIcon("hh.jpg"));
		frame.getContentPane();
	    frame.add(lblImage);
	    
		JLabel lblUser_id = new JLabel("User ID : ");
		lblUser_id.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUser_id.setForeground(Color.DARK_GRAY);
		lblUser_id.setBounds(10, 45, 100, 10);
		west.add(lblUser_id);

		
		//String uid = Integer.toString(Global.loginCred.getId());
		JLabel lblUser_id1 = new JLabel();
		lblUser_id1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUser_id1.setForeground(Color.DARK_GRAY);
		lblUser_id1.setBounds(70, 45, 100, 10);
		west.add(lblUser_id1);

		JLabel lblName = new JLabel("Service : ");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setForeground(Color.black);
		lblName.setBounds(50, 100, 100, 25);
		west.add(lblName);

		JTextField txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtName.setForeground(Color.black);
		txtName.setBounds(150, 100, 200, 25);
		west.add(txtName);



		JLabel lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setForeground(Color.black);
		lblDate.setBounds(50, 150, 100, 25);
		west.add(lblDate);

		JDateChooser c1 = new JDateChooser();
		c1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c1.setDateFormatString("yyyy-MM-dd");
		c1.setBounds(150, 150, 200, 25);
		west.add(c1);


		JLabel lblQuantity = new JLabel("Quantity : ");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantity.setForeground(Color.black);
		lblQuantity.setBounds(50, 200, 100, 25);
		west.add(lblQuantity);
		
		JTextField txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtQuantity.setForeground(Color.black);
		txtQuantity.setBounds(150, 200, 200, 25);
		west.add(txtQuantity);
		
		JButton updatebtn=new JButton("Update");
		updatebtn.setBounds(300,300,95,25);
		updatebtn.setFocusable(false);
		updatebtn.setBackground(new Color(106,101,101));
		updatebtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		updatebtn.setForeground(Color.white);
		west.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				 int userid =  Global.loginCred.getId();	
				 String service = txtName.getText();
				 String date = ((JTextField) c1.getDateEditor().getUiComponent()).getText();
                 String  quantity = txtQuantity.getText();
				 
				 JDBC jdbc1 = new JDBC();
				 LibServiceReq lib1 = new LibServiceReq();
				 lib1.setUId(userid);
				 lib1.setService(service);
				 LibServiceReq result1 = jdbc1.serviceId(lib1);
				 int serviceid = lib1.getServiceid();
				 
				
				 
					try {
						Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e1) {

					}				 
			
				 		 
				 JDBC jdbc = new JDBC();			 
				 LibServiceReq lib = new LibServiceReq( userid, service,  date, quantity,serviceid);
				 boolean result = jdbc.requpdateService(lib);
				 
				 
				 
			}});
		
		
		JButton Deletebtn=new JButton("Delete");
		Deletebtn.setBounds(170,300,90,25);
		Deletebtn.setFocusable(false);
		Deletebtn.setBackground(new Color(106,101,101));
		Deletebtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		Deletebtn.setForeground(Color.white);
		west.add(Deletebtn);
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				 int userid =  Global.loginCred.getId();
				 String service = txtName.getText();
				 JDBC jdbc1 = new JDBC();
				 LibServiceReq lib1 = new LibServiceReq();
				 lib1.setUId(userid);
				 lib1.setService(service);
				 LibServiceReq result = jdbc1.serviceId(lib1);
				 boolean result1 = jdbc1.deleteServiceinbook(lib1);
				 boolean result2 = jdbc1.deleteService(lib1);
				 
				
			}});
		
		JButton Confirmbtn=new JButton("Comfirm");
		Confirmbtn.setBounds(20,300,108,25);
		Confirmbtn.setFocusable(false);
		Confirmbtn.setBackground(new Color(106,101,101));
		Confirmbtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		Confirmbtn.setForeground(Color.white);
		west.add(Confirmbtn);
		Confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				 int userid = Global.loginCred.getId();
				 
				 String service = txtName.getText();
				 String date = ((JTextField) c1.getDateEditor().getUiComponent()).getText();
				 String  quantity = txtQuantity.getText();
				
				 
					try {
						Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e1) {

					}				 				
				   Random rand = new Random(); //instance of random class
				      int upperbound = 100;
				        //generate random values from 0-99
				      int randomno = rand.nextInt(upperbound);
				 int serviceid = userid*randomno; 
				 JDBC jdbc = new JDBC();
				LibServiceReq lib = new LibServiceReq( userid, service,  date, quantity,serviceid);
				 boolean result = jdbc.ReqService(lib);
				 
				 boolean result1 = jdbc.addServiceBook(lib);
				 
			}});
					
		JSeparator s2 = new JSeparator();
		s2.setBounds(0, 450, 450, 20);
		west.add(s2);
		
		JLabel lbllink = new JLabel("www.lutonhotel.com");
		lbllink.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbllink.setForeground(Color.BLACK);
		lbllink.setBounds(160, 480, 200, 20);
		west.add(lbllink);
		
		frame.setResizable(false);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new ServicesReq();
	}

}