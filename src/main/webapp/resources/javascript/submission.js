var submissionURL = "ajaxsubmissions";
var submissionID;
var addSubmissionURL = "addsubmission";
var editSubmissionURL = "editsubmission"
var tempURL;
var action = 'edit';
var addSubmissionURL = "addsubmission";
var editSubmissionURL = "editsubmission";
var deleteSubmissionURL = "deletesubmission";
var submissionTable;

$(document)
		.ready(
				function() {
					
					$('[data-toggle="tooltip"]').tooltip();
					submissionTable = $('#submissionTable')
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
														return '<a class="btn btn-info btn-sm editbutton">'
																+ '<i class="glyphicon glyphicon-edit "></i></a>'
																+ '<a class="btn btn-danger btn-sm removebutton">'
																+ '<i class="glyphicon glyphicon-remove "></i></a>';
													}
												}
												],
										ajax : {
											url : submissionURL + "?group_id="
													+ getUrlVars()["group_id"],
											dataType : 'json'
										}
									});

					// $('.datepicker').datepicker();
					// total groups, total submission

					// show Info Modal
					$('#submissionTable tbody').on(
							'click',
							'tr',
							function() {
								$('#view_submission_id').html(
										submissionTable.cell(this, 0).data());
								$('#view_submission_date').html(
										submissionTable.cell(this, 1).data());
								$("#view_submission_comment").html(
										submissionTable.cell(this, 2).data());
								if(submissionTable.cell(this, 3)
														.data() === null)
									$("#view_submission_download").hide()
								else{
								$("#view_submission_download").attr(
										"href",
										"downloadfile?filename="
												+ submissionTable.cell(this, 3)
														.data());
								$("#view_submission_download").show()
								}
								$('#modalSubmissionInfo').modal('show');
							});

					// show Submission Add modal on button click
					$('#button_add_submission').on('click', function(event) {

						tempURL = addSubmissionURL;
						$('#modal_label').html("Add Submission");
						$('#edit_submission_group_id').val(getUrlVars()["group_id"]);
						$('#edit_submission_date').val("");
						$("#edit_submission_comment").val("");
						$('#edit_submission_date').val("06/01/2015 12:00:00");
						$('#modalSubmissionEdit').modal('show');
					});

					// show Submission Edit modal on button click
					$('#submissionTable tbody').on(
							'click',
							'td a.editbutton',
							function(e) {
								e.stopImmediatePropagation();
								tempURL = editSubmissionURL;
								var rowIndex = submissionTable.cell(
										$(this).parent()).index().row;
								submissionID = submissionTable
										.cell(rowIndex, 0).data();
								$('#modal_label').html("Edit Submission");
								$('#edit_submission_date').val(
										submissionTable.cell(rowIndex, 1)
												.data());
								$("#edit_submission_comment").val(
										submissionTable.cell(rowIndex, 2)
												.data());
								$("#edit_submission_file").val(null);
								$('#modalSubmissionEdit').modal('show');
							});

					// show Submission Delete Modal on button click
					$('#submissionTable tbody').on(
							'click',
							'td a.removebutton',
							function(e) {
								e.stopImmediatePropagation(); // stop the row
								// selection
								// when clicking
								// on an icon
								var rowIndex = submissionTable.cell(
										$(this).parent()).index().row;
								submissionID = submissionTable
										.cell(rowIndex, 0).data();
								$('#modalSubmissionDelete').modal('show');
							});

					// Submit Submission add/edit form
					$('#edit_submission').submit(function(event) {
						saveMedia();
						//submissionTable.ajax.reload();
						event.preventDefault();
					});

					// Submit Submission Delete form
					$('#buttonSubmissionDelete').on(
							'click',
							function(event) {
								$.ajax({
									type : 'post', // define the type of HTTP
									// verb we
									// want to use (POST for our form)
									url : deleteSubmissionURL
											+ "?submissionId=" + submissionID,
									encode : true,
									success : function(data) {
										$('#modalSubmissionDelete').modal(
												'hide');
										submissionTable.ajax.reload();
									}
								}), event.preventDefault();
							});

				});

function saveMedia() {
	var form = document.getElementById('edit_submission');
	var formData = new FormData(form);
	var selectedFileName = $("#edit_submission_file").val();
	if (selectedFileName === null | selectedFileName === ""){
		tempURL = tempURL +'nofile';
		//alert('We have >>' + tempURL + '<<');

	}
	if (selectedFileName != null && selectedFileName != "") {
		formData.append('file', $('input[type=file]')[0].files[0]);
		
	} else {
		// formData = "";
		// formData = $('#edit_submission').serialize();
	}
	// console.log("form data " + formData);
	$.ajax({
		url : tempURL+"?submissionId=" + submissionID,
		data : formData,
		// dataType: json,
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(data) {
			$('#modalSubmissionEdit').modal('hide');
			submissionTable.ajax.reload();
		},
		error : function(err) {
			alert("failed to upload data");
		}
	});
}

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