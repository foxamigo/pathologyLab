package com.foxamigo.pathlab.modules.patient;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Action;

import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import org.jdesktop.swingx.JXDatePicker;

import com.foxamigo.pathlab.constants.PathologyConstants;
import com.foxamigo.pathlab.dao.PathologyDAO;
import com.foxamigo.pathlab.dbutil.DbUtil;
import com.foxamigo.pathlab.init.ResourceInit;
import com.foxamigo.pathlab.vo.PatientVO;


import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PatientPatho extends JFrame implements ActionListener, WindowListener{

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField middleNamefield;
	private JTextField lastNameField;
	private JTextField ageField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField refDoctorField;
	private final Action action = new NextButtonAction();
	private JComboBox testTypeComboBox;
	private JComboBox testSubTypeComboBox;
	private JDatePickerImpl picker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientPatho frame = new PatientPatho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public PatientPatho() throws ClassNotFoundException, SQLException {
		//new ResourceInit();
		//new DbUtil();
		System.out.println("sahiiii 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		System.out.println("sahiiii 2");
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel patientPane = new JPanel(); 
		System.out.println("sahiiii 3");
		tabbedPane.addTab("New tab", null, patientPane, null);
		patientPane.setLayout(null);
		
		/*JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		System.out.println("sahiiii 4");
		*/
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(22, 67, 60, 14);
		patientPane.add(firstNameLabel);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(109, 64, 168, 20);
		//firstNameField.addKeyListener(this);
		patientPane.add(firstNameField);
		firstNameField.setColumns(10);
		
		JLabel middleNameLabel = new JLabel("Middle Name");
		middleNameLabel.setBounds(22, 101, 60, 14);
		patientPane.add(middleNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(22, 133, 60, 14);
		patientPane.add(lastNameLabel);
		
		middleNamefield = new JTextField();
		middleNamefield.setColumns(10);
		middleNamefield.setBounds(109, 95, 168, 20);
		patientPane.add(middleNamefield);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(109, 127, 168, 20);
		patientPane.add(lastNameField);
		
		JLabel dobLabel = new JLabel("DOB");
		dobLabel.setBounds(22, 168, 46, 14);
		patientPane.add(dobLabel);
		
		/*JComboBox dayComboBox = new JComboBox();
		dayComboBox.setBounds(109, 165, 28, 20);
		contentPane.add(dayComboBox);
		
		JComboBox monthComboBox = new JComboBox();
		monthComboBox.setBounds(153, 165, 28, 20);
		contentPane.add(monthComboBox);
		
		JComboBox yearComboBox = new JComboBox();
		yearComboBox.setBounds(202, 165, 28, 20);
		contentPane.add(yearComboBox);*/
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanelImpl = new JDatePanelImpl(model);
		picker = new JDatePickerImpl(datePanelImpl);
        picker.setBounds(109, 165, 150, 20);
		patientPane.add(picker);
		picker.addActionListener(this);
		
        /*picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        picker.setBounds(109, 165, 100, 20);
        contentPane.add(picker);
        picker.addActionListener(this);
		*/
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setBounds(22, 205, 46, 14);
		patientPane.add(ageLabel);
		
		ageField = new JTextField();
		ageField.setBounds(109, 202, 86, 20);
		patientPane.add(ageField);
		ageField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(22, 240, 46, 14);
		patientPane.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setBounds(109, 237, 86, 20);
		patientPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setBounds(22, 273, 46, 14);
		patientPane.add(phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setBounds(109, 270, 86, 20);
		patientPane.add(phoneField);
		phoneField.setColumns(10);
		
		JLabel refDoctorLabel = new JLabel("Ref Doctor");
		refDoctorLabel.setBounds(22, 307, 60, 14);
		patientPane.add(refDoctorLabel);
		
		refDoctorField = new JTextField();
		refDoctorField.setBounds(109, 304, 86, 20);
		//populateDoctorCombo();
		patientPane.add(refDoctorField);
		refDoctorField.setColumns(10);
		
		JLabel testTypeLabel = new JLabel("Test Type");
		testTypeLabel.setBounds(22, 348, 60, 14);
		patientPane.add(testTypeLabel);
		
		testTypeComboBox = new JComboBox();
		testTypeComboBox.setBounds(109, 345, 86, 20);
		testTypeComboBox.addItem("Haemotology");
		testTypeComboBox.addItem("Geology");
		testTypeComboBox.addItem("Kimology");
		patientPane.add(testTypeComboBox);
		
		JLabel testSubTypeLabel = new JLabel("Test Sub-Type");
		testSubTypeLabel.setBounds(22, 389, 70, 14);
		patientPane.add(testSubTypeLabel);
		
		testSubTypeComboBox = new JComboBox();
		testSubTypeComboBox.setBounds(109, 386, 86, 20);
		patientPane.add(testSubTypeComboBox);
		
		PatientVO patientVO = null;
		
		System.out.println("first name ="+firstNameField.getText());
		System.out.println("middle name ="+middleNamefield.getText());
		System.out.println("last name ="+lastNameField.getText());
		JButton btnNext = new JButton("Next");
		btnNext.setAction(action);
		btnNext.setBounds(268, 458, 105, 23);
		patientPane.add(btnNext);
	}
	private void populateDoctorCombo() {
		Set mapSet = (Set) PathologyConstants.doctorToIdMap.entrySet();
		Iterator mapIterator = mapSet.iterator();
        while (mapIterator.hasNext()) 
        {
        Map.Entry mapEntry = (Map.Entry) mapIterator.next();
        String keyValue = (String) mapEntry.getKey();
        //refDoctor
        }
	}
	private class NextButtonAction extends AbstractAction {
		private PatientVO patientVO;
		public NextButtonAction() {
			putValue(NAME, "Next");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			POPULATE_PATIENT_VO:
			{
				patientVO = new PatientVO();
				patientVO.setPatientFname(firstNameField.getText().trim());
				patientVO.setPatientMname(middleNamefield.getText().trim());
				patientVO.setPatientLname(lastNameField.getText().trim());
				
				//getting age of patient
				//Date dob = picker.getDate();
				
				patientVO.setPatientAge(Integer.parseInt(ageField.getText().equalsIgnoreCase("")?"0":ageField.getText().trim()));
				patientVO.setPatientEmail(emailField.getText().trim());
				patientVO.setPatientPhone(phoneField.getText().trim());
				//patientVO.setDoctorId(Long.parseLong(refDoctorField.getText().equalsIgnoreCase("")?"0":refDoctorField.getText().trim()));
				patientVO.setDoctorId(1);
				patientVO.setPatientCode("1234");
				//patientVO.setTestType(Integer.parseInt((testTypeComboBox.getItemAt(testTypeComboBox.getSelectedIndex())).toString()));
				//patientVO.setTestSubType(Integer.parseInt((testSubTypeComboBox.getItemAt(testSubTypeComboBox.getSelectedIndex())).toString()));
				patientVO.setTestType(1);
				patientVO.setTestSubType(1);
				PathologyDAO.addPatientDetails(patientVO);
			}
			System.out.println("sahiii beeee");
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Calendar dobDate = Calendar.getInstance();
		dobDate.setTime((Date)picker.getModel().getValue());
		Calendar today = Calendar.getInstance();
		int curYear = today.get(Calendar.YEAR);
		int curMonth = today.get(Calendar.MONTH);
		int curDay = today.get(Calendar.DAY_OF_MONTH);

		int year = dobDate.get(Calendar.YEAR);
		int month = dobDate.get(Calendar.MONTH);
		int day = dobDate.get(Calendar.DAY_OF_MONTH);

		int age = curYear - year;
		if (curMonth < month || (month == curMonth && curDay < day)) {
		    age--;
		}
		ageField.setText(age+"");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		try {
			DbUtil.close();
			System.exit(0);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
