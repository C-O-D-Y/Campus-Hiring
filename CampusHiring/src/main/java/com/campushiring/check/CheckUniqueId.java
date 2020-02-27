//package com.campushiring.check;
//
//import com.campushiring.services.DatabaseConnection;
//
///*
// * This class is used to check that Id is unique or not
// * */
//public class CheckUniqueId {
//
//	/*
//	 * In this Method, printing message if entered Id is unique or not, If it is not
//	 * unique it will not enter the values of the data
//	 */
//	public static boolean checkid(DatabaseConnection db, int id) {
//		boolean isIdPresent = false;
//		try {
//
//			isIdPresent = db.findById(id).isPresent();
//		} catch (Exception e) {
//
//		}
//		return isIdPresent;
//
//	}
//}
