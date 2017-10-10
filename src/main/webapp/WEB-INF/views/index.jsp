<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>AngularJS $http Example</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/main-style.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/plugins/bootstrap/bootstrap.css' />"
	rel="stylesheet"></link>

<link href="<c:url value='static/font-awesome/css/font-awesome.css' />"
	rel="stylesheet" />
<link
	href="<c:url value='/static/plugins/pace/pace-theme-big-counter.css' />"
	rel="stylesheet"></link>
<link
	href="<c:url value='/static/plugins/dataTables/dataTables.bootstrap.css' />"
	rel="stylesheet"></link>

</head>


<body ng-app="myApp" class="ng-cloak">
	<!--  wrapper -->
	<div id="wrapper">
		<!-- navbar top -->
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			id="navbar" style="height: 82px">
			<!-- navbar-header -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"> <img
					src="<c:url value='/static/img/logo.png'/>" alt="" />
				</a>
			</div>
			<!-- end navbar-header -->
			<!-- navbar-top-links -->


		</nav>
		<!-- end navbar top -->

		<!-- navbar side -->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<!-- sidebar-collapse -->
			<div class="sidebar-collapse">
				<!-- side-menu -->
				<ul class="nav" id="side-menu">
					<li>
						<!-- user image section-->
						<div class="user-section">
							<div class="user-info">
								<div>
									Jonny <strong>Deen</strong>
								</div>
								<div class="user-text-online">
									<span class="user-circle-online btn btn-success btn-circle "></span>&nbsp;Online
								</div>
							</div>
						</div> <!--end user image section-->
					</li>
					<li class="sidebar-search">
						<!-- search section-->
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Search...">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div> <!--end search section-->
					</li>
					<li class=""><a href="index.html"><i
							class="fa fa-dashboard fa-fw"></i>Dashboard</a></li>
					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Charts<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="flot.html">Flot Charts</a></li>
							<li><a href="morris.html">Morris Charts</a></li>
						</ul> <!-- second-level-items --></li>
					<li><a href="timeline.html"><i class="fa fa-flask fa-fw"></i>Customers</a>
					</li>
					<li class="selected"><a href="tables.html"><i
							class="fa fa-table fa-fw"></i>Orders</a></li>
					<li><a href="forms.html"><i class="fa fa-edit fa-fw"></i>Order
							Details</a></li>

				</ul>
				<!-- end side-menu -->
			</div>
			<!-- end sidebar-collapse -->
		</nav>
		<!-- end navbar side -->
		<!--  page-wrapper -->
		<div id="page-wrapper">

			<div class="row">
				<!--  page header -->
				<div class="col-lg-12">
					<h1 class="page-header">Tables</h1>
				</div>
				<!-- end  page header -->
			</div>
			
						<!-- everything here will be for a story -->

			<div class="row">
				<div class="col-lg-12">
					<!-- Advanced Tables  -->
					<div class="generic-container"
						ng-controller="StoryController as ctrl">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="lead">List of Story Summaries </span>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<div class="tablecontainer">
										<table class="table table-hover">
											<thead>
												<tr>
													<th>ID.</th>
													<th>Title</th>
													<th>Author</th>
													<th>Genre</th>
													<th>Genre2</th>
													<th>Description</th>
													<th>Date created</th>
											        <th>Date updated</th>
													<th>Number of views</th>

													<th width="20%"></th>
												</tr>
											</thead>
											<tbody>
												<tr ng-repeat="c in ctrl.stories">
													<td><span ng-bind="c.id"></span></td>
													<td><span ng-bind="c.storyTitle"></span></td>
													<td><span ng-bind="c.author"></span></td>
													<td><span ng-bind="c.genre"></span></td>
													<td><span ng-bind="c.genre_minor1"></span></td>
													<td><span ng-bind="c.description"></span></td>
													<td><span ng-bind="c.created"></span></td>
													<td><span ng-bind="c.updated"></span></td>
													<td><span ng-bind="c.numberOfviews"></span></td>

													<td>
													
														<button type="button" ng-click="ctrl.edit(c.id)"
															class="btn btn-success custom-width">Story, bud?</button>
												</td>
													
																		
														<!-- <button type="button" ng-click="show_story(c.id)"
															class="btn btn-success custom-width">View Story</button> -->
			
												
												</tr>
											</tbody>
										</table>
										<div id ="story_contents" class="story_text">
										 {{ctrl.story.storyString}}
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--End Advanced Tables -->
				</div>


			</div>
			<!-- end wrapper -->
			



			<script
				src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
			<script src="<c:url value='/static/js/app.js' />"></script>
			<script src="<c:url value='/static/js/service/user_service.js' />"></script>
			<script
				src="<c:url value='/static/js/controller/user_controller.js' />"></script>
			<script
				src="<c:url value='/static/js/service/customer_service.js' />"></script>
				
				<script
				src="<c:url value='/static/js/controller/story_controller.js' />"></script>
			<script
				src="<c:url value='/static/js/service/story_service.js' />"></script>
			<script
				src="<c:url value='/static/js/controller/customer_controller.js' />"></script>
			<script src="<c:url value='/static/js/service/order_service.js' />"></script>
			<script
				src="<c:url value='/static/js/controller/order_controller.js' />"></script>
			<script
				src="<c:url value='/static/js/service/order_id_printed_service.js' />"></script>
			<script
				src="<c:url value='/static/js/controller/order_id_printed_controller.js' />"></script>

			<script src="<c:url value='/static/plugins/jquery-1.10.2.js' />"></script>
			<script
				src="<c:url value='/static/plugins/bootstrap/bootstrap.min.js' />"></script>
			<script
				src="<c:url value='/static/plugins/metisMenu/jquery.metisMenu.js' />"></script>
			<script src="<c:url value='/static/plugins/pace/pace.js' />"></script>

			<script src="<c:url value='/static/scripts/siminta.js' />"></script>
			<script
				src="<c:url value='/static/plugins/dataTables/jquery.dataTables.js' />"></script>
			<script
				src="<c:url value='/static/plugins/dataTables/dataTables.bootstrap.js' />"></script>



			<script>
				$(document).ready(function() {
					$('#dataTables-example').dataTable();
				});
			</script>
</body>

</html>
