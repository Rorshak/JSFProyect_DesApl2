package utng.jsf.filters;

import java.io.IOException;
import java.rmi.ServerException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = { "Faces Servelet" })
public class JPAFilter implements Filter {

	private EntityManagerFactory emf;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		emf = Persistence.createEntityManagerFactory("testdb");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
			throws IOException, ServletException {
		EntityManager entityManger = emf.createEntityManager();
		request.setAttribute("entityManger", entityManger);
		entityManger.getTransaction().begin();
		fc.doFilter(request, response);
		try {
			entityManger.getTransaction().commit();
		} catch (Exception e) {
			entityManger.getTransaction().rollback();
			throw new ServerException(e.getMessage());
		} finally {
			entityManger.close();
		}
	}

	@Override
	public void destroy() {
		emf.close();
	}

}
