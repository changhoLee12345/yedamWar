package com.yedam.edu.common;

import lombok.Getter;
import lombok.ToString;

// paging에 보여줄 리스트 정보.
@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;

	private int total;
	private Criteria cri;

	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		this.endPage = (int) (Math.ceil(cri.getPageNum() / (cri.getAmount() * 1.0))) * cri.getAmount();
		this.startPage = this.endPage - (cri.getAmount() - 1);

		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
