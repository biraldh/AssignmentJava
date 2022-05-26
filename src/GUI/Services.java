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

public class Services implements MouseListener {
	JFrame frame;
	JComboBox comboBox;
	JTextField txtService_id, txtName, txtQuantity;
	DefaultTableModel model;
	JTable tableservice;
	public Services() {
		frame = new JFrame();
		frame.setSize(1200, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(750, 10));
		east.setLayout(null);
		east.setBackground(new Color(0,0,0));
		frame.getContentPane().add(east, BorderLayout.EAST);
		
		model = new DefaultTableModel();
		model.addColumn("Customer ID");
		model.addColumn("Service ID");
		model.addColumn("Name");
		model.addColumn("Service");
		model.addColumn("Service Status");
		model.addColumn("Quantity");
		model.addColumn("Date");
		tableservice = new JTable(model);
		tableservice.addMouseListener(this);
		
		JButton btnsearch = new JButton("Display");
		btnsearch.setBounds(20, 20, 100, 25);
		btnsearch.setFocusable(false);
		btnsearch.setBackground(new Color(106, 101, 101));
		btnsearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnsearch.setForeground(Color.white);
		east.add(btnsearch);
		btnsearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ex) {
				model.setRowCount(0);//clearing the rows of the jtable
				//Retrieving data from middleware
				JDBC jdbc = new JDBC();
				ServiceLibdata servic = new ServiceLibdata();
				ArrayList search = jdbc.servicedata(servic);
				if (search.size() > 0) {
					for (int i = 0; i < search.size(); i++) {
						servic = (ServiceLibdata) search.get(i);
						Object[] tmp = { servic.getUid(),servic.getServiceId(),servic.getName(),servic.getItem(),servic.getStatus(),servic.getQuantity(),servic.getDate() };
						model.addRow(tmp);

					}
				}
			}
		});
		
	
		JScrollPane sroll = new JScrollPane(tableservice);
		sroll.setBounds(10, 50, 730, 400);
		east.add(sroll);
		
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(1, 60));
		north.setLayout(null);
		north.setBackground(new Color(150, 255, 255));
		frame.getContentPane().add(north, BorderLayout.NORTH);

		JLabel lbltitle = new JLabel("Luton Hotel");
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbltitle.setForeground(Color.black);
		lbltitle.setBounds(500, 20, 200, 35);
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

		JLabel lblService_id = new JLabel("Service ID : ");
		lblService_id.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblService_id.setForeground(Color.black);
		lblService_id.setBounds(50, 60, 100, 25);
		west.add(lblService_id);

		txtService_id = new JTextField();
		txtService_id.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtService_id.setForeground(Color.black);
		txtService_id.setBounds(150, 60, 200, 25);
		west.add(txtService_id);

		JLabel lblName = new JLabel("Services : ");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setForeground(Color.black);
		lblName.setBounds(50, 100, 100, 25);
		west.add(lblName);

		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtName.setForeground(Color.black);
		txtName.setBounds(150, 100, 200, 25);
		west.add(txtName);

		JLabel lblrate = new JLabel("Rate : ");
		lblrate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblrate.setForeground(Color.black);
		lblrate.setBounds(50, 140, 100, 25);
		west.add(lblrate);

		JTextField txtrate = new JTextField();
		txtrate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtrate.setForeground(Color.black);
		txtrate.setBounds(150, 140, 200, 25);
		west.add(txtrate);

		JLabel lblStatus = new JLabel("Status : ");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStatus.setForeground(Color.black);
		lblStatus.setBounds(50, 180, 100, 25);
		west.add(lblStatus);

		String[] Types1 = { "Confirmed", "UnConfirmed" };
		JComboBox ComboBox = new JComboBox(Types1);
		ComboBox.setBounds(150, 180, 200, 25);
