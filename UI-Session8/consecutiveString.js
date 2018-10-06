function removeConsecutive(string) {
	var count=0;
	for (var i=0; i<string.length-1;i++) {
		if(string[i]===string[i+1]) {
			count++;
		} else {
			if(count>0) {
				if((i+1)<string.length) {					
					string = string.slice(0,i-count).concat(string.substring(i+1,string.length));
					i=0;
				}
			}
			count=0;
		}
	}
	console.log(string);
}
