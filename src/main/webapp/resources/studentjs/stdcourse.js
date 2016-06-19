/**
 * 
 */


var courseURL = 'ajaxstdcourse';
var courseTable;



$(document).ready(
		function() {
			//alert('user here is: '+ $('#hidden_username').val());
			$('[data-toggle="tooltip"]').tooltip();
			courseTable = $('#courseTable').DataTable({
				"dom" : 'lrtip',
				"processing" : true,
				// "serverSide": true,
				"lengthChange" : true,
				"autoWidth" : false,
				"aoColumns" : [ {
					"mData" : 0,

				}, {
					"sWidth" : "20%",
					"mData" : 1
				}, {
					// "sWidth": "20%",
					"mData" : 2
				}, {
					"mData" : 3

				}

				],
				ajax : {
					url : courseURL + "?username=" + $('#hidden_username').val(),
					//url: courseURL,
					type : 'get',
					dataType : 'json'
				}

			});
			

			$('#courseTable tbody').on(
					'click',
					'tr',
					function(e) {
						var rowIndex = courseTable.row(this).index();
						var redirectWithParam = "gotostdtasks?course_id="
								+ courseTable.cell(rowIndex, 0).data();
						window.location.href = redirectWithParam;
						//window.location.redirect(redirectWithParam) ;
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

