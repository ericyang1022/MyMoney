<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>
  <c:when test="${account.shortName!=''}">
    <h2>Transactions : ${account.shortName}</h2>
  </c:when>
  <c:otherwise>
    <h2>Transactions : ${account.name}</h2>
  </c:otherwise>
</c:choose>

<table bordercolor="BLACK">
	<thead>
		<th>Date</th>
		<th>Category</th>		
		<th>Sub Category</th>
		<th>Description</th>
		<th>Payee</th>
		<th>Amount</th>	
	
	</thead>
	<c:forEach items="${account.transactions}" var="transaction">
    <tr>
      	<td><fmt:formatDate value="${transaction.date}" pattern="yyyy-MM-dd"/></td>
	  	<td><c:out value="${transaction.category}"/></td>
	  	<td><c:out value="${transaction.subCategory}"/></td>
	  	<td><c:out value="${transaction.description}"/></td>
	  	<td><c:out value="${transaction.payee}"/></td>
	  	<td><c:out value="${transaction.amount}"/></td>      	                 
	</tr>
    </c:forEach>
</table>
<p></p>
<a href="createTransaction.htm?accountId=${account.id}">Enter transaction</a> 

  
  


<%@ include file="/WEB-INF/jsp/footer.jsp" %>