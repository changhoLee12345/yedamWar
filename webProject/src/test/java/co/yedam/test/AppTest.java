package co.yedam.test;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();

		List<Map<String, Object>> obj = svc.getCntByMember();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(obj);
		System.out.println(json);

	}
}
