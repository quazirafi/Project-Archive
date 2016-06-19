var projectURL = "ajaxstdprojects";
var projectallURL = "ajaxprojects";
var groupURL = "ajaxstdgroups";

var addGroupURL = "addgroup";

var tempProjectURL;
var tempGroupURL;
var projectID;
var groupID;
var memberCounter;
var maxAllowedMembers = 6;
var items = "";
var notall="true";
var view="false";


$(document)
		.ready(
				function() {
					var projectTable;
					var groupTable;

					// Enable tooltips for registration ids in group table
					$('[data-toggle="tooltip"]').tooltip();

					// Init Datatable for Project
					projectTable = $('#projectTable').DataTable(
							{  
								"dom" : 'lrtip',
								"processing" : true,
								// "serverSide": true,
								"lengthChange" : true,
								"autoWidth" : false,
								"fnInitComplete" : function(oSettings, json) {
									$('#projectTable tbody tr:eq(0)').click();
								},
								"fnDrawCallback" : function(oSettings) {
									$('#projectTable tbody tr:eq(0)').click();
								},
								"aoColumns" : [ {
									"mData" : 0,
									"visible" : false
								}, {
									"sWidth" : "40%",
									"mData" : 1
								}, {
									"sWidth" : "40%",
									"mData" : 2
								// "visible": false
								} ],
								ajax : {

									url : projectURL + "?task_id="
											+ getUrlVars()["task_id"],
									dataType : 'json',
									
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
														for (var i = 0; i < data.length; i++) {
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
					$('#projectTable tbody').on(
							'click',
							'tr',
							function() {
								projectID = projectTable.cell(this, 0).data();
								if (projectID === null | projectID === "") {
									alert('whoops');
									projectID = 0;

								} else

									projectTable.$('tr.selected').removeClass(
											'selected');
								$(this).addClass('selected');
								if(notall=="true"){
									groupURL = "ajaxstdgroups" + "?project_id="
									+ projectID;
							groupTable.ajax.url(groupURL).load();
								}
								
							});

					// Group click redirect
					$('#groupTable tbody').on(
							'click',
							'tr',
							function(e) {
								var rowIndex = groupTable.row(this).index();
								var redirectWithParam = "stdsubmissions?group_id="
										+ groupTable.cell(rowIndex, 0).data();
								window.location.href = redirectWithParam;
							});

					
				
					 

					/*
					 * $('#searchtext').on('keyup', function() {
					 * projectTable.search(this.value).draw(); });
					 */
					
					
					$('#button_add_project').on('click',  function() {
						
						if(view=="false"){
							view="true";
						projectURL = "ajaxprojects" + "?task_id="
						+ getUrlVars()["task_id"];
						projectTable.ajax.url(projectURL).load();
						notall="false";
						
						}
						else 
							{
							projectURL = "ajaxstdprojects" + "?task_id="
							+ getUrlVars()["task_id"];
							projectTable.ajax.url(projectURL).load();
							view="false";
							}
					});

				});

// Getting parameters from url
function getUrlVars() {

	var vars = [], hash;
	var hashes = window.location.href.slice(
			window.location.href.indexOf('?') + 1).split('&');
	for (var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		vars.push(hash[0]);
		vars[hash[0]] = hash[1];
	}
	return vars;
}