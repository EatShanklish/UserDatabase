package com.Shanklish.UserDatabase;

public class user
    {
	private String fullname;
	private String username;
	private String email;
	private String password;
	private int id;
	
	
	public int getId()
	{
	    return id;
	}

	
	public void setId( int id )
	{
	    this.id = id;
	}

	public String getFullname()
	{
	    return fullname;
	}
	
	public void setFullname( String fullname )
	{
	    this.fullname = fullname;
	}
	
	public String getUsername()
	{
	    return username;
	}
	
	public void setUsername( String username )
	{
	    this.username = username;
	}
	
	public String getEmail()
	{
	    return email;
	}
	
	public void setEmail( String email )
	{
	    this.email = email;
	}
	
	public String getPassword()
	{
	    return password;
	}
	
	public void setPassword( String pass )
	{
	    this.password = pass;
	}
	
	
    }
