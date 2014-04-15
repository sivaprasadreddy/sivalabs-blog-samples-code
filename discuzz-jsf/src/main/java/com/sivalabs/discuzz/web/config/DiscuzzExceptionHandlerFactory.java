
package com.sivalabs.discuzz.web.config;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class DiscuzzExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory base;
    
    private ViewExpiredExceptionHandler cached;
    
    public DiscuzzExceptionHandlerFactory(ExceptionHandlerFactory base) {
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
