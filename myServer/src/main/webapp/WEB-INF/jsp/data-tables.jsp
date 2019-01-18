<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Tables</title>
        <!-- Mobile specific metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- Force IE9 to render in normal mode -->
        <!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
        <meta name="author" content="SuggeElson" />
        <meta name="description" content=""
        />
        <meta name="keywords" content=""
        />
        <meta name="application-name" content="sprFlat admin template" />
        <!-- Import google fonts - Heading first/ text second -->
        <link rel='stylesheet' type='text/css' />
        <!-- Css files -->
        <!-- Icons -->
        <link href="/myServer/css/maincss/icons.css" rel="stylesheet" />
        <!-- jQueryUI -->
        <link href="/myServer/css/maincss/sprflat-theme/jquery.ui.all.css" rel="stylesheet" />
        <!-- Bootstrap stylesheets (included template modifications) -->
        <link href="/myServer/css/maincss/bootstrap.css" rel="stylesheet" />
        <!-- Plugins stylesheets (all plugin custom css) -->
        <link href="/myServer/css/maincss/plugins.css" rel="stylesheet" />
        <!-- Main stylesheets (template main css file) -->
        <link href="/myServer/css/maincss/main.css" rel="stylesheet" />
        <!-- Custom stylesheets ( Put your own changes here ) -->
        <link href="/myServer/css/maincss/custom.css" rel="stylesheet" />
        <!-- Windows8 touch icon ( http://www.buildmypinnedsite.com/ )-->
        <meta name="msapplication-TileColor" content="#3399cc" />
    </head>
    <body>
        <!-- Start #header -->
        <div id="header">
            <div class="container-fluid">
                <div class="navbar">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <i class="im-windows8 text-logo-element animated bounceIn"></i><span class="text-logo">CRM</span><span class="text-slogan">system</span> 
                        </a>
                    </div>
                    <nav class="top-nav" role="navigation">

                        <ul class="nav navbar-nav pull-left">
                            <li id="toggle-sidebar-li">
                            </li>
                            <li>
                            </li>
                            <li class="dropdown">
                        </ul>
                        <ul class="nav navbar-nav pull-right">
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown">
                                    <img class="user-avatar" src="/myServer/img/mainimg/48.jpg" alt="${user.userName}">${user.userName}</a>
                                <ul class="dropdown-menu right" role="menu">
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- End #header -->
        <!-- Start #sidebar -->
        <div id="sidebar">
            <!-- Start .sidebar-inner -->
            <div class="sidebar-inner">
                <!-- Start #sideNav -->
                <ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li><h3><a href="#"> display <i class="im-table2"></i></a></h3>
                    </li>
				</ul>
				 <ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li><h3><a href="#"> display <i class="im-table2"></i></a></h3>
                    </li>
				</ul>
				<ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li><h3><a href="#"> display <i class="im-table2"></i></a></h3>
                    </li>
				</ul>
				<ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li><h3><a href="#"> display <i class="im-table2"></i></a></h3>
                    </li>
				</ul>
				<ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li><h3><a href="#"> display <i class="im-table2"></i></a></h3>
                    </li>
				</ul>
				<ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li><h3><a href="#"> display <i class="im-table2"></i></a></h3>
                    </li>
				</ul>
				<ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li><h3><a href="#"> display <i class="im-table2"></i></a></h3>
                    </li>
				</ul>
				<ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li><h3><a href="#"> display <i class="im-table2"></i></a></h3>
                    </li>
				</ul>

<!--  可以做左侧导航栏   -->
            </div>
        </div>
        <!-- End #sidebar -->
        <!-- Start #right-sidebar -->
        <div id="right-sidebar" class="hide-sidebar">
            <!-- Start .sidebar-inner -->
            <div class="sidebar-inner">
                <div class="sidebar-panel mt0">
                    <div class="sidebar-panel-content fullwidth pt0">
                        <div class="chat-user-list">
                            <form class="form-horizontal chat-search" role="form">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Search for user...">
                                    <button type="submit"><i class="ec-search s16"></i>
                                    </button>
                                </div>
                                <!-- End .form-group  -->
                            </form>
                            <ul class="chat-ui bsAccordion">
                          
                            </ul>
                        </div>
                        <div class="chat-box">
                        </div>
                    </div>
                </div>
            </div>
            <!-- End .sidebar-inner -->
        </div>
        <!-- End #right-sidebar -->
        <!-- Start #content -->
        <div id="content">
            <!-- Start .content-wrapper -->
            <div class="content-wrapper">
                <div class="row">
                    <!-- Start .row -->
                    <!-- Start .page-header -->
                    <div class="col-lg-12 heading">
                        <h1 class="page-header"><i class="im-table2"></i> Data Tables</h1>
                        <!-- Start .bredcrumb -->
                        <ul id="crumb" class="breadcrumb">
                        </ul>
                        <!-- End .breadcrumb -->
                        <!-- Start .option-buttons -->
                        <div class="option-buttons">
                        </div>
                        <!-- End .option-buttons -->
                    </div>
                    <!-- End .page-header -->
                </div>
                <!-- End .row -->

                <div class="outlet">
                    <!-- Start .outlet -->
                    <!-- Page start here ( usual with .row ) -->
                    <div class="row">
                        <div class="col-lg-12">
                            <!-- col-lg-12 start here -->
                            <div class="panel panel-default plain toggle panelClose panelRefresh">
                                <!-- Start .panel -->
                                <div class="panel-heading white-bg">
                                    <h2 class="panel-title">Data table</h2>
                                </div>
                                <div class="panel-body">
                                    <table class="table display" id="datatable">
                                        <thead>
                                           <tr>
                                               <td>id</td>
                                               <td>userName</td>
                                               <td>password</td>
                                               <td>age</td>
                                               <td>p_name</td>
                                           </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="user" varStatus="st">
                                               <tr class="odd gradeX">
                                                   <td class="center">${user.id}</td>
                                                   <td class="center">${user.userName}</td>
                                                   <td class="center">${user.password}</td>
                                                   <td class="center">${user.age}</td>
                                                   <td class="center">${user.permission.pName}</td>
                                               </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                           <tr>
                                               <td>id</td>
                                               <td>userName</td>
                                               <td>password</td>
                                               <td>age</td>
                                               <td>p_name</td>
                                           </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                            <!-- End .panel -->
                        </div>
                        <!-- col-lg-12 end here -->
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <!-- col-lg-12 start here -->
                            <div class="panel panel-default plain toggle panelClose panelRefresh">
                                <!-- Start .panel -->                                                                                                                                                                                                                                                                             
                                <div class="panel-heading white-bg">
                                    <h3 class="panel-title">With Table tools</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table display" id="datatable1">
                                        <thead>
                                            <tr>
                                                <th>Rendering engine</th>
                                                <th>Browser</th>
                                                <th>Platform(s)</th>
                                                <th>Engine version</th>
                                                <th>CSS grade</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="odd gradeX">
                                                <td>Trident</td>
                                                <td>Internet Explorer 4.0</td>
                                                <td>Win 95+</td>
                                                <td class="center">4</td>
                                                <td class="center">X</td>
                                            </tr>
                                            <tr class="even gradeC">
                                                <td>Trident</td>
                                                <td>Internet Explorer 5.0</td>
                                                <td>Win 95+</td>
                                                <td class="center">5</td>
                                                <td class="center">C</td>
                                            </tr>
                                            <tr class="odd gradeA">
                                                <td>Trident</td>
                                                <td>Internet Explorer 5.5</td>
                                                <td>Win 95+</td>
                                                <td class="center">5.5</td>
                                                <td class="center">A</td>
                                            </tr>
                                            <tr class="even gradeA">
                                                <td>Trident</td>
                                                <td>Internet Explorer 6</td>
                                                <td>Win 98+</td>
                                                <td class="center">6</td>
                                                <td class="center">A</td>
                                            </tr>
                                            <tr class="odd gradeA">
                                                <td>Trident</td>
                                                <td>Internet Explorer 7</td>
                                                <td>Win XP SP2+</td>
                                                <td class="center">7</td>
                                                <td class="center">A</td>
                                            </tr>
                                            <tr class="even gradeA">
                                                <td>Trident</td>
                                                <td>AOL browser (AOL desktop)</td>
                                                <td>Win XP</td>
                                                <td class="center">6</td>
                                                <td class="center">A</td>
                                            </tr>
                                            <tr class="gradeA">
                                                <td>Gecko</td>
                                                <td>Firefox 1.0</td>
                                                <td>Win 98+ / OSX.2+</td>
                                                <td class="center">1.7</td>
                                                <td class="center">A</td>
                                            </tr>
                                            <tr class="gradeA">
                                                <td>Gecko</td>
                                                <td>Firefox 1.5</td>
                                                <td>Win 98+ / OSX.2+</td>
                                                <td class="center">1.8</td>
                                                <td class="center">A</td>
                                            </tr>
                                            <tr class="gradeA">
                                                <td>Gecko</td>
                                                <td>Firefox 2.0</td>
                                                <td>Win 98+ / OSX.2+</td>
                                                <td class="center">1.8</td>
                                                <td class="center">A</td>
                                            </tr>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Rendering engine</th>
                                                <th>Browser</th>
                                                <th>Platform(s)</th>
                                                <th>Engine version</th>
                                                <th>CSS grade</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                            <!-- End .panel -->
                        </div>
                        <!-- col-lg-12 end here -->
                    </div>
                    <!-- Page End here -->
                </div>
                <!-- End .outlet -->
            </div>
            <!-- End .content-wrapper -->
            <div class="clearfix"></div>
        </div>
        <!-- End #content -->
        <!-- Javascripts -->
        <!-- Load pace first -->
        <script src="assets/plugins/core/pace/pace.min.js"></script>
        <!-- Important javascript libs(put in all pages) -->
        <script src="assets/js/jquery-1.8.3.min.js"></script>
        <script>
        window.jQuery || document.write('<script src="/myServer/js/libs/jquery-2.1.1.min.js">\x3C/script>')
        </script>
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <script>
        window.jQuery || document.write('<script src="/myServer/js/libs/jquery-ui-1.10.4.min.js">\x3C/script>')
        </script>
        <!--[if lt IE 9]>
  <script type="text/javascript" src="/myServer/js/libs/excanvas.min.js"></script>
  <script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <script type="text/javascript" src="/myServer/js/libs/respond.min.js"></script>
<![endif]-->
        <!-- Bootstrap plugins -->
        <script src="/myServer/js/bootstrap/bootstrap.js"></script>
        <!-- Core plugins ( not remove ever) -->
        <!-- Handle responsive view functions -->
        <script src="/myServer/js/jRespond.min.js"></script>
        <!-- Custom scroll for sidebars,tables and etc. -->
        <script src="/myServer/js/plugins/core/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="/myServer/js/plugins/core/slimscroll/jquery.slimscroll.horizontal.min.js"></script>
        <!-- Resize text area in most pages -->
        <script src="/myServer/js/plugins/forms/autosize/jquery.autosize.js"></script>
        <!-- Proivde quick search for many widgets -->
        <script src="/myServer/js/plugins/core/quicksearch/jquery.quicksearch.js"></script>
        <!-- Bootbox confirm dialog for reset postion on panels -->
        <script src="/myServer/js/plugins/ui/bootbox/bootbox.js"></script>
        <!-- Other plugins ( load only nessesary plugins for every page) -->
        <script src="/myServer/js/plugins/core/moment/moment.min.js"></script>
        <script src="/myServer/js/plugins/charts/sparklines/jquery.sparkline.js"></script>
        <script src="/myServer/js/plugins/charts/pie-chart/jquery.easy-pie-chart.js"></script>
        <script src="/myServer/js/plugins/forms/icheck/jquery.icheck.js"></script>
        <script src="/myServer/js/plugins/forms/tags/jquery.tagsinput.min.js"></script>
        <script src="/myServer/js/plugins/forms/tinymce/tinymce.min.js"></script>
        <script src="/myServer/js/plugins/tables/datatables/jquery.dataTables.min.js"></script>
        <script src="/myServer/js/plugins/tables/datatables/jquery.dataTablesBS3.js"></script>
        <script src="/myServer/js/plugins/tables/datatables/tabletools/ZeroClipboard.js"></script>
        <script src="/myServer/js/plugins/tables/datatables/tabletools/TableTools.js"></script>
        <script src="/myServer/js/plugins/misc/highlight/highlight.pack.js"></script>
        <script src="/myServer/js/plugins/misc/countTo/jquery.countTo.js"></script>
        <script src="/myServer/js/jquery.sprFlat.js"></script>
        <script src="/myServer/js/app.js"></script>
        <script src="/myServer/js/pages/data-tables.js"></script>
    </body>
</html>