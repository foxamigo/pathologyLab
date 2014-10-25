package com.foxamigo.pathlab.modules.doctor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DebugGraphics;

import com.foxamigo.pathlab.modules.doctor.bean.DoctorBean;
import com.foxamigo.pathlab.util.ValidationUtils;

public class AddDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtMName;
	private JTextField txtLName;
	private JTextField txtAdd;
	private JTextField txtAge;
	private JTextField txtHospital;
	private JTextField txtQualification;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		launchApplication();
		}
	public static void launchApplication(){

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDoctor frame = new AddDoctor();
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
	public AddDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(29, 36, 65, 14);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setToolTipText("Enter your first Name");
		txtFirstName.setBounds(153, 33, 146, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(29, 67, 87, 14);
		contentPane.add(lblMiddleName);
		
		txtMName = new JTextField();
		txtMName.setToolTipText("Enter your middle name");
		txtMName.setBounds(153, 64, 146, 20);
		contentPane.add(txtMName);
		txtMName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(29, 103, 65, 14);
		contentPane.add(lblLastName);
		
		txtLName = new JTextField();
		txtLName.setToolTipText("Enter your last name");
		txtLName.setBounds(153, 95, 146, 20);
		contentPane.add(txtLName);
		txtLName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
		lblAddress.setBounds(29, 128, 65, 14);
		contentPane.add(lblAddress);
		
		txtAdd = new JTextField();
		txtAdd.setToolTipText("Enter your work address");
		txtAdd.setBounds(153, 125, 146, 20);
		contentPane.add(txtAdd);
		txtAdd.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(29, 196, 46, 14);
		contentPane.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setToolTipText("Enter your age");
		txtAge.setBounds(153, 193, 146, 20);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblHospital = new JLabel("Hospital Name:");
		lblHospital.setToolTipText("Enter your hospital name");
		lblHospital.setBounds(29, 230, 87, 14);
		contentPane.add(lblHospital);
		
		JLabel lblQualification = new JLabel("Qualification:");
		lblQualification.setBounds(29, 269, 87, 14);
		contentPane.add(lblQualification);
		
		txtHospital = new JTextField();
		txtHospital.setToolTipText("Enter hospital name");
		txtHospital.setBounds(153, 227, 146, 20);
		contentPane.add(txtHospital);
		txtHospital.setColumns(10);
		
		txtQualification = new JTextField();
		txtQualification.setToolTipText("Enter your qualification");
		txtQualification.setBounds(153, 266, 146, 20);
		contentPane.add(txtQualification);
		txtQualification.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("SAVE BUTTON");
				insertDoc();
			}
		});
		btnSave.setBounds(59, 297, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("RESET BUTTON");
				reset();
			}
		});
		btnReset.setBounds(188, 297, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("Enter your Email Address");
		lblEmail.setBounds(29, 168, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(153, 165, 146, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
	}
	public void reset(){
		txtFirstName.setText("");
		txtMName.setText("");
		txtLName.setText("");
		txtAge.setText("");
		txtHospital.setText("");
		txtAdd.setText("");
		txtQualification.setText("");
		txtEmail.setText("");
	}
	public void insertDoc(){
		DoctorBean objBean = new DoctorBean();
		objBean.setfName(txtFirstName.getText());
		objBean.setmName(txtMName.getText());
		objBean.setlName(txtLName.getText());
		String age = txtAge.getText();
		age = age.equalsIgnoreCase("")?"0":age;
		objBean.setAge(Integer.parseInt(age));
		objBean.setAddress(txtAdd.getText());
		objBean.setEmail(txtEmail.getText());
		if(validateFields(objBean)){
			//true: all fields are entered correctly
			//we can proceed insertion in DB
		}else{
			//this block refers that some of the field is not 
			//mention correctly. We should not proceed further 
		}
		System.out.println("Doctor Name \n"+objBean.getfName()+" "+objBean.getmName()+" "+objBean.getlName());
	}
	
	public boolean validateFields(DoctorBean objBean){
		if(ValidationUtils.isEmpty(objBean.getfName())){
			showMsg(objBean.getfName());
			return false;
		}if(ValidationUtils.isEmpty(objBean.getlName())){
			showMsg(objBean.getlName());
			return false;
		}if(0==objBean.getAge()){
			showMsg(Integer.toString(objBean.getAge()));
			return false;
		}if(ValidationUtils.isEmpty(objBean.getEmail())){
			showMsg(objBean.getEmail());
			return false;
		}
		return true;
	}
	
	public String showMsg(String text){
		JOptionPane.showMessageDialog(contentPane, "Please mention your "+text);
		return "";
	}
	
}
