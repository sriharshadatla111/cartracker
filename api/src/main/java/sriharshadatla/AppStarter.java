package sriharshadatla;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import sriharshadatla.config.JPAConfig;

public class AppStarter extends AbstractAnnotationConfigDispatcherServletInitializer{


    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{Application.class, JPAConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
