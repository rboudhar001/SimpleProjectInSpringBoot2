
$(document).ready(function() {
	
	// DataTable
	$('table').DataTable({
		"info": false,
		"paging": false,
		"ordering": true,
		"searching": false
	});
	
	// Button 'Cancel'
	$('.js-cancel').on('click', function(e) {
	    e.preventDefault();
//	    window.history.back();
	    location.href = "http://localhost:8080/users";
	});
	
});