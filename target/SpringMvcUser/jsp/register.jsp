<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
      <html>
      <head>
       <!--<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">-->
          <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
          <title>Registration</title>
      </head>
      <body>
          <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
              <table align="center">
                  <tr>
                      <td>
                          <form:label path="username">User Name</form:label>
                      </td>
                      <td>
                          <form:input path="username" name="username" id="username" placeholder="User Name"/>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="password">Password</form:label>
                      </td>
                      <td>
                          <form:password path="password" name="password" id="password" placeholder="Password"/>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="firstname">First Name</form:label>
                      </td>
                      <td>
                          <form:input path="firstname" name="firstname" id="firstname" placeholder="First Name" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="lastname">Last Name</form:label>
                      </td>
                      <td>
                          <form:input path="lastname" name="lastname" id="lastname" placeholder="Last Name" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="email">Email</form:label>
                      </td>
                      <td>
                          <form:input
                          path="email" name="email" id="email" placeholder="Email" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="address">Address</form:label>
                      </td>
                      <td>
                          <form:input path="address" name="address" id="address" placeholder="Address" />
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <form:label path="phone">Phone</form:label>
                      </td>
                      <td>
                          <form:input path="phone" name="phone" id="phone" />
                      </td>
                  </tr>
                  <tr>
                      <td></td>
                      <td>
                          <form:button id="register" name="register">Register</form:button>
                      </td>
                  </tr>
                  <tr></tr>
                  <tr>
                      <td></td>
                      <td><a href="home.jsp">Home</a>
                      </td>
                  </tr>
              </table>
          </form:form>
      </body>
      </html>