package co.yedam.common.control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Center;
import co.yedam.common.Control;

public class RegisterCenter implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// byte stream => 객체.(id,centerName,sido,......) => 객체[]
		ServletInputStream sis = req.getInputStream();
		String json = StreamUtils.copyToString(sis, StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
//		Center[] list = mapper.readValue(json, Center[].class);
		List<Center> list = mapper.readValue(json, new ArrayList<Center>().getClass());

//		ReplyService svc = new ReplyServiceImpl();
//		int cnt = svc.addCenter(list);
//		System.out.println(cnt);

		// 처리된 건수.
//		resp.getWriter().print(cnt);
	}

}
