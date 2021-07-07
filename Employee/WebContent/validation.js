function validate() {
	if (!nameValidate() || !emailValidate() || !passwordValidate()
			|| !confirmPasswordValidate() || !contactValidate()
			|| !companyValidate()) {
		return false;
	}
	return true;
}

function nameValidate() {
	var regex = /^[a-zA-Z]{2,}$/;
	var first_name = document.signupform.first_name;
	var last_name = document.signupform.last_name;
	if (!regex.test(first_name.value)) {
		alert("First Name length should be of minimum 2 and should contain only alphabets");
		first_name.focus();
		return false;
	} else if (!regex.test(last_name.value)) {
		alert("Last Name length should be of minimum 2 and should contain only alphabets");
		last_name.focus();
		return false;
	}
	return true;
}

function emailValidate() {
	var regex = /^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/;
	if (!regex.test(document.signupform.email.value)) {
		alert("Invalid email Id");
		document.signupform.email.focus();
		return false;
	}
	return true;
}

function passwordValidate() {
	var password = document.signupform.password;
	var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,}$/;
	if (!regex.test(password.value)) {
		alert("Password should contain one upper case, one lower case, alpha numeric and minimum length should be 8");
		password.focus();
		return false;
	}
	return true;
}

function checkConfirmPassword() {
	var password = document.signupform.password.value;
	var confirmPassword = document.signupform.confirm_password.value;
	if (password != confirmPassword) {
		document.getElementById('checkpassword').innerHTML = "&#10006";
		document.getElementById('checkpassword').style.color = "red";
		document.getElementById('confirm_password').style.borderColor = "red";
	} else {
		document.getElementById('checkpassword').innerHTML = "&#10004;";
		document.getElementById('checkpassword').style.color = "green";
		document.getElementById('confirm_password').style.borderColor = "green";
	}
}

function clearConfirmPassword() {
	document.signupform.confirm_password.value = '';
}

function confirmPasswordValidate() {
	var password = document.signupform.password.value;
	var confirmPassword = document.signupform.confirm_password.value;
	if (password != confirmPassword) {
		alert("Password and Confirm Password doesn't match");
		return false;
	}
	return true;
}

function contactValidate() {
	var regex = /^[0-9]+$/;
	var contact_no = document.signupform.contact;
	if (contact_no.value.length <= 8 || contact_no.value.length > 12) {
		alert("Contact Number length should be minimum 8 and maximum 12");
		contact_no.focus();
		return false;
	} else if (!regex.test(contact_no.value)) {
		alert("Contact Number should contain only numberic value");
		contact_no.focus();
		return false;
	}
	return true;
}

function companyValidate() {
	if (document.signupform.company.value == "") {
		alert("Select Company");
		return false;
	}
	return true;
}