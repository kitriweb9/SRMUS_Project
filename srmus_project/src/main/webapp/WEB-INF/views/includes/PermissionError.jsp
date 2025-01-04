<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/includes/common.jsp" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">

<meta charset="UTF-8">
    <title>403 Forbidden - 권한 오류</title>
    <style>
        .error-page {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .error-message {
            font-size: 3rem;
            font-weight: bold;
            color: #dc3545;
        }
        .error-description {
            font-size: 1.25rem;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/includes/header.jsp" />
    
    <div class="d-flex">
        <jsp:include page="/WEB-INF/views/includes/sidebar.jsp" />
        <div class="main-content p-4">
            <div class="container-fluid px-0">
                <div class="card p-3 mb-5">
                    
				    <div class="container error-page">
				        <div>
				         
				            <div class="error-message"><i class="fas fa-lock error-icon"></i>  403</div>
				            <div class="error-description">권한이 없습니다. 이 페이지에 접근할 수 없습니다.</div>
				        </div>
				    </div>


                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
