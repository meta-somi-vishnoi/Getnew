function validate() {
	if(validateFirstName() && validateLastName() && validateContactNumber ()){
		document.getElementById("signupForm").submit();
		return true;
	}
	return false;
}

function validateFirstName() {
	var letters = /[a-zA-Z]{2,}/;
	if(document.getElementById('firstname').value.match(letters) ) {
		return true;
	} else {
		alert('Please input firstname as alphabetic characters only and length greater than 2');
		console.log("lastname");
	    document.getElementById('firstname').focus();
		return false;
	}
}

function validateLastName() {
	var letters = /[a-zA-Z]{2,}/;
	if(	document.getElementById('lastname').value.match(letters) ) {
		return true;
	} else {
		alert('Please input last name as alphabetic characters only and length greater than 2');
		document.getElementById('lastname').focus();
		return false;
	}
}

function validateContactNumber() {
	var letters = /^[0-9]/;
	if(document.getElementById('contactNo').value.match(letters) && document.getElementById('contactNo').value.length>8 && document.getElementById('contactNo').value.length<=10) {
		return true;
	} else {
		alert('Please input contact number as numeric characters and length between 8 to 10');
		document.getElementById('contactNo').focus();
		return false;
	}
}

function validatePassword() {
    var strings = document.getElementById('password');
    var i=0;
    var countUpper=0,countLower=0;
    var character='';
    while (i <= strings.length){
        if(strings.charAtIsUpper(i)) {
            countUpper++;
        }
        if(strings.charAtIsLower(i)) {
            countLower++;
        }
        i++;
    }
	var letters = /^[0-9][A-Z][a-z]/;
    if(	document.getElementById('password').value.match(letters) && document.getElementById('password').value.length>=8 ) {
		return true;
	} else {
		alert('Please input password should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8');
		document.getElementById('password').focus();
		return false;
	}
}

function validateEmail() {
    if(	document.getElementById('email').indexOf('@')!=-1 && document.getElementById('email').indexOf('.')!=-1) {
		return true;
	} else {
		alert('Please input valid email id');
		document.getElementById('email').focus();
		return false;
	}
}