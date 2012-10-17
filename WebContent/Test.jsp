<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!-- Test page to check database is OK -->
<sql:query dataSource="jdbc/mymoney" var="rst" scope="request">
    select * from account
</sql:query>
<c:forEach items="${rst.rows}" var="account">
    ${account.id} ${account.name} ${account.accountNum}<br />
</c:forEach>
