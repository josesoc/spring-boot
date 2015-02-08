<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Spring MVC with spring-boot (jstl, tiles, jpa)</title>
	<!--  
		<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen, projection"></link>
		<link rel="stylesheet" href="resources/css/screen.css" type="text/css" media="screen, projection"></link>	
 	-->   
</head>
<body>
	<div class="container">
	
		<!-- Header -->
		<tiles:insertAttribute name="header" />
		
		<!-- Menu Page -->
		<div>
			<tiles:insertAttribute name="menu" />
		</div>
		
		<!-- Body Page -->
		<div>
			<tiles:insertAttribute name="body" />
		</div>
		
		<!-- Footer Page -->
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>