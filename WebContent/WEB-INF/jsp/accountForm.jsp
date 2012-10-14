<%@ include file="/WEB-INF/jsp/header.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Enter a new account</h2>



<form:form modelAttribute="account">
	<table>
		
		<tr>
			<th>Account Name: <form:errors path="name" cssClass="errors"/>
			<br/>
			<form:input path="name" size="30" maxlength="80"/>
			</th>
		</tr>

		<tr>
			<th>Short Name: <form:errors path="shortName" cssClass="errors" />
			<br/>
			<form:input path="shortName" size="30" maxlength="80"/>
			</th>
		</tr>				
		
		<tr>
			<th>Account Number: <form:errors path="accountNum" cssClass="errors" />
			<br/>
			<form:input path="accountNum" size="30" maxlength="30"/>
			</th>
		</tr>
		
		<tr>
			<th>Opening Balance: <form:errors path="openingBalance" cssClass="errors" />
			<br/>
			<form:input path="openingBalance" size="10" maxlength="10"/>
			</th>
		</tr>
						
		<tr>
			<th>Notes: <form:errors path="notes" cssClass="errors" />
			<br/>
			<form:textarea path="notes" rows="3" cols="25"/>
			</th>
		</tr>

		<tr>
			<th>Currency: ${account.currency}</th>
		</tr>

	</table>

	<table class="table-buttons">
		<tr>
			<td><c:choose>
				<c:when test="${account['new']}">  ${client['new']}
					<p class="submit"><input type="submit" value="Add Account" /></p>
				</c:when>
				<c:otherwise>
					<p class="submit"><input type="submit" value="Update Account" /></p>
				</c:otherwise>
				</c:choose></td>
			<td>
				<p class="submit"><INPUT TYPE="button" VALUE="Cancel"
				onclick="document.location = 'accountList.htm'";></p>				
			<td>
			</td>
			
			</td>
		</tr>
	</table>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
