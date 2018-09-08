<!doctype html>
<%@page import="java.util.List"%>
<%@page import="com.models.UserDetails"%>
<html>
<head>
<title>Friends</title>
<link rel="shortcut icon" href="images/html.png" />
<link rel="stylesheet" href="style.css">
</head>
<%
    List<UserDetails> userDetailsList = (List<UserDetails>) request
            .getAttribute("userDetailsList");
%>
<body align="center">
	<table align="right" width="62%" class="header">
		<tr>
			<td class="table-text"><a href="ProfileEdit" />Home</a> <a
				href="Logout">Logout</a></td>
		</tr>
	</table>
	<hr width="60%">
	<div class="table-text">
		<h1>Friends</h1>
		<table align="center" cellspacing="10">
			<%
			    for (UserDetails user : userDetailsList) {
			%>
			<tr>
				<td>
					<form id="myform" method="post" action="FriendProfile">
						<input type="hidden" name="email"
							value="<%out.print(user.getEmail());%>" />
							 <a onclick="document.getElementById('myform').submit();"
								style="text-decoration: underline; cursor: pointer;">
								 <%
    								out.print(user.getFirstName() + " " + user.getLastName());
								 %>
							</a>
					</form>
				</td>
			</tr>
			<%
			    }
			%>
		</table>
	</div>
</body>
</html>