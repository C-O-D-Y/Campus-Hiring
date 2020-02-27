//package com.campushiring.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class DeleteOperations {
//
//	@Autowired
//	DatabaseConnection db;
//
//	@RequestMapping("/deleteEmployeeByName")
//
//	public ModelAndView deleteEmployeeByName(@RequestParam String ename) {
//
//		ModelAndView mv = null;
//		try {
//
//			mv = new ModelAndView("deleteEmployee.jsp");
//
//			List<Questions> deletedEmployeeDetails = db.findByEname(ename);
//			System.out.println(deletedEmployeeDetails.size());
//			List<Questions> updatedEmployeeDetails = null;
//
//			mv.addObject("employee", deletedEmployeeDetails);
//			if (deletedEmployeeDetails.size() == 0)
//				return new ModelAndView("Default.jsp");
//			for (int i = 0; i < deletedEmployeeDetails.size(); i++) {
//
//				int empId = deletedEmployeeDetails.get(i).getEid();
//
//				System.out.println("deleted employee id is: " + empId);
//				db.deleteById(empId);
//				updatedEmployeeDetails = db.findAll();
//				mv.addObject("employeeList", updatedEmployeeDetails);
//			}
//			return mv;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ModelAndView("Default.jsp");
//		}
//	}
//
//	@RequestMapping("/deleteEmployeeByTech")
//	public ModelAndView deleteEmployeeByTech(@RequestParam String tech) {
//
//		ModelAndView mv = null;
//		try {
//
//			mv = new ModelAndView("deleteEmployee.jsp");
//
//			List<Questions> deletedEmployeeDetails = db.findByTech(tech);
//			System.out.println(deletedEmployeeDetails.size());
//			List<Questions> updatedEmployeeDetails = null;
//
//			mv.addObject("employee", deletedEmployeeDetails);
//			if (deletedEmployeeDetails.size() == 0)
//				return new ModelAndView("Default.jsp");
//			for (int i = 0; i < deletedEmployeeDetails.size(); i++) {
//
//				int empId = deletedEmployeeDetails.get(i).getEid();
//
//				System.out.println("deleted employee id is: " + empId);
//				db.deleteById(empId);
//				updatedEmployeeDetails = db.findAll();
//				mv.addObject("employeeList", updatedEmployeeDetails);
//			}
//			return mv;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ModelAndView("Default.jsp");
//		}
//	}
//
//	@RequestMapping("/deleteEmployee")
//	public ModelAndView deleteEmployee(@RequestParam int eid) {
//
//		ModelAndView mv = null;
//		try {
//			System.out.println(eid);
//			mv = new ModelAndView("deleteEmployeeWithId.jsp");
//			boolean isEmployeeExists = db.existsById(eid);
//
//			List<Questions> updatedEmployeeDetails = null;
//
//			if (isEmployeeExists == true) {
//				Questions deletedEmployeeDetails = db.findById(eid).orElse(new Questions());
//
//				mv.addObject("employee", deletedEmployeeDetails);
//				db.deleteById(eid);
//				updatedEmployeeDetails = db.findAll();
//				mv.addObject("employeeList", updatedEmployeeDetails);
//				return mv;
//			} else {
//				return new ModelAndView("Default.jsp");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ModelAndView("Default.jsp");
//		}
//
//	}
//
//}
