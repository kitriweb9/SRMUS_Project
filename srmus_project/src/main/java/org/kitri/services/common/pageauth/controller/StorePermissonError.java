package org.kitri.services.common.pageauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StorePermissonError {

	@GetMapping("/storePermissionError")
	public String permissionErrorPage() {
		return "/includes/storePermissionError";
	}
}
