
package service;

import models.users;

public class Account {
    public users login(String username, String password){
        if((username.equals("abe")|| username.equals("barb"))
                && password.equals("password")){
            return new users(username, null);
    }
        return null;
    }
}
