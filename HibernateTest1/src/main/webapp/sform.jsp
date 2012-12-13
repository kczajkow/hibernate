<%@ page import="org.czajkowski.Customer" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Using Post Method in JSP Form.</title>
</head>

<body>
	<form method="post" action="<%=request.getContextPath()%>/DigestServlet">
		<input type="text" size="20" name="txtName" />
		<input type="submit" name="B1" value="Submit" />
		<input type="reset" name="B2" value="Reset" />
	</form>
	<%
		if(request.getParameter("txtName") != null){
			if(request.getParameter("txtName").equals(""))
				out.println("<html><font color=red>Please enter your name.</font></html>");
			else
				out.println("Your username is: " + request.getParameter("txtName"));
		}
	%>
</body>
</html>