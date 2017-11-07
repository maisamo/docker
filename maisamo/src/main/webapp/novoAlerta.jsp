<%@page import="pds.web.maisamo.model.TipoAlerta"%>
<%@page import="pds.web.maisamo.DAO.TipoAlertaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Maisamo</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="bootstrap4/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="container-fluid" style="background-color: #42f4b3">
		<div class="container">
			<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
			  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <a class="navbar-brand" href="#"><img alt="logo" src="img/logo1.png"></a>

			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <!-- <ul class="navbar-nav mr-auto">
			      <li class="nav-item active">
			        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="#">Link</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link disabled" href="#">Disabled</a>
			      </li>
			    </ul> -->
			      <button class="btn btn-outline-success my-2 my-sm-0 ml-auto p-2" type="submit">ADMINISTRADOR | <i class="fa fa-sign-out" aria-hidden="true"></i></button>
			    
			  </div>
			</nav>
			<div class="row p-3">
				<!-- menu -->
	  			<div class="d-inline-flex mr-2 col-3" style="background-color: #f7f7f7; height: 800px;">
	  				<ul class="nav flex-column">
					  <li class="nav-item">
					    <a class="nav-link active" href="index.jsp"><div class="btn btn-outline-primary">Pacientes <i class="fa fa-users" aria-hidden="true"></i></div></a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" href="novoAlerta.jsp"><div class="btn btn-outline-primary">Novo alerta <i class="fa fa-warning" aria-hidden="true"></i></div></a>
					  </li>
					  <!--
					  <li class="nav-item">
					    <a class="nav-link" href="#">Link</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link disabled" href="#">Disabled</a>
					  </li> -->
					</ul>
	  			</div>
	  			<!-- conteudo -->
	  			<div class="col" style="background-color: #f7f7f7; height: 800px;">
  					<nav class="breadcrumb mt-1">
					  <a class="breadcrumb-item" href="index.jsp">Home</a>
					  <span class="breadcrumb-item active">Novo Alerta</span>
					</nav>
	  				<form method="post" action="SendMensager">
	  					<div class="form-group">
						    <label for="exampleSelect1">Paciente</label>
					    	<select class="form-control" id="exampleSelect1" name="tipo_alerta">
					      		<option> </option>
					      		<%TipoAlertaDAO dao = new TipoAlertaDAO();
						    		for(TipoAlerta tipo:dao.listar()){%>
					      		<option value="<%=tipo.getId() %>"><%=tipo.getNome() %></option>
					      		<%} %>
					    	</select>
					  	</div>
					  	<div class="form-group">
						    <label for="exampleInputEmail1">E-mail</label>
						    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="paciente@alerta.com">
					  	</div>
					  	<div class="form-group">
						    <label for="exampleInputPassword1">Telefone</label>
						    <input type="password" class="form-control" id="exampleInputPassword1" name="telefone" placeholder="Ex.: 99999-8888 ou 3333-2222">
					  	</div>
					  	<div class="form-group">
						    <label for="exampleSelect1">Tipo de Alerta</label>
					    	<select class="form-control" id="exampleSelect1" name="tipomensagem">
					    		<option> </option>
					      		<option>EXAME</option>
					      		<option>CONSULTA</option>
					      		<option>PREPARATÓRIO</option>
					    	</select>
					  	</div>
					  	<div class="form-group">
						    <label for="exampleSelect1">Intervalo</label>
					    	<select class="form-control" id="exampleSelect1" name="interAlerta">
					    		<option> </option>
					      		<option>de 10 em 10 minutos</option>
					      		<option>de 30 em 30 minutos</option>
					      		<option>de 45 em 45 minutos</option>
					    	</select>
					  	</div>
					  	<div class="form-group">
						    <label for="exampleTextarea">Mensagem</label>
						    <textarea class="form-control" id="exampleTextarea" name="descricao" rows="5"></textarea>
					  	</div>
					  	<input style="float:right" type="submit" class="btn btn-success" value="Concluir">
					</form>
	  			</div>
			</div>
			<div class="row">
				<div class="col mr-3 ml-3 pb-2 text-center" style="background-color: #f7f7f7">
					<div class="col mt-3"><span><i class="fa fa-copyright" aria-hidden="true"></i> 2017 - Liga Contra o Câncer - Todos os Direitos Reservados</span></div>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>