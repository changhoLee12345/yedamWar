package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int page; // 현재 페이지.
	private int startPage, endPage; // 11 [13] 20
	private boolean prev, next; // 이전페이지, 이후페이지.

	public PageDTO(int page, int totalCnt) { // 123건 => 24.3
		this.page = page;
		int realEnd = (int) Math.ceil(totalCnt / 5.0);

		this.endPage = (int) Math.ceil(page / 5.0) * 5;
		this.startPage = this.endPage - 4;

		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;

		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
