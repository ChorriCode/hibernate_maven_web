package controller.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Libro;
import model.modelDAO.DatosDAO;

/**
 * Servlet implementation class ControllerServletMain
 */
@WebServlet("/ControllerServletMain")
public class ServletControllerMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControllerMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		System.out.println("estoy dentro de init ControllerServletMain");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession mySession = request.getSession(true);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DatosDAO<Libro> accesoLibro = new DatosDAO<Libro>(Libro.class);
		ArrayList<Libro> listadoLibros = accesoLibro.getListadoDatos();
		request.setAttribute("listadoLibros", listadoLibros);
		request.getRequestDispatcher("jsp/menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
