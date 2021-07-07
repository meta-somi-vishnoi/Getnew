function validate() {
	if(validateFirstName() && validateLastName() && validateContactNumber() && validateStrength() && validateEmail()){
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
		alert('Please input valid contact number');
		document.getElementById('contactNo').focus();
		return false;
	}
}

function validateStrength() {
    var strings = document.getElementById('password').value;
    var i=0;
    var countUpper=0,countLower=0;
    var character='';
    while (i < strings.length){
        if(strings[i].match(/[a-zA-Z]/)) {
            if(strings[i]===strings[i].toUpperCase()) {
                countUpper++;
            }
            if(strings[i]===strings[i].toLowerCase()) {
                countLower++;
            }
        }
        i++;
    }
    var letters = /^[0-9A-Za-z]/;
    if(letters.test(document.getElementById('password').value) && document.getElementById('password').value.length>=8 && countLower>=1 && countUpper>=1) {
        document.getElementById('strength').innerHTML = "NormalPassword";
        document.getElementById('strength').style.color = "Blue";
        return true;
    }
    else if(/^\S/.test(document.getElementById('password').value) && document.getElementById('password').value.length>=8 && countLower>=1 && countUpper>=1) {
        document.getElementById('strength').innerHTML = "StrongPassword";
        document.getElementById('strength').style.color = "green";
        return true;
    } else {
        document.getElementById('strength').innerHTML = "WeakPassword.";
        document.getElementById('strength').style.color = "red";
        alert('Please input password should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8');
        return false;
    } 
}

function validateConfirmPassword() {
    if(document.getElementById('confirmPassword').value!=document.getElementById('password').value) {
        document.getElementById('checkMark').innerHTML = "&#10006";
        document.getElementById('checkMark').style.color = "red";
        document.getElementById('confirmPassword').focus();
    } else {
        document.getElementById('checkMark').innerHTML = "&#10004";
        document.getElementById('checkMark').style.color = "green";
    }
}

function validateEmail() {
    var regex = /^\w+([\.-]?\w+)*@[a-zA-Z0-9]+(\.[a-zA-Z]{2,3})+$/;
    if(document.getElementById('email').value.match(regex)) {
        return true;
    }
    else {
        alert('Please input valid email id');
		document.getElementById('email').focus();
		return false;
    }
}
