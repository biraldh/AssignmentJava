package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class staffcreateaccount {
	JFrame frame;
	
	public staffcreateaccount() {
		frame = new JFrame();
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color (255, 178, 102));
		
		JSeparator s1 = new JSeparator();
		s1.setBounds(0,20,500,5);
		frame.add(s1);
		
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(0,180,500,5);
		frame.add(s2);
		
		JLabel lblcreate = new JLabel("Click here to register.");
		lblcreate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblcreate.setForeground(Color.BLACK);
		lblcreate.setBounds(50, 40, 300, 30);
		frame.add(lblcreate);
		
		JButton btncreate = new JButton("register");
		btncreate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncreate.setForeground(Color.BLACK);
		btncreate.setBounds(115, 80, 150, 30);
		btncreate.setBackground(new Color(255,255,255));
		btncreate.setFocusable(false);
		frame.add(btncreate);
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				stafreg register = new stafreg();
				register.frame1.setVisible(true);
			}});
		JLabel lbllogin = new JLabel("Click here to log in if you already have an account.");
		lbllogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbllogin.setForeground(Color.BLACK);
		lbllogin.setBounds(50, 130, 310, 30);
		frame.add(lbllogin);
		lbllogin.addMouseListener(new MouseAdapter() {
		      @Override
		      public void mouseClicked(MouseEvent e) {
		        Login log = new Login();
		        log.frame.setVisible(true);
		      }
		    });
		
		JLabel lbllink = new JLabel("www.lutonhotel.com");
		lbllink.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbllink.setForeground(Color.BLACK);
		lbllink.setBounds(120, 185, 200, 20);
		frame.add(lbllink);
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new staffcreateaccount();
	}

}