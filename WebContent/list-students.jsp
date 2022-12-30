<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css" >
<title>app</title>
<style>
 table {
	width: 250px;
	height:150px;
}
</style>


</head>
<body>
 
 	<div id="wrapper">
 	 <div id="header">
        <h2>Celal Bayar University</h2> 	 
 	 </div>
 	</div>
 	
 	<div id="container">
 	    <div id="content">
        <table>
 	    <tr>
 	    <th>Ad</th>
 	    <th>Soyad</th>
 	    <th>Ogrenci no</th>
 	    <th>Email</th>
 	    <th>Degisiklik</th>
 	    </tr>
 	    <c:forEach var="tempStudent" items="${STUDENT_LIST}">
 	              
 	              <c:url var="link" value="StudentController">
 	               <c:param name="command" value="LOAD"/>
 	               <c:param name="studentId" value="${tempStudent.id}"/>
 	              </c:url>
 	              
 	              <c:url var="deleteLink" value="StudentController">
 	                  <c:param name="command" value="DELETE"/>
 	                  <c:param name="studentId" value="${tempStudent.id}"/>
 	              </c:url>
 	              
 	              
 	               	<tr>
						<td> ${tempStudent.firstName}</td>
						<td> ${tempStudent.lastName}</td>
						<td> ${tempStudent.no}</td>
						<td> ${tempStudent.email}</td>
						<td> <a href="${link}">Guncelle</a> |
						     <a href="${deleteLink}" onclick="if (!(confirm('Bu ogrenciyi silmek istediginize emin misiniz?')))return false">Sil</a>  
                        </td>
						
					</tr>
				
				</c:forEach>
 	    </table>
 	    <input type="button" value="Ogrenci Ekle" onclick="window.location.href='add-student-form.jsp';return false;" class="add-student-button"/>
 	    </div>
        	
 	</div>

</body>

</html>