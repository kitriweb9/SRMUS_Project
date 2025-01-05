<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="custom-sidebar bg-white border-end">
    <ul class="list-unstyled m-0">
        <li class="sidebar-item active">
            <a href="layout.jsp" class="sidebar-link">
                <i class="bi bi-speedometer2 me-2"></i> 대시보드
            </a>
        </li>
        
        <li class="sidebar-item">
            <a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#goods" aria-expanded="false" aria-controls="goods">
                <span><i class="bi bi-box-seam me-2"></i> 상품조회</span>
                <i class="bi bi-chevron-down toggle-icon"></i>
            </a>
            <ul class="collapse list-unstyled ms-3" id="goods">
                <li><a href="${pageContext.request.contextPath}/customer/goods" class="sidebar-link">상품 목록</a></li>
            </ul>
        </li>
        
        <!-- employee 권한일 때만 표시 -->
        <c:if test="${sessionScope.userType == 'employee'}">
            <li class="sidebar-item">
                <a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#order" aria-expanded="false" aria-controls="order">
                    <span><i class="bi bi-file-earmark-text me-2"></i> 발주관리</span>
                    <i class="bi bi-chevron-down toggle-icon"></i>
                </a>
                <ul class="collapse list-unstyled ms-3" id="order">
                    <li><a href="${pageContext.request.contextPath}/SsmOrdGdoChk/list" class="sidebar-link">발주 목록</a></li>
                    <li><a href="${pageContext.request.contextPath}/SsmOrdGdoReg/reg" class="sidebar-link">발주 등록</a></li>
                    <li><a href="${pageContext.request.contextPath}/SsmOrdSnd/beforeSend" class="sidebar-link">발주 전송</a></li>
                </ul>
            </li>
            <li class="sidebar-item">
                <a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#inbound" aria-expanded="false" aria-controls="inbound">
                    <span><i class="bi bi-truck me-2"></i> 입고관리</span>
                    <i class="bi bi-chevron-down toggle-icon"></i>
                </a>
                <ul class="collapse list-unstyled ms-3" id="inbound">
                    <li><a href="${pageContext.request.contextPath}/SsmInbMgtEChk/list" class="sidebar-link">입고 목록</a></li>
                    <li><a href="${pageContext.request.contextPath}/SsmInbMgtChk/list" class="sidebar-link">입고 확정 목록</a></li>
                </ul>
            </li>
            <li class="sidebar-item">
                <a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#stock" aria-expanded="false" aria-controls="stock">
                    <span><i class="bi bi-box2-fill me-2"></i> 재고관리</span>
                    <i class="bi bi-chevron-down toggle-icon"></i>
                </a>
                <ul class="collapse list-unstyled ms-3" id="stock">
                    <li><a href="${pageContext.request.contextPath}/SsmStkMgtChk/list" class="sidebar-link">재고 목록</a></li>
                </ul>
            </li>
        </c:if>
    </ul>
</div>
