
package com.mycompany.lab7team2.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserList {
    
     private Map<String, User> userList;
    
    public UserList() {
        userList = new HashMap<>();
        populateUserList();
    }
    
    public void addUser(User user) {
        userList.put(user.getUserName(), user);
    }
    
    public User getUserById(String userId) {
        return userList.get(userId);
    }
    
    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        for (User user : userList.values()) {
            users.add(user);
        }
        return users;
    }
    
    public User updateUserID(String existingUserId, String newUserId) {
        
        User user = userList.get(existingUserId);
        
        if (user == null) {
            return null;
        }
         
        user.setUserName(newUserId);
        userList.remove(existingUserId);
        this.addUser(user);
        
        return user;
    } 
    
    public User deleteUserById(String userId) {
        return userList.remove(userId);
      
    }
    
    private void populateUserList(){
        User userOne = new User("John", "Doe", "jdoe", 34);
        User userTwo = new User("Eric", "Jones", "ejones", 34);
        userList.put(userOne.getUserName(), userOne);
        userList.put(userTwo.getUserName(), userTwo);
        
    }
}
