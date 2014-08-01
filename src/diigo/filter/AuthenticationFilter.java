package diigo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diigo.beans.PagesBean;
import diigo.beans.SessionBean;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		SessionBean session = (SessionBean) ((HttpServletRequest)req).getSession().getAttribute("sessionBean");
		
		if(session == null || !session.isLoggedIn()) {
			String contextPath = ((HttpServletRequest) req).getContextPath();
			((HttpServletResponse)resp).sendRedirect(contextPath + PagesBean.LOGIN_PAGE );
		}
		
		//TODO: authentication regarding user type (pages allowed)
		//diigo user or jsf2 demo user
		
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
