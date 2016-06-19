var projectURL = "ajaxprojects";
var groupURL = "ajaxgroups";
var addProjectURL = "addproject";
var updateProjectURL = "updateproject";
var deleteProjectURL = "deleteproject";
var addGroupURL = "addgroup";
var updateGroupURL = "updategroup";
var deleteGroupURL = "deletegroup";
var tempProjectURL;
var tempGroupURL;
var projectID;
var groupID;
var memberCounter;
var maxAllowedMembers = 6;
var items = "";

$(document)
		.ready(
				function() {
					var projectTable;
					var groupTable;
					
					// Enable tooltips for registration ids in group table
					$('[data-toggle="tooltip"]').tooltip();

					// Init Datatable for Project
					projectTable = $('#projectTable')
							.DataTable(
									{
										"dom" : 'lrtip',
										"processing" : true,
										// "serverSide": true,
										"lengthChange" : true,
										"autoWidth" : false,
										"fnInitComplete" : function(oSettings,
												json) {
											$('#projectTable tbody tr:eq(0)')
													.click();
										},
										"fnDrawCallback" : function(oSettings) {
											$('#projectTable tbody tr:eq(0)')
													.click();
										},
										"aoColumns" : [
												{
													"mData" : 0,
													"visible" : false
												},
												{
													"sWidth" : "40%",
													"mData" : 1
												},
												{
													"sWidth" : "40%",
													"mData" : 2
												// "visible": false
												},
												{
													"mData" : null,
													"bSortable" : false,
													"mRender" : function(data,
															type, full) {
													return null;
														
													}
												} ],
										ajax : {

											url : projectURL + "?task_id="
													+ getUrlVars()["task_id"],
											dataType : 'json'
										}

									});

					// Init Datatable for Group
					groupTable = $('#groupTable')
							.DataTable(
									{
										"dom" : 'lrtip',
										"processing" : true,
										// "serverSide": true,
										"lengthChange" : true,
										"autoWidth" : false,
										"aoColumns" : [
												{
													"mData" : 0,
												},
												{
													"mData" : 1,
													"visible" : false
												},
												{
													// "sWidth": "20%",
													"mData" : 2,
													"bSortable" : false,
													"mRender" : function(data,
															type, full) {
														var render = "";
														for ( var i = 0; i < data.length; i++) {
															render = render
																	+ '<span class="group-member"'
																	+ 'data-toggle="tooltip" data-placement="bottom" title="'
																	+ data[i]
																	+ '"'
																	+ 'style="background-color:'
																	+ "#00BCD4"
																	+ '">'
																	+ data[i]
																			.substring(8)
																	+ '</span>';
														}
														return render;
													}
												},
												{
													"mData" : null,
													"bSortable" : false,
													"mRender" : function(data,
															type, full) {
														return '<a class="btn btn-info btn-sm editbutton"><i class="glyphicon glyphicon-edit "></i></a>'
																+ '<a class="btn btn-danger btn-sm removebutton"><i class="glyphicon glyphicon-remove "></i></a>';
													}
												} ],

										// ajax data loads when projectTable
										// clicks row, first row is clicked
										// automatically on init
										ajax : {
											url : groupURL,
											dataType : 'json'
										}
									});

					// Load Group data on Project row click
					$('#projectTable tbody').on('click', 'tr', function() {
						projectID = projectTable.cell(this, 0).data();
						if(projectID === null | projectID === ""){
							alert('whoops');
							projectID = 0;
							$("#button_add_group").prop("disabled", true);
						}
						else
							$("#button_add_gorup").prop("disabled", false);
						projectTable.$('tr.selected').removeClass('selected');
						$(this).addClass('selected');
						groupURL = "ajaxgroups" + "?project_id=" + projectID;
						groupTable.ajax.url(groupURL).load();
					});

					// Group click redirect
					$('#groupTable tbody').on(
							'click',
							'tr',
							function(e) {
								var rowIndex = groupTable.row(this).index();
								var redirectWithParam = "submission?group_id="
										+ groupTable.cell(rowIndex, 0).data();
								window.location.href = redirectWithParam;
							});

					// show Project Add modal on button click
					$('#button_add_project').on(
							'click',
							function(event) {
								$('#modal_project_label').html("Add Project");
								tempProjectURL = addProjectURL + '?task_id='
										+ getUrlVars()["task_id"];
								// alert(tempProjectURL);
								$('#edit_project_title').val("");
								$('#edit_project_submission_date').val("");
								$('#modalProjectEdit').modal('show');
							});
					
					// show Group Add modal on button click
					$('#button_add_group').on(
							'click',
							function(e) {
								tempGroupURL = addGroupURL + '?project_id=' + projectID;
								$('#modal_group_label').html("Add Project");
								for ( var i = 0; i < 6; i++) {
										var temp = i+1;
										$("#edit_group_members_" + temp).val("");
								}
								$('#modalGroupEdit').modal('show');
							});

					// show Project Edit modal on button click
					$('#projectTable tbody').on(
							'click',
							'td a.editbutton',
							function(e) {
								$('#modal_project_label').html("Edit Project");
								// e.stopImmediatePropagation(); // stop the row
								// selection when clicking on an icon
								tempProjectURL = updateProjectURL;
								var rowIndex = projectTable.cell(
										$(this).parent()).index().row;
								projectID = projectTable.cell(rowIndex, 0)
										.data();
								$('#edit_project_id').val(
										projectTable.cell(rowIndex, 0).data());
								$('#edit_project_title').val(
										projectTable.cell(rowIndex, 1).data());
								$('#edit_project_desc').val(
										projectTable.cell(rowIndex, 2).data());
								$('#modalProjectEdit').modal('show');
							});

					// show Group Edit modal on button click
					$('#groupTable tbody').on(
							'click',
							'td a.editbutton',
							function(e) {
								e.stopImmediatePropagation();
								tempGroupURL = updateGroupURL;
								var rowIndex = groupTable
										.cell($(this).parent()).index().row;
								groupID = groupTable.cell(rowIndex, 0).data();
								$("#edit_group_id").val(groupID);
								var members = groupTable.cell(rowIndex, 2)
										.data();
								for ( var i = 0; i < 6; i++) {
									var temp = i + 1;
									if (i < members.length) {
										$("#edit_group_members_" + temp).val(
												members[i]);
									} else {
										$("#edit_group_members_" + temp)
												.val("");
									}
								}
								$('#modalGroupEdit').modal('show');
							});

					// show Project Delete Modal on button click
					$('#projectTable tbody').on(
							'click',
							'td a.removebutton',
							function(e) {
								// e.stopImmediatePropagation(); // stop the row
								// selection when clicking on an icon
								var rowIndex = projectTable.cell(
										$(this).parent()).index().row;
								projectID = projectTable.cell(rowIndex, 0)
										.data();
								$('#modalProjectDelete').modal('show');
							});

					// show Group Delete Modal on button click
					$('#groupTable tbody').on(
							'click',
							'td a.removebutton',
							function(e) {
								e.stopImmediatePropagation(); // stop the row
								// selection when clicking on an icon
								var rowIndex = groupTable
										.cell($(this).parent()).index().row;
								groupID = groupTable.cell(rowIndex, 0).data();
								$('#modalGroupDelete').modal('show');
							});

					// Submit Project Edit form
					$('#edit_project').submit(function(event) {
						alert("Temp Project Url: " + tempProjectURL);
						$.ajax({
							type : 'post',
							url : tempProjectURL,
							data : $('#edit_project').serialize(),
							// dataType: 'json',
							encode : true,
							success : function(data) {
								$('#modalProjectEdit').modal('hide');
								projectTable.ajax.reload(function() {
									$('#projectTable tbody tr:eq(0)').click();
								});
							}
						}), event.preventDefault();
					});

					// submit Group Edit form
					$('#edit_group').submit(function(event) {
						$.ajax({
							type : 'post',
							url : tempGroupURL,
							data : $('#edit_group').serialize(),
							// dataType: 'json',
							// expect back from the server
							encode : true,
							success : function(data) {
								$('#modalGroupEdit').modal('hide');
								projectTable.ajax.reload(function() {
									$('#projectTable tbody tr:eq(0)').click();
								});
							}
						}), event.preventDefault();
					});

					// Submit Project Delete form
					$('#buttonProjectDelete').on('click', function(event) {
						$.ajax({
							type : 'post',
							url : deleteProjectURL + '?projectId=' + projectID,
							encode : true,
							success : function(data) {
								$('#modalProjectDelete').modal('hide');
								projectTable.ajax.reload(function() {
									$('#projectTable tbody tr:eq(0)').click();
								});
							}
						}), event.preventDefault();
					});

					// Submit Group Delete form
					$('#buttonGroupDelete').on('click', function(event) {
						$.ajax({
							type : 'post',
							url : deleteGroupURL + '?group_id=' + groupID,
							success : function(data) {
								$('#modalGroupDelete').modal('hide');
								projectTable.ajax.reload(function() {
									$('#projectTable tbody tr:eq(0)').click();
								});
							}
						}), event.preventDefault();
					});

					// Filtering table
					// $('#button-search-table').click(function(e) {
					// //e.preventDefault();
					// value = $('#searchtext').val();
					// tempURL = projectURL+"?task_id="+getUrlVars()["task_id"];
					// tempURL = tempURL + "&session=" + $('#session').val() +
					// "&semester=" + $('#semester').val();
					// //alert(tempURL);
					// projectTable.ajax.url( tempURL ).load();
					// projectTable.search(value).draw();
					//        
					// //projectTable.draw();
					// });

					$('#searchtext').on('keyup', function() {
						projectTable.search(this.value).draw();
					});

				});

// Getting parameters from url
function getUrlVars() {

	var vars = [], hash;
	var hashes = window.location.href.slice(
			window.location.href.indexOf('?') + 1).split('&');
	for ( var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		vars.push(hash[0]);
		vars[hash[0]] = hash[1];
	}
	return vars;
}