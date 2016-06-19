var submissionURL = 'ajaxstdsubmissions';
var submissionTable;
var submissionID;
var addSubmissionURL = "addstdsubmission";

$(document).ready(
		function() {
			// alert('user here is: '+ $('#hidden_username').val());
			$('[data-toggle="tooltip"]').tooltip();
			submissionTable = $('#submissionTable').DataTable(
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
						}, {
							"sWidth" : "20%",
							"mData" : 1
						}, {
							// "sWidth": "20%",
							"mData" : 2,
						}

						],
						ajax : {
							url : submissionURL + "?group_id="
									+ getUrlVars()["group_id"],
							dataType : 'json'
						}

					});
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
						if (submissionTable.cell(this, 3).data() === null)
							$("#view_submission_download").hide()
						else {
							$("#view_submission_download").attr(
									"href",
									"stddownloadfile?filename="
											+ submissionTable.cell(this, 3)
													.data());
							$("#view_submission_download").show()
						}
						$('#modalSubmissionInfo').modal('show');
					});

			$('#button_add_submission').on('click', function(event) {

				tempURL = addSubmissionURL;
				$('#modal_label').html("Add Submission");
				$('#edit_submission_group_id').val(getUrlVars()["group_id"]);
				$('#edit_submission_date').val("");
				$("#edit_submission_comment").val("");
				$('#edit_submission_date').val("06/01/2015 12:00:00");
				$('#modalSubmissionEdit').modal('show');
			});

			$('#edit_submission').submit(function(event) {
				saveMedia();
				// submissionTable.ajax.reload();
				event.preventDefault();
			});

		});

function saveMedia() {
	var form = document.getElementById('edit_submission');
	var formData = new FormData(form);
	var selectedFileName = $("#edit_submission_file").val();
	if (selectedFileName === null | selectedFileName === "") {
		tempURL = tempURL + 'nofile';
		// alert('We have >>' + tempURL + '<<');

	}
	if (selectedFileName != null && selectedFileName != "") {
		formData.append('file', $('input[type=file]')[0].files[0]);

	} else {
		// formData = "";
		// formData = $('#edit_submission').serialize();
	}
	// console.log("form data " + formData);
	$.ajax({
		url : tempURL + "?submissionId=" + submissionID,
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
	for (var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		vars.push(hash[0]);
		vars[hash[0]] = hash[1];
	}
	return vars;
}
