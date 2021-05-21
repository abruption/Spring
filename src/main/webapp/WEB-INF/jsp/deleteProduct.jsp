<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
    String productId = request.getParameter("productId");
%>
<sql:setDataSource var="dataSource"
                   url="jdbc:mysql://152.67.192.35:3306/spring"
                   driver="com.mysql.cj.jdbc.Driver" user="admin" password="lmyykr25" />


<sql:update dataSource="${dataSource}" var="resultSet">
    DELETE FROM SHOP_PRODUCT WHERE PRODUCT_ID = ?
    <sql:param value="<%=productId%>" />
</sql:update>

<c:if test="${resultSet>=1}">
    <c:redirect url="/products.do" />
</c:if>

