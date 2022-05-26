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

import ConLib.BookDataLib;
import ConLib.JDBC;
import ConLib.LibServiceReq;
import ConLib.ServiceLib;
import ConLib.ServiceLibdata;

public class ServicesReq implements MouseListener {
	JFrame frame;
	JComboBox comboBox;
	DefaultTableModel model;
	JTable tableService;
	int serviceID;

	public ServicesReq() {
		frame = new JFrame();
		frame.setSize(1100, 600);
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

		String[] servic = {"car wash","parking","room cleaning"};
		JComboBox txtName = new JComboBox(servic);
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
				//intialize and declare variables
				 int userid =  Global.loginCred.getId();	
				 String service = txtName.getSelectedItem().toString();
				 String date = ((JTextField) c1.getDateEditor().getUiComponent()).getText();
                 String  quantity = txtQuantity.getText();
				 //sending variables data to middleware
				 JDBC jdbc1 = new JDBC();			
				 System.out.println(service);
				
				 
					try {
						Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e1) {

					}				 
			
				 		 
				 JDBC jdbc = new JDBC();			 
				 LibServiceReq lib = new LibServiceReq( userid, service,  date, quantity,serviceID);
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
				//getting uid data from global class
				 int userid =  Global.loginCred.getId();
				 //sending uid to middleware
				 JDBC jdbc1 = new JDBC();
				 LibServiceReq lib1 = new LibServiceReq();
				 lib1.setUId(userid);
				 lib1.setServiceid(serviceID);
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
				//getting uid data from global class
				 int userid = Global.loginCred.getId();
				 //intialize and declare variables
				 String service = txtName.getSelectedItem().toString();
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
				//sending data to middleware
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
		
		JPanel center = new JPanel();
		center.setSize(1000,600);
		//north.setPreferredSize(new Dimension(1, 60));
		center.setLayout(null);
		center.setBackground(new Color(100, 100, 133));
		frame.getContentPane().add(center, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		model.addColumn("Customer ID");
		model.addColumn("Service ID");
		model.addColumn("Service");
		model.addColumn("Service Status");
		model.addColumn("Quantity");
		model.addColumn("Date");
		
		tableService = new JTable(model);
		tableService.addMouseListener(this);
		
		

		JButton btnsearch = new JButton("Display");
		btnsearch.setBounds(10, 20, 100, 25);
		btnsearch.setFocusable(false);
		btnsearch.setBackground(new Color(106, 101, 101));
		btnsearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnsearch.setForeground(Color.white);
		center.add(btnsearch);
		btnsearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ex) {
				model.setRowCount(0);//counting rows
				JDBC jdbc = new JDBC();
				int id = Global.loginCred.getId();//getting uid from global class
				ServiceLibdata servic = new ServiceLibdata();
				servic.setUid(id);				
				ArrayList search = jdbc.servicview(servic);//sending uid to middleware 
				if (search.size() > 0) {
					for (int i = 0; i < search.size(); i++) {//counting the size of arraylist
						servic = (ServiceLibdata) search.get(i);//Retrieving the data 
						Object[] tmp = { servic.getUid(),servic.getServiceId(),servic.getItem(),servic.getStatus(),servic.getQuantity(),servic.getDate() };
						model.addRow(tmp);//placing the retrieved data in a table

					}
				}
			}
		});
		
	
		JScrollPane sroll = new JScrollPane(tableService);
		sroll.setBounds(20, 50, 600, 400);
		center.add(sroll);
		
		frame.setResizable(false);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new ServicesReq();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rows = tableService.getSelectedRow();
		String serviceid = model.getValueAt(rows, 1).toString();
		serviceID = Integer.parseInt(serviceid);
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
		
	}

}