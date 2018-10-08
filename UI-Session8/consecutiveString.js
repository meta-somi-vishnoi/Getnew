function removeConsecutive(string) {
    var count=0;
    for (var i=0; i<string.length-1;i++) {
        if(string[i]===string[i+1]) {
            count++;
        } else {
            if(count>0) {                 
                string = string.slice(0,i-count).concat(string.substring(i+1,string.length));
                i=-1;
            }
            count=0;
        }
    }
    if(count>0) {                   
        string = string.slice(0,i-count).concat(string.substring(i+1,string.length));
    }
    return string;
}
