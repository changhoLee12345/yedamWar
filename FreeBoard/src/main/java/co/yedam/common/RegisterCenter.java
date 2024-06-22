package co.yedam.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceImpl;

public class RegisterCenter implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		ServletInputStream sis = req.getInputStream();
		String strJson = StreamUtils.copyToString(sis, StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		Center[] list = mapper.readValue(strJson, Center[].class);

		MemberService svc = new MemberServiceImpl();
		System.out.println(svc.addCenter(list));
//		System.out.println(svc.delCenter(list));

//		System.out.println(strJson);
		resp.getWriter().print("end");
	}

}
