package com.health.nutrition.common.base;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class BaseController implements ServletContextAware{

    protected ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext)
    {
        this.servletContext = servletContext;
    }
}
