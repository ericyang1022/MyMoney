<%@ include file="/WEB-INF/jsp/header.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<h2>Enter a new account</h2>

<spring:message code="label.paymentNo"/>

<form:form modelAttribute="dependsOnExoticType">
	<table>

		<tr>
			<th>type: <form:errors path="type" cssClass="errors"/>
			<br/>
			<form:input path="type" size="30" maxlength="80"/>
			</th>
		</tr>
		
		

	</table>

	<table class="table-buttons">
		<tr>
			<td>
					<p class="submit"><input type="submit" value="Submit" /></p>
				
			</td>
		</tr>
	</table>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>