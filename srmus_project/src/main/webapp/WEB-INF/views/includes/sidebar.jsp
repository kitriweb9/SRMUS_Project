<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="custom-sidebar bg-white border-end">
    <ul class="list-unstyled m-0">
        <li class="sidebar-item active">
            <a href="layout.jsp" class="sidebar-link">
                <i class="bi bi-speedometer2 me-2"></i> 대시보드
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#staffMenu" aria-expanded="false" aria-controls="staffMenu">
                <span><i class="bi bi-person-lines-fill"></i> 직원관리</span>
                <i class="bi bi-chevron-down toggle-icon"></i>
            </a>
            <ul class="collapse list-unstyled ms-3" id="staffMenu">
                <li><a href="${pageContext.request.contextPath}/employee" class="sidebar-link">직원 목록</a></li>
                <li><a href="${pageContext.request.contextPath}/employee/add" class="sidebar-link">직원 추가</a></li>
            </ul>
        </li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#inventoryMenu" aria-expanded="false" aria-controls="inventoryMenu">
                <span><i class="bi bi-truck"></i> 입/출고관리</span>
                <i class="bi bi-chevron-down toggle-icon"></i>
            </a>
            <ul class="collapse list-unstyled ms-3" id="inventoryMenu">
                <li><a href="${pageContext.request.contextPath}/inbound" class="sidebar-link">본사 입고 목록</a></li>
                <li><a href="${pageContext.request.contextPath}/inbound/ing" class="sidebar-link">본사 입고 예정 목록</a></li>
                <li><a href="${pageContext.request.contextPath}/inbound/ship" class="sidebar-link">본사 출하 등록</a></li>
                <li><a href="${pageContext.request.contextPath}/inbound/store" class="sidebar-link">매장별 입고 내역</a></li>
            </ul>
        </li>
		<li class="sidebar-item">
			<a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#storeMenu" aria-expanded="false" aria-controls="storeMenu">
			 <span><i class="bi bi-shop"></i> 매장관리</span> 
			 <i	class="bi bi-chevron-down toggle-icon"></i>
			</a>
			<ul class="collapse list-unstyled ms-3" id="storeMenu">
				<li><a href="${pageContext.request.contextPath}/storelist"
					class="sidebar-link">매장 목록</a></li>
				<li><a href="${pageContext.request.contextPath}/registstore"
					class="sidebar-link">매장 등록</a></li>
			</ul>
		</li>
		
		<li class="sidebar-item">
			<a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#orderMenu" aria-expanded="false" aria-controls="orderMenu">
			 <span><i class="bi bi-shop"></i>수주 관리</span> 
			 <i	class="bi bi-chevron-down toggle-icon"></i>
			</a>
			<ul class="collapse list-unstyled ms-3" id="orderMenu">
				<li><a href="${pageContext.request.contextPath}/searchorders"
					class="sidebar-link">수주 목록</a></li>
			</ul>
		</li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#stockMenu" aria-expanded="false" aria-controls="stockMenu">
                <span><i class="bi bi-box"></i> 상품관리</span>
                <i class="bi bi-chevron-down toggle-icon"></i>
            </a>
            <ul class="collapse list-unstyled ms-3" id="stockMenu">
				<li><a href="${pageContext.request.contextPath}/goodslist" class="sidebar-link">상품 목록</a></li>
				<li><a href="${pageContext.request.contextPath}/registgoods" class="sidebar-link">상품 등록</a></li>
                <li><a href="${pageContext.request.contextPath}/goods/stock" class="sidebar-link">본부 재고 조회</a></li>
                <li><a href="${pageContext.request.contextPath}/store/goods/stock" class="sidebar-link">매장별 재고 조회</a></li>
            </ul>
        </li>
        
        <li class="sidebar-item"><a href="#"
			class="sidebar-link d-flex justify-content-between align-items-center"
			data-bs-toggle="collapse" data-bs-target="#closureMenu"
			aria-expanded="false" aria-controls="closureMenu"> <span><i
					class="bi bi-pen me-2"></i> 마감관리</span> <i
				class="bi bi-chevron-down toggle-icon"></i>
		</a>
			<ul class="collapse list-unstyled ms-3" id="closureMenu">
				<li class="sidebar-item"><a href="#"
					class="sidebar-link d-flex justify-content-between align-items-center"
					data-bs-toggle="collapse" data-bs-target="#storeClosureMenu"
					aria-expanded="false" aria-controls="storeClosureMenu"> <span>매장별
							마감관리</span> <i class="bi bi-chevron-down toggle-icon"></i>
				</a>
					<ul class="collapse list-unstyled ms-3" id="storeClosureMenu">
						<li><a
							href="${pageContext.request.contextPath}/marketcloseinfo"
							class="sidebar-link">마감 목록</a></li>
						<li><a href="${pageContext.request.contextPath}/marketclose"
							class="sidebar-link">마감 등록</a></li>
					</ul></li>
				<li class="sidebar-item"><a href="#"
					class="sidebar-link d-flex justify-content-between align-items-center"
					data-bs-toggle="collapse" data-bs-target="#headquartersClosureMenu"
					aria-expanded="false" aria-controls="headquartersClosureMenu">
						<span>본부 마감관리</span> <i class="bi bi-chevron-down toggle-icon"></i>
				</a>
					<ul class="collapse list-unstyled ms-3"
						id="headquartersClosureMenu">
						<li><a href="${pageContext.request.contextPath}/hqcloseinfo"
							class="sidebar-link">마감 목록</a></li>
						<li><a href="${pageContext.request.contextPath}/hqclose"
							class="sidebar-link">마감 등록</a></li>
					</ul></li>
			</ul></li>
    </ul>
</div>

<style>
    .collapse {
        transition: height 0.3s ease;
    }
</style>

<script>
    document.querySelectorAll('.sidebar-item .sidebar-link').forEach(link => {
        const targetId = link.getAttribute('data-bs-target');
        if (!targetId) return;

        const targetElement = document.querySelector(targetId);
        const icon = link.querySelector('.toggle-icon');

        link.addEventListener('click', function (event) {
            event.preventDefault();

            const collapseInstance = bootstrap.Collapse.getOrCreateInstance(targetElement);
            collapseInstance.toggle();

            targetElement.addEventListener('hidden.bs.collapse', () => {
                icon.classList.remove('bi-chevron-up');
                icon.classList.add('bi-chevron-down');
            }, { once: true });

            targetElement.addEventListener('shown.bs.collapse', () => {
                icon.classList.remove('bi-chevron-down');
                icon.classList.add('bi-chevron-up');
            }, { once: true });
        });
    });
</script>
