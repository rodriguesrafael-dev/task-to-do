package br.com.tasktodo.appinitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import br.com.tasktodo.config.AppConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext configWeb = new AnnotationConfigWebApplicationContext();
		configWeb.register(AppConfig.class);
		configWeb.setServletContext(servletContext);
		servletContext.addListener(new ContextLoaderListener(configWeb));
		servletContext.addListener(new RequestContextListener());
		Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(configWeb));
		dynamic.addMapping("/webapp/index.xhtml");
		dynamic.setLoadOnStartup(1);	
	}
	
}
