var Calculator = {
 
    sum : function(data) {
        var settings = {
            url : 'api/calculator/sum',
            type : 'POST',
            data : JSON.stringify(data),
            contentType : 'application/json'
        };
 
        return $.ajax(settings);
    }
};