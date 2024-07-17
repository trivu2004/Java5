<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<h3><s:message code="home.title"/></h3>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("a[href*=lang]").on("click", function(){
		var param = $(this).attr("href");
		$.ajax({
			url: "/home/index" + param,
			success: function(){
				location.reload();
			}
		});
		return false;
	})
})
</script>