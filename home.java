package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				home frame = new home();
				try {
					
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
	public home() {
		
		
        
		/*JLabel bg;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVoteNow = new JLabel("vote now");
		lblVoteNow.setForeground(Color.WHITE);
		lblVoteNow.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lblVoteNow);*/
		JPanel heading;
		heading=new JPanel();
		heading.setBounds(10, 40, 380, 274);
		heading.setForeground(Color.WHITE);
		heading.setBackground(new Color(76,169,115,50));
		heading.setLayout(null);
		JLabel name=new JLabel("voting");
		name.setBounds(140, 11, 93, 33);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		heading.add(name);
		
		setSize(432,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon im=new ImageIcon("C:\\Users\\user\\Desktop\\java programs\\Java\\swing\\src\\swing\\f.jpg"); 
        Image i=im.getImage();
        Image temp=i.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        im=new ImageIcon(temp);
       JLabel bg=new JLabel("",im,JLabel.CENTER);
       bg.setFont(new Font("Tahoma", Font.BOLD, 15));
       bg.setBounds(-140, -100, 700, 500);
        getContentPane().setLayout(null);
       getContentPane().add(heading);
        
        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.setBounds(262, 192, 93, 34);
        heading.add(btnNewButton);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		loginform l=new loginform();
        		l.setVisible(true);
        	}
        	
        });
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 15));
        btnNewButton.setBackground(Color.BLACK);
        
        
        
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBounds(169, 99, 139, 28);
		heading.add(btnRegister);
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup s=new signup();
				s.setVisible(true);
			}
		});
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblApplyForVoting = new JLabel("For voting ");
		lblApplyForVoting.setBounds(38, 100, 121, 28);
		lblApplyForVoting.setForeground(Color.WHITE);
		lblApplyForVoting.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		heading.add(lblApplyForVoting);
		
		JButton btnRegisterAsCandidate = new JButton("Apply as candidate");
		btnRegisterAsCandidate.setBounds(10, 187, 205, 45);
		btnRegisterAsCandidate.setForeground(Color.WHITE);
		btnRegisterAsCandidate.setBackground(Color.ORANGE);
		btnRegisterAsCandidate.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		heading.add(btnRegisterAsCandidate);
		
		 getContentPane().add(bg);//to add bg image u used
	        
	       setVisible(true); 
	}
}
