<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.net.*, f201432005.*,java.text.*"%>
<%
request.setCharacterEncoding("UTF-8");

String 에러메시지 = null;
String s1 = request.getParameter("id");
int id = Integer.parseInt(s1);
String pg = request.getParameter("pg");

Book book = null;
if (request.getMethod().equals("GET")) {
    book = BookDAO.findOne(id);
}
else {
   book= new Book();
   book.setId(id);
   book.setTitle(request.getParameter("title"));
   book.setAuthor(request.getParameter("author"));
   String s2 =request.getParameter("categoryId");
   book.setCategoryId(ParseUtils.parseInt(s2, 0));
   String s3 =request.getParameter("publisherId");
   book.setPublisherId(ParseUtils.parseInt(s3, 0));
   String s4 =request.getParameter("price");
   book.setPrice(ParseUtils.parseInt(s4, 0));
   String s5 =request.getParameter("available");
   book.setAvailable(s5 !=null);
   if (book.getTitle() == null || book.getTitle().length() == 0) 
       에러메시지 = "제목 입력하세요";
   else if (book.getAuthor() == null || book.getAuthor().length() == 0) 
       에러메시지 = "저자를 입력하세요";
   else if (book.getPrice()<=0) 
       에러메시지 = "가격 입력하세요";
  
   else {
       BookDAO.update(book);
       response.sendRedirect("list3.jsp?pg=" + pg);
       return;
   }
}
%>

<html>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
      body { font-family: 굴림체; }
      input.form-control, select.form-control { width: 200px; }
  </style>
</head>
<div class="container">

<h1>책수정</h1>
<hr />

<form method="post">
  <div class="form-group">
    <label>제목</label>
    <input type="text" class="form-control" name="title" 
           value="<%= book.getTitle() %>" />
  </div>
  
  <div class="form-group">
    <label>저자</label>
    <input type="text" class="form-control" name="author" value="<%= book.getAuthor() %>" />
  </div>
  
  <div class="form-group">
    <label>카테고리</label>
    <select class="form-control" name="categoryId">
      <% for (Category c : CategoryDAO.findAll()) { %>
          <% String selected = book.getCategoryId()==c.getId() ? "selected" : ""; %>
          <option value="<%= c.getId() %>" <%= selected %>>
            <%= c.getCategoryName() %>
          </option>
      <% } %>
    </select>
  </div>
  
  <div class="form-group">
    <label>출판사</label>
    <select class="form-control" name="publisherId">
      <% for (Publisher p : PublisherDAO.findAll()) { %>
          <% String selected = book.getPublisherId()==p.getId() ? "selected" : ""; %>
          <option value="<%= p.getId() %>" <%= selected %>>
            <%= p.getTitle() %>
          </option>
      <% } %>
    </select>
  </div>
  
  <div class="form-group">
    <label>가격</label>
    <input type="number" class="form-control" name="price" value="<%=book.getPrice() %>" />
  </div>
  
  <div class="form-group">
    <label>대여가능</label>
    <input type="checkBox" name="available" value=<%=book.getAvailable() %>
    <%=book.getAvailable()==true?"checked":""%>>
  </div>
  
  <button type="submit" class="btn btn-primary">
    <i class="glyphicon glyphicon-ok"></i> 저장
  </button>
  
  <a href="delete1.jsp?id=<%=id%>&pg=<%=pg%>" 
     class="btn btn-danger" onclick="return confirm('삭제하시겠습니까?')">
    <i class="glyphicon glyphicon-trash"></i> 삭제
  </a>
  
  <a href="list3.jsp?pg=<%= pg %>" 
     class="btn btn-default">
    <i class="glyphicon glyphicon-list"></i> 목록으로
  </a>
</form>

<hr />
<% if (에러메시지 != null) { %>
  <div class="alert alert-danger">
    등록 실패: <%= 에러메시지 %>
  </div>
<% } %>
</div>



</body>
</html>