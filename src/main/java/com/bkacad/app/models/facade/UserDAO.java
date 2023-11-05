package com.bkacad.app.models.facade;

import java.util.ArrayList;

import com.bkacad.app.exception.ServerErrorException;
import com.bkacad.app.exception.UserNotFoundException;
import com.bkacad.app.models.entity.User;

public interface UserDAO {
    public abstract void addUser(User user) throws ServerErrorException;
    public abstract void editUser(User user) throws ServerErrorException;
    public abstract void delUser(String username) throws ServerErrorException;
    public abstract User findUser(String username) throws ServerErrorException,UserNotFoundException;
    public abstract ArrayList<User>  findUser() throws ServerErrorException;
}
