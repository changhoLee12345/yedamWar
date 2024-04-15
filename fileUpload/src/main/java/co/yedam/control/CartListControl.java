package co.yedam.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.vo.CartVO;

public class CartListControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");

		List<CartVO> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			CartVO vo = new CartVO();
			vo.setNo(i + 1);
			vo.setPrice(1000 * (i + 1));
			vo.setProduct_nm("상품" + (i + 1));
			vo.setQty(2);

			list.add(vo);
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);

		response.getWriter().print(json);
	}

}
