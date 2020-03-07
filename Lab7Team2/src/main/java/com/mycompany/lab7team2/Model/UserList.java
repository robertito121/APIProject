
package com.mycompany.lab7team2.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserList {
    
    private Map<String, User> userList;
    
    public UserList() {
        userList = new HashMap<>();
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
}
