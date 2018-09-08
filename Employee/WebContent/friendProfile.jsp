<!doctype html>
<%@page import="com.models.UserDetails"%>
<html>
<head>
<title>My Profile</title>
<link rel="shortcut icon" href="images/html.png" />
<link rel="stylesheet" href="style.css">
</head>
<%
    UserDetails userDetails = (UserDetails)request.getAttribute("userDetails");
%>
<body align="center">
	<table align="right" width="62%" class="header">
		<tr>
			<td class="table-text">
				 <a href="ProfileEdit" />Home</a>
				<a href="Logout" >Logout</a>
			</td>
		</tr>
	</table>
	<hr width="55%">
	<div class="table-text">
		<h1>Profile</h1>
		<table align="center" cellspacing="10">
			<tr align="left">
				<td>Name</td>
				<td>
					<%
					    out.print(userDetails.getFirstName() + " " + userDetails.getLastName());
					%>
				</td>
			</tr>
			<tr align="left">
				<td>Email</td>
				<td>
					<%
					    out.print(userDetails.getEmail());
					%>
				</td>
			</tr>
			<tr align="left">
				<td>Date of Birth</td>
				<td><input type="date" name="dob"
					value="<%out.print(userDetails.getDob());%>" readonly /></td>
			</tr>
			<tr align="left">
				<td width="30">Contact Number</td>
				<td><input type="number" name="contact_no"
					value="<%out.print(userDetails.getContactNo());%>" readonly></td>
			</tr>
		</table>
	</div>
</body>
</html>