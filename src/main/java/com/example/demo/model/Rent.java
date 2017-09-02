/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MAC
 */
@Entity
@Table(name="rents")
public class Rent extends BaseEntity{
	
	public enum Status {
		IN_PROGRESS, FINISHED
	}
	
	@Column(name = "created_date", nullable = false)
	private Date createdDate;
	

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="book_id", nullable = false)
	private Book book;
	
	//trzeba pamietac aby w klasach encyjnych dodac pusty konstruktor
	public Rent() {
		
	}
	
	

	public Rent(User user, Book book) {
		super();
		this.user = user;
		this.book = book;
		createdDate = new Date();
		status = Status.IN_PROGRESS;
	}



	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
