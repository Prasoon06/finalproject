package com.yash.storeapp.exceptions;

/**
 * StoreIDException is an Exception class.
 *
 */
public class StoreIDException extends Exception {

	
	public StoreIDException(int id) 
	{
		super("Id not Valid");
	}

}
