<%@ include file="/WEB-INF/jsp/header.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Enter a new transaction</h2>

<form:form modelAttribute="transaction">

	<table >
		<tr>
			<td>Account: </td>
			<td>${transaction.account.displayName}</td>
		</tr>

		<tr>
			<td>Date:</td> 
			<td><form:input path="date" size="20" maxlength="30" /></td>
		</tr>

		<tr>
			<td>Category: </td>
			<td><form:input path="category" size="20" maxlength="30" /></td>
		</tr>
		
		<tr>
			<td>Sub Category:</td>
			<td><form:input path="subCategory" size="20" maxlength="30" /></td>
		</tr>
		
		<tr>
			<td>Description: </td>
			<td><form:input path="description" size="20" maxlength="30" /></td>
		</tr>
		
		<tr>
			<td>Payee: </td>
			<td><form:input path="payee" size="20" maxlength="30" /></td>
		</tr>
		
		<tr>
			<td>Amount: </td>
			<td><form:input path="amount" size="10" maxlength="10" /></td>
		</tr>
		</table>
		<table class="table-buttons">
		<tr>
			<td>
				<p class="submit"><input type="submit" value="Add" /></p>
					
			</td>
			<td>
				<p class="submit"><INPUT TYPE="button" VALUE="Cancel" onclick="document.location ='transactionList.htm?accountId=${transaction.account.id}'"></p>
			</td>
		</tr>
		<tr>

		</tr>
		
	</table>
</form:form>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>