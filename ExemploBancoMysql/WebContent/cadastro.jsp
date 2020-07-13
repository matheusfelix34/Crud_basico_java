<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crud Basico</title>
</head>
<body>


<form name="form1" method="get" action="/ExemploBancoMysql/inserir">
<h1>CADASTRO:</h1>

	Nome <input type="text" name="nome"> <br><br>
	
	Endereço <input type="text" name="endereco"><br><br>
	
	Código <input type="text" name="codigo"><br><br>
	
	
	
	<input type="submit" value="Enviar"> <input type="reset" value="Limpar">

</form>
<br>
-------------------------------------------------------------------------------------
<form name="form2" method="get" action="/ExemploBancoMysql/ConsultarAlunosrv">
<h1>CONSULTAR:</h1>

	
	
	
	Código <input type="text" name="codigo_consulta"><br><br>
	<input type="submit" value="Consultar"> 
</form>
-------------------------------------------------------------------------------------
<br>

<form name="form3" method="get" action="/ExemploBancoMysql/ExcluirAlunosrv">
<h1>EXCLUIR:</h1>

	
	
	Código <input type="text" name="codigo_excluir"><br><br>
	
	<input type="submit" value="excluir"> 
</form>
-------------------------------------------------------------------------------------
<br>
<form name="form4" method="get" action="/ExemploBancoMysql/AlterarAlunosrv">
<h1>ALTERAR:</h1>

	Código <input type="text" name="codigo_alterar"><br><br>
	
	Nome <input type="text" name="nome_alterar"><br><br>
	
	Endereço <input type="text" name="endereco"><br><br>
	
	<input type="submit" value="alterar"> 
</form>
</body>
</html>