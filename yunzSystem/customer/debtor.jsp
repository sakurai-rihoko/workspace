<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>债务逾期在线司法处置平台</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="../bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
  <link rel="stylesheet" href="../dist/css/skins/skin-blue.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <!--icheck-->
  <link rel="stylesheet" href="../plugins/iCheck/all.css">
  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <style type="text/css">
         
      
        </style>
        
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">

<!--
 jsp-code-field

-->
<%!
    String subTitle = "债务人管理";
    String liClass = "active";


 %>


<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="../manager-base.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini">云证</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">债务逾期在线司法处置平台</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <!-- Menu toggle button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-success">4</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                <!-- inner menu: contains the messages -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <!-- User Image -->
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <!-- Message title and timestamp -->
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <!-- The message -->
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <!-- end message -->
                </ul>
                <!-- /.menu -->
              </li>
              <li class="footer"><a href="#">See All Messages</a></li>
            </ul>
          </li>
          <!-- /.messages-menu -->

          <!-- Notifications Menu -->
          <li class="dropdown notifications-menu">
            <!-- Menu toggle button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <!-- Inner Menu: contains the notifications -->
                <ul class="menu">
                  <li><!-- start notification -->
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  <!-- end notification -->
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
          <!-- Tasks Menu -->
          <li class="dropdown tasks-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger">9</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                <!-- Inner menu: contains the tasks -->
                <ul class="menu">
                  <li><!-- Task item -->
                    <a href="#">
                      <!-- Task title and progress text -->
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <!-- The progress bar -->
                      <div class="progress xs">
                        <!-- Change the css width attribute to simulate progress -->
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar"
                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all tasks</a>
              </li>
            </ul>
          </li>
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">测试</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Alexander Pierce - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body -->
             
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">设置</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">注销</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
     <!-- <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div> -->

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>
        <!-- <li class="treeview">
          <a href="#"><i class="fa fa-group"></i><span>主体管理</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#">债权人管理</a></li>
            <li><a href="#">债务人管理</a></li>
            <li><a href="#">共同债务人管理</li>
          </ul>
        </li> -->
        <li class="treeview active">
          <a href="#">
            <i class="fa fa-group"></i> <span>主体管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class=><a href="list.jsp"><i class="fa fa-user"></i>债权人管理</a></li>
            <li class="<%=liClass %>"><a href="debtor.jsp"><i class="fa fa-user"></i>债务人管理</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#"><i class="fa fa-files-o"></i><span>合同管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-folder"></i>合同管理</a></li>
            <li><a href="#"><i class="fa fa-file-text"></i>司法处置记录</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#"><i class="fa fa-area-chart"></i><span>统计结算</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-line-chart"></i>概览汇总</a></li>
            <li><a href="#"><i class="fa fa-book"></i>司法处置明细</a></li>
            <li><a href="#"><i class="fa fa-desktop"></i>充值记录</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#"><i class="fa fa-cog"></i><span>系统管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-user-circle"></i>用户管理</a></li>
            <li><a href="#"><i class="fa fa-edit"></i>模板管理</a></li>
         
          </ul>
        </li>
      
      </ul>




      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h3><%=subTitle %></h3>
    
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
      <div class="row">
        <div class="col-lg-12">
          <div class="box" id="CustomerTableView">
          <div class="box-header">
            <div class="col-sm-10">
              <h3 class="box-title">债务人列表</h3>
              </div>
              <div class="col-sm-2">
              <button type="button" class="btn btn-block btn-primary btn-sm" id = "addNewCustomer">新增</button>
              </div>
            </div>
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover table-condensed table-striped">
                <thead>
                  <tr>
                    <th>名称</th>
                    <th>证件类型</th>
                    <th>证件号码</th>
                    <th>联系电话</th>
                    <th>审核状态</th>
                    <th>创建时间</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>叶泽群</td>
                    <td>身份证</td>
                    <td>330***********</td>
                    <td>181*****0676</td>
                    <td>审核通过</td>
                    <td>2018年03月16日</td>
                    <td>
                      <ol class="breadcrumb" style="padding: 0px 0px 0px 0px;margin-bottom: 0px;list-style: none;background-color: #f5f5f5;border-radius: 0px;">
                          <li><a href="#">查看</a></li>
                          <li><a href="#">授权</a></li>
                          <li><a href="#">删除</a></li>
                      </ol>
                    </td>
                  </tr>
                </tbody>
                
              </table>
            </div>
         
        </div>

        <div class="box" id="addCustomerView" style = "display: none;">
          <div class="box-header with-border">
          	<div class="col-sm-10">
          		<h3>新增债务人</h3>
  
          	</div>
          	<div class="col-sm-2">
          		<button type="button" class="btn btn-block btn-primary btn-sm" id = "returnToCustomerTable">返回</button>
          	</div>
          </div>
          
          <div class = "box-header with-border">
             <!--输入用户信息类型选择-->      
            <div class="col-sm-4">
            <h4 class="box-title">类型选择</h4>
            </div>
              <div class="col-sm-8">
              
              <label>
                <input type="radio" name="r1" class="minimal" value = "1" checked>
                  企业</label>
              <label>
                  <input type="radio" name="r1" class="minimal" value="2">
                  个人</label>
              </div>
           </div>
