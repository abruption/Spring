<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
	String sessionId = (String) session.getAttribute("sessionId");
%>
<sql:setDataSource var="dataSource"
	url="jdbc:mysql://152.67.192.35:3306/spring"
	driver="com.mysql.cj.jdbc.Driver" user="admin" password="lmyykr25" />


<sql:update dataSource="${dataSource}" var="resultSet">
   DELETE FROM SHOP_MEMBER WHERE id = ?
	<sql:param value="<%=sessionId%>" />
</sql:update>

<c:if test="${resultSet>=1}">
	<c:import var="url" url="/member/logoutMember.do" />
	<c:redirect url="/member/resultMember.do" />
</c:if>

