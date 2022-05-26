package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ConLib.CorpLib;
import ConLib.CustomerLib;
import ConLib.JDBC;
import ConLib.LoginLibs;

public class CustomerReg {

	JLabel lbltitle1;
	JLabel lblCusty1;
	JComboBox cCusty1;
	JLabel lblNam1;
	JTextField txtNam1;
	JLabel lblGender1;
	JComboBox cGender1;
	JLabel lblAdd1;
	JTextField txtAdd1;
	JLabel lblUsername1;
	JTextField txtUsername1;
	JLabel lblCompany;
	JTextField txtCompany;
	JLabel lblEmail1;
	JTextField txtEmail1;
	JLabel lblDob1;
	JLabel lblNum1;
	JTextField txtNum1;
	JLabel lblPass1;
	JPasswordField txtPass1;
	JButton btnReg1;
	JButton btnBack1;
	JButton btnclear1;
	JFrame frame2;

	public CustomerReg() {
		frame2 = new JFrame();
		frame2.setSize(640, 450);
		frame2.getContentPane().setLayout(new BorderLayout());
		frame2.setLocationRelativeTo(null);
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 153, 102));

		lbltitle1 = new JLabel("Registration");
		lbltitle1.setBounds(240, 7, 309, 27);
		lbltitle1.setForeground(new Color(0, 0, 0));
		lbltitle1.setFont(new Font("Bauhaus 93", Font.PLAIN, 27));

		JSeparator s2 = new JSeparator();
		s2.setBounds(0, 33, 690, 10);
		pn2.add(s2);

		lblCusty1 = new JLabel("Customer Type : ");
		lblCusty1.setBounds(30, 50, 190, 30);

		String Custy1[] = { "Customer", "Corp-Customer" };
		cCusty1 = new JComboBox(Custy1);
		cCusty1.setBounds(150, 50, 150, 30);
		cCusty1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String type = cCusty1.getSelectedItem().toString();
				if (type.equals("Corp-Customer")) {
					lblCompany.setVisible(true);
					txtCompany.setVisible(true);
				} else if (type.equals("Customer")) {
					lblCompany.setVisible(false);
					txtCompany.setVisible(false);
				}

			}
		});

		lblNam1 = new JLabel("Full Name : ");
		lblNam1.setBounds(30, 90, 190, 30);

		txtNam1 = new JTextField();
		txtNam1.setBounds(150, 90, 150, 30);

		lblGender1 = new JLabel("Gender : ");
		lblGender1.setBounds(30, 130, 190, 30);

		String gender1[] = { "Male", "Female", "Others" };
		cGender1 = new JComboBox(gender1);
		cGender1.setBounds(150, 130, 150, 30);

		lblAdd1 = new JLabel("Address : ");
		lblAdd1.setBounds(30, 170, 190, 30);

		txtAdd1 = new JTextField();
		txtAdd1.setBounds(150, 170, 150, 30);

		lblUsername1 = new JLabel("Username : ");
		lblUsername1.setBounds(30, 210, 190, 30);

		txtUsername1 = new JTextField();
		txtUsername1.setBounds(150, 210, 150, 30);

		lblCompany = new JLabel("Company : ");
		lblCompany.setBounds(320, 50, 190, 30);
		lblCompany.setVisible(false);

		txtCompany = new JTextField();
		txtCompany.setBounds(440, 50, 150, 30);
		txtCompany.setVisible(false);

		lblEmail1 = new JLabel("Email : ");
		lblEmail1.setBounds(320, 90, 190, 30);

		txtEmail1 = new JTextField();
		txtEmail1.setBounds(440, 90, 150, 30);

		lblDob1 = new JLabel("Date of Birth : ");
		lblDob1.setBounds(320, 130, 190, 30);

		JDateChooser txtDob1 = new JDateChooser();
		txtDob1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txtDob1.setDateFormatString("yyyy-MM-dd");
		txtDob1.setBounds(440, 130, 150, 30);

		lblNum1 = new JLabel("Phone No : ");
		lblNum1.setBounds(320, 170, 190, 30);

		txtNum1 = new JTextField();
		txtNum1.setBounds(440, 170, 150, 30);

		lblPass1 = new JLabel("Password : ");
		lblPass1.setBounds(320, 210, 190, 30);

		txtPass1 = new JPasswordField();
		txtPass1.setBounds(440, 210, 150, 30);

		btnReg1 = new JButton("Register");
		btnReg1.setBounds(170, 310, 90, 40);
		btnReg1.setBackground(new Color(196, 195, 135));
		btnReg1.setForeground(Color.black);
		btnReg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				String name = txtNam1.getText();
				String address = txtAdd1.getText();
				String gender = cGender1.getSelectedItem().toString();
				String CustType = cCusty1.getSelectedItem().toString();
				String uname = txtUsername1.getText();
				String company = txtCompany.getText();
				String email = txtEmail1.getText();
				String dob = ((JTextField) txtDob1.getDateEditor().getUiComponent()).getText();

				try {
					Date date1 = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(dob);
				} catch (ParseException e1) {

				}
				int phone = Integer.parseInt(txtNum1.getText());
				String pass = txtPass1.getText();
				int id = phone / 3 + 1;

				if (CustType.equals("Customer")) {

					Pattern regexPattern = Pattern
							.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
					Matcher regMatcher = regexPattern.matcher(email);

					// if email pattern correct code will execute
					if (regMatcher.matches()) {
						if ((name.isEmpty() || address.isEmpty() || dob.isEmpty() || uname.isEmpty() || email.isEmpty()
								|| pass.isEmpty())) {

							JOptionPane.showMessageDialog(null, "Fill all the Fields");

						} else {
							 if (pass.length() <= 8) {
								JOptionPane.showMessageDialog(null, "password needs to be greater then 8 letters!");
							}else {
								// sending data to database
								JDBC jdbc = new JDBC();
								CustomerLib insert = new CustomerLib(id, name, dob, gender, email, address, phone,
										CustType);
								boolean result = jdbc.saveCust(insert);

								LoginLibs lib = new LoginLibs();
								lib.setUsername(uname);
								lib.setPassword(pass);
								lib.setId(id);
								lib.settype(CustType);
								boolean result1 = jdbc.logindata(lib) != null;
								frame2.dispose();
								Login log = new Login();
										log.frame.setVisible(true);

							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "email invaild");
					}
				} else if (CustType.equals("Corp-Customer")) {
					Pattern regexPattern = Pattern
							.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
					Matcher regMatcher = regexPattern.matcher(email);

					// if email pattern correct code will execute
					if (regMatcher.matches()) {
						if ((name.isEmpty() || address.isEmpty() || dob.isEmpty() || uname.isEmpty() || email.isEmpty()
								|| pass.isEmpty() || company.isEmpty())) {

							JOptionPane.showMessageDialog(null, "Fill all the Fields");

						} else {
							 if (pass.length() <= 8) {
								JOptionPane.showMessageDialog(null, "password needs to be greater then 8 letters!");
							}else {
								// sending data to database
								JDBC jdbc = new JDBC();
								CorpLib insert = new CorpLib(id, name, dob, gender, email, address, phone,company,CustType);
								boolean result = jdbc.save(insert);

								LoginLibs lib = new LoginLibs();
								lib.setUsername(uname);
								lib.setPassword(pass);
								lib.setId(id);
								lib.settype(CustType);
								boolean result1 = jdbc.logindata(lib) != null;
							
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "email invaild");
					}
				}

			}
			
		});

		btnBack1 = new JButton("Back");
		btnBack1.setBounds(270, 310, 90, 40);
		btnBack1.setBackground(new Color(196, 195, 135));
		btnBack1.setForeground(Color.black);
		btnBack1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ex) {
				new WelcomePage().setVisible(true);
				frame2.dispose();
			}

		});

		btnclear1 = new JButton("Clear");
		btnclear1.setBounds(370, 310, 90, 40);
		btnclear1.setFocusable(false);
		btnclear1.setBackground(new Color(106, 101, 101));
		btnclear1.setForeground(Color.white);
		btnclear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				txtNam1.setText(null);
				txtAdd1.setText(null);
				txtUsername1.setText(null);
				txtEmail1.setText(null);
				txtPass1.setText(null);
				txtNum1.setText(null);
				txtCompany.setText(null);
				txtDob1.setCalendar(null);
			}

		});

		JSeparator s22 = new JSeparator();
		s22.setBounds(0, 370, 640, 5);
		pn2.add(s22);

		JLabel lbllink1 = new JLabel("www.lutonhotel.com");
		lbllink1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbllink1.setForeground(Color.black);
		lbllink1.setBounds(240, 375, 200, 20);
		pn2.add(lbllink1);

		pn2.add(lbltitle1);
		pn2.add(lblCusty1);
		pn2.add(cCusty1);
		pn2.add(lblCompany);
		pn2.add(txtCompany);
		pn2.add(lblNam1);
		pn2.add(txtNam1);
		pn2.add(lblPass1);
		pn2.add(txtPass1);
		pn2.add(lblNum1);
		pn2.add(txtNum1);
		pn2.add(lblEmail1);
		pn2.add(txtEmail1);
		pn2.add(lblAdd1);
		pn2.add(txtAdd1);
		pn2.add(lblDob1);
		pn2.add(txtDob1);
		pn2.add(lblGender1);
		pn2.add(cGender1);
		pn2.add(lblUsername1);
		pn2.add(txtUsername1);
		pn2.add(btnBack1);
		pn2.add(btnReg1);
		pn2.add(btnclear1);
		pn2.setLayout(null);
		frame2.getContentPane().add(pn2, BorderLayout.CENTER);
		frame2.setVisible(true);
	}

	public static void main(String[] args) {
		new CustomerReg();

	}

}
