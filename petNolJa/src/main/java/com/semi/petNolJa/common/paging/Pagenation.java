package com.semi.petNolJa.common.paging;

public class Pagenation {
	
	/* 기본 페이징 처리 */
	public static SelectCriteria getSelectCriteria(int pageNo, int totalCount, int limit, int buttonAmount) {
		return getSelectCriteria(pageNo, totalCount, limit, buttonAmount, null, null);
	}
	
	/* 검색 기능 + 페이징 처리 */
	public static SelectCriteria getSelectCriteria(int pageNo, int totalCount, int limit, int buttonAmount, String searchCondition, String searchValue) {
		/* 
		 * pageNo와 totalCount가 넘어온 상태이기 때문에
		 * 페이징처리에 필요한 나머지 변수만 선언을 한다.
		 */
		int maxPage;			//전체 페이지에서 가장 마지막 페이지
		int startPage;			//한번에 표시될 페이지 버튼의 시작할 페이지
		int endPage;			//한번에 표시될 페이지 버튼의 끝나는 페이지
		int startRow;
		int endRow;
		
		maxPage = (int) Math.ceil((double) totalCount / limit);
		startPage = (int) (Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1;
		endPage = startPage + buttonAmount - 1;

		if(maxPage < endPage){
			endPage = maxPage;
		}
		
		if(maxPage == 0 && endPage == 0) {
			maxPage = startPage;
			endPage = startPage;
		}
		
		/* 조회할 시작 번호와 마지막 행 번호를 계산한다. */
		startRow = (pageNo - 1) * limit + 1;
		endRow = startRow + limit - 1;
		
		SelectCriteria selectCriteria = new SelectCriteria(pageNo, totalCount, limit, buttonAmount ,maxPage, startPage, endPage, startRow, endRow, searchCondition, searchValue);
		return selectCriteria;
	}

}
