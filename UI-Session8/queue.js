class Queue {
	constructor() {
		this.elements = [];
	}
}

Queue.prototype.enqueue = function(data) {
	this.elements.push(data);
}

Queue.prototype.dequeue = function() {
	if (this.elements.length == 0) {
        return "Queue Underflow"; 
	}
    return this.elements.shift(); 
}

Queue.prototype.display = function() {
    for (var i = 0; i < this.elements.length; i++) { 
        console.log(this.elements[i]); 
    }
}