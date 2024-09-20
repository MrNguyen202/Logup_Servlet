<%@ page import="hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.entities.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.entities.Role" %><%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 9/8/2024
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Account account = (Account) session.getAttribute("account");
    String role = (String) session.getAttribute("GrantAccessOfAccount");
%>
<h1>User:  <%=account.getFullName()%>
</h1>
<div>
    <ul>
        <li><a href="controller?action=InfAccount">Account</a></li>
        <li><a href="controller?action=addAccount">Add account</a></li>
        <li><a href="controller?action=listRole">List Role</a></li>
        <% if (role.equals("admin")) { %>
            <li><a href="controller?action=listAccount">List Account</a></li>
        <% } %>
        <li><a href="controller?action=logout">Logout</a></li>
    </ul>
    <table>
        <tr>
            <th>STT</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th>Fullname</th>
            <th>Role</th>
            <th>Action</th>
        </tr>

    </table>
</div>

</body>
</html>
