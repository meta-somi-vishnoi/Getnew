function validate() {
	if (!nameValidate() || !emailValidate() || !ageValidate()) {
		return false;
	}
	return true;
}
 function nameValidate() {
	var regex = /^[a-zA-Z]{2,}$/;
	var firstName = document.addDetailsForm.firstName;
	var lastName = document.addDetailsForm.lastName;
	if (!regex.test(firstName.value)) {
		alert("First Name length should be of minimum 2 and should contain only alphabets");
		firstName.focus();
		return false;
	} else if (!regex.test(lastName.value)) {
		alert("Last Name length should be of minimum 2 and should contain only alphabets");
		lastName.focus();
		return false;
	}
	return true;
}
 function emailValidate() {
	var regex = /^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/;
	if (!regex.test(document.addDetailsForm.email.value)) {
		alert("Invalid email Id");
		document.addDetailsForm.email.focus();
		return false;
	}
	return true;
}
 function ageValidate() {
	if (document.addDetailsForm.age.value < 1) {
		alert("Age Should be greater than zero:");
		document.addDetailsForm.age.focus();
		return false;
	}
	return true;
} 