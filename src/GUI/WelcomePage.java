package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage extends JFrame implements ActionListener {
	JLabel lbltitle, lblcontact, lblcontact1;
	JButton btnsignup, btnsignin;

	public WelcomePage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Welcome Page");
		setSize(1600, 740); 
		setLocationRelativeTo(null);
		
		getContentPane().setBackground(new Color(255, 178, 102));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		getContentPane().setLayout(null);

		//inserting Image
		JLabel lblImage = new JLabel(""); 
		lblImage.setBounds(-10, 90, 1400, 545);
		lblImage.setIcon(new ImageIcon("2690549.jpg"));
		getContentPane();
		
		//declare and initializing
		lbltitle = new JLabel("Welcome To Luton Hotel");
		lbltitle.setBounds(379, 40, 600, 50); 
		lbltitle.setFont(new Font("Lucida Calligraphy", Font.BOLD, 38));

		lblcontact = new JLabel("Contact us :");
		lblcontact.setBounds(70, 640, 80, 20);
		lblcontact.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		lblcontact1 = new JLabel("lutonhotel99@gmail.com | 9887654321, 01-7654321");
		lblcontact1.setBounds(25, 660, 300, 20);
		lblcontact1.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		btnsignup = new JButton("Sign up");
		btnsignup.setBounds(1150, 30, 80, 30);
		btnsignup.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnsignup.setBackground(new Color(255,255,255));
		btnsignup.setForeground(Color.BLACK);
		btnsignup.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnsignup.addActionListener(this);
		
		btnsignin = new JButton("Sign in");
		btnsignin.setBounds(1250, 30, 80, 30);
		btnsignin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnsignin.setBackground(new Color(255,255,255));
		btnsignin.setForeground(Color.BLACK);
		btnsignin.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnsignin.addActionListener(this);
		
		btnsignup.setFocusable(false);
		btnsignin.setFocusable(false);
		setLayout(null);

		//add variables to JFrame
		add(lblImage);
		add(lbltitle);
		add(lblcontact);
		add(lblcontact1);
		add(btnsignup);
		add(btnsignin);

		setVisible(true);
		setResizable(false);

	}

	public static void main(String[] args) {
		new WelcomePage();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnsignup) {

			CustomerReg reg =new CustomerReg();
			reg.frame2.setVisible(true);
			this.dispose();
		}
		if (e.getSource() == btnsignin) {
			
			Login log =new Login();
			log.frame.setVisible(true);
			this.dispose();
			
		}

	}
}
