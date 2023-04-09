<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script>
function validateForm() {
  let x = document.forms["myForm"]["username"].value;
  let y = document.forms["myForm"]["password"].value;
  if (x == ""&& y == "") {
    alert("Values must be filled out");
    return false;
  }
}
</script>
</head>
<body>
<div align="center">
  <h1>Employee Login Form</h1>
  <form action="<%=request.getContextPath()%>/login" method="post" name="myForm" onsubmit="return validateForm()">
   <table style="with: 100%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
   <input type="Reset" value="Reset" onClick="myFunction()">
  </form>
  <script>
function myFunction(){
    document.getElementByName("myForm").(reset);
}
</script>
 </div>
</body>
</html>