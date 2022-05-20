package GUI;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import ConLib.JDBC;
import ConLib.libBook;
import ConLib.libBookRequest;
import ConLib.libRoom;

public class bookRequest extends JFrame {
	JComboBox CoPreference;
	JButton btnSearch;

	public bookRequest() {

		setSize(1250, 650);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(1, 80));
		north.setBackground(new Color(106, 101, 101));
		getContentPane().add(north, BorderLayout.NORTH);

		JPanel Center = new JPanel();
		Center.setLayout(null);
		Center.setPreferredSize(new Dimension(180, 180));
		Center.setBackground(new Color(200, 100, 100));

		getContentPane().add(Center, BorderLayout.CENTER);

		JLabel titlelbl = new JLabel("Luton Hotel");
		titlelbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelbl.setForeground(Color.white);
		titlelbl.setBounds(520, 20, 200, 35);
		north.add(titlelbl);

		JPanel west = new JPanel();
		west.setLayout(null);
		west.setPreferredSize(new Dimension(440, 80));
		west.setBackground(new Color(21, 159, 133));
		getContentPane().add(west, BorderLayout.WEST);

		JLabel titlelbl1 = new JLabel("Customer Booking");
		titlelbl1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		titlelbl1.setForeground(Color.white);
		titlelbl1.setBounds(150, 20, 200, 35);
		west.add(titlelbl1);

		JSeparator s1 = new JSeparator();
		s1.setBounds(0, 50, 500, 10);
		west.add(s1);
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(0, 500, 500, 10);
		west.add(s2);
		
		JLabel lbllink = new JLabel("www.lutonhotel.com");
		lbllink.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbllink.setForeground(Color.WHITE);
		lbllink.setBounds(160, 510, 200, 20);
		west.add(lbllink);

//		JLabel Customerlbl = new JLabel("Customer ID:");
//		Customerlbl.setBounds(20, 120, 150, 30);
//		Customerlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		Customerlbl.setForeground(Color.white);
//
//		west.add(Customerlbl);
//
//		JLabel customertxt = new JLabel();
//		customertxt.setBounds(200, 120, 200, 30);
//		customertxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		//String id = Integer.toString(Global.loginCred.getId());
//		//customertxt.setText(id);
//		west.add(customertxt);


		JLabel checkinlbl = new JLabel("Check-In:");
		checkinlbl.setBounds(20, 170, 150, 30);
		checkinlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		checkinlbl.setForeground(Color.white);
		west.add(checkinlbl);

		JDateChooser c1 = new JDateChooser();
		c1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c1.setDateFormatString("yyyy-MM-dd");
		c1.setBounds(200, 170, 200, 30);
		west.add(c1);

		JLabel checkoutlbl = new JLabel("Check-Out:");
		checkoutlbl.setBounds(20, 220, 150, 30);
		checkoutlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		checkoutlbl.setForeground(Color.white);
		west.add(checkoutlbl);

		JDateChooser c2 = new JDateChooser();
		c2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c2.setDateFormatString("yyyy-MM-dd");
		c2.setBounds(200, 220, 200, 30);
		west.add(c2);

		JLabel Preference = new JLabel("Room Preference:");
		Preference.setBounds(20, 270, 150, 30);
		Preference.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Preference.setForeground(Color.white);
		west.add(Preference);

		Object[] status = { "Single", "Double","Twin"};
		CoPreference = new JComboBox(status);
		CoPreference.setBounds(200, 270, 200, 30);
		CoPreference.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CoPreference.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(CoPreference);

		

		JButton insertbtn = new JButton("Book");
		insertbtn.setBounds(40, 400, 100, 30);
		insertbtn.setFocusable(false);
		insertbtn.setBackground(new Color(106, 101, 101));
		insertbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		insertbtn.setForeground(Color.white);
		west.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String checkin = ((JTextField) c1.getDateEditor().getUiComponent()).getText();

				try {
					Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(checkin);
				} catch (ParseException e1) {

				}
				String checkout = ((JTextField) c2.getDateEditor().getUiComponent()).getText();

				try {
					Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(checkout);
				} catch (ParseException e1) {

				}
				int id = Global.loginCred.getId();			
				//int CustId = Integer.parseInt(customertxt.getText());
				String prefer= CoPreference.getSelectedItem().toString();
				

				JDBC jdbc = new JDBC();
				libBookRequest lib = new libBookRequest(checkin, checkout, prefer, id);
				boolean result = jdbc.RequestBook(lib);
				
			}
		});

		JButton updatebtn = new JButton("Update");
		updatebtn.setBounds(170, 400, 100, 30);
		updatebtn.setFocusable(false);
		updatebtn.setBackground(new Color(106, 101, 101));
		updatebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		updatebtn.setForeground(Color.white);
		west.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String checkin1 = ((JTextField) c1.getDateEditor().getUiComponent()).getText();

				try {
					Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(checkin1);
				} catch (ParseException e1) {

				}
				String checkout1 = ((JTextField) c2.getDateEditor().getUiComponent()).getText();

				try {
					Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(checkout1);
				} catch (ParseException e1) {

				}
				int id1 = Global.loginCred.getId();
				String prefer1= CoPreference.getSelectedItem().toString();
				

				JDBC jdbc1 = new JDBC();
				libBookRequest lib1 = new libBookRequest(checkin1, checkout1, prefer1, id1);
				boolean result1 = jdbc1.bookupdaterequest(lib1) != null;
				
			}
		});
 
		JButton clearbtn = new JButton("Delete");
		clearbtn.setBounds(300, 400, 100, 30);
		clearbtn.setFocusable(false);
		clearbtn.setBackground(new Color(106, 101, 101));
		clearbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clearbtn.setForeground(Color.white);
		west.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				int id = Global.loginCred.getId();
				JDBC jdbc = new JDBC();
				libBook lib = new libBook();
				lib.setUid(id);
				boolean result = jdbc.DeleteBook(lib);

			}

		});

		setVisible(true);

	}

	public static void main(String[] args) {
		new bookRequest();
	}
}
