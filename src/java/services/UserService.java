/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;
import models.*;
import dataaccess.UserDB;
import java.util.List;
import models.Role;

/**
 *
 * @author BTran
 */
public class UserService {
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    
    public boolean insert(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception { 
        User user = new User();
        UserDB userDB = new UserDB();
        
        user.setEmail(email);
        user.setActive(activity);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setPassword(password);
        user.setRole(role);
        
        boolean inserted = userDB.insert(user);
        return inserted;
        
    }
    
    
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    
    
    public boolean update(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception{
        UserDB userDB = new UserDB();
        
        User user = userDB.get(email);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setRole(role);
        
        boolean updated = userDB.update(user);
        return updated;
        
        
    }
    
    
    public boolean delete(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        boolean deleted = userDB.delete(user);
        
        return deleted;
    }


}






