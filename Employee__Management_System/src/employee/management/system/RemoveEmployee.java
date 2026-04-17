package employee.management.system;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;

public class RemoveEmployee extends JFrame {

	Choice choiceEMPID;

	JButton delete, back;

	RemoveEmployee() {

		JLabel label = new JLabel("Employee ID");
		label.setBounds(50, 50, 100, 30);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(label);

		choiceEMPID = new Choice();
		choiceEMPID.setBounds(200, 50, 150, 30);
		add(choiceEMPID);

		try {
			conn c = new conn();
			ResultSet resultSet = c.statement.executeQuery("select * from employee");
			while (resultSet.next()) {
				choiceEMPID.add(resultSet.getString("empId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel labelName = new JLabel("Name");
		labelName.setBounds(50, 100, 100, 30);
		labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(labelName);

		JLabel textName = new JLabel();
		textName.setBounds(200, 100, 100, 30);
		add(textName);

		JLabel labelPhone = new JLabel("Phone");
		labelPhone.setBounds(50, 150, 100, 30);
		labelPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(labelPhone);

		JLabel textPhone = new JLabel();
		textPhone.setBounds(200, 150, 100, 30);
		add(textPhone);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(50, 200, 100, 30);
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(labelEmail);

		JLabel textEmail = new JLabel();
		textEmail.setBounds(200, 200, 100, 30);
		add(textEmail);

		try {
			conn c = new conn();
			ResultSet resultSet = c.statement
					.executeQuery("select * from employee where empId = '" + choiceEMPID.getSelectedItem() + "'");
			while (resultSet.next()) {
				textName.setText(resultSet.getString("name"));
				textPhone.setText(resultSet.getString("phone"));
				textEmail.setText(resultSet.getString("email"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		choiceEMPID.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					conn c = new conn();
					ResultSet resultSet = c.statement.executeQuery(
							"select * from employee where empId = '" + choiceEMPID.getSelectedItem() + "'");
					while (resultSet.next()) {
						textName.setText(resultSet.getString("name"));
						textPhone.setText(resultSet.getString("phone"));
						textEmail.setText(resultSet.getString("email"));

					}

				} catch (Exception E) {
					E.printStackTrace();
				}

			}

		});

		delete = new JButton("Delete");
		delete.setBounds(80, 300, 100, 30);
		delete.setBackground(Color.black);
		delete.setForeground(Color.WHITE);
		add(delete);
		
		back = new JButton("Back");
		back.setBounds(220, 300, 100, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/delete.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(600,80,200,200);
		add(img);

		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Icons/rback.png"));
		Image i22 = i11.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
		ImageIcon i33 = new ImageIcon(i22);
		JLabel imgage = new JLabel(i33);
		imgage.setBounds(0,100,900,400);
		add(imgage);

		setSize(900, 400);
		setLocation(250, 150);
		setLayout(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		new RemoveEmployee();

	}

}
