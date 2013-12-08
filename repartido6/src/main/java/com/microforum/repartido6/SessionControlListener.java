package com.microforum.repartido6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionControlListener
 * 
 */
public class SessionControlListener implements ServletContextListener, HttpSessionListener {
	/**
	 * Default constructor.
	 */
	public SessionControlListener() {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent evt) {
		synchronized (evt.getServletContext()) {
			ServletContext servletContext = evt.getServletContext();
			servletContext.setAttribute("contadorSesiones", new Integer(0));
		}
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent evt) {
		synchronized (evt.getSession().getServletContext()) {
			Integer contadorSesiones = (Integer) evt.getSession().getServletContext().getAttribute("contadorSesiones");
			contadorSesiones++;
			evt.getSession().getServletContext().setAttribute("contadorSesiones", contadorSesiones);
			if (contadorSesiones > 2) {
				evt.getSession().invalidate();
			}
		}
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent evt) {
		synchronized (evt.getSession().getServletContext()) {
			try {
				Integer contadorSesiones = (Integer) evt.getSession().getServletContext().getAttribute("contadorSesiones");
				contadorSesiones--;
				evt.getSession().getServletContext().setAttribute("contadorSesiones", contadorSesiones);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}
}
