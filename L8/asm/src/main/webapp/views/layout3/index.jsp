<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Thiết kế layout</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header"/>
		<tiles:insertAttribute name="menu"/>	
		<main class="row">
			<article class="col-sm-9">
				<div class="row">
					<tiles:insertAttribute name="body"/>
				</div>
			</article>
			<aside class="col-sm-3">
				<div class="row" style="margin-left: 10px;">
					<tiles:insertAttribute name="aside"/>
				</div>
			</aside>
		</main>
		<tiles:insertAttribute name="footer"/>
	</div>	
</body>
</html>