package com.jw.evo.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage; // 시작 페이지 (1, 11, 21...)
	private int endPage; // 끝 페이지 (10, 20, 30...)
    private boolean prev;
    private boolean next;
    
	private int total; // 전체 데이터 개수
	private int page; // 현재 페이지
	private int amount; // 페이지당 출력 개수

	public PageDTO(int page, int amount, int total) {
		this.page = page;
		this.amount = amount;
		this.total = total;

		// 끝 페이지 계산 (10개씩 보여줄 경우)
		this.endPage = (int) (Math.ceil(page / 10.0)) * 10;
		this.startPage = this.endPage - 9;

		int realEnd = (int) (Math.ceil((total * 1.0) / amount));

		if (realEnd < endPage) {
			endPage = realEnd;
		}

		this.prev = startPage > 1;
		this.next = endPage < realEnd;
	}
}
