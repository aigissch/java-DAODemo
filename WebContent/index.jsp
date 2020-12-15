<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="dao.*"%>
<%@page import="models.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DAO Demo - Empresa y empleados</title>
</head>
<body>
	<center>
		<h1>Práctica Patrón DAO</h1>
	</center>
	<hr>

	<h2>Lista de empleados</h2>
	<ul>
	<!-- Propiedad getAllStaff implica poner empl.allStaff -->
		<jsp:useBean id="empls" class="dao.StaffDAOImpl"></jsp:useBean>
		<c:forEach items="${empls.allStaff}" var="staff">
		<li title="Editar Empleado"> 
		<a href="SaveUpdateController?idStaffUpdate=${staff.id}">
		<c:out value="${staff.name}"> </c:out>
		</a>
		</li>
		</c:forEach>	
	</ul>
	 
	 

	
	
	<h2>Añadir un empleado</h2>
	<form action="SaveUpdateController" method="post">
 		<label for="nombre">Nombre: </label>
		<input type="text" id="nombre" name="nombre" value="${staff.name}" required>
		<input type="hidden" value="" name="idEmpleado" value="${staff.id}">
		<br/>
		
		<label for="department">Department</label>
		<select id="department" name="idDepartment" required>
			<option>
			</option>
			<jsp:useBean id="dpto" class="dao.DepartmentDAOImpl"></jsp:useBean>
			<c:forEach items="${dpto.departments}" var="department">
				<option value="${department.idDepartment}" 
					<c:if  test="${department.idDepartment eq staff.idDepartment}"> selected="selected" </c:if>>
					<c:out value="${department.nameDepartment}"> </c:out> </option>
			</c:forEach>
		</select>
		<br/>

 
 		<label>Gender</label>
		<br>
		<label for="male"> Male</label>
		<input type="radio" id="male" name="gender" value="MALE" required="required" 
			<c:if test="${staff.gender eq 'MALE'}">checked </c:if>>
		
		<label for="female"> Female</label>
		<input type="radio" id="female" name="gender" value="FEMALE" required 
			<c:if test="${staff.gender eq 'FEMALE'}">checked </c:if>>
		<br>
 
	 
		<input type="submit"  value="Crear/Actualizar Empleado">
	</form>
		
</body>
</html>
