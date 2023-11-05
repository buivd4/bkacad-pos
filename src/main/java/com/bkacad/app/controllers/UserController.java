package com.bkacad.app.controllers;

import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.exception.ServerErrorException;
import com.bkacad.app.models.entity.User;
import com.bkacad.app.models.facade.UserDAO;
import com.bkacad.app.views.menu.AdminHomeView;
import com.bkacad.app.views.popup.AnnouncementView;
import com.bkacad.app.views.user.UserAddView;
import com.bkacad.app.views.user.UserEditView;
import com.bkacad.app.views.user.UsersView;
import com.bkacad.app.views.user.prompt.PromptUsernameForEditView;
import com.bkacad.app.views.user.prompt.PromptUsernameForReadView;
import com.bkacad.app.views.user.prompt.PromptUsernameForRemoveView;
import com.bkacad.app.views.user.UserRemoveView;
import com.bkacad.app.views.user.UserView;

public class UserController {
    UserDAO userDAO;
    public UserController(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    public AnnouncementView<AdminHomeView> process(UserAddView view) throws ServerErrorException{
        userDAO.addUser(new User(view.username, view.password, view.role));
        return new AnnouncementView<AdminHomeView>(String.format("User <%s> added!", view.username), new AdminHomeView());
    }
    public UsersView process() throws ServerErrorException{
        return new UsersView(userDAO.findUser());
    }
    public UserView process(PromptUsernameForReadView view) throws AbstractException{
        return new UserView(userDAO.findUser(view.username));
    }
    public UserRemoveView process(PromptUsernameForRemoveView view) throws AbstractException{
        return new UserRemoveView(userDAO.findUser(view.username));
    }
    public AnnouncementView<AdminHomeView> process(UserRemoveView view) throws AbstractException{
        userDAO.delUser(view.getUser().username);
        return new AnnouncementView<AdminHomeView>(String.format("User <%s> deleted!", view.getUser().username),new AdminHomeView());
    }
    public UserEditView process(PromptUsernameForEditView view) throws AbstractException{
        return new UserEditView(userDAO.findUser(view.username));
    }
    public AnnouncementView<AdminHomeView> process(UserEditView view) throws AbstractException{
        userDAO.editUser(view.getUser());
        return new AnnouncementView<AdminHomeView>(String.format("User <%s> updated!", view.getUser().username),new AdminHomeView());
    }

}
