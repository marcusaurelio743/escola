package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Login;
import util.HibernateUtil;



@WebFilter(urlPatterns = {"/*"})

public class FilterAltenticacaao extends HttpFilter implements Filter {
       private HibernateUtil util = new HibernateUtil();
    
	private static final long serialVersionUID = 1L;

	public FilterAltenticacaao() {
        super();
       
    }

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Login usuarioLogado = (Login) session.getAttribute("usuarioLogado");
		
		String url = req.getServletPath();
		
		if(!url.equalsIgnoreCase("index.jsf") && usuarioLogado == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsf");
			dispatcher.forward(request, response);
			return;
			
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		util.getenEntityManager();
	}

}
