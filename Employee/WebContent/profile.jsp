<!doctype html>
<%@page import="com.models.UserDetails"%>
<html>
<head>
<title>My Profile</title>
<link rel="shortcut icon" href="images/html.png" />
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="fieldsEditable.js"></script>
</head>
<%
    UserDetails userDetails = (UserDetails) request
            .getAttribute("userDetails");
%>
<body align="center">
	<table align="right" width="62%">
		<tr>
			<td class="table-text">
				<%
				    out.print(userDetails.getFirstName() + " "
				            + userDetails.getLastName());
				%> <a href="FriendsList"
				style="color: green; text-decoration: none; padding-right: 30px; padding-left: 30px;" />
				Friends</a>
				<a href="Logout" style="color: green; text-decoration: none;">Logout</a>
			</td>
		</tr>
	</table>
	<hr width="60%">
	<h1 class="table-text">Profile</h1>
	<div>
		<div class="profile-table">
			<form action="UpdateDetails" method="post">
				<table align="center" cellspacing="10">
					<tr align="left">
						<td>First Name</td>
						<td><input type="text" name="first_name"
							value="<%out.print(userDetails.getFirstName());%>" readonly /></td>
					</tr>
					<tr align="left">
						<td>Last Name</td>
						<td><input type="text" name="last_name"
							value="<%out.print(userDetails.getLastName());%>" readonly /></td>
					</tr>
					<tr align="left">
						<td>Email</td>
						<td><input type="text" name="email"
							value="<%out.print(userDetails.getEmail());%>" readonly /></td>
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
					<tr align="left">
						<td>Company/Organization</td>
						<td><input type="text" name="organization"
							value="<%out.print(userDetails.getOrganization());%>" readonly>
						</td>
					</tr>
					<tr>
						<td align="left"><input type="button" name="edit"
							value="Edit" class="button" onclick="fieldsEditable()" /></td>
						<td align="left"><input type="submit" name="update"
							value="Update" class="button" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<img src="images/<%out.print(userDetails.getImage());%>"
				width="100px" style="padding-top: 50px; padding-bottom: 50px;" />
			<form action="UploadImage" method="post"
				enctype="multipart/form-data">
				<input type="file" name="image" class="table-text" /> <input
					type="submit" name="imageupload" class="table-text" />
			</form>
		</div>
	</div>
</body>
</html>