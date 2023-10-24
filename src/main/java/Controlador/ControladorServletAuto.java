package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudAutoImp;
import model.TblAuto;

/**
 * Servlet implementation class ControladorServletAuto
 */
public class ControladorServletAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServletAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/GestionAuto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//recuperamos los valores del formulario
				String color=request.getParameter("color");
				String modelo=request.getParameter("modelo");
				String motor=request.getParameter("motor");
				double precio=Double.parseDouble(request.getParameter("precio"));
				String marca=request.getParameter("marca");
				String fabricacion=request.getParameter("fabricacion");
				//instanciamos las respectivas clases..
				TblAuto tblauto=new TblAuto();
				ClassCrudAutoImp crud = new ClassCrudAutoImp();
				//asignamos los prespectivos valores
				tblauto.setColor(color);
				tblauto.setModelo(modelo);
				tblauto.setMotor(motor);
				tblauto.setPrecio(precio);
				tblauto.setMarca(marca);
				tblauto.setFabricacion(fabricacion);
				//invocamos almetood registrar
				crud.RegistrarAuto(tblauto);
				//recuperamos listado de auots
				List<TblAuto> listadoauto=crud.ListadoAuto();
				//enviamos ala vista
				request.setAttribute("listado", listadoauto);
				//redireccionamos
				request.getRequestDispatcher("/GestionAuto.jsp").forward(request, response);
	}

}
