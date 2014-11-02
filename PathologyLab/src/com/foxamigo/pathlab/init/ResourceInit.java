package com.foxamigo.pathlab.init;

import com.foxamigo.pathlab.dao.PathologyDAO;

public class ResourceInit {
	public ResourceInit()
	{
		initDoctorToIdMap();
		initTestTypeToIdMap();
		initTestSubTypeToIdMap();
	}

	private void initTestSubTypeToIdMap() {
		PathologyDAO.initTestSubTypeToIdMap();
	}

	private void initTestTypeToIdMap() {
		initTestTypeToIdMap();
	}

	private void initDoctorToIdMap() {
		initTestSubTypeToIdMap();
	}
	
}
