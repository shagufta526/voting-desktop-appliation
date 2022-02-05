package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		
		con=db.dbConnect();
		JPanel heading=new JPanel();
		heading.setBounds(0, 0, 419, 537);
		heading.setForeground(Color.WHITE);
		heading.setBackground(new Color(76,169,115,50));
		
		setSize(435,526);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon im=new ImageIcon("C:\\Users\\user\\Desktop\\java programs\\Java\\swing\\src\\swing\\h.jpg"); 
        Image i=im.getImage();
        Image temp=i.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        im=new ImageIcon(temp);
        getContentPane().setLayout(null);
       getContentPane().add(heading);
		heading.setLayout(null);
       
		
		
		JLabel lblSignUp = new JLabel(" sign up");
		lblSignUp.setBackground(Color.DARK_GRAY);
		lblSignUp.setBounds(142, 11, 104, 43);
		lblSignUp.setForeground(Color.GREEN);
		lblSignUp.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		heading.add(lblSignUp);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(44, 91, 82, 24);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		heading.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(136, 94, 143, 24);
		heading.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastname = new JLabel("LASTNAME");
		lblLastname.setForeground(Color.WHITE);
		lblLastname.setBounds(21, 142, 117, 24);
		lblLastname.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		heading.add(lblLastname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 145, 137, 24);
		heading.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFatherName = new JLabel("FATHER NAME");
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setBounds(21, 177, 115, 24);
		lblFatherName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		heading.add(lblFatherName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 180, 137, 24);
		heading.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setForeground(Color.WHITE);
		lblState.setBounds(22, 263, 73, 24);
		lblState.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		heading.add(lblState);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(22, 298, 104, 24);
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		heading.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 302, 134, 24);
		heading.add(passwordField);
		
		JLabel lblPincode = new JLabel("PINCODE");
		lblPincode.setForeground(Color.WHITE);
		lblPincode.setBounds(21, 354, 94, 24);
		lblPincode.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		heading.add(lblPincode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 354, 137, 27);
		heading.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAdharno = new JLabel("ADHARNO.");
		lblAdharno.setForeground(Color.WHITE);
		lblAdharno.setBounds(25, 402, 101, 20);
		lblAdharno.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		heading.add(lblAdharno);
		
		textField_4 = new JTextField();
		textField_4.setBounds(142, 402, 179, 20);
		heading.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.BLACK);
		btnSave.setBounds(261, 439, 89, 23);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				String name=textField.getText();
				String lname=textField_1.getText();
				String faname=textField_2.getText();
				String age=textField_5.getText();
				String pass=String.copyValueOf(passwordField.getPassword());
				String pin=textField_3.getText();
				String an=textField_4.getText();
				//encrypt en=new encrypt();
				//en.init();
	            
	            //String encryptpass = en.encrypt(pass);
	       //   String decryptedMessage = en.decrypt(encryptedMessage);
			if(Integer.parseInt(age)>=18)	
			{	PreparedStatement pst=con.prepareStatement("insert into signup (name,lname,fname,age,pword,pincode,adharno) value(?,?,?,?,?,?,?)");
				pst.setString(1,name);
				pst.setString(2, lname);
				pst.setString(3,faname);
				pst.setString(4, age);
				pst.setString(5, pass);
				pst.setString(6, pin);
				pst.setString(7, an);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"saved");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_5.setText("");
				passwordField.setText("");
				textField_3.setText("");
				textField_4.setText("");
				

			}
			else {
				JOptionPane.showMessageDialog(null,"age must be above or equal to 18");	
			}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
			setVisible(false);
		}});
		btnSave.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		heading.add(btnSave);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(40, 212, 86, 28);
		lblAge.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		heading.add(lblAge);
		
		textField_5 = new JTextField();
		textField_5.setBounds(142, 218, 104, 24);
		heading.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 264, 137, 24);
		comboBox.addItem("AP");
		comboBox.addItem("AR");
		comboBox.addItem("AS");
		comboBox.addItem("BR");
		comboBox.addItem("Goa");
		comboBox.addItem("HR");
		comboBox.addItem("HP");
		comboBox.addItem("JK");
		comboBox.addItem("Jharkhand");
		comboBox.addItem("Karnatka");
		comboBox.addItem("Kerela");
		comboBox.addItem("MP");
		comboBox.addItem("maharastra");
		comboBox.addItem("manipur");
		comboBox.addItem("meghalaya");
		comboBox.addItem("Mizoram");
		comboBox.addItem("Nagaland");
		comboBox.addItem("Odisha");
		comboBox.addItem("Punjab");
		comboBox.addItem("rajasthan");
		comboBox.addItem("sikkim");
		comboBox.addItem("tamil nadu");
		comboBox.addItem("telangana");
		comboBox.addItem("tripura");
		comboBox.addItem("uttar pradesh");
		comboBox.addItem("uttrakhand");
		comboBox.addItem("west bengal");
		heading.add(comboBox);
		JLabel bg=new JLabel("",im,JLabel.CENTER);
		bg.setBounds(-218, -76, 700, 567);
		heading.add(bg);
		bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		setVisible(true);
	}
}
