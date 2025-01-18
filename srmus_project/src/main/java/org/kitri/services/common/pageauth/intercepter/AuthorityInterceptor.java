package org.kitri.services.common.pageauth.intercepter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorityInterceptor implements HandlerInterceptor {
	@Autowired
	private HttpSession session;

	@Autowired
	private ISvcComEmpInqSvc iInqSvc;

	@Autowired
	private SvcComPgcAcp auth;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true; // 다른 핸들러는 체크하지 않음
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		RequiresAuthority requiresAuthority = handlerMethod.getMethodAnnotation(RequiresAuthority.class);

		if (requiresAuthority == null) {
			return true; // 어노테이션이 없으면 접근 권한 체크 불필요
		}

		SvcComEmpLgnDto sessionEmployee = (SvcComEmpLgnDto) session.getAttribute("employee");
		if (sessionEmployee == null) {
			response.sendRedirect(request.getContextPath() + "/employee/login");
			return false;
		}
		
		String errorCtrlPath = null;
		
		if(requiresAuthority.value().toLowerCase().startsWith("ssm")) {
			errorCtrlPath = request.getContextPath() + "/storePermissionError";
		} else {
			errorCtrlPath = request.getContextPath() + "/permissionError";
		}
		// 권한 체크 (value와 basicServiceId 동시에 검사)
		if (requiresAuthority.value() != null && !permissionCheck(requiresAuthority.value(), sessionEmployee)) {
			redirectPage(response, errorCtrlPath);
			return false;
		}

		if (requiresAuthority.basicServiceId() != null
				&& !permissionCheck(requiresAuthority.basicServiceId(), sessionEmployee)) {
			redirectPage(response, errorCtrlPath);
			return false;
		}

		// editServiceId에 대한 권한 체크
		if (requiresAuthority.editServiceId() != null) {
			request.setAttribute("canEdit", permissionCheck(requiresAuthority.editServiceId(), sessionEmployee));
		}

		return true;
	}

	private void redirectPage(HttpServletResponse response, String path)
			throws IOException {
		response.sendRedirect(path);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 현재는 구현 필요 없음
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 현재는 구현 필요 없음
	}

	private boolean permissionCheck(String serviceId, SvcComEmpLgnDto sessionEmployee) {
		if (serviceId == null || serviceId.isEmpty()) {
			return true; // value가 빈 문자열일 경우 권한 체크를 생략
		}

		SvcComEmpDto svcComEmpDto = iInqSvc.employeeInquiryByFilters(sessionEmployee.getEmployeeId(), null, null, null)
				.get(0);
		boolean hasAuthority = auth.hasAuthority(svcComEmpDto, serviceId);
		return hasAuthority;
	}
}
