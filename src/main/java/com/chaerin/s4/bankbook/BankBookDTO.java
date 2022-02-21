package com.chaerin.s4.bankbook;

public class BankBookDTO {
	
	private long bookNumber;
	private String bookName;
	private String bookContents;
	private Double bookRate;
	private Integer bookSale;
	
	//생성자 안만들면 디폴트 생성자 만들어짐
	
	public long getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookContents() {
		return bookContents; 
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	

	
}