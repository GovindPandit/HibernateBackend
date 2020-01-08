package com.niit.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.niit.daoimpl.BookDAOImpl;
import com.niit.daoimpl.CartDAOImpl;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.Book;
import com.niit.model.CartItem;
import com.niit.model.User;

public class CartTest
{
	CartDAOImpl cdi=new CartDAOImpl();
	UserDAOImpl udi=new UserDAOImpl();
	BookDAOImpl bdi=new BookDAOImpl();
	
	@Test
	@Ignore
	public void addCartItem()
	{
		CartItem c=new CartItem();
		
		User u=udi.displayUserById(5);
		Book b=bdi.displayBookById(4);
		
		c.setUser(u);
		c.setBook(b);
		cdi.addCartItem(c);
	}
	
	@Test
	public void displayCartItemsByName()
	{
		List<CartItem> cartItems=cdi.displayCartItems("Govind123");
		
		for(CartItem c:cartItems)
		{
			System.out.println(c.getCartitemid());
			System.out.println(c.getBook().getBookid());
			System.out.println(c.getBook().getBookname());
			System.out.println(c.getUser().getUsername());
		}
	}
	
	
}
