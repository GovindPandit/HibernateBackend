package com.niit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Books")
public class Book
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int Bookid;
		@Column
		private String Bookname;
		private String Author;
		private Float price;
		private String link;
		
		@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "book")
		private List<CartItem> cartItems;
		
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		
		public int getBookid() {
			return Bookid;
		}
		public void setBookid(int bookid) {
			Bookid = bookid;
		}
		public String getBookname() {
			return Bookname;
		}
		public void setBookname(String bookname) {
			Bookname = bookname;
		}
		public String getAuthor() {
			return Author;
		}
		public void setAuthor(String author) {
			Author = author;
		}
		public Float getPrice() {
			return price;
		}
		public void setPrice(Float price) {
			this.price = price;
		}
		
		
		
	}


