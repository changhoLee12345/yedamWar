package co.yedam;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Center;
import co.yedam.common.DataSource;
import co.yedam.member.mapper.MemberMapper;

public class MapperTest {
	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		MemberMapper mapper = session.getMapper(MemberMapper.class);

		List<Center> list = new ArrayList<>();
		list.add(new Center(1, "center1", "seoul"));
		list.add(new Center(2, "center2", "seoul"));
		list.add(new Center(3, "center3", "seoul"));

		System.out.println(mapper.insertCenter(list));
//		System.out.println(mapper.deleteCenter(list));
		System.out.println("end");

	}

	static void method1() {
		File file = new File("c:/temp/json.dat");
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			char[] cbuf = new char[100];
			while (true) {
				if (isr.read(cbuf) == -1) {
					break;
				}
				System.out.println(cbuf);
			}
			isr.close();
			fis.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
