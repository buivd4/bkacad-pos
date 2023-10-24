package com.bkacad.app.view.login;

import com.bkacad.app.view.AbstractView;
import com.bkacad.app.view.menu.AdminMenu;

public class LoginSuccess extends AbstractView{

    public void render() throws Exception {
        AdminMenu am = new AdminMenu();
        am.render();
    }
    
}
