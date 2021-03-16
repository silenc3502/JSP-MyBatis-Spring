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

	$("#btnRemove").on("click", function() {
		formObj.attr("action", "/item/remove");
		formObj.attr("method", "post");
		formObj.submit();
	});

	$("#btnList").on("click", function() {
		self.location = "/item/list";
	});
  
	function getOriginalName(fileName){
		if(checkImageType(fileName)){
			return;
		}
		
		var idx = fileName.indexOf("_") + 1;
		
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
		
	var itemId = ${item.itemId};
	
	console.log("itemId : " + itemId);
	
	$.getJSON("/item/getAttach/"+itemId,function(list){
		$(list).each(function(){
			console.log("data : " + this);
			
			var data = this;
			
			var str ="";
			  
			if(checkImageType(data)){
				str = "<div><a href='/item/displayFile?fileName=" + data + "'>"
					+ "<img src='/item/displayFile?fileName=" + getThumbnailName(data) + "'/>"
					+ "</a></div>";
			}
			else{
				str = "<div><a href='/item/displayFile?fileName=" + data + "'>" 
					+ getOriginalName(data) + "</a></div>";
			}
			  
			$(".uploadedList").append(str);
		});
	});

});
</script>

<body>
	<h2>DELETE</h2>
	
	<form:form modelAttribute="item" action="delete">
		<form:hidden path="itemId" />
		
		<table>
			<tr>
				<td>상품명</td>
				<td><form:input path="itemName" disabled="true" /></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><form:input path="price" disabled="true" />&nbsp;원
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<div class="uploadedList"></div>
				</td>
			</tr>
			<tr>
				<td>개요</td>
				<td><form:textarea path="description" disabled="true" /></td>
			</tr>
		</table>
		
	</form:form>
	
	<div>
		<button type="submit" id="btnRemove">Remove</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>
