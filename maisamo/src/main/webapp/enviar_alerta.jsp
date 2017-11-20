<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- <meta charset="utf-8"> -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Smart Alerta!</title>
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
    <!-- Google fonts - Roboto 
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    -->
    <!-- jQuery Circle-->
    <link rel="stylesheet" href="css/grasp_mobile_progress_circle-1.0.0.min.css">
    <!-- Custom Scrollbar-->
    <link rel="stylesheet" href="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.blue.css" id="theme-stylesheet">
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
            <h2 class="h5 text-uppercase">${usuario.nome}</h2>
          </div>
          <div class="sidenav-header-logo"><a href="#" class="brand-small text-center"> <strong>S</strong><strong class="text-primary">A</strong></a></div>
        </div>
        <div class="main-menu">
          <ul id="side-main-menu" class="side-menu list-unstyled">                  
            <li> <a href="#"> <i class="fa fa-home" style="font-size: 18px"></i><span>Início</span></a></li>
            <li> <a href="#alerta" data-toggle="collapse" aria-expanded="true"><i class="fa fa-bell" style="font-size: 20px"></i><span>Alerta</span>
                <div class="arrow pull-right"><i class="fa fa-angle-down" style="font-size: 20px"></i></div></a>
              <ul id="alerta" class="list-unstyled">
	            <li> <a href="cadastrar_alerta.jsp"><i class="fa fa-plus-square" style="font-size: 18px"></i><span>Cadastrar Alerta</span></a></li>
	           	<li class="active"> <a href="enviar_alerta.jsp#"> <i class="fa fa-send" style="font-size: 16px"></i><span>Enviar Alerta</span></a></li>
	           	<li> <a href="visualizar_alertas.jsp"> <i class="fa fa-bell" style="font-size: 16px"></i><span>Ver Alertas</span></a></li>
	           	<li> <a href="alertas_enviados.jsp"> <i class="fa fa-check-square" style="font-size: 18px"></i><span>Alertas Enviados</span></a></li>
              </ul>
            </li>
            <li> <a href="#contato" data-toggle="collapse" aria-expanded="false"><i class="fa fa-address-book" style="font-size: 20px"></i><span>Contato</span>
                <div class="arrow pull-right"><i class="fa fa-angle-down" style="font-size: 20px"></i></div></a>
              <ul id="contato" class="collapse list-unstyled">
                <li> <a href="adicionar_contato.jsp"> <i class="fa fa-user-plus" style="font-size: 16px"></i><span>Adicionar Contato</span></a></li>
           		<li> <a href="visualizar_contatos.jsp"> <i class="fa fa-users" style="font-size: 16px"></i><span>Ver Contatos</span></a></li>
              </ul>
            </li>
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
              <div class="navbar-header"><a id="toggle-btn" href="#" class="menu-btn"><i class="fa fa-bars" style="font-size: 25px"> </i></a><a href="#" class="navbar-brand">
                  <div class="brand-text d-none d-md-inline-block"><strong class="text-secondary">Smart</strong><strong class="text-primary">Alerta!</strong></div></a></div>
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">                
                <li class="nav-item"><a href="login.html" class="nav-link logout">Sair<i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="breadcrumb-holder">
        <div class="container-fluid">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Início</a></li>
            <li class="breadcrumb-item active">Enviar Alerta</li>
          </ul>
        </div>
      </div>
      <section class="forms">
        <div class="container-fluid">
          <header> 
            <h1 class="h1 display">Enviar Alerta</h1>
          </header>
          <div class="row">  
            <div class="col-lg-12">
              <div class="card">
                <div class="card-header d-flex align-items-center">
                  <h2 class="h5 display display"><strong class="text-primary">Qual alerta deve ser enviado?</strong></h2>
                </div>
                <div class="card-body">                  
                  <form>
                    <div class="form-group">
                      <label>Categoria</label>                  
                      <select name="categoria" class="form-control" onchange="javascript:document.form-cat.submit()">
                       	<option></option>
	                      <%
                       		String categoria;
                      		for (int i = 0; i < 5; ++i) {
                      			categoria = "CATEGORIA " + i;
                      			out.println("<option value=\"" + categoria + "\">" + categoria + "</option>");
                      		}
	                      %>
                 	  </select>                
                    </div>
                    <div class="line"></div>
                    <div class="form-group">       
                      <label>Título</label>
                      <select name="titulo" class="form-control">
                          <option></option>
                          	<%
                          		String titulo;
	                			for (int i = 0; i < 10; ++i) {
	                				titulo = "TÍTULO " + i;
	                          		out.println("<option value=\"" + titulo + "\">" + titulo + "</option>");
	                			}
	                        %>
                        </select>
                    </div>                    
                  </form>
                </div>
              </div>
            </div>                      
            <div class="col-lg-12">
              <div class="card">
                <div class="card-header d-flex align-items-center">
                  <h2 class="h5 display"><strong class="text-primary">Quem deve receber este alerta?</strong></h2>
                </div>
                <div class="card-body">
                  <form class="form-horizontal" method="post" action="EnviarAlerta">
                    <div class="form-group row">            
                      <div class="col-sm-12 select">
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
                      <div class="col-sm-6"></div>
                      <div class="col-sm-6">
                        <button type="submit" style="float: right" class="btn btn-primary">Enviar</button>
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
              <p>Smart Alerta! &copy; 2017</p>
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