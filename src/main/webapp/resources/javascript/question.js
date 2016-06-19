/**
 * 
 */

var questionURL = "ajaxquestion";
var questionID;
var addquestionURL = "addquestion";
var editQuestionURL = "editquestion"
	var tempURL;
	var action = 'edit';
	var addquestionURL = "addquestion";
	var editQuestionURL = "editquestion";


$(document)
.ready(
		function() {
			var questionTable;
			$('[data-toggle="tooltip"]').tooltip();
			questionTable = $('#questionTable')
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
										// "visible": false
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
											// "sWidth": "20%",
											"mData" : 3,
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
									url : questionURL,
									type : 'get',
									dataType : 'json'
								}
							});
			// show Info Modal
			$('#questionTable tbody').on(
					'click',
					'tr',
					function() {
						$('#view_course_code').html(
								questionTable.cell(this, 0).data());
						$('#view_session').html(
								questionTable.cell(this, 1).data());
						$("#view_question_type").html(
								questionTable.cell(this, 2).data());
						$("#view_question_download").attr(
								"href",
								"downloadfile?filename="
										+ questionTable.cell(this, 3)
												.data());
						$("#view_question_department").html(
								questionTable.cell(this, 2).data());
						$('#modalQuestionInfo').modal('show');
					});
			
			// show Submission Add modal on button click
			$('#button_add_question').on('click', function(event) {

				tempURL = addQuestionURL;
				$('#modal_label').html("Add Question");
				$('#edit_course_code').val("");
				$("#edit_session").val("");
				$("#edit_question_type").val("");
				$('#edit_question_department').val("");
				$('#modalQuestionEdit').modal('show');
			});