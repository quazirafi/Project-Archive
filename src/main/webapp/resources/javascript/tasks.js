var taskURL = "ajaxtasks";
var addTaskURL = "addtask";
var editTaskURL = "edittask";
var deleteTaskURL = "deletetask";
var tempURL = taskURL;
var taskID;
var delID;


$(document)
		.ready(
				function() {
					
					var taskTable;
					var items = "";
					// Get session list for drop down options
					$.getJSON("getsessions", function(data) {
						$.each(data, function(index, item) {
							if (item !== 'OK') {
								for ( var i = item.length - 1; i >= 0; i--) {
									items += "<option value='" + item[i] + "'>"
											+ item[i] + "</option>";
								}
							}
						});
						$("#filter_session").append(items);
						$("#session").append(items);
					});
					
					// Enable Tooltips
					$('[data-toggle="tooltip"]').tooltip();
					taskTable = $('#taskTable')
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
													"visible" : false
												},
												{
													"sWidth" : "20%",
													"mData" : 1
												},
												{
													// "sWidth": "20%",
													"mData" : 2,
												},
												{
													"mData" : 3,
													"visible" : false
												},
												{
													"mData" : 4,
												// "visible": false
												},
												{
													"mData" : 5,
													"visible" : false
												},
												{
													"mData" : 6,
													"visible" : false
												},
												{
													"mData" : 7,
													"visible" : false
												},
												{
													"mData" : null,
													"bSortable" : false,
													"sWidth" : "10%",
													"mRender" : function(data,
															type, full) {
														return '<a class="btn btn-info btn-sm editbutton"><i class="glyphicon glyphicon-edit "></i></a>'
																+ '<a class="btn btn-danger btn-sm removebutton"><i class="glyphicon glyphicon-remove "></i></a>';
													}
												   
												} ],
										ajax : {
											url : taskURL+"?course_id="+ getUrlVars()["course_id"],
											type : 'get',
											dataType : 'json'
										}
									});

					// $('.datepicker').datepicker();
					// total groups, total submission

					// show Info Modal
					/*
					 * $('#taskTable tbody').on('click', 'tr', function() {
					 * taskID = taskTable.cell(this, 0).data();
					 * $('#view_task_id').html(taskID);
					 * $('#view_task_title').html(taskTable.cell(this,
					 * 1).data());
					 * $('#view_task_type').html(taskTable.cell(this,
					 * 2).data());
					 * $('#view_task_description').html(taskTable.cell(this,
					 * 3).data()); $('#modalTaskInfo').modal('show'); });
					 */

					// go to project-groups.html on row click
					$('#taskTable tbody').on('click', 'tr', function(e) {
						var rowIndex = taskTable.row( this ).index();
						var redirectWithParam = "projectgroups?task_id=" +taskTable.cell(rowIndex, 0).data();
						window.location.href = redirectWithParam;
					});

					// show Task Add modal on button click
					$('#button_add_task').on('click', function(event) {
						tempURL = addTaskURL;
						$('#modal_label').html("Add task");
						$('#edit_task_title').val("");
						$('#edit_task_description').val("");
						$('#edit_task_deadline').val("06/01/2015 12:00:00");
						$('#edit_task_total_submission').val("10");
						$('edit_task_sopen').val("true");
						$('#edit_task_description').val("");
						$('#modalTaskEdit').modal('show');
					});

					// show Task Edit modal on button click
					$('#taskTable tbody')
							.on(
									'click',
									'td a.editbutton',
									function(e) {
										
										
										e.stopImmediatePropagation();
										tempURL = editTaskURL;
										var rowIndex = taskTable.cell(
												$(this).parent()).index().row;
										taskID = taskTable.cell(rowIndex, 0)
												.data();
										$('#modal_label').html("Edit task");
										
										$('#edit_task_id').val(
												taskTable.cell(rowIndex, 0)
														.data());
										
										$('#edit_task_title').val(
												taskTable.cell(rowIndex, 1)
														.data());
										$("#edit_task_type").val(
												taskTable.cell(rowIndex, 2)
														.data());
//										if ( taskTable.cell(rowIndex, 2).data() == 1)
//											$("#edit_task_type").val("Assignment");
//										else if ( taskTable.cell(rowIndex, 2).data() == 2)
//											$("#edit_task_type").val("Project");
//										else if ( taskTable.cell(rowIndex, 2).data() == 3)
//											$("#edit_task_type").val("Thesis");
										
										$('#edit_task_description').val(
												taskTable.cell(rowIndex, 3)
														.data());
										$('#edit_task_deadline').val(
												taskTable.cell(rowIndex, 4)
														.data());

										if (taskTable.cell(rowIndex, 5).data() == "true")
											$('#edit_task_sopen').prop(
													'checked', true);
										else
											$('#edit_task_sopen').prop(
													'checked', false);
										$('#modalTaskEdit').modal('show');
										
										$('#edit_task_group_number').val(
												taskTable.cell(rowIndex, 6)
														.data());
										$('#edit_task_total_submission').val(
												taskTable.cell(rowIndex, 7)
														.data());
										

									});

					// show Task Delete Modal on button click
					$('#taskTable tbody').on(
							'click',
							'td a.removebutton',
							function(e) {
								e.stopImmediatePropagation();
								var rowIndex = taskTable.cell($(this).parent())
										.index().row;
								taskID = taskTable.cell(rowIndex, 0).data();
								$('#modalTaskDelete').modal('show');
							});

					// Submit Task Add/Edit form
					$('#edit_task').submit(function(event) {
						if (tempURL == addTaskURL)
						// perform add

						{
							$.ajax({
								type : 'post',
								url : tempURL+"?course_id="+ getUrlVars()["course_id"],
								data : $('#edit_task').serialize(), 
								dataType : 'json',
								encode : true,
								success : function(data) {
									$('#modalTaskEdit').modal('hide');
									taskTable.ajax.reload();
								}
							}), event.preventDefault();
						} else {
							$.ajax({
								type : 'post', 
								url : tempURL + '?taskId=' + taskID, 
								data : $('#edit_task').serialize(), 
								dataType : 'json',
								encode : true,
								success : function(data) {
									$('#modalTaskEdit').modal('hide');
									taskTable.ajax.reload();
								}
							}), event.preventDefault();
						}
						// perform edit
					});

					// Submit Task Delete form
					$('#delete_task').submit(function(event) {
						$.ajax({
							type : 'post',
							url : deleteTaskURL + '?taskId=' + taskID,
							data : $('#delete_task').serialize(),
							dataType : 'json',
							encode : true,
							success : function(data) {
								$('#modalTaskDelete').modal('hide');
								taskTable.ajax.reload();
							}
						}), event.preventDefault();
					});
				});

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