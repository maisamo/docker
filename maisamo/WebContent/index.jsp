<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MaisAmo</title>
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
					    <a class="nav-link active" href="#"><div class="btn btn-outline-primary" href="#">Selecionar pacientes <i class="fa fa-users" aria-hidden="true"></i></div></a>
					  </li>
					  <!-- <li class="nav-item">
					    <a class="nav-link" href="#">Link</a>
					  </li>
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
					  <a class="breadcrumb-item" href="index.html">Home</a>
					  <span class="breadcrumb-item active">Pacientes</span>
					</nav>
	  				<table class="table table-hover">
					  <thead>
					    <tr>
					      <th>#</th>
					      <th>Nome</th>
					      <th>Cpf</th>
					      <th>Selecionar</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row">1</th>
					      <td>Mark</td>
					      <td>327.466.765-08</td>
					      <td><input type="checkbox" aria-label="Checkbox for following text input"></td>
					    </tr>
					    <tr>
					      <th scope="row">2</th>
					      <td>Jacob</td>
					      <td>842.465.333-51</td>
					      <td><input type="checkbox" aria-label="Checkbox for following text input"></td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td>Larry the Bird</td>
					      <td>451.516.831-28</td>
					      <td><input type="checkbox" aria-label="Checkbox for following text input"></td>
					    </tr>
					  </tbody>
					</table>
	  			</div>
			</div>
			<div class="row">
				<div class="col mr-3 ml-3 pb-2 text-center" style="background-color: #f7f7f7">
					<div class="col mt-3"><span><i class="fa fa-copyright" aria-hidden="true"></i> 2017 -Liga Contra o Câncer - Todos os Direitos Reservados</span></div>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>