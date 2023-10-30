package com.bkacad.app.views;

import com.bkacad.app.exception.AbstractException;

public abstract class AbstractView {    
    public abstract void render() throws AbstractException;
}
