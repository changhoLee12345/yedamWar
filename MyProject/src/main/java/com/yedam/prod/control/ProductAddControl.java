package com.yedam.prod.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.domain.ProductVO;
import com.yedam.prod.service.ProdService;
import com.yedam.prod.service.ProdServiceImpl;

public class ProductAddControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageInfo = "main.do";

		ProdService service = new ProdServiceImpl();

		if (req.getMethod().equals("GET")) {
			pageInfo = "prod/prodAddForm.tiles";

		} else if (req.getMethod().equals("POST")) {
			String pcode = req.getParameter("pcode");
			String pname = req.getParameter("pname");
			String pdesc = req.getParameter("pdesc");
			String price = req.getParameter("price");
			String sprice = req.getParameter("sprice");
			String pimage = req.getParameter("pimage");
			String like = req.getParameter("like");

			ProductVO vo = new ProductVO();
			vo.setLikeIt(Integer.parseInt(like));
			vo.setPrice(Integer.parseInt(price));
			vo.setProdCode(pcode);
			vo.setProdDesc(pdesc);
			vo.setProdImage(pimage);
			vo.setProdName(pname);
			vo.setSalePrice(Integer.parseInt(sprice));

			if (service.addProduct(vo)) {
				pageInfo = "productList.do";
			} else {
				req.setAttribute("msg", "등록안됨!!");
				pageInfo = "prod/prodAddForm.tiles";
			}

		}

		return pageInfo;
	}

}
