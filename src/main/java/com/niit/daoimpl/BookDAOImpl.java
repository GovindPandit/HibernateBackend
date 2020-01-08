package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.dao.BookDAO;
import com.niit.dbconfig.HibernateUtil;
import com.niit.model.Book;

public class BookDAOImpl implements BookDAO
{

	public boolean addBook(Book book)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(book);
		tx.commit();
		return true;
	}

	public boolean deleteBook(int bookid) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		
		Book book=new Book();
		book.setBookid(bookid);
		session.delete(book);
		tx.commit();
		return true;
	}

	public boolean updateBook(Book book) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.update(book);
		tx.commit();
		return true;
	}

	public List<Book> displayBooks()
	{
		Session session=HibernateUtil.getSession();
		return session.createQuery("from com.niit.model.Book").list();
	}

	public Book displayBookById(int bookid) 
	{
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from com.niit.model.Book where bookid= :bid");
		query.setParameter("bid", bookid);
		return (Book)query.getResultList().get(0);
	}
	
	public List<Book> displayBookByName(String name)
	{
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from com.niit.model.Book where bookname like :name");
		query.setParameter("name", "%"+name+"%");
		return query.getResultList();
	}
	
	public List<Book> displayBookByPriceHighToLow() 
	{
		Session session=HibernateUtil.getSession();
		return session.createQuery("from com.niit.model.Book order by price desc").getResultList();
	}

	public List<Book> displayBookByPriceLowToHigh() 
	{
		Session session=HibernateUtil.getSession();
		return session.createQuery("from com.niit.model.Book order by price asc").getResultList();
	}

}
