<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Item</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	var formObj = $("#item");

	$("#btnRegister").on("click", function() {
		formObj.attr("action", "/item/register");
		formObj.attr("method", "post");
		formObj.submit();
	});

	$("#btnList").on("click", function() {
		self.location = "/item/list";
	});
	
	$(".uploadedList").on("click", "span", function(event){
		$(this).parent("div").remove();
	});
		
	function getOriginalName(fileName){
		if(checkImageType(fileName)){
			return;
		}
		
		var idx = fileName.indexOf("_") + 1 ;
		
		return fileName.substr(idx);
	}
	
	function getThumbnailName(fileName){
		var front = fileName.substr(0,12);
		var end = fileName.substr(12);
		
		console.log("front : " + front);
		console.log("end : " + end);
		
		return front + "s_" + end;
	}
	
	function checkImageType(fileName){
		var pattern = /jpg|gif|png|jpeg/i;
		
		return fileName.match(pattern);
	}
	
	$("#item").submit(function(event){
		event.preventDefault();
		
		var that = $(this);
		
		var str ="";
		$(".uploadedList a").each(function(index){	
			 var value = $(this).attr("href");
			 value = value.substr(27);
		
			 str += "<input type='hidden' name='files["+index+"]' value='"+ value +"'> ";
		});
		
		console.log("str = " + str);
		
		that.append(str);

		that.get(0).submit();
	});
	
	$("#inputFile").on("change", function(event){
		console.log("change");
		
		var files = event.target.files;
		
		var file = files[0];

		console.log(file);
		
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			url: "/item/uploadAjax",
			data: formData,
			dataType:"text",
			processData: false,
			contentType: false,
			type: "POST",
			success: function(data){
				console.log(data);
			  
				var str ="";
			  
				if(checkImageType(data)){
					str = "<div><a href='/item/displayFile?fileName=" + data + "'>"
						+ "<img src='/item/displayFile?fileName=" + getThumbnailName(data) + "'/>"
						+ "</a><span>X</span></div>";
				}
				else{
					str = "<div><a href='/item/displayFile?fileName=" + data + "'>" 
						+ getOriginalName(data) + "</a>"
						+ "<span>X</span></div></div>";
				}
			  
				$(".uploadedList").append(str);
			}
		});
	});
		
});
</script>

<body>
	<h2>REGISTER</h2>
	
	<form:form modelAttribute="item" action="register" enctype="multipart/form-data">
	
		<table>
			<tr>
				<td>상품명</td>
				<td><form:input path="itemName" /></td>
				<td><font color="red"><form:errors path="itemName" /></font></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><form:input path="price" />&nbsp;원
				</td>
				<td><font color="red"><form:errors path="price" /></font></td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" id="inputFile">
	
					<div class="uploadedList"></div>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>개요</td>
				<td><form:textarea path="description" />
				</td>
				<td><font color="red"><form:errors path="description" /></font></td>
			</tr>
		</table>
		
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister">Register</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>
