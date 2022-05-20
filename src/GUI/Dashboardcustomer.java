package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboardcustomer extends JFrame {

	public Dashboardcustomer() {

		new JFrame();
		setTitle("Dashboard");
		setSize(1600, 740);

		// inserting image
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 50, 1600, 610);
		lblImage.setIcon(new ImageIcon("myhq-workspaces-Becc3eg9-l0-unsplash(1).jpg"));
		getContentPane();

		// declare and initialize variables
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 178, 102));
		panel_1.setBounds(-20, 0, 1700, 50);
		getContentPane();
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 178, 102));
		panel_2.setBounds(-20, 650, 1700, 50);
		getContentPane();
		panel_2.setLayout(null);

		JButton btnbook = new JButton("Booking");
		btnbook.setBounds(10, 140, 95, 40);
		btnbook.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnbook.setBackground(new Color(255, 178, 102));
		btnbook.setForeground(Color.BLACK);
		btnbook.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				new bookRequest().setVisible(true);
			}
		});

		JButton btnser = new JButton("Services");
		btnser.setBounds(10, 240, 95, 40);
		btnser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnser.setBackground(new Color(255, 178, 102));
		btnser.setForeground(Color.BLACK);
		btnser.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				ServicesReq service1 = new ServicesReq();
				service1.frame.setVisible(true);
			}
		});

		JButton btnmenu = new JButton("Menu");
		btnmenu.setBounds(10, 340, 95, 40);
		btnmenu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnmenu.setBackground(new Color(255, 178, 102));
		btnmenu.setForeground(Color.BLACK);
		btnmenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				MenuReq menu1 = new MenuReq();
				menu1.frame.setVisible(true);
			}
		});

		JButton btnbill = new JButton("Bill");
		btnbill.setBounds(10, 440, 95, 40);
		btnbill.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnbill.setBackground(new Color(255, 178, 102));
		btnbill.setForeground(Color.BLACK);
		btnbill.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnbill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				billReceipt Bill = new billReceipt();
				Bill.frame.setVisible(true);
			}
		});

		JButton btnlogout = new JButton("Log Out");
		btnlogout.setBounds(10, 540, 95, 40);
		btnlogout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnlogout.setBackground(new Color(255, 178, 102));
		btnlogout.setForeground(Color.BLACK);
		btnlogout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				
				 dispose();
				 new WelcomePage().setVisible(true);
			}
		});

		JLabel lbl1 = new JLabel("Hotel Online Booking And Management System");
		lbl1.setBounds(370, 15, 700, 45);
		lbl1.setFont(new Font("Constantia", Font.BOLD, 30));

		btnser.setFocusable(false);
		btnmenu.setFocusable(false);
		btnbook.setFocusable(false);
		btnbill.setFocusable(false);
		//btnroom.setFocusable(false);
		btnlogout.setFocusable(false);

		// add variables to JFrame
		add(lbl1);
		add(btnmenu);
		add(btnser);
		add(btnbook);
		//add(btnroom);
		add(btnbill);
		add(btnlogout);
		add(panel_1);
		add(panel_2);
		add(lblImage);

		setLayout(null);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Dashboardcustomer();
	}

}