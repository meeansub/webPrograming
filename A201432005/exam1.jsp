<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    table { border-collapse: collapse; }
    td { padding: 5px; border: solid 1px gray; }
</style>

</head>
<body>
<table>
<tr>
<%for(int i=2;i<=9;++i){%>
    <%if(i==6){%>
    <tr>
    <%}%>
	<td style='background-color: <%= i==2||i==4||i==7||i==9 ? "#ccffcc":"#ffffcc"%>'>
	<%for(int j=1;j<=9;++j){%>
		<%=i+"x"+j+"="%><%=i*j%><br>
	<%}%>
	</td>
	
<%}%>
</tr>
</table>

</body>
</html>