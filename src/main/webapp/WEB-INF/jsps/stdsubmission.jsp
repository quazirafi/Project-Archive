<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setHeader("Cache-Control","no-cache"); 
/*HTTP 1.1*/ response.setHeader("Pragma","no-cache"); 
/*HTTP 1.0*/ response.setDateHeader ("Expires", 0);
%> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <title>SUST Archives</title>
        <link href="<c:url value="/resources/css/topbar.css" />" rel="stylesheet" type="text/css" />
        
         <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />       
        <link href="<c:url value="/resources/css/jquery.dataTables.min.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/resources/css/dataTables.bootstrap.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/resources/css/thesis-list.css"/>" rel="stylesheet"  type="text/css" />

        <script src="<c:url value="/resources/javascript/jquery-1.11.3.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/javascript/bootstrap.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/javascript/jquery.dataTables.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/javascript/dataTables.bootstrap.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/studentjs/studentSubmission.js" />" type="text/javascript" ></script>
    
    </head>
    <body>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="row topbar">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="
                 col-sm-4 col-sm-offset-1
                 col-xs-12">
                <a class="navbar-brand" href="/greatweb">SUST Archives<sup>beta</sup></a>
            </div>
            <div class="
                 col-sm-5 col-sm-offset-1
                 col-xs-12">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">${UserRole.getUserName()}</a></li>
                    <li><a href="#">Settings</a></li>
                    <li><a href="sign-in.html">Log out</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row searchbar">
            <div class="col-xs-10">
            </div>
            <div class="col-xs-2">	
						
						
					
				
				<button id="button_add_submission" class="btn btn-success col-xs-12" >
                    <i class="glyphicon glyphicon-plus-sign"></i>
                    Add Submission
                </button>
			</div>	
            
            
                
            </div>
        </div>
        <div class="clearfix"></div>

        <div class="panel">

            <table id="submissionTable" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class="col-md-1 col-sm-1 col-xs-1">
                            ID
                        </th>
                        <th class="col-md-3 col-sm-3 col-xs-3">
                            Date
                        </th>
                        <th class="col-md-6 col-sm-6 col-xs-6">
                            Comment
                        </th>
                       
                        
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div><!-- panel -->


        <div class="modal fade" id="modalSubmissionInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Submission details</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-4"><label>ID</label></div>
                            <div class="col-md-8"><p id="view_submission_id"></p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4"><label>Date</label></div>
                            <div class="col-md-8"><p id="view_submission_date"></p></div></div>
                        <div class="row">
                            <div class="col-md-4"><label>Comment</label></div>
                            <div class="col-md-8"><p id="view_submission_comment"></p></div></div>
                        <div class="row">
                            <div class="col-md-4"><label></label></div>
                            <div class="col-md-8"><a id="view_submission_download">download source</a></div></div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div><!-- Modal Details -->
        
         <div class="modal fade" id="modalSubmissionEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form id="edit_submission" name="edit_submission" method="post" enctype="multipart/form-data">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="modal_label">Edit Submission</h4>
                        </div>
                        <div class="modal-body">
							<input id="edit_submission_group_id" name="groupId" type="hidden"></input>
                            <div class="row bottom-buffer">
                                <div class="col-md-4"><label>Date</label></div>
                                <div class="col-md-8"><input name="submissionTime" id="edit_submission_date" type="date" class="form-control"></input></div>
                            </div>
                            <div class="row bottom-buffer">
                                <div class="col-md-4"><label>Comment</label></div>
                                <div class="col-md-8"><textarea name="commentTeacher" id="edit_submission_comment" type="text" class="form-control"></textarea></div>
                            </div>
                            <div class="row bottom-buffer">
                                <div class="col-md-4"><label>File</label></div>

                                <div class="col-md-8"><input type="file" accept=".zip" name="submissionFileTest" id="edit_submission_file"></input></div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <!-- <button type="submit" class="btn btn-info">Save changes</button> -->
                            <input type="submit" value="Submit" class="btn btn-info">
                        </div>
                    </form>
                </div>
            </div>
        </div><!--Modal Edit -->
        

       
    </div> <!-- body container -->
</body>
</html>