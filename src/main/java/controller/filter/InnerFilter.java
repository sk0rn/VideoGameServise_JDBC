package controller.filter;

import constants.WEBConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InnerFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpSession httpSession = httpServletRequest.getSession();

        if (httpSession.getAttribute(WEBConstants.LOGIN) != null) {
            chain.doFilter(req, resp);
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +
                    WEBConstants.ERROR_CODE_LOGIN+WEBConstants.ACCESS_DENIED);
        }


    }

    @Override
    public void destroy() {

    }
}
