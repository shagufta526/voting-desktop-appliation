package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.JComboBox;

public class loginform extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginform frame = new loginform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con=null;
	public loginform() {
		con=db.dbConnect();

		JPanel heading;
		heading=new JPanel();
		heading.setBounds(10, 40, 396, 288);
		heading.setForeground(Color.WHITE);
		heading.setBackground(new Color(255,255,255,80));
		heading.setLayout(null);
		
		setSize(432,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon im=new ImageIcon("C:\\Users\\user\\Desktop\\java programs\\Java\\swing\\src\\swing\\s.jpg"); 
        Image i=im.getImage();
        Image temp=i.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        im=new ImageIcon(temp);
       JLabel bg=new JLabel("",im,JLabel.CENTER);
       bg.setFont(new Font("Tahoma", Font.BOLD, 15));
       bg.setBounds(-140, -100, 700, 500);
        getContentPane().setLayout(null);
       getContentPane().add(heading);
       
		
		
		JLabel lblLoginForm = new JLabel("LOGIN FORM");
		lblLoginForm.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setBounds(125, 0, 169, 65);
		heading.add(lblLoginForm);
		
		JLabel lblAdharno = new JLabel("ADHARNO.");
		lblAdharno.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAdharno.setForeground(Color.WHITE);
		lblAdharno.setBounds(33, 89, 113, 24);
		heading.add(lblAdharno);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(171, 89, 150, 24);
		heading.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setBounds(33, 155, 113, 24);
		heading.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.ORANGE);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(171, 157, 150, 24);
		heading.add(passwordField);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					encrypt de= new encrypt();
				    String adn=textField.getText();	
				    String pass1=String.copyValueOf(passwordField.getPassword());
				    PreparedStatement pst=con.prepareStatement("select * from signup where adharno=? and pword=?");
				    pst.setString(1, adn);
				    de.init();
				    //String enc_pswd = de.encrypt(pass1);
				    System.out.println("*************** " + pass1);
				    pst.setString(2, pass1);
				    ResultSet r=pst.executeQuery();	
		   PreparedStatement ps=con.prepareStatement("select times from signup where adharno=? and pword=?");
		    ps.setString(1, adn);
		    ps.setString(2, pass1);
				    ResultSet ti=ps.executeQuery();	
				    
				    if(ti.next()) {
	                 int f=ti.getInt("times");
	                 System.out.println(f);
				    	if(r.next() && f==0)
				    	{
				    		String msg=adn;
				    votingpage vp=new votingpage();
				    vp.myupdates(msg);
				    	vp.setVisible(true);
				    	
				         }
				    
			    	else
			    		{
				    	JOptionPane.showMessageDialog(null," already voted");
                          }
			   
				    
				}}
				catch(Exception e1) {
					e1.printStackTrace();
			    	JOptionPane.showMessageDialog(null,"you are not valid voter");

				}
			
	     
				setVisible(false);
				
			}});
		btnLogin.setForeground(Color.GRAY);
		btnLogin.setBackground(Color.YELLOW);
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 18));
		btnLogin.setBounds(125, 216, 89, 31);
		heading.add(btnLogin);
		getContentPane().add(bg);
	}
}
