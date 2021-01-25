package issac.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author issac.hu
 */
public class MyServlet extends HttpServlet {
    /**
     * 1、 resp.sendRedirect("index.jsp");
     * index.jsp 和 /index.jsp的区别 前者是相对路径，比如此时请求的路径为
     * http://localhost:8080/myServlet/test
     * 那么前者就是http://localhost:8080/myServlet/index.jsp 而后者为http://localhost:8080/index.jsp
     * 也即这里是相对于servlet的，如果servlet的mapping是/ppp/xxx那么此时的路径就是
     * http://localhost:8080/myServlet/ppp/index.jsp
     * <p>
     * <p>
     * 2、req.getContextPath()
     * <p>
     * 这里是war的路径，比如放在ROOT目录下的就是这里的上下文路径就是空
     * 3、req.getServletPath()
     * 这里是servlet配置的路径
     * 完整的getRequestURL为：
     * req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + req.getServletPath()
     * <p>
     * req.getRequestURI() = req.getContextPath() + req.getServletPath()
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet doGet");
        resp.sendRedirect("index.jsp");
    }


    @Override
    public void init() throws ServletException {
        System.out.println("servlet init()");
    }

    @Override
    public void destroy() {
        System.out.println("servlet destroy()");
    }
}
