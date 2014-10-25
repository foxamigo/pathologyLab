package com.foxamigo.pathology.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.foxamigo.pathology.dbutil.DbUtil;
import com.foxamigo.pathology.exception.PathologyDAOException;
import com.foxamigo.pathology.vo.BaseVO;
import com.foxamigo.pathology.vo.PatientVO;

public class PathologyDAO {
	public void addPatientDetails(PatientVO patientVO) 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		String sqlCmd = "insert into patient_tbl(patient_id, patient_addl_id, patient_fname, " 
			+	"patient_mname, patient_lname, patient_age, patient_email, patient_phone, doctor_id values " 
			+	"(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sqlCmd);
			ps.setLong(++i, patientVO.getPatientId());
			ps.setString(++i, patientVO.getPatientAddlId());
			ps.setString(++i, patientVO.getPatientFname());
			ps.setString(++i, patientVO.getPatientMname());
			ps.setString(++i, patientVO.getPatientLname());
			ps.setInt(++i, patientVO.getPatientAge());
			ps.setString(++i, patientVO.getPatientEmail());
			ps.setString(++i, patientVO.getPatientPhone());
			ps.setLong(++i, patientVO.getDoctorId());
			
			boolean done = ps.execute();
			if(done)
			{
				JOptionPane.showMessageDialog(null, " \nSaving Successfully  \n");               
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " \n *** SQLException ***  \n " +e.getMessage() + "\n");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, " \n *** Exception ***  \n " +e.getMessage() + "\n");
		}
	}
}
