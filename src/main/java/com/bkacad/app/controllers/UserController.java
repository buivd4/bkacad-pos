package com.bkacad.app.controllers;

import com.bkacad.app.exception.ServerErrorException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.models.facade.UserDAOInterface;
import com.bkacad.app.views.menu.AdminHomeView;
import com.bkacad.app.views.popup.AnnouncementView;
import com.bkacad.app.views.user.UserAddView;
import com.bkacad.app.views.user.UserListView;
import com.bkacad.app.views.user.UserRemoveView;

public class UserController{
    UserDAOInterface userDAO;
    public UserController(UserDAOInterface userDAO){
        this.userDAO = userDAO;
    }
    public AnnouncementView<AdminHomeView> process(UserAddView view) throws ServerErrorException{
        userDAO.addUser(new User(view.username, view.password, view.role));
        return new AnnouncementView<AdminHomeView>(String.format("User <{}> added!", view.username), new AdminHomeView());
    }
    public UserListView process() throws ServerErrorException{
        return new UserListView(userDAO.findUser());
    }
    public AnnouncementView<AdminHomeView> process(UserRemoveView view) throws ServerErrorException{
        userDAO.delUser(view.username);
        return new AnnouncementView<AdminHomeView>(String.format("User <{}> deleted!", view.username),new AdminHomeView());
    }
}
