<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	src="<c:url value="/resources/javascript/project-groups-static.js" />"
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
				<li><a href="#">Profile</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="sign-in.html">Log out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<div class="row searchbar">

			<div class="clearfix"></div>
		</div>
		<div class="panel col-lg-6 col-sm-6">
			<div class="row">
			<div class="rowAddButton col-xs-7">
				<input name="searchtext" id="searchtext" type="text"
					class="form-control" placeholder="Search a project"
					aria-controls="myTable"> </input>
			
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
					<!-- 
                    <tr>
                        <th scope="row">01</th>
                        <td>
                            SUST Archive
                        </td>
                        <td>
                            20-05-15
                        </td>
                        <td>
                            <span class="btn-group pull-right">
                                <a class="btn btn-info btn-sm" data-task="edit" data-primary="2345328" href="javascript:;" title="Edit">
                                    <i class="glyphicon glyphicon-edit "></i>
                                </a>
                                <a class="btn btn-danger btn-sm" data-confirm="Do you really want remove this entry?" data-task="remove" data-primary="2345328" href="javascript:;" title="Remove">
                                    <i class="glyphicon glyphicon-remove"></i>
                                </a>
                            </span>
                        </td>
                    </tr>
                     -->
				</tbody>
			</table>
		</div>
		<!-- panel 1-->
		


		<div class="modal fade" id="modalInfo" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Project details</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-4">
								<label>ID</label>
							</div>
							<div class="col-md-8">
								<p id="view_id"></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label>Title</label>
							</div>
							<div class="col-md-8">
								<p id="view_title"></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<label>Submission Date</label>
							</div>
							<div class="col-md-8">
								<p id="view_submission_date"></p>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Details -->

		<div class="modal fade" id="modalProjectEdit" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form id="edit_project" name="edit_project" method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="modal_project_label">Edit
								Project</h4>
						</div>
						<div class="modal-body">
							<input id="edit_task_id" name="taskId" type="hidden"></input> <input
								id="edit_project_id" name="projectId" type="hidden"></input>
							<div class="row bottom-buffer">
								<div class="col-md-4">
									<label>Title</label>
								</div>
								<div class="col-md-8">
									<input name="projectTitle" id="edit_project_title" type="text"
										class="form-control"></input>
								</div>
							</div>
							<div class="row bottom-buffer">
								<div class="col-md-4">
									<label>Description</label>
								</div>
								<div class="col-md-8">
									<input name="projectDesc" id="edit_project_desc" type="text"
										class="form-control"></input>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<!-- <button type="submit" class="btn btn-info">Save changes</button> -->
							<input type="submit" value="Submit" class="btn btn-info">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--Modal Project Edit -->

		<div class="modal fade" id="modalGroupEdit" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form id="edit_group" name="edit_group" method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="modal_group_label">Edit Group</h4>
						</div>
						<div id="div_edit_group_fields" class="modal-body">
							<input id="edit_group_id" name ="groupId" type = "hidden"></input>
							<div class="row bottom-buffer">
								<div class="col-md-4">
									<label>Student 1: </label>
								</div>
								<div class="col-md-8">
									<input name="groupMember1" id="edit_group_members_1"
										type="text" class="form-control"></input>
								</div>
							</div>
							<div class="row bottom-buffer">
								<div class="col-md-4">
									<label>Student 2: </label>
								</div>
								<div class="col-md-8">
									<input name="groupMember2" id="edit_group_members_2"
										type="text" class="form-control"></input>
								</div>
							</div>
							<div class="row bottom-buffer">
								<div class="col-md-4">
									<label>Student 3: </label>
								</div>
								<div class="col-md-8">
									<input name="groupMember3" id="edit_group_members_3"
										type="text" class="form-control"></input>
								</div>
							</div>
							<div class="row bottom-buffer">
								<div class="col-md-4">
									<label>Student 4: </label>
								</div>
								<div class="col-md-8">
									<input name="groupMember4" id="edit_group_members_4"
										type="text" class="form-control"></input>
								</div>
							</div>
							<div class="row bottom-buffer">
								<div class="col-md-4">
									<label>Student 5: </label>
								</div>
								<div class="col-md-8">
									<input name="groupMember5" id="edit_group_members_5"
										type="text" class="form-control"></input>
								</div>
							</div>
							<div class="row bottom-buffer">
								<div class="col-md-4">
									<label>Student 6: </label>
								</div>
								<div class="col-md-8">
									<input name="groupMember6" id="edit_group_members_6"
										type="text" class="form-control"></input>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<!-- <button type="submit" class="btn btn-info">Save changes</button> -->
							<input type="submit" value="Submit" class="btn btn-info">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--Modal Group Edit -->

		<div class="modal fade" id="modalProjectDelete" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Delete Project</h4>
					</div>
					<div class="modal-body">
						Are you sure you want to delete this <b>Project</b>? <br>Note:
						All <b>Groups</b> and <b>Submissions</b> under this group will
						also be deleted.
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button id="buttonProjectDelete" class="btn btn-danger btn-ok">Delete</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Project Delete -->

		<div class="modal fade" id="modalGroupDelete" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Delete Group</h4>
					</div>
					<div class="modal-body">
						Are you sure you want to delete this <b>Group</b>? <br>Note:
						All <b>Submissions</b> under this group will also be deleted.
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button id="buttonGroupDelete" class="btn btn-danger btn-ok">Delete</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Group Delete -->

		<!-- body container -->
</body>
</html>