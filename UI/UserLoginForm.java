package UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Data.DatabaseManager;
import Data.TempUserRecord;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import logic.MainSystem;

import javax.swing.*;

public class UserLoginForm extends JFrame implements ActionListener  {

	JFrame frame;
	private JTextField txt_username;
	private JPasswordField pf_loginpassword;
	private JCheckBox cb_isContributor;
	private JButton btn_login;
	private JButton btn_register;
	MainSystem system = new MainSystem("Workout");
	DatabaseManager db;
	Register register;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginForm window = new UserLoginForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserLoginForm() {
		frame = new JFrame();
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txt_username.setToolTipText("Please enter your username");
		txt_username.setBounds(150, 127, 132, 20);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		cb_isContributor = new JCheckBox("Login as Contributor");
		cb_isContributor.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		cb_isContributor.setBounds(280, 160, 176, 23);
		frame.getContentPane().add(cb_isContributor);
		
		btn_login = new JButton("Login");
		btn_login.setFont(new Font("Felix Titling", Font.PLAIN, 11));
		btn_login.setBounds(150, 195, 89, 23);
		frame.getContentPane().add(btn_login);
		btn_login.addActionListener(this);
		
		JLabel lblNoAccount = new JLabel("No account?");
		lblNoAccount.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNoAccount.setBounds(248, 218, 66, 14);
		frame.getContentPane().add(lblNoAccount);
		
		btn_register = new JButton("Register");
		btn_register.setFont(new Font("Felix Titling", Font.PLAIN, 11));
		btn_register.setBounds(321, 214, 89, 23);
		frame.getContentPane().add(btn_register);
		btn_register.addActionListener(this);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_username.setBounds(66, 127, 74, 17);
		frame.getContentPane().add(lbl_username);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(66, 165, 66, 14);
		frame.getContentPane().add(lblPassword);
		
		pf_loginpassword = new JPasswordField();
		pf_loginpassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pf_loginpassword.setBounds(150, 164, 132, 20);
		frame.getContentPane().add(pf_loginpassword);
		
		JLabel lblBreakASweat = new JLabel("Break a Sweat");
		lblBreakASweat.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblBreakASweat.setBounds(136, 11, 166, 38);
		frame.getContentPane().add(lblBreakASweat);
	}

	public UserLoginForm getLoginForm(){
		return this;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == btn_login) {
			String username= txt_username.getText();
			String password = pf_loginpassword.getText();
			
			if(cb_isContributor.isSelected()){
				if(register!=null && register.registerredContributor()>3){		//make sure the register has opened before and the Contributor has been registered.
					if(register.verifyContReg(username, password)){
						MainMenuForm main = new MainMenuForm(this);
						main.setSize(800,500);
						main.setLocationRelativeTo(null);
						main.setVisible(true);
						frame.setVisible(false);
						txt_username.setText("");
						pf_loginpassword.setText("");
						
					}else{
						JOptionPane.showMessageDialog(frame, "Wrong ID or password"  ,"Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{				//straight login using existing contributor username
					if(system.isValidContributor(username, password)){
						MainMenuForm main = new MainMenuForm(this);
						main.setSize(800,500);
						main.setLocationRelativeTo(null);
						main.setVisible(true);
						frame.setVisible(false);
						txt_username.setText("");
						pf_loginpassword.setText("");
					}else{
						JOptionPane.showMessageDialog(frame, "Wrong ID or password"  ,"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}else{
				if(register!=null && register.registerredUser()>3){
					if(register.verifyUserReg(username, password)){
						MainMenuForm main = new MainMenuForm(this);
						main.setSize(800,500);
						main.setLocationRelativeTo(null);
						main.setVisible(true);
						frame.setVisible(false);
						txt_username.setText("");
						pf_loginpassword.setText("");
					}else{
					JOptionPane.showMessageDialog(frame, "Wrong ID or password"  ,"Error", JOptionPane.ERROR_MESSAGE);
					}
					register.viewAllUserRegistered();
				}else{
					if(system.isValidUser(username, password)){
						MainMenuForm main = new MainMenuForm(this);
						main.setSize(800,500);
						main.setLocationRelativeTo(null);
						main.setVisible(true);
						frame.setVisible(false);
						txt_username.setText("");
						pf_loginpassword.setText("");
					}else{
						JOptionPane.showMessageDialog(frame, "Wrong ID or password"  ,"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} else if (obj == btn_register) {
			try {
				register=new Register();
				register.frame.setLocationRelativeTo(null);
				register.frame.setVisible(true);
			} catch (Exception f) {
				f.printStackTrace();
			}
		}
	}
}
