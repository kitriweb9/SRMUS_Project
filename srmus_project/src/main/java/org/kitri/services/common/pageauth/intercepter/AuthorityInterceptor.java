package org.kitri.services.common.pageauth.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {
	@Autowired
	private HttpSession session;

	@Autowired
	private ISvcComEmpInqSvc iInqSvc;

	@Autowired
	private SvcComPgcAcp auth;

	public AuthorityInterceptor() {
		System.out.println("Create Instance");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("작동 시작");
		if (!(handler instanceof HandlerMethod)) {
			System.out.println("핸들러");
			return true;
		}

		System.out.println("AuthorityInterceptor: 요청 처리 중");

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		RequiresAuthority requiresAuthority = handlerMethod.getMethodAnnotation(RequiresAuthority.class);

		if (requiresAuthority == null) {
			return true;
		}

		SvcComEmpLgnDto sessionEmployee = (SvcComEmpLgnDto) session.getAttribute("employee");
		System.out.println(sessionEmployee);
		System.out.println("세션 문제 아님");
		if (sessionEmployee == null) {
			response.sendRedirect("/employee/login");
			return false;
		}

		if (!permissionCheck(requiresAuthority.value(), sessionEmployee)) {
			response.sendRedirect("/includes/PermissionError");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	private boolean permissionCheck(String serviceId, SvcComEmpLgnDto sessionEmployee) {
		SvcComEmpDto svcComEmpDto = iInqSvc.employeeInquiryByFilters(sessionEmployee.getEmployeeId(), null, null, null)
				.get(0);
		return auth.hasAuthority(svcComEmpDto, serviceId);
	}

}
