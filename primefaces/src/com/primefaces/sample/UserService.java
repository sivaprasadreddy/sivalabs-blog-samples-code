package com.primefaces.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserService
{
    private static final Map<Integer, User> USERS_TABLE = new HashMap<Integer, User>();
    static
    {
        USERS_TABLE.put(1, new User(1, "Administrator", "admin@gmail.com", "9000510456", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(2, new User(2, "Guest", "guest@gmail.com", "9247469543", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(3, new User(3, "John", "John@gmail.com", "9000510456", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(4, new User(4, "Paul", "Paul@gmail.com", "9247469543", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(5, new User(5, "raju", "raju@gmail.com", "9000510456", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(6, new User(6, "raghav", "raghav@gmail.com", "9247469543", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(7, new User(7, "caren", "caren@gmail.com", "9000510456", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(8, new User(8, "Mike", "Mike@gmail.com", "9247469543", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(9, new User(9, "Steve", "Steve@gmail.com", "9000510456", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(10, new User(10, "Polhman", "Polhman@gmail.com", "9247469543", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(11, new User(11, "Rogermoor", "Rogermoor@gmail.com", "9000510456", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(12, new User(12, "Robinhood", "Robinhood@gmail.com", "9247469543", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(13, new User(13, "Sean", "Sean@gmail.com", "9000510456", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(14, new User(14, "Gabriel", "Gabriel@gmail.com", "9247469543", new Date(), "M", "Hyderabad"));
        USERS_TABLE.put(15, new User(15, "raman", "raman@gmail.com", "9000510456", new Date(), "M", "Hyderabad"));
        
    }
    public Integer create(User user)
    {
        if(user == null)
        {
            throw new RuntimeException("Unable to create User. User object is null.");
        }
        Integer userId = this.getMaxUserId();
        user.setUserId(userId);
        USERS_TABLE.put(userId, user);
        return userId;
    }

    public void delete(User user)
    {
        if(user == null)
        {
            throw new RuntimeException("Unable to delete User. User object is null.");
        }
        USERS_TABLE.remove(user.getUserId());
    }

    public Collection<User> getAllUsers()
    {
        return USERS_TABLE.values();
    }

    public User getUser(Integer userId)
    {
        return USERS_TABLE.get(userId);
    }

    public Collection<User> searchUsers(String username)
    {
        String searchCriteria = (username == null)? "":username.toLowerCase().trim();
        Collection<User> users = USERS_TABLE.values();
        Collection<User> searchResults = new ArrayList<User>();
        for (User user : users)
        {
            if(user.getUsername() != null && user.getUsername().toLowerCase().trim().startsWith(searchCriteria))
            {
                searchResults.add(user);
            }
        }
        return searchResults;
    }

    public void update(User user)
    {
        if(user == null || !USERS_TABLE.containsKey(user.getUserId()))
        {
            throw new RuntimeException("Unable to update User. User object is null or User Id ["+user.getUserId()+"] is invalid." );
        }
        USERS_TABLE.put(user.getUserId(), user);
    }
    
    protected Integer getMaxUserId()
    {
        Set<Integer> keys = USERS_TABLE.keySet();
        Integer maxId = 1;
        for (Integer key : keys)
        {
            if(key > maxId)
            {
                maxId = key;
            }
        }
        return maxId;
    }
}