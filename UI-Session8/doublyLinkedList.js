function Node(data) {
	this.data = data;
	this.next = null;
    this.previous = null;
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
            node.previous = current; 
        }  
    }

    this.removeElement = function(data) { 
        if(!this.isEmpty()) {
            var current = this.head; 
            var previousElement = null; 
            while (current != null) {  
                if (current.data === data) { 
                    if (previousElement == null) { 
                        this.head = current.next; 
                        if(current.next!=null) {
                            current.next.previous = null;
                        }
                    } else { 
                        previousElement.next = current.next; 
                        if(current.next!=null) {
                            current.next.previous = previousElement;
                        }
                    } 
                    return current.data; 
                } 
                previousElement = current; 
                current = current.next; 
            } 
            return -1;
        } else {
            return -1;
        }
    }

    this.isEmpty = function() {
        if(this.head == null) {
            return true;
        }
        return false;
    }

    this.display = function(list) {
        var currentNode = this.head;
        while (currentNode != null) {
            console.log(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}
