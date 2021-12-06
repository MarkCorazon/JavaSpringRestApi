package com.markcorazon.animals;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApiInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {WebAppConfig.class};
    }

    protected Class<?>[] getServletConfigClasses()  {
        return null;
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
