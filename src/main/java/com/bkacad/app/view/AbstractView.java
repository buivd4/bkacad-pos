package com.bkacad.app.view;

import java.lang.ModuleLayer.Controller;

public abstract class AbstractView {
    private Controller controller;
    
    public abstract void render() throws Exception;
}
