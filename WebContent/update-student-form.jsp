<html>
<head>
<title>Ogrenci Guncelle</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
	<div id="wrapper">
	  <div id="header">
	   <h2>Celal Bayar University</h2>
	  </div>
	  </div>
	  
	  <div id="container">
	   <h3>Ogrenci Guncelle</h3>
	   
	   <form action="StudentController" method="GET">
	   <input type="hidden" name="command" value="UPDATE" />
	   <input type="hidden" name="studentId" value="${the_student.id}" />
	    <table>
	     <tbody>
	      <tr>
	        <td><label>Ad:</label></td>
	        <td><input type="text" name="firstName" value="${the_student.firstName }" /></td>
	      </tr>
	      <tr>
	        <td><label>Soyad:</label></td>
	        <td><input type="text" name="lastName" value="${the_student.lastName}" /></td>
	      </tr>
	      <tr>
	        <td><label>Okul Numarasi:</label></td>
	        <td><input type="text" name="no" value="${the_student.no}"/></td>
	      </tr>
	      <tr>
	        <td><label>Email:</label></td>
	        <td><input type="text" name="email" value="${the_student.email}" /></td>
	      </tr>
	      <tr>
	      <td><label></label></td>
	      <td><input type="submit" value="Save" class="save" /></td>	
	      </tr>
	     </tbody>
	    </table>
	  
	  
	   </form>
	   <div style="clear:both;"></div>
	   
	   <p>
	   <a href="StudentController">Ogrenci listesine geri don</a>
	   </p>
	   
	   
	  </div>
</body>
</html>