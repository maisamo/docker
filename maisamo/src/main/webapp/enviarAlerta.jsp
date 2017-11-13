<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- <meta charset="utf-8"> -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Smart Alerta</title>
    <!-- <base href="/bootstrap-dashboard/"> -->
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Roboto -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <!-- jQuery Circle-->
    <link rel="stylesheet" href="css/grasp_mobile_progress_circle-1.0.0.min.css">
    <!-- Custom Scrollbar-->
    <link rel="stylesheet" href="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="favicon.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    <link rel="stylesheet" type="text/css" href="framework/demo-framework.css" />
    <script src="https://code.angularjs.org/1.2.9/angular.js"></script>
    <script src="js/angular-drag-and-drop-lists.js"></script>
  </head>
  <body>
    <!-- Side Navbar -->
    <nav class="side-navbar">
      <div class="side-navbar-wrapper">
        <div class="sidenav-header d-flex align-items-center justify-content-center">
          <div class="sidenav-header-inner text-center"><img src="img/avatar-1.jpg" alt="person" class="img-fluid rounded-circle">
            <h2 class="h5 text-uppercase">Seu José</h2>
          </div>
          <div class="sidenav-header-logo"><a href="#" class="brand-small text-center"> <strong>S</strong><strong class="text-primary">A</strong></a></div>
        </div>
        <div class="main-menu">
          <ul id="side-main-menu" class="side-menu list-unstyled">                  
            <li><a href="#"> <i class="icon-home"></i><span>Home</span></a></li>
            <li> <a href="cadastrarAlerta.jsp"><i class="icon-bill"></i><span>Cadastrar Alerta</span></a></li>
            <li class="active"> <a href="enviarAlerta.jsp"> <i class="icon-mail"></i><span>Enviar Alerta</span></a></li>
          </ul>
        </div>        
      </div>
    </nav>
    <div class="page forms-page">
      <!-- navbar-->
      <header class="header">
        <nav class="navbar">
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <div class="navbar-header"><a id="toggle-btn" href="#" class="menu-btn"><i class="icon-bars"> </i></a><a href="#" class="navbar-brand">
                  <div class="brand-text d-none d-md-inline-block"><span>SMART </span><strong class="text-primary">ALERTA</strong></div></a></div>
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">                
                <li class="nav-item"><a href="login.html" class="nav-link logout">Logout<i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="breadcrumb-holder">
        <div class="container-fluid">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item active">Enviar Alerta</li>
          </ul>
        </div>
      </div>
      <section class="forms">
        <div class="container-fluid">
          <header> 
            <h1 class="h3 display">ENVIAR ALERTA</h1>
          </header>
          <div class="row">  
            <div class="col-lg-12">
              <div class="card">
                <div class="card-header d-flex align-items-center">
                  <h2 class="h5 display display">Escolha a categoria</h2>
                </div>
                <div class="card-body">                  
                  <form>
                    <div class="form-group">
                      <label>Categoria</label>                      
                      <select name="account" class="form-control">
                        <option></option>
                        <option>EXAME</option>
                        <option>CONSULTA</option>
                        <option>PROCEDIMENTO</option>
                        <option>CANCELAMENTO</option>
                      </select>                      
                    </div>
                    <div class="form-group">       
                      <label>Mensagem</label>
                      <select name="account" class="form-control">
                          <option></option>
                          <option>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</option>
                          <option>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</option>
                          <option>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</option>
                          <option>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</option>
                        </select>
                    </div>                    
                  </form>
                </div>
              </div>
            </div>                      
            <div class="col-lg-12">
              <div class="card">
                <div class="card-header d-flex align-items-center">
                  <h2 class="h5 display">Selecione quem vai receber a mensagem</h2>
                </div>
                <div class="card-body">
                  <form class="form-horizontal">
                    <div class="form-group row">            
                      <div class="col-sm-10 select">
                        <div ng-app="demo">
                          <div ng-controller="DemoController" class="row">
                            <div ng-repeat="list in model" class="col-sm-6">
                              <div class="panel panel-info">
                                <div class="panel-heading"><h3 class="panel-title">List {{$index+1}}</h3></div>
                                <div class="panel-body">
                                  <ul dnd-list dnd-drop="callback({targetList: list, targetIndex: index})">
                                    <li ng-repeat="item in list"
                                        dnd-draggable="null" dnd-callback="onDrop(list, $index, targetList, targetIndex)">
                                      {{item.labelFunc($index)}}
                                    </li>
                                  </ul>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>                                               
                      </div>                      
                    </div>                                       
                    <div class="line"></div>
                    <div class="form-group row">
                      <div class="col-sm-4">
                        <button type="submit" class="btn btn-secondary">Cancel</button>
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <footer class="main-footer">
        <div class="container-fluid">
          <div class="row">
            <div class="col-sm-6">
              <p>Smart Alerta &copy; 2017-2019</p>
            </div>
            <div class="col-sm-6 text-right">
              <p>Design by <a href="#" class="external">Devops Group</a></p>
              <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
            </div>
          </div>
        </div>
      </footer>
    </div>
    <!-- Javascript files-->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
    <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/front.js"></script>    
    <!-- angular is the only dependency! -->
    
    <!-- <script src="js/angular-drag-and-drop-lists.js"></script> -->
  </body>
</html>