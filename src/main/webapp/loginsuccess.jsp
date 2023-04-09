<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
<script>
function validateForm() {
  let x = document.forms["myForm"]["t1"].value;
  let y = document.forms["myForm"]["t2"].value;
  let op = document.forms["myForm"]["btn"].value;

  if (x == ""&& y == "") {
    alert("Values must be filled out");
    return false;
  }
  if (y = ""&& op.equals("/")) {
	    alert("Invalid infinity");
	    return false;
	  }
}
</script>
</head>
<body>
<div align="center">
<form method="post" action="calculator" name="myForm" onsubmit="return validateForm()">
Number 1 <input type="text" name="t1" oninput="myFunction1()"><br>
<br>
Number 2 <input type="text" name="t2"><br><br>
Result 
<input type="text" id="result" name="result" defaultValue="0" value="<%=request.getAttribute("result") %>">
<br><br>
<input type="submit" value="+" name="btn">
<input type="submit" value="-" name="btn">
<input type="submit" value="*" name="btn">
<input type="submit" value="/" name="btn">
<input type="Reset" value="Reset" onClick="myFunction()">

</form>
</div>
  <script>
function myFunction(){
    document.getElementByName("myForm").(reset);
    document.form.reset();
    document.getElementById("result").value = '0';
}
function myFunction1(){
    //document.getElementByName("myForm").(reset);
    document.getElementById("result").value = '0';
}
</script>
</body>
</html>