<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty sessionScope.usuario}">
	<c:redirect url="/acesso_negado.jsp" context="/maisamo"/>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Smart Alerta!</title>
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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
  </head>
  <body>
    <!-- Side Navbar -->
    <nav class="side-navbar">
      <div class="side-navbar-wrapper">
        <div class="sidenav-header d-flex align-items-center justify-content-center">
          <div class="sidenav-header-inner text-center"><img src="img/avatar-1.jpg" alt="person" class="img-fluid rounded-circle">
            <h2 class="h5 text-uppercase">${usuario.nome}</h2>
          </div>
          <div class="sidenav-header-logo"><a href="index.html" class="brand-small text-center"> <strong>S</strong><strong class="text-primary">A</strong></a></div>
        </div>
        <div class="main-menu">
          <ul id="side-main-menu" class="side-menu list-unstyled">
            <li> <a href="#"> <i class="fa fa-home" style="font-size: 22px"></i><span>Início</span></a></li>
            <li> <a href="#alerta" data-toggle="collapse" aria-expanded="true"><i class="fa fa-bell" style="font-size: 20px"></i><span>Alerta</span>
                <div class="arrow pull-right"><i class="fa fa-angle-down" style="font-size: 20px"></i></div></a>
              <ul id="alerta" class="list-unstyled">
	            <li> <a href="cadastrar_alerta.jsp"><i class="fa fa-plus-square" style="font-size: 18px"></i><span>Cadastrar Alerta</span></a></li>
	           	<li> <a href="enviar_alerta.jsp"> <i class="fa fa-send" style="font-size: 16px"></i><span>Enviar Alerta</span></a></li>
	           	<li class="active"> <a href="VerAlertas#"> <i class="fa fa-bell" style="font-size: 16px"></i><span>Ver Alertas</span></a></li>
	           	<li> <a href="AlertasEnviados"> <i class="fa fa-check-square" style="font-size: 18px"></i><span>Alertas Enviados</span></a></li>
              </ul>
            </li>
            <li> <a href="#contato" data-toggle="collapse" aria-expanded="false"><i class="fa fa-address-book" style="font-size: 20px"></i><span>Contato</span>
                <div class="arrow pull-right"><i class="fa fa-angle-down" style="font-size: 20px"></i></div></a>
              <ul id="contato" class="collapse list-unstyled">
                <li> <a href="adicionar_contato.jsp"> <i class="fa fa-user-plus" style="font-size: 16px"></i><span>Adicionar Contato</span></a></li>
           		<li> <a href="VerContatos"> <i class="fa fa-users" style="font-size: 16px"></i><span>Ver Contatos</span></a></li>
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
            <li class="breadcrumb-item active">Alertas</li>
          </ul>
        </div>
      </div>
      <section class="forms">
        <div class="container-fluid">
          <header> 
            <h1 class="h1 display">Alertas</h1>
          </header>
          <div class="row">  
            <div class="col-lg-12">
              <div class="card">
                <div class="card-body">                  
                  <table id="example" class="display" cellspacing="0" width="100%">
                    <thead>
                      <tr>
                        <th>Categoria</th>
                        <th>Título</th>
                        <th>Mensagem</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>Categoria</th>
                        <th>Título</th>
                        <th>Mensagem</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                      </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="alerta" items="${alertas}">
                      <tr>
                        <td>${alerta.categoria}</td>
                        <td>${alerta.titulo}</td>
                        <td>${alerta.mensagem}</td>
                        <td><button name="${alerta.id}" type="button" data-toggle="modal" data-target="#editar_modal" class="btn btn-outline-info">Editar</button></td>
                        <td><button name="${alerta.id}" type="button" data-toggle="modal" data-target="#excluir_modal" class="btn btn-outline-danger">Excluir</button></td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            
            <!-- editar Modal-->
            <div id="editar_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
              <div role="document" class="modal-dialog modal-lg">
                <div class="modal-content">
                  <div class="modal-header">
                    <h3 id="exampleModalLabel" class="modal-title text-primary"><strong class="text-primary">Editar Alerta</strong></h3>
                    <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">&times;</span></button>
                  </div>
                  <div class="modal-body" >
                    <form method="post" action="EditarAlerta">
                      <div class="form-group">
                        <label>Categoria</label>
                        <input name="categoria" type="text" value="${editar_alerta.categoria}" class="form-control">
                      </div>
                      <div class="line"></div>
                      <div class="form-group">       
                        <label>Título</label>
                        <input name="titulo" type="text" value="${editar_alerta.titulo}" class="form-control">
                      </div>     
                      <div class="line"></div>
	                  <label>Mensagem</label>
	                  <div id="summernote"><p>${editar_alerta.mensagem}</p></div>
	                  <input name="mensagem" type="hidden">
                    </form>
                  </div>
                  <div class="modal-footer">
	               	<button type="button" style="float:left" data-dismiss="modal" class="btn btn-secondary">Cancelar</button>  
	                <button type="submit" style="float:right" class="btn btn-primary">Salvar</button>
                  </div>
                </div>
              </div>
            </div>  
            <!-- atualizado Modal-->
            <div id="excluir_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
              <div role="document" class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h3 id="exampleModalLabel" class="modal-title"><strong class="text-success">Alerta atualizado!</strong></h3>
                    <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">&times;</span></button>
                  </div>
                  <div class="modal-body">
                  	<h4>As mudanças foram salvas.</h4>
                  </div>
                  <div class="modal-footer">
                    <button type="button" style="float:left" data-dismiss="modal" class="btn btn-secondary">Fechar</button>
                  </div>
                </div>
              </div>
            </div> 
            
            <!-- excluir Modal-->
            <div id="excluir_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
              <div role="document" class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h3 id="exampleModalLabel" class="modal-title"><strong class="text-danger">Excluir Alerta</strong></h3>
                    <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">&times;</span></button>
                  </div>
                  <div class="modal-body">
                  	<h4>Você está prestes a excluir este <b>Alerta</b>.
	      			Esta ação não poderá ser revertida, deseja prosseguir?</h4>
                  </div>
                  <div class="modal-footer">
                    <button type="button" style="float:left" data-dismiss="modal" class="btn btn-secondary">Não</button>
                    <button type="button" onclick="window.location.href='ExcluirAlerta'" style="float:right" class="btn btn-primary">Sim</button>
                  </div>
                </div>
              </div>
            </div>
            <!-- excluído Modal-->
            <div id="excluido_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
              <div role="document" class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h3 id="exampleModalLabel" class="modal-title"><strong class="text-primary">Alerta Excluído</strong></h3>
                    <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">&times;</span></button>
                  </div>
                  <div class="modal-footer">
                    <button type="button" style="float:right" data-dismiss="modal" class="btn btn-secondary">Fechar</button>
                  </div>
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
              <p>Design by <a href="#" class="external">DevOps Group</a></p>
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
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote-bs4.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote-bs4.js"></script>
    <script>
      $('#summernote').summernote({
        height: 200,                 // set editor height
        minHeight: null,             // set minimum height of editor
        maxHeight: null,             // set maximum height of editor
        focus: true                  // set focus to editable area after initializing summernote
      });
      $( "#form_alerta" ).submit(function( event ) {
    	  $('input[name="mensagem"]').val($('#summernote').summernote('code'));
    	});
      $('input[name="mensagem"]').val($('#summernote').summernote('code'));
    </script> 
    <script>
      $(document).ready(function() {
        $('#example').DataTable({
          "language": {
            "sEmptyTable": "Nenhum registro encontrado",
            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
            "sInfoPostFix": "",
            "sInfoThousands": ".",
            "sLengthMenu": "_MENU_ resultados por página",
            "sLoadingRecords": "Carregando...",
            "sProcessing": "Processando...",
            "sZeroRecords": "Nenhum registro encontrado",
            "sSearch": "Pesquisar",
            "oPaginate": {
              "sNext": "Próximo",
              "sPrevious": "Anterior",
              "sFirst": "Primeiro",
              "sLast": "Último"
            },
            "oAria": {
              "sSortAscending": ": Ordenar colunas de forma ascendente",
              "sSortDescending": ": Ordenar colunas de forma descendente"
            }
          }
        });
      });
    </script>    
    <!-- Google Analytics: change UA-XXXXX-X to be your site's ID.-->
  </body>
</html>