<!--用户信息form id代表两种身份类型 -->
        <form role="form" id="enterprise">
              
            <div class="box-header with-border">
            <h4 class="box-title col-sm-4">企业信息</h4>
            </div>
            <div class="box-body">      
             <div class="form-group">
             <label class="col-sm-4">集团名称</label>
              <div class="col-sm-8">
              <input type="text" class="form-control" style="width:50%;">
              </div>
            </div>
           <br><br>

            <div class="form-group">
              <small class="col-sm-4">统一社会代码</small>
              <div class = "col-sm-8">
                <input type="text" class="form-control" style="width: 50%;">
              </div>
            </div>
             <br><br>

            <div class="form-group"> 
                <small class="col-sm-4">营业执照照片</small>
              <div class="col-sm-8">
                <a href="javascript:;"><img src="../dist/img/Scode.png" alt=" " id="societyCodePic" onclick="fileSelect()" style="width:50%;height:50%;">
                <input type="file" class="form-control" id="societyCode" style="display: none;" onchange="previewImage(this)"
                accept="image/jpeg, image/png" />
              </a>
              </div>
            </div>
            <br><br> <br><br> <br><br> <br><br> <br><br> <br><br>
                   

            <div class="form-group">
              <small class="col-sm-4">联系手机号码</small>
              <div class = "col-sm-8">
                <input type="text" class="form-control" style="width: 50%;">
              </div>
            </div>
             <br><br>

            <div class="form-group">
              <small class="col-sm-4">公司地址</small>
              <div class = "col-sm-8">
                <input type="text" class="form-control" style="width: 50%;">
              </div>
            </div>
               <br><br>

          <div class="box-header with-border">
            <h4 class="box-title col-sm-4" style="padding-left: 3px;">企业法人信息</h4>
            </div>
            
                <div class="form-group">
              <small class="col-sm-4">姓名</small>
              <div class = "col-sm-8">
                <input type="text" class="form-control" style="width: 50%;">
              </div>
            </div>
               <br><br>
           <div class="form-group">
              <small class="col-sm-4">邮箱</small>
              <div class = "col-sm-8">
                <input type="email" class="form-control" style="width: 50%;">
              </div>
            </div>
               <br><br>

            <div class="form-group">
              <small class="col-sm-4">银行账户</small>
              <div class = "col-sm-8">
                <input type="text" class="form-control" style="width: 50%;">
              </div>
            </div>
               <br><br>

             <div class="form-group">
              <small class="col-sm-4">开户行所在地</small>
              <div class = "col-sm-8">
                <input type="text" class="form-control" style="width: 50%;">
              </div>
            </div>
               <br><br>

            <div class="form-group">
              <small class="col-sm-4">身份证号码</small>
              <div class = "col-sm-8">
                <input type="text" class="form-control" style="width: 50%;">
              </div>
            </div>
               <br><br>

               <div class="form-group"> 
                <small class="col-sm-4">身份证正面</small>
              <div class="col-sm-8">
                <a href="javascript:;"><img src="../dist/img/IDCard-front.png" alt=" " id="IDCard-frontPic01" onclick="fileSelect()" style="width:50%;height:50%;">
                <input type="file" class="form-control" id="IDCard-front01" style="display: none;" onchange="previewImage(this)"
                accept="image/jpeg, image/png" />
              </a>
              </div>
            </div>
            <br><br> <br><br> <br><br> <br><br><br>
             <div class="form-group"> 
                <small class="col-sm-4">身份证反面</small>
              <div class="col-sm-8">
                <a href="javascript:;"><img src="../dist/img/IDCard-back.png" alt=" " id="IDCard-backPic01" onclick="fileSelect()" style="width:50%;height:50%;">
                <input type="file" class="form-control" id="IDCard-back01" style="display: none;" onchange="previewImage(this)"
                accept="image/jpeg, image/png" />
              </a>
              </div>
            </div>
            <br><br> <br><br> <br><br> <br><br> <br><br> <br><br>
              </div>
            </form>

      <form role="form" id = "person" style="display: none">
          <div class="box-header with-border">
            <h4 class="box-title col-sm-4">个人信息</h4>
            </div>
            <div class="box-body">      
             <div class="form-group">
             <label class="col-sm-4">姓名</label>
              <div class="col-sm-8">
              <input type="text" class="form-control" style="width:50%;">
              </div>
            </div>
           <br><br>

           <div class="form-group">
             <label class="col-sm-4">联系电话</label>
              <div class="col-sm-8">
              <input type="text" class="form-control" style="width:50%;">
              </div>
            </div>
           <br><br>

           <div class="form-group">
             <label class="col-sm-4">邮箱</label>
              <div class="col-sm-8">
              <input type="text" class="form-control" style="width:50%;">
              </div>
            </div>
           <br><br>

           <div class="form-group">
             <label class="col-sm-4">联系地址</label>
              <div class="col-sm-8">
              <input type="text" class="form-control" style="width:50%;">
              </div>
            </div>
           <br><br>

           <div class="form-group">
             <label class="col-sm-4">银行账户</label>
              <div class="col-sm-8">
              <input type="text" class="form-control" style="width:50%;">
              </div>
            </div>
           <br><br>

           <div class="form-group">
             <label class="col-sm-4">开户行所在地</label>
              <div class="col-sm-8">
              <input type="text" class="form-control" style="width:50%;">
              </div>
            </div>
           <br><br>

           <div class="form-group">
              <small class="col-sm-4">身份证号码</small>
              <div class = "col-sm-8">
                <input type="text" class="form-control" style="width: 50%;">
              </div>
            </div>
               <br><br>


         <div class="form-group"> 
                <small class="col-sm-4">身份证正面</small>
              <div class="col-sm-8">
                <a href="javascript:;"><img src="../dist/img/IDCard-front.png" alt=" " id="IDCard-frontPic02" onclick="fileSelect()" style="width:50%;height:50%;">
                <input type="file" class="form-control" id="IDCard-front02" style="display: none;" onchange="previewImage(this)"
                accept="image/jpeg, image/png" />
              </a>
              </div>
            </div>
            <br><br> <br><br> <br><br> <br><br><br>
             <div class="form-group"> 
                <small class="col-sm-4">身份证反面</small>
              <div class="col-sm-8">
                <a href="javascript:;"><img src="../dist/img/IDCard-back.png" alt=" " id="IDCard-backPic02" onclick="fileSelect()" style="width:50%;height:50%;">
                <input type="file" class="form-control" id="IDCard-back02" style="display: none;" onchange="previewImage(this)"
                accept="image/jpeg, image/png" />
              </a>
              </div>
            </div>
            <br><br> <br><br> <br><br> <br><br> <br><br> <br><br>
              </div>
            
           </form>
            



           
            
            
            
        </div>
        </div>
      </div>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2018 <a href="#">杭州云证科技</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/adminlte.min.js"></script>
<script src="../dist/js/common-scripts.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
<script type="text/javascript">


 </script>
</body>
</html>