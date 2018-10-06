function Node(data) {
	this.data = data;
	this.next = null;
}

function LinkedList() {
	this.head = null;

    this.add = function(data) {
    	var node = new Node(data);
    	var current; 
    	if (this.head == null) 
            this.head = node; 
        else { 
            current = this.head; 
            while (current.next) { 
                current = current.next; 
            }  
            current.next = node; 
        } 
    }

    this.removeElement = function(data) { 
        var current = this.head; 
        var previousElement = null; 
        while (current != null) {  
            if (current.data === data) { 
                if (previousElement == null) { 
                    this.head = current.next; 
                } else { 
                    previousElement.next = current.next; 
                } 
                return current.element; 
            } 
            previousElement = current; 
            current = current.next; 
        } 
        return -1;
    } 

    this.display = function() {
        var currentNode = this.head;
        while (currentNode != null) {
            console.log(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}

