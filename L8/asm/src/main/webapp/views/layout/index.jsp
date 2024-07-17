<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Thiết kế layout</title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="menu"/>	
	<main>
		<table style="width:100%" border="1">
			<tr>
				<td valign="top"><tiles:insertAttribute name="body"/></td>
				<td width="250"><tiles:insertAttribute name="aside"/></td>
			</tr>
		</table>
	</main>
	<tiles:insertAttribute name="footer"/>
</body>
</html>