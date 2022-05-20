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

import javax.swing.BorderFactory;
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
import ConLib.libBook;
import ConLib.libRoom;


public class Staffbook extends JFrame {
	JComboBox CoStatus;
	JButton btnSearch;

	public Staffbook() {

		setSize(1250, 650);
		setTitle("Booking Details");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(1, 80));
		north.setBackground(new Color(204, 204, 255));
		getContentPane().add(north, BorderLayout.NORTH);

		JPanel Center = new JPanel();
		Center.setLayout(null);
		Center.setPreferredSize(new Dimension(180, 180));
		Center.setBackground(new Color(200, 190, 160));

		getContentPane().add(Center, BorderLayout.CENTER);

		JLabel titlelbl = new JLabel("Luton Hotel");
		titlelbl.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		titlelbl.setForeground(Color.BLACK);
		titlelbl.setBounds(520, 20, 200, 35);
		north.add(titlelbl);

		JPanel west = new JPanel();
		west.setLayout(null);
		west.setPreferredSize(new Dimension(400, 80));
		west.setBackground(new Color(255, 153, 102));
		getContentPane().add(west, BorderLayout.WEST);

		JLabel titlelbl1 = new JLabel("Booking Details for Staff");
		titlelbl1.setFont(new Font("Bauhaus 93", Font.PLAIN, 27));
		titlelbl1.setForeground(Color.BLACK);
		titlelbl1.setBounds(55, 10, 300, 35);
		west.add(titlelbl1);

		JSeparator s1 = new JSeparator();
		s1.setBounds(0, 50, 400, 10);
		west.add(s1);

		JLabel bookinglbl = new JLabel("Booking ID : ");
		bookinglbl.setBounds(20, 70, 150, 30);
		//Customerlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//Customerlbl.setForeground(Color.white);
		west.add(bookinglbl);

		JTextField bookingtxt = new JTextField();
		bookingtxt.setBounds(150, 70, 200, 30);
		bookingtxt.setFont(new Font("Times  New Roman", Font.PLAIN, 14));
		//customertxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		// String id = Integer.toString(Global.loginCred.getId());
		// customertxt.setText(id);
		west.add(bookingtxt);
		
		JLabel guesttlbl = new JLabel("Guest Name : ");
		guesttlbl.setBounds(20, 120, 150, 30);
		//lblPref.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//lblPref.setForeground(Color.white);
		west.add(guesttlbl);

		JTextField guesttxt = new JTextField();
		guesttxt.setBounds(150, 120, 200, 30);
		guesttxt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		west.add(guesttxt);

		JLabel roomid = new JLabel("Room No : ");
		roomid.setBounds(20, 170, 150, 30);
		//roomid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//roomid.setForeground(Color.white);
		west.add(roomid);

		JTextField roomidtxt = new JTextField();
		roomidtxt.setBounds(150, 170, 200, 30);
		roomidtxt.setFont(new Font("Times  New Roman", Font.PLAIN, 14));
		//roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(roomidtxt);

		JLabel checkinlbl = new JLabel("Check-In : ");
		checkinlbl.setBounds(20, 220, 150, 30);
		//checkinlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//checkinlbl.setForeground(Color.white);
		west.add(checkinlbl);

		JDateChooser c1 = new JDateChooser();
		c1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		c1.setDateFormatString("yyyy-MM-dd");
		c1.setBounds(150, 220, 200, 30);
		west.add(c1);

		JLabel checkoutlbl = new JLabel("Check-Out : ");
		checkoutlbl.setBounds(20, 270, 150, 30);
		//checkoutlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//checkoutlbl.setForeground(Color.white);
		west.add(checkoutlbl);

		JDateChooser c2 = new JDateChooser();
		c2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		c2.setDateFormatString("yyyy-MM-dd");
		c2.setBounds(150, 270, 200, 30);
		west.add(c2);

		JLabel BokStat = new JLabel("Booking Status : ");
		BokStat.setBounds(20, 320, 150, 30);
		//BokStat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//BokStat.setForeground(Color.white);
		west.add(BokStat);

		Object[] status = { "Pending", "Booked" };
		CoStatus = new JComboBox(status);
		CoStatus.setBounds(150, 320, 200, 30);
		//CoStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//CoStatus.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(CoStatus);


		JButton insertbtn = new JButton("Confirm");
		insertbtn.setBounds(20, 400, 100, 40);
		insertbtn.setFocusable(false);
		insertbtn.setBackground(new Color(196, 195, 135));
		//insertbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		insertbtn.setForeground(Color.BLACK);
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
				int bookId = Integer.parseInt(bookingtxt.getText());
				String Gname = guesttxt.getText();
				String Status = CoStatus.getSelectedItem().toString();
				int roomNo = Integer.parseInt(roomidtxt.getText());

				JDBC jdbc = new JDBC();
				libBook lib = new libBook(checkin, checkout, Status, bookId, Gname, roomNo);
				boolean result = jdbc.saveBook(lib);

			}
		});
		
		JButton updatebtn = new JButton("Update");
		updatebtn.setBounds(140, 400, 100, 40);
		updatebtn.setFocusable(false);
		updatebtn.setBackground(new Color(196, 195, 135));
		//updatebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		updatebtn.setForeground(Color.BLACK);
		west.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {
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
				int bookId = Integer.parseInt(bookingtxt.getText());
				String Gname = guesttxt.getText();
				String Status = CoStatus.getSelectedItem().toString();

				int roomNo = Integer.parseInt(roomidtxt.getText());

				JDBC jdbc = new JDBC();
				libBook lib = new libBook(checkin, checkout, Status, bookId, Gname, roomNo);
				boolean result = jdbc.saveBook(lib);

			}
		});

		JButton clearbtn = new JButton("Delete");
		clearbtn.setBounds(260, 400, 100, 40);
		clearbtn.setFocusable(false);
		clearbtn.setBackground(new Color(106, 101, 101));
		//clearbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clearbtn.setForeground(Color.WHITE);
		west.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				int bookId = Integer.parseInt(bookingtxt.getText());
				JDBC jdbc = new JDBC();
				libBook lib = new libBook();
				lib.setUid(bookId);
				boolean result = jdbc.DeleteBookstaf(lib);
			}

		});
		
		JSeparator s22 = new JSeparator();
		s22.setBounds(0, 510, 640, 5);
		west.add(s22);

		JLabel lbllink1 = new JLabel("www.lutonhotel.com");
		lbllink1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbllink1.setForeground(Color.black);
		lbllink1.setBounds(140, 510, 200, 20);
		west.add(lbllink1);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Booking ID");
		model.addColumn("Customer ID");
		model.addColumn("Checkin date");
		model.addColumn("Checkout date");
		model.addColumn("Booking Status");
		model.addColumn("Room Preference");
		JTable tableRoom = new JTable(model);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSearch.setBounds(20, 20, 100, 23);
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFocusable(false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				JDBC jdbc = new JDBC();
				BookDataLib book = new BookDataLib();
				ArrayList search = jdbc.Bookdata(book);
				if (search.size() > 0) {
					for (int i = 0; i < search.size(); i++) {
						book = (BookDataLib) search.get(i);

						Object[] tmp = { book.getBookid(),book.getUid(), book.getCheckin_date(), book.getCheckout_date(), book.getBooking_status(),book.getPreference()};
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
		sroll.setBounds(20, 50, 800, 400);
		Center.add(sroll);

		
		Center.add(mes);
		Center.add(btnSearch);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Staffbook();
	}

}
