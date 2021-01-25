package issac.study.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author issac.hu
 */
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context listener initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context listener destroyed");
    }
}
