class Stack {
	constructor() {
		this.elements = [];
	}
}

Stack.prototype.pushElement = function(data) {
	this.elements.push(data);
}

Stack.prototype.popElement = function() {
	if (this.elements.length == 0) {
        return "Stack Underflow"; 
	}
    return this.elements.pop(); 
}

Stack.prototype.display = function() {
    for (var i = 0; i < this.elements.length; i++) { 
        console.log(this.elements[i]); 
    }
}