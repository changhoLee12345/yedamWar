package co.micol.prj.notice.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	@JsonFormat(pattern="yyyy-MM-dd", locale="Asia/Seoul")
	private String noticeDate;
	private int hitCount;
	private String attachFile;
	private String attachDir;
}
