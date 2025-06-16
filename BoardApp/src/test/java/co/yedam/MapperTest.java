package co.yedam;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.reply.mapper.ReplyMapper;
import co.yedam.reply.vo.Reply;

public class MapperTest {
	public static void main(String[] args) {

		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		Reply rep = new Reply();

		rep.setBoardNo(1);
		rep.setReply("test");
		rep.setReplyer("newbie");
		mapper.insertReply(rep);
		
		System.out.println("end");

	}
}
