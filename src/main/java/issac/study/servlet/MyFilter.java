package issac.study.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author issac.hu
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter.init()");
    }

    /**
     * 这里必须写   chain.doFilter(request, response); 否则filter就直接失败了
     * 对于web.xml里面的       <url-pattern>/*</url-pattern> 如果是/ 是拦截不到 已配置的servlet的.
     * 当然对于servlet也是可以配置为<url-pattern>/*</url-pattern> 但是此时filter不能为此，因为这样会导致死循环
     * 如果改为<url-pattern>/</url-pattern>那此时就是可以的，是不是想到了springboot的DispatcherServlet
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter.doFilter()");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("filter.destroy()");
    }
}
