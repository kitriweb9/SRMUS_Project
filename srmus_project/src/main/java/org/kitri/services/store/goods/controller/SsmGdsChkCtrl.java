package org.kitri.services.store.goods.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.store.goods.service.ISsmGdsChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @apiNote 상품 정보
 * @author kitri03
 * @since 2025-01-03
 */
@Controller
public class SsmGdsChkCtrl {
	@Autowired
	ISsmGdsChkSvc goodsService;
	@Autowired
	SvcComLgnSsn svcComLgnSsn;
	
	/**
	 * @apiNote 상품 정보
	 * @param model: 상품 정보를 서버에 전달해주기 위해 호출
	 * @param session: 로그인 유무 검증 위해 호출
	 * @return: 주소
	 * @author 박시연
	 * @since 2025-01-03
	 */
	@RequestMapping("/customer/goods")
	public String goodsList(Model model, HttpSession session) {
		if(svcComLgnSsn.isLogin(session)) {
			model.addAttribute("goodsList", goodsService.findGoodsAll());
			return "store/goods/SsmGdsChk";
		}
		
		return "store/customer/SsmCusLgnLin";
	}
}
