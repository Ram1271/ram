package DBOperation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Studentregistrationform {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentregistrationform window = new Studentregistrationform();
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
	public Studentregistrationform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registratin Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(162, 35, 304, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lb1 = new JLabel("Rollno");
		lb1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb1.setBounds(178, 120, 81, 29);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Name");
		lb2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb2.setBounds(178, 184, 61, 29);
		frame.getContentPane().add(lb2);
		
		JLabel lb3 = new JLabel("Branch");
		lb3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb3.setBounds(178, 250, 77, 22);
		frame.getContentPane().add(lb3);
		
		JLabel lb4 = new JLabel("Marks");
		lb4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb4.setBounds(178, 314, 68, 22);
		frame.getContentPane().add(lb4);
		
		
		tf1 = new JTextField();
		tf1.setBounds(315, 128, 96, 19);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(315, 192, 96, 19);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CSE", "ECE", "EEE", "IT", "IOT", "DS"}));
		cb1.setBounds(315, 250, 96, 21);
		frame.getContentPane().add(cb1);
		
		tf3 = new JTextField();
		tf3.setBounds(315, 319, 96, 19);
		frame.getContentPane().add(tf3);
		tf3.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll=tf1.getText();
				String name=tf2.getText();
				String branch=(String)cb1.getSelectedItem();
				String marks=tf3.getText();
				int m=Integer.parseInt(marks);
				int r=Integer.parseInt(roll);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mysql");
					String q="insert into student values('"+r+"','"+name+"','"+branch+"','"+m+"')";
		            Statement stn=con.createStatement();
		            stn.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Successfuly Inserted");
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(287, 388, 104, 29);
		frame.getContentPane().add(btnNewButton);
		
	}

}
