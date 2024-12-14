package srv;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticoloDao;
import model.Articolo;

/**
 * Servlet implementation class ArticoloSrv
 */
@WebServlet("/ArticoloSrv")
public class ArticoloSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticoloSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String operazione = request.getParameter("operazione");
		
		ArticoloDao aDao = new ArticoloDao();
		
		if(operazione.equals("inserimento")) {
		
		String descrizione = request.getParameter("descrizione");
		String quant = request.getParameter("quantita");
		int quantita = Integer.parseInt(quant);
		
		Articolo a = new Articolo();
		a.setDescrizione(descrizione);
		a.setQuantita(quantita);
		
		try {
			aDao.insert(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(operazione.equals("update")) {
			
			String descrizione = request.getParameter("descrizione");
			String quant = request.getParameter("quantita");
			int quantita = Integer.parseInt(quant);
			String cod = request.getParameter("codice");
			int codice = Integer.parseInt(cod);
			
			Articolo a = new Articolo();
			a.setDescrizione(descrizione);
			a.setQuantita(quantita);
			a.setCodice(codice);
			
			try {
				aDao.update(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(operazione.equals("delete")) {
			
			String cod = request.getParameter("codice");
			int codice = Integer.parseInt(cod);
			
		
			try {
				aDao.delete(codice);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
if(operazione.equals("find")) {
			
			String cod = request.getParameter("codice");
			int codice = Integer.parseInt(cod);
			
				aDao.getByCode(codice);
		}
		
	if(operazione.equals("findAll")) {
		
		List<Articolo> listaArticoli = aDao.getAll();
		
		request.getSession().setAttribute("elencoArticoli", listaArticoli);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/elencoArticoli.jsp");
		dispatcher.forward(request,response);
		// per poter indicare la pagina che volgiamo aprire dobbiamo agire con il request dispacher e richiamare il metodo forward
	
	}else
	
	response.getWriter().append("Served at: ").append(request.getContextPath());
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
