<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <html>
      <head>
         <link rel="StyleSheet" href="style.css"/>
          <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
          <link rel="StyleSheet" href="main.css"/>
          <title>Login</title>
      </head>
      <body>
      <h3 align="center"> Welcome to Inventory System</h3>
          <form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
              <table align="center">
               <tr>
               <td></td>
                      <td>
                          <form:label path="username">User Name</form:label>
                      </td>
                      </tr>
                  <tr>
                  <td></td>
                      <td>
                          <form:input path="username" name="username" id="username" placeholder="User Name"/>
                      </td>
                  </tr>
                  <tr>
                  <td></td>
                      <td>
                          <form:label path="password">Password </form:label>
                      </td>
                      </tr>
                      <tr>
                   <td></td>
                      <td>
                          <form:password path="password" name="password" id="password" placeholder="Password"/>
                      </td>
                  </tr>
                  <tr>
                   <td></td>
                      <td align="center">
                          <form:button id="login" name="login">Login</form:button>
                      </td>
                  </tr>
                  <tr></tr>
                  <tr>
                      <td></td>
                      <td>New User? <a href="register">Create an Account</a>
                      </td>
                  </tr>
              </table>
          </form:form>
          <table align="center">
              <tr>
                  <td style="font-style: italic; color: red;">${message}</td>
              </tr>
          </table>
      </body>
      </html>