package co.yedam;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.reply.mapper.ReplyMapper;

public class MapperTest {
	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		SearchVO search = new SearchVO();
		search.setBno(521);
		mapper.selectList(search).forEach(reply -> {
			System.out.println(reply);
		});

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
