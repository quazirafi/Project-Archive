var url = "TestServlet";
var id;

$(document).ready(function() {
    var table;

    table = $('#myTable').DataTable({
        "dom": 'lrtip',
        "processing": true,
        //"serverSide": true,
        "lengthChange": true,
        "autoWidth": false,
        "aoColumns": [{
                "mData": 0,
                "visible": false
            }, {
                //"sWidth": "20%",
                "mData": 1
            }, {
                //"sWidth": "20%",
                "mData": 2
            }, {
                //"sWidth": "20%",
                "mData": 3
            },
            {
                "mData": null,
                "bSortable": false,
                "mRender": function(data, type, full) {
                    //return '<a class="btn btn-info btn-sm" href=#/' + full[0] + '>' + '<i class="glyphicon glyphicon-edit "></i>' + '</a>';
                    //return '<a class="btn btn-info btn-sm"><i class="glyphicon glyphicon-edit "></i>' + '</a>';
                    return '<a class="btn btn-info btn-sm editbutton"><i class="glyphicon glyphicon-edit "></i></a>'
                         + '<a class="btn btn-danger btn-sm removebutton"><i class="glyphicon glyphicon-remove "></i></a>';
                }
            }],
        ajax: {
            url: url,
            dataType: 'json'
        }
    });

    //Info Modal
    $('#myTable tbody').on('click', 'tr', function() {
        id = table.cell(this, 0).data();

        $('#view_id').html(id);
        $('#view_title').html(table.cell(this, 1).data());
        $('#view_submission_date').html(table.cell(this, 2).data());
        $('#view_members').html(table.cell(this, 3).data());
        $('#modalInfo').modal('show');
    });

    //Edit modal on button click
    $('#myTable tbody').on('click', 'td a.editbutton', function(e) {
        e.stopImmediatePropagation(); // stop the row selection when clicking on an icon
        var rowIndex = table.cell($(this).parent()).index().row;
        id = table.cell(rowIndex, 0).data();
        //alert('clicked button for id: ' + id);
        $('#edit_title').val(table.cell(rowIndex, 1).data());
        $('#edit_submission_date').val(table.cell(rowIndex, 2).data());
        $('#edit_members').val(table.cell(rowIndex, 3).data());
        $('#modalEdit').modal('show');
    });
    
    
    //Delete Modal on button click
    $('#myTable tbody').on('click', 'td a.removebutton', function(e) {
        e.stopImmediatePropagation(); // stop the row selection when clicking on an icon
        var rowIndex = table.cell($(this).parent()).index().row;
        id = table.cell(rowIndex, 0).data();
        $('#modalDelete').modal('show');
    });

    //Submit edit form
    $('#edit_project').submit(function (event) {
        //alert('form submitted');
        var formData = {
            'title'             : $('input[name=edit_title]').val(),
            'submission_date'   : $('input[name=edit_submission_date]').val(),
            'members'           : $('input[name=edit_members]').val()
        };
        $.ajax({
            type: 'post', // define the type of HTTP verb we want to use (POST for our form)
            url: 'TestServlet?action=edit&', // the url where we want to POST
            data: $('#edit_project').serialize(), // our data object
            //dataType: 'json', // what type of data do we expect back from the server
            encode: true,
            success: function(data) {
                $('#modalEdit').modal('hide');
            }
        }),
        event.preventDefault();
    });
    
    //Submit delete form
    $('#buttonDelete').on('click', function (event) {        
        $.ajax({
            type: 'post', // define the type of HTTP verb we want to use (POST for our form)
            url: 'TestServlet?action=delete&id=' + id, // the url where we want to POST
            encode: true,
            success: function(data) {
                $('#modalDelete').modal('hide');
            }
        }),
        event.preventDefault();
    });

    //Filtering table
    $('#button-search-table').click(function(e) {
        e.preventDefault();
        value = $('#searchtext').val();
        url = url + "?session=" + $('#session').val() + "&semester=" + $('#semester').val();
        table.ajax.url(url).load();
        table.search(value).draw();
    });

});