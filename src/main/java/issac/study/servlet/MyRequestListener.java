package issac.study.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * listener是有好几个的
 *
 * @author issac.hu
 */
public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request listener destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request listener initialized");
    }
}
