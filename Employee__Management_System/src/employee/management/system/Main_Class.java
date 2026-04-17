package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main_Class extends JFrame {
	Main_Class() {

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(0, 0, 1000, 600);
		add(img);

		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(280, 155, 400, 40);
		heading.setFont(new Font("Raleway", Font.BOLD, 25));
		
		img.add(heading);

		JButton add = new JButton("Add Employee");
		add.setBounds(280, 250, 150, 40);
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddEmployee();
				setVisible(false);

			}

		});

		img.add(add);

		JButton view = new JButton("View Employee");
		view.setBounds(500, 250, 150, 40);
		view.setForeground(Color.WHITE);
		view.setBackground(Color.BLACK);
		view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new View_Employee();
				setVisible(false);

			}

		});
		img.add(view);

		JButton rem = new JButton("Remove Employee");
		rem.setBounds(390, 350, 150, 40);
		rem.setForeground(Color.WHITE);
		rem.setBackground(Color.BLACK);
		rem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		img.add(rem);

		setSize(1000, 600);
		setLocation(150, 50);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main_Class();

	}
}
