<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript"> 

</script> 

<style>
body { font-family: 굴림체; }
input.form-control { width: 200px; }
</style>
</head>
<body>
<%
String text1 = request.getParameter("text1");
int number1;
if(text1==null)text1="0";
else{
 number1= Integer.parseInt(text1);
 number1+=1;
 text1=Integer.toString(number1);

}
   
%>
  <div class="container">
<form>

      <div class="form-group">
        <label>number1:</label> 
        <input type="text" name="text1" class="form-control" value="<%= text1%>" />
      </div>

      <div class="form-group">
        <input type="submit" class="btn btn-primary" name="cmd" value="확인"/>
        
      </div>
    </form>
  </div>
 
  
   
</body>
</html>
