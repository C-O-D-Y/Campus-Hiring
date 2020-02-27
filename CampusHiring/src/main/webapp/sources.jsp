<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.campushiring.services.*"%>
<%
	Sources db = new Sources();

	String query = request.getParameter("q");

	List<String> empNames = db.getSourcesEmpName(query);

	Iterator<String> iterator = empNames.iterator();
	while (iterator.hasNext()) {
		String empName = (String) iterator.next();
		out.println(empName);
	}
%>