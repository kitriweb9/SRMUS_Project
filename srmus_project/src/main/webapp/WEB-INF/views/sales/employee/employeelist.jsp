<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
    .search-bar {
        display: flex;
        align-items: center;
        gap: 10px;
        margin-bottom: 15px;
    }
    .search-input {
        max-width: 200px;
    }
    .search-form select, .search-form input[type="checkbox"] {
        margin-right: 10px;
    }
</style>
<jsp:include page="/WEB-INF/views/includes/common.jsp" />
<meta charset="UTF-8">
<title>영업관리본부: 직원 목록 조회</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/includes/header.jsp" />
    
    <div class="d-flex">
        <jsp:include page="/WEB-INF/views/includes/sidebar.jsp" />
        <div class="main-content p-4">
            <div class="container-fluid px-0">
                <div class="card p-3 mb-5">
                    <h5>직원 목록 조회</h5>
						<c:choose>
						    <c:when test="${not empty employeeList}">
						        <div class="table-responsive mt-3">
						            <table class="table table-bordered project-table align-middle">
						                <thead class="table-light">
						                    <tr>
						                        <th>직원 ID</th>
						                        <th>이름</th>
						                        <th>연락처</th>
						                        <th>이메일</th>
						                        <th>직책</th>
						                        <th>역할</th>
						                        <th>부서</th>
						                    </tr>
						                </thead>
						                <tbody>
						                    <c:forEach var="employee" items="${employeeList}">
						                        <tr>
						                            <td>${employee.employeeId}</td>
						                            <td>${employee.employeeName}</td>
						                            <td>${employee.employeeContact}</td>
						                            <td>${employee.employeeEmail}</td>
						                            <td>${employee.positionName}</td>
						                            <td>${employee.roleName}</td>
						                            <td>${employee.departmentName}</td>
						                        </tr>
						                    </c:forEach>
						                </tbody>
						            </table>
						        </div>
						    </c:when>
							<c:otherwise>
							    <div class="alert alert-warning d-flex align-items-center mt-3" role="alert">
							        <i class="bi bi-exclamation-triangle-fill me-2"></i>
							        <div>
							            <strong>결과 없음:</strong> 조회된 직원이 없습니다. 검색 조건을 변경하거나 다시 시도해주세요.
							        </div>
							    </div>
							</c:otherwise>
						</c:choose>


                    <!-- 검색 폼 -->
                    <div class="search-bar">
                        <form action="${pageContext.request.contextPath}/employee" method="get" class="d-flex align-items-center gap-3">
                            <input type="text" class="form-control search-input" id="employeeId" name="employeeId" placeholder="직원 아이디">
                            <select id="positionId" name="positionId" class="form-select">
                                <option value="">직위 선택</option>
                                <c:forEach var="position" items="${positions}">
                                    <option value="${position.positionId}">${position.positionName}</option>
                                </c:forEach>
                            </select>
                            <select id="roleId" name="roleId" class="form-select">
                                <option value="">역할 선택</option>
                                <c:forEach var="role" items="${roles}">
                                    <option value="${role.roleId}">${role.roleName}</option>
                                </c:forEach>
                            </select>
                            <select id="departmentId" name="departmentId" class="form-select">
                                <option value="">부서 선택</option>
                                <c:forEach var="department" items="${departments}">
                                    <option value="${department.departmentId}">${department.departmentName}</option>
                                </c:forEach>
                            </select>
                            <button type="submit" class="btn btn-outline-primary w-auto" style="white-space: nowrap;">조회</button>
                            <c:if test="${not empty param.employeeId or not empty param.positionId or not empty param.departmentId}">
                            	<a href="${pageContext.request.contextPath}/employeeinquirypage" class="btn btn-outline-primary w-auto" style="white-space: nowrap;">전체 조회</a>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
