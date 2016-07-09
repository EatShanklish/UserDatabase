package com.Shanklish.UserDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.tomcat.util.security.MD5Encoder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DAOuser {
	private static SessionFactory factory;
	
	private static void setupFactory() 
	{
	    try 
    		{
    	          Class.forName("com.mysql.jdbc.Driver");
    		} 
		
		catch (Exception e) 
		{
			;//this is silliness!
		}
	    
		 Configuration configuration = new Configuration();

		 // Pass hibernate configuration file
		 configuration.configure("hibernate.cfg.xml");
		 
		 // pass in setup file for Product class
		 configuration.addResource("product.hbm.xml");
		 
		 // Since version 4.x, service registry is being used
		 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
		 applySettings(configuration.getProperties()).build(); 

		 // Create session factory instance
		 factory = configuration.buildSessionFactory(serviceRegistry);

	}
	
	public static int addUser(user u) throws NoSuchAlgorithmException 
	{
	    String pass = MD5Encoder(u.getPassword().toString());
	    u.setPassword(pass);
	    
		if (factory == null)
			setupFactory();
		
		 // Get current session
		 Session hibernateSession = factory.openSession();

		 // Begin transaction
		 hibernateSession.getTransaction().begin();

		 //save this specific record
		 int i = (Integer)hibernateSession.save(u);  
		 
		 // Commit transaction
		 hibernateSession.getTransaction().commit();
		 
		 hibernateSession.close();  
				    
		 return i;  
	}
	
	public static void deleteUser(user u) 
	{   
		if (factory == null)
			setupFactory();
		
		 // Get current session
		 Session hibernateSession = factory.openSession();

		 // Begin transaction
		 hibernateSession.getTransaction().begin();

		 //save this specific record
		 hibernateSession.delete(u);  
		 
		 // Commit transaction
		 hibernateSession.getTransaction().commit();
		 
		 hibernateSession.close();  
		
	}
	
	public static void deleteUserByID(int i) 
	{   
	    
	    user myObject ;

	    Session hibernateSession = factory.openSession();
	   
	    hibernateSession.getTransaction().begin();
	    
	    myObject = (user)hibernateSession.get(user.class,i);
	    
	    hibernateSession.delete(myObject);

	   hibernateSession.getTransaction().commit();
	    
	    hibernateSession.close();  
	    
	   
		
	}
	
	

	public static List<user> getAllUsers()
	{
		if (factory == null)
			setupFactory();
		
		 // Get current session
		 Session hibernateSession = factory.openSession();

		 // Begin transaction
		 hibernateSession.getTransaction().begin();
		 
		 
		 
		 //deprecated method & unsafe cast
		 List<user> users = hibernateSession.createQuery("FROM user").list(); 
		 
//         for(user u: users)
//             {
//        	 u.setPassword(md5decoder(u.getPassword()));
//             }
         
         // Commit transaction
         hibernateSession.getTransaction().commit();
      		 
      	 hibernateSession.close();  
      				    
		return users;
	}
	
	private static String MD5Encoder( String password ) throws NoSuchAlgorithmException
	{
	    	MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(password.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        
	        for (int i = 0; i < byteData.length; i++) 
	        {
	            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        return sb.toString();
	}

}
