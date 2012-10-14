<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>



<table bordercolor="BLACK">
	<thead>
		<th>Name (Short Name)</th>
		<th>Account Number</th>		
		<th>Transactions</th>
		<th>Edit</th>
	</thead>
	<c:forEach items="${accounts}" var="account">
    <tr>
      	<td><c:out value="${account.name} (${account.shortName})"/></td>
	  	<td><c:out value="${account.accountNum}"/></td>
      	<td>
			<a href="transactionList.htm?accountId=${account.id}">List transactions</a> 
		</td>
		

      
		<td>
        	<form method="GET" action="<c:url value="/editAccount.htm"/>">
          		<input type="hidden" name="accountId" value="${account.id}"/>
          		<p class="submit"><input type="submit" value="Edit"/></p>
        	</form>
      	</td>                  	
	</tr>
    </c:forEach>
</table>
<p></p>
<a href="createAccount.htm">Create a new Account</a>
  
  


<%@ include file="/WEB-INF/jsp/footer.jsp" %>