package com.foxamigo.pathlab.constants;

import java.util.HashMap;

public class PathologyConstants {

	public static HashMap<String, Integer> doctorToIdMap= new HashMap<String, Integer>();
	public static HashMap<String, Integer> testTypeToIdMap = new HashMap<String, Integer>();
	public static HashMap<String, Integer> testSubTypeToIdMap = new HashMap<String, Integer>();
	
	public static void setDoctorToIdMap(HashMap<String, Integer> map)
	{
		doctorToIdMap = map;
	}
	
	public static void setTestTypeToIdMap(HashMap<String, Integer> map)
	{
		testTypeToIdMap = map;
	}
	
	public static void setTestSubTypeToIdMap(HashMap<String, Integer> map)
	{
		testSubTypeToIdMap = map;
	}
}
