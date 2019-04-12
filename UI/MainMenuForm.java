package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextArea;

import Data.DatabaseManager;
import logic.MainSystem;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuForm extends JFrame implements ActionListener {
	DatabaseManager db = new DatabaseManager();
	private MainSystem system = new MainSystem("Break A Sweat");
	JButton btn_purchase;
	JButton btn_logout;
	JButton btn_myprogram;
	JButton btn_music;
	JButton btn_bmi;
	JButton btn_workout;
	UserLoginForm userlogin;

	/**
	 * Create the application.
	 */
	public MainMenuForm(UserLoginForm login) {
		this.userlogin=login;
		Container pane = getContentPane();
		
		JLabel lbl_features = new JLabel("Welcome");
		lbl_features.setFont(new Font("Stencil", Font.BOLD, 12));
		lbl_features.setBounds(10, 63, 114, 32);
		pane.add(lbl_features);

		btn_bmi = new JButton("BMI");
		btn_bmi.setFont(new Font("Stencil", Font.BOLD, 18));
		btn_bmi.setBounds(5, 106, 89, 38);
		pane.add(btn_bmi);
		btn_bmi.addActionListener(this);
		
		btn_purchase = new JButton("Purchase");
		btn_purchase.setFont(new Font("Stencil", Font.BOLD, 18));
		btn_purchase.setBounds(5, 166, 137, 38);
		pane.add(btn_purchase);
		btn_purchase.addActionListener(this);

		btn_music = new JButton("Music");
		btn_music.setFont(new Font("Stencil", Font.BOLD, 18));
		btn_music.setBounds(5, 226, 114, 38);
		pane.add(btn_music);
		btn_music.addActionListener(this);

		btn_myprogram = new JButton("My Programs");
		btn_myprogram.setFont(new Font("Stencil", Font.BOLD, 18));
		btn_myprogram.setBounds(5, 286, 175, 38);
		pane.add(btn_myprogram);
		btn_myprogram.addActionListener(this);
		
		btn_workout = new JButton("Workout");
		btn_workout.setFont(new Font("Stencil", Font.BOLD, 18));
		btn_workout.setBounds(5, 346, 175, 38);
		pane.add(btn_workout);
		btn_workout.addActionListener(this);
		
		btn_logout = new JButton("Logout");
		btn_logout.addActionListener(this);
		btn_logout.setBackground(Color.LIGHT_GRAY);
		btn_logout.setForeground(Color.BLACK);
		btn_logout.setFont(new Font("Stencil", Font.BOLD, 18));
		btn_logout.setBounds(5, 406, 114, 38);
		pane.add(btn_logout);

		
		JLabel lbl_mainmenu = new JLabel("Main Menu");
		lbl_mainmenu.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		lbl_mainmenu.setBounds(343, 11, 114, 32);
		pane.add(lbl_mainmenu);

		JLabel lbl_tips = new JLabel("Tips of the day");
		lbl_tips.setFont(new Font("Stencil", Font.BOLD, 20));
		lbl_tips.setBounds(521, 63, 175, 14);
		pane.add(lbl_tips);

		JTextArea ta_first = new JTextArea();
		ta_first.setEditable(false);
		ta_first.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ta_first.setText(
				"Grow Muscle, Save Time\r\nKeep your weight workouts under an hour. \r\nAfter 1 hour, your body starts producing \r\nmore of the stress hormone cortisol, \r\nwhich can have a testosterone-blocking, \r\nmuscle-wasting effect.");
		ta_first.setBounds(521, 88, 253, 152);
		pane.add(ta_first);

		JTextArea ta_second = new JTextArea();
		ta_second.setEditable(false);
		ta_second.setText(
				"Exercise in Order\r\nUse dumbbells, barbells, and machines\r\n\u2014in that order. \"The smaller, stabilizer \r\nmuscles you use with dumbbells fatigue \r\nbefore your larger muscle groups,\" \r\nsays Charles Staley, a strength coach in \r\nLas Vegas. So progress to machines, which \r\nrequire less help from your smaller muscles,\r\nas you grow tired.");
		ta_second.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ta_second.setBounds(521, 257, 253, 193);
		pane.add(ta_second);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\1.png"));
		lblNewLabel.setBounds(204, 47, 292, 193);
		pane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\2.jpg"));
		lblNewLabel_1.setBounds(202, 240, 294, 210);
		pane.add(lblNewLabel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn_purchase) {
			this.setVisible(false);
			new PurchaseProgram(this, system);
			

		} else if (obj == btn_logout) {
			this.dispose();
			try {
				userlogin.getLoginForm();
				userlogin.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (obj == btn_music){
			this.setVisible(false);
			Music music = new Music();
			music.frame.setSize(1110, 623);
			music.frame.setLocationRelativeTo(null);
			music.frame.setVisible(true);
			
		} else if (obj == btn_myprogram){
			this.setVisible(false);
			MyPrograms mprog = new MyPrograms();
			mprog.frame.setSize(1104, 743);
			mprog.frame.setLocationRelativeTo(null);
			mprog.frame.setVisible(true);
			
		} else if (obj == btn_bmi){
			this.setVisible(false);
			BMICalculatorInputData bmi = new BMICalculatorInputData();
			bmi.setSize(400, 400);
			bmi.setLocationRelativeTo(null);
			bmi.setVisible(true);
			
		} else if (obj == btn_workout){
			this.setVisible(false);
			Workout wk = new Workout();
			wk.frame.setSize(1110, 623);
			wk.frame.setLocationRelativeTo(null);
			wk.frame.setVisible(true);
		}
	}
}
