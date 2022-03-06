package com.chaerin.s4.util;

public class Pager {
	//페이지당 보여줄 row 갯수
	private Long perPage;
	//페이지 번호
	private Long page;
	//시작번호
	private Long startRow;
	//끝번호
	private Long lastRow;
	
	//--------------검색관련변수--------------
	private String search;
	private String kind;
	
	
	//---------------JSP사용변수--------------
	private Long startNum;
	private Long lastNum;	
	private boolean next;
	private boolean pre;
	
	
	public void makeRow() {
	      this.startRow=(this.getPage()-1)*this.getPerPage()+1;
	      this.lastRow=this.getPage()*this.getPerPage();
	      }
	public void makeNum(Long totalCount) {
		//1. 전체 row의 갯수 구하기
		//Long totalCount=237L;
		
		//2. 전체 page의 갯수 구하기
		Long totalPage=totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		
		//3. block당 갯수
		Long perBlock=10L;

		//4. 전체 block 갯수 구하기
		Long totalBlock=totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		//5. 현재 페이지 번호로 현재 몇번째 block인지 구하기
		//1블럭 : 1-10 2블럭 : 11-20 3블럭 : 21-30
		
		//page번호 		block번호
		//1				1
		//5				1
		//12			2
		//21			3

		Long curBlock=this.getPage()/perBlock;
		
		if(this.getPage()%perBlock!=0) {
			curBlock++;
		}
		
		//6. curBlock로 startNum, lastNum 구하기
		//curBlock이 몇번이냐에 따라 startNum, lastNum이구해져야함
		// 1                      1         10
		// 2                      11        20
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
		//7.이전,다음블럭유무
		this.pre=false;
		if(curBlock>1) {
			//현재블록이 2,3,4. . . .
			this.pre=true;
		}
	
		this.next=false;
		if(totalBlock > curBlock) { //현재블럭이 마지막블럭이 아니라면
			this.next=true;
		}
		
		//8. 현재 블럭이 마지막 블럭 번호랑 같다면
		if(curBlock == totalBlock) {
			this.lastNum=totalPage;
		}
		
	}

	public Long getPerPage() {
        if(this.perPage==null || this.perPage<1) {
           this.perPage=10L;
        }
        return perPage;
     }
     public void setPerPage(Long perPage) {
        this.perPage = perPage;
     }
     public Long getPage() {
        if(this.page==null || this.page<1) {
           this.page=1L;
        }
        return page;
     }
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public String getSearch() {
		//검색어가 없으면 null
		if(this.search==null) {
			this.search="";
		}
//this.search="%"+this.search+"%";
		
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}	
	
	
}