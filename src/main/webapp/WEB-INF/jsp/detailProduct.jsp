<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
    <link rel="stylesheet" href="/resource/res/css/bootstrap.min.css" />
    <script type="text/javascript">
        function init(){
            document.newProduct.condition.value = "${dto.condition}";
        }
    </script>
    <title>상품 수정</title>
</head>
<body onload="init()">
<jsp:include page="menu.jsp" />
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">상세 정보</h1>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="${dto.fileName}" alt="image" style="width: 100%" />
        </div>
        <div class="col-md-7">
            <form name="newProduct" action="/processUpdateProduct.do" class="form-horizontal" method="post" enctype="multipart/form-data">
                <div class="form-group row">
                    <label class="col-sm-2">상품 코드</label>
                    <div class="col-sm-3">
                        <input type="text" id="productId" name="productId" class="form-control" value='${dto.productId}'>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2">상품명</label>
                    <div class="col-sm-3">
                        <input type="text" id="pname" name="pname" class="form-control" value="${dto.pname}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2">가격</label>
                    <div class="col-sm-3">
                        <input type="text" id="unitPrice" name="unitPrice" class="form-control" value="${dto.unitPrice}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2">상세 설명</label>
                    <div class="col-sm-5">
                        <textarea name="description" cols="50" rows="2" class="form-control">${dto.description}</textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2">제조사</label>
                    <div class="col-sm-3">
                        <input type="text" name="manufacturer" class="form-control" value="${dto.manufacturer}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2">분류</label>
                    <div class="col-sm-3">
                        <input type="text" name="category" class="form-control" value="${dto.category}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2">재고 수</label>
                    <div class="col-sm-3">
                        <input type="text" id="unitsInStock" name="unitsInStock" class="form-control" value="${dto.unitsInStock}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2">상태</label>
                    <div class="col-sm-5">
                        <input type="radio" name="condition" value="New "> 신규 제품
                        <input type="radio" name="condition" value="Old"> 중고 제품
                        <input type="radio" name="condition" value="Refurbished"> 재생 제품
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
