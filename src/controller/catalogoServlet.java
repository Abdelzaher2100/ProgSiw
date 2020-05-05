package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/catalogo")
public class catalogoServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		System.out.println("partita servlet di catalogo");
		
		String paramStart= req.getParameter("trip-start");
		String paramEnd = req.getParameter("trip-end");
		session.setAttribute("dataInizio", paramStart);
		session.setAttribute("dataFine", paramEnd);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String search = null;
			search = (paramStart);
		
		//int giorni = dataFine.getDay()-dataInizio.getDay();
		session.setAttribute("keyword", search);
		
		
		RequestDispatcher disp;
		
			 // se non sei admin mandalo a catalogo 
			if((Boolean)session.getAttribute("admin")==false) {
			disp = req.getRequestDispatcher("catalogo.jsp");
			}
			else // se sei admin mandalo a registrazione walkin
			disp = req.getRequestDispatcher("registrazioneWalkin.jsp");
			disp.forward(req, resp);
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
