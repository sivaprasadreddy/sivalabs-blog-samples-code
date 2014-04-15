
package com.sivalabs.phonebook.web;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory base;
    
    private ViewExpiredExceptionHandler cached;
    
    public CustomExceptionHandlerFactory(ExceptionHandlerFactory base) {
        this.base = base;
    }
    
    @Override
    public ExceptionHandler getExceptionHandler() {
        if(cached == null) {
            cached = new ViewExpiredExceptionHandler(base.getExceptionHandler());
        }
        
        return cached;
    }
}
