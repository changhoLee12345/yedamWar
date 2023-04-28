package com.yedam.prod.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.service.ProdService;
import com.yedam.prod.service.ProdServiceImpl;

public class ProductMainControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pcode = req.getParameter("pcode");
		ProdService service = new ProdServiceImpl();

		req.setAttribute("pcode", service.getProdeuct(pcode));
		req.setAttribute("rlist", service.relatedProduct());

		return "prod/prodMain.tiles";
	}

}
