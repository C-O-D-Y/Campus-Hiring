//package com.campushiring.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class FetchingOperations {
//
//	@Autowired
//	DatabaseConnection db;
//
//	@RequestMapping(path="/getEmployee")
//	@ResponseBody
//	public ModelAndView fetchEmployee(@RequestParam int eid) {
//		try {
//			Questions employeeList = db.findById(eid).orElse(new Questions());
//			if (employeeList.getEid() != 0) {
//				ModelAndView mv = new ModelAndView("ShowEmployee.jsp");
//				mv.addObject("employee", employeeList);
//				return mv;
//
//			} else {
//				ModelAndView mv = new ModelAndView("Default.jsp");
//				return mv;
//			}
//		} catch (Exception e) {
//			return new ModelAndView("Default.jsp");
//		}
//	}
//
//	@RequestMapping("/getEmployeeByName")
//	@ResponseBody
//	public ModelAndView fetchEmployeeByName(@RequestParam String ename) {
//		try {
//			List<Questions> employeeList = db.findByEname(ename);
//			if (employeeList.get(0).getEname() != null) {
//				System.out.println("Got the Employee");
//
//				ModelAndView mv = new ModelAndView("showMultipleEmployee.jsp");
//				mv.addObject("employeeList", employeeList);
//				return mv;
//
//			} else {
//				ModelAndView mv = new ModelAndView("Default.jsp");
//				return mv;
//			}
//		} catch (Exception e) {
//			return new ModelAndView("Default.jsp");
//		}
//
////		ModelAndView mv = new ModelAndView("ShowEmployee.jsp");
//	}
//
//	@RequestMapping("/fetchAll")
//	@ResponseBody
//	public ModelAndView fetchAll() {
//		try {
//			List<Questions> employeeList = db.findAll();
//			if (employeeList.get(0).getEname() != null) {
//				System.out.println("Got the Employee");
//				ModelAndView mv = new ModelAndView("showMultipleEmployee.jsp");
//				mv.addObject("employeeList", employeeList);
//				return mv;
//
//			} else {
//				ModelAndView mv = new ModelAndView("Default.jsp");
//				return mv;
//			}
//		} catch (Exception e) {
//			return new ModelAndView("Default.jsp");
//		}
//	}
//
//	@RequestMapping("/getEmployeeByTech")
//	@ResponseBody
//	public ModelAndView fetchEmployeeByTech(@RequestParam String tech) {
//		try {
//			List<Questions> employeeList = db.findByTech(tech);
//			if (employeeList.get(0).getTech() != null) {
//				System.out.println("Got the Employee");
//				ModelAndView mv = new ModelAndView("showMultipleEmployee.jsp");
//				mv.addObject("employeeList", employeeList);
//				return mv;
//
//			} else {
//				ModelAndView mv = new ModelAndView("Default.jsp");
//				return mv;
//			}
////		ModelAndView mv = new ModelAndView("ShowEmployee.jsp");
//		} catch (Exception e) {
//			return new ModelAndView("Default.jsp");
//		}
//	}
//}
