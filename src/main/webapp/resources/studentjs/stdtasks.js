/**
 * 
 */
var taskURL = 'ajaxstdtasks';
var taskTable;

$(document).ready(
		function() {
		
			$('[data-toggle="tooltip"]').tooltip();
			taskTable = $('#taskTable').DataTable(
					{
						"dom" : 'lrtip',
						"processing" : true,
						// "serverSide": true,
						"lengthChange" : true,
						"autoWidth" : false,
						"aoColumns" : [ {
							"mData" : 0,
							"visible" : false
						}, {
							"sWidth" : "20%",
							"mData" : 1
						}, {
							// "sWidth": "20%",
							"mData" : 2,
						}, {
							"mData" : 3,
							"visible" : false
						}, {
							"mData" : 4,
						// "visible": false
						}, {
							"mData" : 5,
							"visible" : false
						}, {
							"mData" : 6,
							"visible" : false
						}, {
							"mData" : 7,
							"visible" : false
						}

						],
						ajax : {
							url : taskURL+"?course_id="+ getUrlVars()["course_id"],
							type : 'get',
							dataType : 'json'
						}

					});

			$('#taskTable tbody').on(
					'click',
					'tr',
					function(e) {
						var rowIndex = taskTable.row( this ).index();
						var redirectWithParam = "projectstdgroups?task_id=" +taskTable.cell(rowIndex, 0).data();
						window.location.href = redirectWithParam;
					});

		});

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
