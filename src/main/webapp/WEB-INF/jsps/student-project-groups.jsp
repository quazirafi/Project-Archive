<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% response.setHeader("Cache-Control","no-cache"); 
/*HTTP 1.1*/ response.setHeader("Pragma","no-cache"); 
/*HTTP 1.0*/ response.setDateHeader ("Expires", 0);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width-device-width, initial-scale=1.0">
<title>SUST Archives</title>
<link href="<c:url value="/resources/css/topbar.css" />"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/jquery.dataTables.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/dataTables.bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/project-groups.css"/>"
	rel="stylesheet" type="text/css" />

<script
	src="<c:url value="/resources/javascript/jquery-1.11.3.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/javascript/bootstrap.min.js" />"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/javascript/jquery.dataTables.min.js" />"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/javascript/dataTables.bootstrap.js" />"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/studentjs/project-groups-static-student.js" />"
	type="text/javascript"></script>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="row topbar">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div
			class="
                 col-sm-4 col-sm-offset-1
                 col-xs-12">
			<a class="navbar-brand" href="/greatweb">SUST Archives<sup>beta</sup></a>
		</div>
		<div
			class="
                 col-sm-5 col-sm-offset-1
                 col-xs-12">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">${UserRole.getUserName()}</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="sign-in.html">Log out</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<div class="container">
	
	<div class="row searchbar">
	<div class="col-xs-8">
				<p class="table-headertext">
					Task: <span id="task_title">${task_title}</span>
				</p>
				
				
			</div>
			
			
			<div class="clearfix"></div>
		
		<div class="panel col-lg-6 col-sm-6">
		
		
			
		
			
			<div class="row">
			
			<div class="col-xs-4 rowAddButton">
				<button id="button_add_project"
					class="btn btn-success"> 
					 View All
				</button>
			</div>
			</div>
			<table id="projectTable"
				class="table table-striped table-bordered table-hover">
				
		
				<thead>
					<tr>
						<th
							class="	col-md-1
                            col-sm-1
                            col-xs-1">
							ID</th>
						<th
							class="	col-md-2
                            col-sm-4
                            col-xs-4">
							Title</th>
						<th
							class="	col-md-3
                            col-sm-3
                            col-xs-3">
							Description</th>
						
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<!-- panel 1-->
		<div class="panel col-lg-6 col-sm-6">
			
			<table id="groupTable"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th
							class="	col-md-1
                            col-sm-1
                            col-xs-1">
							ID</th>
						<th
							class="	col-md-2
                            col-sm-4
                            col-xs-4">
							Name</th>
						<th
							class="	col-md-2
                            col-sm-4
                            col-xs-4">
							Members</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<!--panel 2-->


		

		

</div>
</div>
		<!-- body container -->
</body>
</html>