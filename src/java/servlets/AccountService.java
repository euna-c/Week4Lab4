/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import model.User;

/**
 *
 * @author 784564
 */
public class AccountService {
    
    User user;
    String name;
    String password;
 

    public AccountService(String name, String password) {
        
        this.name=name;
        this.password=password;
    }

    
    
    
    public User login(String username, String password)
    {
        if(username.equals("betty") && password.equals("password"))
        {
            
            user = new User(username, password);
            user.setPassword(null);
            return user;
        }
        if(username.equals("adam") && password.equals("password"))
        {
            
            user = new User(username, password);
            user.setPassword(null);
            return user;
        }
        return null;
    
    }
}
