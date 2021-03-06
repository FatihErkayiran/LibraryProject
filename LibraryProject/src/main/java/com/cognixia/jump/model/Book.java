package com.cognixia.jump.model;

import java.sql.Date;

public class Book {

	private String isbn;
	private String title;
	private String descr;
	private boolean rented;
	private Date added_to_libray;
	
	public Book(String isbn, String title, String descr, boolean rented, Date added_to_libray) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.descr = descr;
		this.rented = rented;
		this.added_to_libray = added_to_libray;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getAdded_to_libray() {
		return added_to_libray;
	}

	public void setAdded_to_libray(Date added_to_libray) {
		this.added_to_libray = added_to_libray;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", descr=" + descr + ", rented=" + rented
				+ ", added_to_libray=" + added_to_libray + "]";
	}
	
	
	
	
}
