<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
	<title>Home</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#inputFile").on("change", function(event){
		
		console.log("change");
		
		var files = event.target.files;
		
		var file = files[0];

		console.log(file);
		
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			type : "post",
			url : "/uploadAjax",
		  	data: formData,
		  	dataType:'text',
		  	processData: false,
		  	contentType: false,
		  	success: function(data){
			  alert(data);
		  	}
		});
	});
	
});
</script>

<body>
	<h3>Ajax File Upload</h3>
	<div>
		<input type="file" id="inputFile">
	</div>
</body>
</html>
