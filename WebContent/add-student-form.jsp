<html>
<head>
<title>Add Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<style>
 table {
 height: 50%;
 width: 75%;
}
</style>
</head>
<body>
	<div id="wrapper">
	  <div id="header">
	   <h2>Celal Bayar University</h2>
	  </div>
	  </div>
	  
	  
	   <h3>Ogrenci Ekle</h3>
	   
	   <div id="container">
	   <form action="StudentController" method="GET">
	   <input type="hidden" name="command" value="ADD" />
	    <table>
	     <tbody>
	      <tr>
	        <td><label>Ad:</label></td>
	        <td><input type="text" name="firstName" /></td>
	      </tr>
	      <tr>
	        <td><label>Soyad:</label></td>
	        <td><input type="text" name="lastName" /></td>
	      </tr>
	      <tr>
	        <td><label>Okul Numarasi:</label></td>
	        <td><input type="text" name="no" /></td>
	      </tr>
	      <tr>
	        <td><label>Email:</label></td>
	        <td><input type="text" name="email" /></td>
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
	   <a href="StudentController">Ogrenci listesine geri dön</a>
	   </p>
	   
	   
	  </div>
</body>
</html>