//		ComboBox.addActionListener(this);
		west.add(ComboBox);

		JLabel lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setForeground(Color.black);
		lblDate.setBounds(50, 220, 100, 25);
		west.add(lblDate);

		JDateChooser c1 = new JDateChooser();
		c1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c1.setDateFormatString("yyyy-MM-dd");
		c1.setBounds(150, 220, 200, 25);
		west.add(c1);

		JLabel lblType = new JLabel("Types : ");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblType.setForeground(Color.black);
		lblType.setBounds(50, 260, 100, 25);
		west.add(lblType);

		String[] Types2 = { "internal", "External" };
		JComboBox ComboBox1 = new JComboBox(Types2);
		ComboBox1.setBounds(150, 260, 200, 25);
		west.add(ComboBox1);

		JLabel lblQuantity = new JLabel("Quantity : ");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantity.setForeground(Color.black);
		lblQuantity.setBounds(50, 300, 100, 25);
		west.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtQuantity.setForeground(Color.black);
		txtQuantity.setBounds(150, 300, 200, 25);
		west.add(txtQuantity);

		JButton updatebtn = new JButton("Update");
		updatebtn.setBounds(300, 370, 95, 25);
		updatebtn.setFocusable(false);
		updatebtn.setBackground(new Color(106, 101, 101));
		updatebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		updatebtn.setForeground(Color.white);
		west.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				//Initialize and declare variables
				int userid = Integer.parseInt(txtService_id.getText());

				String service = txtName.getText();
				String rate = txtrate.getText();
				String Status = ComboBox.getSelectedItem().toString();
				String date = ((JTextField) c1.getDateEditor().getUiComponent()).getText();
				
				int serviceid = Integer.parseInt(txtService_id.getText());
				try {
					Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
				} catch (ParseException e1) {

				}
				String type = ComboBox1.getSelectedItem().toString();
				String quantity = txtQuantity.getText();
				//sending data to middleware
				JDBC jdbc = new JDBC();
				ServiceLib lib = new ServiceLib(serviceid, userid, service, rate, Status, date, type, quantity);
				boolean result = jdbc.SaveService(lib);

			}
		});

		JButton Deletebtn = new JButton("Delete");
		Deletebtn.setBounds(170, 370, 90, 25);
		Deletebtn.setFocusable(false);
		Deletebtn.setBackground(new Color(106, 101, 101));
		Deletebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Deletebtn.setForeground(Color.white);
		west.add(Deletebtn);
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				int serviceid = Integer.parseInt(txtService_id.getText());
				//sending uid to middleware
				JDBC jdbc1 = new JDBC();
				LibServiceReq lib1 = new LibServiceReq();
				lib1.setServiceid( serviceid);
				boolean result1 = jdbc1.deleteServiceinbook(lib1);
				boolean result2 = jdbc1.deleteService(lib1);

			}
		});

		JButton Confirmbtn = new JButton("Comfirm");
		Confirmbtn.setBounds(20, 370, 108, 25);
		Confirmbtn.setFocusable(false);
		Confirmbtn.setBackground(new Color(106, 101, 101));
		Confirmbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Confirmbtn.setForeground(Color.white);
		west.add(Confirmbtn);
		Confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				//initialize and declare variable
				int userid = Integer.parseInt(txtService_id.getText());

				String service = txtName.getText();
				String rate = txtrate.getText();
				String Status = ComboBox.getSelectedItem().toString();
				String date = ((JTextField) c1.getDateEditor().getUiComponent()).getText();
				
				int serviceid = Integer.parseInt(txtService_id.getText());
				try {
					Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
				} catch (ParseException e1) {

				}
				String type = ComboBox1.getSelectedItem().toString();
				String quantity = txtQuantity.getText();
				//sending data to middleware
				JDBC jdbc = new JDBC();
				ServiceLib lib = new ServiceLib(serviceid, userid, service, rate, Status, date, type, quantity);
				boolean result = jdbc.SaveService(lib);

			}
		});

		JSeparator s2 = new JSeparator();
		s2.setBounds(0, 430, 450, 20);
		west.add(s2);

		frame.setResizable(false);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Services();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rows = tableservice.getSelectedRow();//getting the row number
		//row value if click  goes to txtService_id
		String serviceid = model.getValueAt(rows, 1).toString();
		txtService_id.setText(serviceid);
		//row value if click  goes to txtName
		String service = model.getValueAt(rows, 3).toString();
		txtName.setText(service);
		
		//row value if click  goes to txtQuantity
		String quantity = model.getValueAt(rows, 5).toString();
		txtQuantity.setText(quantity);
		
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