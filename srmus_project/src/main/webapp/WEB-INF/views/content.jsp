<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>콘텐츠</title>
</head>
<body>
	<jsp:include page="includes/common.jsp" />
	<jsp:include page="includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="my-3">
					<h4>대시보드</h4>
					<div class="text-muted">
						<small><i class="bi bi-clock-history me-1"></i><%=new java.util.Date()%></small>
						<span class="ms-3 badge bg-primary">매장등급 VIP</span>
					</div>
				</div>
				<div class="dashboard-cards mb-4">
					<div class="row g-3">
						<div class="col-md-3">
							<div class="card p-3">
								<div class="h5">입고 대기</div>
								<div class="display-6">123</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card p-3">
								<div class="h5">출고 대기</div>
								<div class="display-6">45</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card p-3">
								<div class="h5">미확인 공지</div>
								<div class="display-6">12</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card p-3">
								<div class="h5">기타</div>
								<div class="display-6">37</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-8 mb-4">
						<div class="card p-3">
							<h5>매출추이</h5>
							<div class="chart-placeholder mt-3">chart.js</div>
						</div>
					</div>
					<div class="col-md-4 mb-4">
						<div class="card p-3">
							<h5>기타 차트</h5>
							<div class="chart-placeholder mt-3">chart.js</div>
						</div>
					</div>
				</div>


				<div class="row mb-4">
					<div class="col-md-4">
						<div class="card p-3 h-100">
							<h5>3단 내용</h5>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">1번쨰 줄</li>
								<li class="list-group-item">2번째 줄</li>
								<li class="list-group-item">3번째 줄</li>
								<li class="list-group-item">...</li>
							</ul>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card p-3 h-100">
							<h5>3단 내용</h5>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">1번쨰 줄</li>
								<li class="list-group-item">2번째 줄</li>
								<li class="list-group-item">3번째 줄</li>
								<li class="list-group-item">...</li>
							</ul>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card p-3 h-100">
							<h5>3단 내용</h5>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">1번쨰 줄</li>
								<li class="list-group-item">2번째 줄</li>
								<li class="list-group-item">3번째 줄</li>
								<li class="list-group-item">...</li>
							</ul>
						</div>
					</div>
				</div>


				<div class="card p-3 mb-5">
					<h5>게시판 형식</h5>
					<div class="table-responsive mt-3">
						<table class="table table-bordered project-table align-middle">
							<thead class="table-light">
								<tr>
									<th>선택</th>
									<th>프로젝트명</th>
									<th>도메인</th>
									<th>담당부서</th>
									<th>진행상태</th>
									<th>진척율</th>
									<th>기간</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" /></td>
									<td>개발 프로젝트 A</td>
									<td><span class="badge bg-info text-dark">devprojectA.com</span></td>
									<td><span class="badge bg-secondary">개발팀</span></td>
									<td><span class="badge-status progress">진행</span></td>
									<td>55%</td>
									<td>2023-04-27 ~ 2023-10-31</td>
								</tr>
								<tr>
									<td><input type="checkbox" /></td>
									<td>디자인 개선 B</td>
									<td><span class="badge bg-info text-dark">designB.co.kr</span></td>
									<td><span class="badge bg-secondary">디자인팀</span></td>
									<td><span class="badge-status done">완료</span></td>
									<td>100%</td>
									<td>2023-01-25 ~ 2023-03-25</td>
								</tr>
								<tr>
									<td><input type="checkbox" /></td>
									<td>연구 프로젝트 C</td>
									<td><span class="badge bg-info text-dark">researchC.net</span></td>
									<td><span class="badge bg-secondary">연구소</span></td>
									<td><span class="badge-status hold">보류</span></td>
									<td>35%</td>
									<td>2023-05-05 ~ 2023-08-30</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="mt-3">
						<button class="btn btn-sm btn-outline-primary">등록</button>
						<button class="btn btn-sm btn-outline-secondary">선택삭제</button>
						<button class="btn btn-sm btn-outline-success">선택수정</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="includes/footer.jsp" />
</body>
</html>
