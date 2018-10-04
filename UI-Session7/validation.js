	var errorMap = new Map();

	window.onload=function(){
		var form = document.getElementById('contact_details_form');
		document.getElementById('first_name').addEventListener('focusout', checkFirstName);
		document.getElementById('last_name').addEventListener('focusout', checkLastName);
		document.getElementById('email').addEventListener('focusout', checkEmail);
		document.getElementById('contact').addEventListener('focusout', checkPhone);
		document.getElementById('city').addEventListener('focusout', checkCity);
		document.getElementById('state').addEventListener('change', changeState);
		var zipcode =  document.getElementById("zipcode_container");
		var description =  document.getElementById("description_container");
		if (window.addEventListener ) { 
			form.addEventListener('submit', checkFormDetails);
		}
	}

	function checkFormDetails(event){
		checkFirstName(event);
		checkLastName(event);
		checkEmail(event);
		checkPhone(event);
		checkCity(event);
		var form = document.getElementById('contact_details_form');
		var zipcode =  document.getElementById("zipcode_container");
		var description =  document.getElementById("description_container");
		if(form.contains(zipcode)) {
			checkZipcode(event);
		}
		if(form.contains(description)) {
			checkDescription(event);
		}
		var message = "";
		if(errorMap.size > 0){
			var allkeys = errorMap.keys();
			for(var key of allkeys) {
				message += key + " , Description: " + errorMap.get(key) + "\n";
			}
			alert(message);
		} else { 
			localStorage.clear();
			for(var i=0;i<document.getElementById("contact_details_form").elements.length;i++){
				if(document.getElementById("contact_details_form").elements[i].value.length !=0){
					localStorage.setItem(document.getElementById("contact_details_form").elements[i].name,document.getElementById("contact_details_form").elements[i].value);
				}
			}
		}
	}

	function changeState(event){
		var selection = document.getElementById('state').value;
		var form = document.getElementById("contact_details_form");
		var hosting =  document.getElementById("hosting_container");
		var zipcode =  document.getElementById("zipcode_container");
		var description =  document.getElementById("description_container");
		var domain =  document.getElementById("domain_container");
		if(form.contains(hosting)) {
			form.removeChild(hosting);
		}
		if(form.contains(zipcode)) {
			form.removeChild(zipcode);
		}
		if(form.contains(description)) {
			form.removeChild(description);
		}
		if(form.contains(domain)) {
			form.removeChild(domain);
		}
		switch(selection)
		{
			case "Rajasthan":
				domainAppend();
				projectDescriptionAppend();
				break;
			case "Haryana":
				zipcodeAppend();
				hostingAppend();
				break;
			case "Maharashtra":
				zipcodeAppend();
				projectDescriptionAppend();
				break;
		}
		if(form.contains(document.getElementById("zipcode_container"))) {
			document.getElementById('zip_code').addEventListener('focusout', checkZipcode);
		}
		if(form.contains(description)) {
			document.getElementById('project_description').addEventListener('focusout', checkDescription);
		}
	}

	function domainAppend() {
		var form = document.getElementById('contact_details_form');
		var submitButton  = document.getElementById('submit_button_container');
		var div = document.createElement('div');
		div.setAttribute('class', 'detail_container');
		div.setAttribute('id', 'domain_container');
		var inner_div = document.createElement('div');
		inner_div.setAttribute('class', 'detail_label');
		div.appendChild(inner_div);
		var label = document.createElement('label');
		label.setAttribute('class', 'label_name');
		label.innerHTML = "Website or domain name";
		inner_div.appendChild(label);
		var inner_div_body = document.createElement('div');
		inner_div_body.setAttribute('class', 'user_information');
		div.appendChild(inner_div_body);
		var domain= document.createElement('input');
		domain.setAttribute('type', 'text');
		domain.setAttribute('name', 'domain-name');
		domain.setAttribute('placeholder', 'Website or domain name');
		domain.setAttribute('id', 'domain_name');
		var fontAwesome = document.createElement('i');
		fontAwesome.className = "fas fa-globe-americas";
		inner_div_body.append(fontAwesome);
		inner_div_body.appendChild(domain);
		form.insertBefore(div, submitButton);
	}

	function zipcodeAppend() {
		var form = document.getElementById('contact_details_form');
		var submitButton  = document.getElementById('submit_button_container');
		var div = document.createElement('div');
		div.setAttribute('class', 'detail_container');
		div.setAttribute('id', 'zipcode_container');
		var inner_div = document.createElement('div');
		inner_div.setAttribute('class', 'detail_label');
		div.appendChild(inner_div);
		var label = document.createElement('label');
		label.setAttribute('class', 'label_name');
		label.innerHTML = "Zip Code";
		inner_div.appendChild(label);
		var inner_div_body = document.createElement('div');
		inner_div_body.setAttribute('class', 'user_information');
		div.appendChild(inner_div_body);
		var domain= document.createElement('input');
		domain.setAttribute('type', 'text');
		domain.setAttribute('name', 'zip-code');
		domain.setAttribute('placeholder', 'zip Code');
		domain.setAttribute('id', 'zip_code');
		var fontAwesome = document.createElement('i');
		fontAwesome.className = "fas fa-home";
		inner_div_body.append(fontAwesome);
		inner_div_body.appendChild(domain);
		form.insertBefore(div, submitButton);
	}

	function projectDescriptionAppend() {
		var form = document.getElementById('contact_details_form');
		var submitButton  = document.getElementById('submit_button_container');
		var div = document.createElement('div');
		div.setAttribute('class', 'detail_container');
		div.setAttribute('id', 'description_container');
		var inner_div = document.createElement('div');
		inner_div.setAttribute('class', 'detail_label');
		div.appendChild(inner_div);
		var label = document.createElement('label');
		label.setAttribute('class', 'label_name');
		label.innerHTML = "Project Description";
		inner_div.appendChild(label);
		var inner_div_body = document.createElement('div');
		inner_div_body.setAttribute('class', 'user_information');
		div.appendChild(inner_div_body);
		var fontAwesome = document.createElement('i');
		fontAwesome.className = "fas fa-pen";
		var textarea= document.createElement('textarea');
		textarea.setAttribute('placeholder', 'Project Description');
		textarea.setAttribute('name','project-description');
		textarea.setAttribute('id', 'project_description');
		inner_div_body.append(fontAwesome);
		inner_div_body.appendChild(textarea);
		form.insertBefore(div, submitButton);
	}

	function hostingAppend() {
		var form = document.getElementById('contact_details_form');
		var submitButton  = document.getElementById('submit_button_container');
		var div = document.createElement('div');
		div.setAttribute('class', 'detail_container');
		div.setAttribute('id', 'hosting_container');
		var inner_div = document.createElement('div');
		inner_div.setAttribute('class', 'detail_label');
		div.appendChild(inner_div);
		var label = document.createElement('label');
		label.setAttribute('class', 'label_name');
		label.innerHTML = "Do you have hosting?";
		inner_div.appendChild(label);
		var inner_div_body = document.createElement('div');
		inner_div_body.setAttribute('id', 'hosting_options');
		div.appendChild(inner_div_body);
		var yes = document.createTextNode("Yes");
		var no = document.createTextNode("No");
		var inputyes = document.createElement("input");
		inputyes.type = "radio";
		inputyes.name = "radioBtn";
		inputyes.id = "radio_yes";
		inputyes.value = "Yes";
		var inputno = document.createElement("input");
		inputno.type = "radio";
		inputno.name = "radioBtn";
		inputno.id = "radio_no";
		inputno.value = "No";
		inner_div_body.appendChild(inputyes);
		inner_div_body.appendChild(yes);
		inner_div_body.appendChild(inputno);
		inner_div_body.appendChild(no);
		form.insertBefore(div, submitButton);
	}


	var checkFirstName = function (event) {
		var firstName;
		firstName = document.getElementById('first_name');
		if(firstName.value == ""){
			firstName.style.borderColor = "red";
			errorMap.set("FirstName", "It is required");
			event.preventDefault();
		}else if (!(/^[a-zA-Z]{2,}$/.test(firstName.value))) {
			errorMap.set("FirstName", "It require atleast two alphabets");
			firstName.style.borderColor = "red";
			event.preventDefault();
		}else{
			firstName.style.borderColor = "green";
			deleteMapEntry("FirstName");
		}
	};

	var checkLastName = function (event) {
		var lastName;
		lastName = document.getElementById('last_name');
		if (!(/^[a-zA-Z]{2,}$/.test(lastName.value))) {
			lastName.style.borderColor = "red";
			errorMap.set("LastName", "It is required");
			event.preventDefault();
		}else{
			lastName.style.borderColor = "green";
			deleteMapEntry("LastName");
		}
	};


	function checkEmail(event){
		var email = document.getElementById('email');
		if(email.value == ""){
			email.style.borderColor = "red";
			errorMap.set("Email", "It is required");
			event.preventDefault();
		}else if(!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(email.value))){
			email.style.borderColor = "red";
			errorMap.set("Email", "It is invalid email");
			event.preventDefault();
		}else{
			email.style.borderColor = "green";
			deleteMapEntry("Email");
		}
	}

	function checkPhone(event){
		var phone = document.getElementById('contact');
		if(phone.value == ""){
			phone.style.borderColor = "red";
			errorMap.set("Contact", "It is required");
			event.preventDefault();
		}else if(!(/^[0-9]{8,12}$/.test(phone.value))){
			phone.style.borderColor = "red";
			errorMap.set("Contact", "It rquires numbers between length 10 to 12");
			event.preventDefault();
		}else{
			phone.style.borderColor = "green";
			deleteMapEntry("Contact");
		}
	}

	function checkCity(event){
		var city = document.getElementById('city');
		if(city.value == ""){
			city.style.borderColor = "red";
			errorMap.set("City", "It is required");
			event.preventDefault();
		}else{
			city.style.borderColor = "green";
			deleteMapEntry("City");
		}
	}

	function checkZipcode(event){
		var zipcode = document.getElementById('zip_code');
		if(zipcode.value == ""){
			zipcode.style.borderColor = "red";
			errorMap.set("Zipcode", "It is required");
			event.preventDefault();
		}else if(!(/^[0-9]{6}$/.test(zipcode.value))){
			zipcode.style.borderColor = "red";
			errorMap.set("Zipcode", "It require 6 digit numbers only");
			event.preventDefault();
		}else{
			zipcode.style.borderColor = "green";
			deleteMapEntry("Zipcode");
		}
	}

	function checkDescription(event){
		var description = document.getElementById('project_description');
		if(description.value == ""){
			description.style.borderColor = "red";
			errorMap.set("ProjectDescription", "It is required");
			event.preventDefault();
		}else{
			description.style.borderColor = "green";
			deleteMapEntry("ProjectDescription");
		}
	}

	function deleteMapEntry(key) {
		if(errorMap.has(key)) {
			errorMap.delete(key);
		}
	}