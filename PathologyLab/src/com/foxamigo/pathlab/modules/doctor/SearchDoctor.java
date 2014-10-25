package com.foxamigo.pathlab.modules.doctor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearchDoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDoctor frame = new SearchDoctor();
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
	@SuppressWarnings("deprecation")
	public SearchDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorName = new JLabel("Doctor Name:");
		lblDoctorName.setBounds(63, 64, 84, 14);
		contentPane.add(lblDoctorName);
		
		JLabel lblSearchDoctor = new JLabel("Search Doctor");
		lblSearchDoctor.setBounds(176, 25, 94, 14);
		contentPane.add(lblSearchDoctor);
		
		txtSearchDoc = new JTextField();
		txtSearchDoc.setToolTipText("Enter Doctor name to search");
		txtSearchDoc.setBounds(192, 61, 173, 20);
		contentPane.add(txtSearchDoc);
		txtSearchDoc.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("Add".equalsIgnoreCase(((JButton)e.getSource()).getActionCommand())){
					AddDoctor.launchApplication();
				}
				if("Search".equalsIgnoreCase(((JButton)e.getSource()).getActionCommand())
						&&
					!search(e)){
					((JButton)e.getSource()).setText("Add");
				}
				
			}
		});
		btnSearch.setBounds(145, 107, 89, 23);
		contentPane.add(btnSearch);
		
		
	}

	public Boolean search(ActionEvent e){
	//if the required doctor not found in our DB it will return false
	//which will enable add button to add new entry for the same doctor
		String docName = txtSearchDoc.getText();
		return false;
	}
}
