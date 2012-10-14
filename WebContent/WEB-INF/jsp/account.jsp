<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h2><spring:message code="account.information"/></h2>

  <table>
    <tr>
      <th>Name</th>
      <td><b>${account.name} (${account.shortName})</b></td>
    </tr>
    <tr>
      <th>Account Number</th>
      <td>${account.accountNum}</td>
    </tr>
    <tr>
      <th>Notes</th>
      <td>${account.notes}</td>
    </tr>
    <tr>
      <th>Opening Balance </th>
      <td>${account.openingBalance}</td>
    </tr>    
  </table>
  
  <table class="table-buttons">
    <tr>
      <td colspan="2" align="center">
        <form method="GET" action="<c:url value="/editAccount.do"/>">
          <input type="hidden" name="accountId" value="${account.id}"/>
          <p class="submit"><input type="submit" value="Edit Account Details"/></p>
        </form>
      </td>
    </tr>
  </table>
  
<%@ include file="/WEB-INF/jsp/footer.jsp" %>