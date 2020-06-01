$('#rss_button').on('click', function(){
	
	var email = $('#email_input').val();
	var url = $('#url_input').val();
	
	var message = {
			url: url,
			email: email
	}
	
	$('#spinner').removeClass('hide');
	$.ajax({
 		type: "POST",
 		url: 'sendRss',
 		timeout: 50000,
 		data: JSON.stringify(message),
 		dataType: "text",
 		contentType: 'application/json',
        success: function (data) {
        	$('#spinner').addClass('hide');
        	$('#rssText').html(data);
        },
 		fail: function(){
 			console.log("fail");
 		},
 		error: function(e){
 		    console.log(e);
 		}
	});
});