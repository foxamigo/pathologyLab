package com.foxamigo.pathlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.foxamigo.pathlab.constants.PathologyConstants;
import com.foxamigo.pathlab.dbutil.DbUtil;
import com.foxamigo.pathlab.vo.PatientVO;



public class PathologyDAO {
	public static void addPatientDetails(PatientVO patientVO) 
	{
		System.out.println("addPatientDetails(PatientVO patientVO) ");
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		String sqlCmd = "insert into patient_tbl(patient_code, patient_fname, " 
			+	"patient_mname, patient_lname, patient_age, patient_email, patient_phone, doctor_id, test_type_id, test_sub_type_id) values " 
			+	"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sqlCmd);
			ps.setString(++i, patientVO.getPatientCode());
			ps.setString(++i, patientVO.getPatientFname());
			ps.setString(++i, patientVO.getPatientMname());
			ps.setString(++i, patientVO.getPatientLname());
			ps.setInt(++i, patientVO.getPatientAge());
			ps.setString(++i, patientVO.getPatientEmail());
			ps.setString(++i, patientVO.getPatientPhone());
			ps.setLong(++i, patientVO.getDoctorId());
			ps.setLong(++i, patientVO.getTestType());
			ps.setLong(++i, patientVO.getTestSubType());
			
			boolean done = ps.execute();
			if(done)
			{
				JOptionPane.showMessageDialog(null, " \nSaving Successfully  \n");               
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " \n *** SQLException ***  \n " +e.getMessage() + "\n");
			e.printStackTrace();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, " \n *** Exception ***  \n " +e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
	
	public static void initDoctorToIdMap()
	{
		HashMap<String, Integer> doctorToIdMap= new HashMap<String, Integer>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		String sqlCmd = "select doctor_pid, doctor_fname, doctor_mname, doctor_lname from doctor_table where doctor_pid >0";
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sqlCmd);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int doctorId = rs.getInt(1);
				String fname = rs.getString(2);
				String mname = rs.getString(3);
				String lname = rs.getString(4);
				String name = fname + " "+mname+" "+lname;
				doctorToIdMap.put(name, doctorId);
			}
			System.out.println(doctorToIdMap);
			PathologyConstants.setDoctorToIdMap(doctorToIdMap);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " \n *** SQLException ***  \n " +e.getMessage() + "\n");
			e.printStackTrace();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, " \n *** Exception ***  \n " +e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
	
	public static void initTestTypeToIdMap()
	{
		HashMap<String, Integer> testTypeToIdMap= new HashMap<String, Integer>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		String sqlCmd = "SELECT test_type_pid, test_type_name FROM test_type_table where test_type_pid >0";
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sqlCmd);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int testTypeId = rs.getInt(1);
				String testTypeName = rs.getString(2);
				testTypeToIdMap.put(testTypeName, testTypeId);
			}
			System.out.println(testTypeToIdMap);
			PathologyConstants.setTestTypeToIdMap(testTypeToIdMap);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " \n *** SQLException ***  \n " +e.getMessage() + "\n");
			e.printStackTrace();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, " \n *** Exception ***  \n " +e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
	
	public static void initTestSubTypeToIdMap()
	{
		HashMap<String, Integer> testSubTypeToIdMap= new HashMap<String, Integer>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		String sqlCmd = "SELECT test_sub_type_pid, test_sub_type_name FROM test_type_table where test_sub_type_pid >0";
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sqlCmd);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int testTypeId = rs.getInt(1);
				String testTypeName = rs.getString(2);
				testSubTypeToIdMap.put(testTypeName, testTypeId);
			}
			System.out.println(testSubTypeToIdMap);
			PathologyConstants.setTestSubTypeToIdMap(testSubTypeToIdMap);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " \n *** SQLException ***  \n " +e.getMessage() + "\n");
			e.printStackTrace();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, " \n *** Exception ***  \n " +e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
}
