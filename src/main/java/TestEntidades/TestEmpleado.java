package TestEntidades;

import java.util.Date;
import java.util.List;

import Dao.ClassCrudEmpleadoImp;
import model.TblEmpleado;

public class TestEmpleado {

	public static void main(String[] args) {
		// realizamos las respectibas instancias
		TblEmpleado tblemp=new TblEmpleado();
		ClassCrudEmpleadoImp crud=new ClassCrudEmpleadoImp();
		/*	 tblemp.setNombre("Abel");
		 tblemp.setApellido("Matias");
		 tblemp.setSexo("F");
		 tblemp.setEmail("Abelm@gmail.com");
		 tblemp.setDni("18877767");
		 tblemp.setTelf("965464347");
		 //convertir  la fecha a javasql
		 Date fecha=new Date();
		 Date fechasql=new Date(fecha.getTime());
		 tblemp.setFechanac(fechasql);
		 //invocamos wel metodo registrar 
		 crud.RegistrarEmpleado(tblemp);
		 //EMITIMOS mensaje por consola
		 System.out.println("dato registeado en la BD");*/
		
		//actualizarrrrr,,,,,,,,,,,,,,,,,,,,..........
		
		/*tblemp.setIdempleado(2);
		tblemp.setNombre("Nilson Alezxander");
		 tblemp.setApellido("silva silva");
		 tblemp.setSexo("M");
		 tblemp.setEmail("Nilson@gmail.com");
		 tblemp.setDni("765765434");
		 tblemp.setTelf("998765646");
		//convertir  la fecha a javasql
		 Date fecha=new Date();
		 Date fechasql=new Date(fecha.getTime());
		 tblemp.setFechanac(fechasql);
		 crud.ActualizarEmpleado(tblemp);
		//EMITIMOS mensaje por consola
		 System.out.println("datos actualizados en la BD");*/
		
		
		
		//ELIMINARRRRRR
		
		/*tblemp.setIdempleado(6);
		//invocamos el metod eliminar
		crud.EliminarEmpleado(tblemp);*/
		
		
		//METODO LISTADOOO.....
		 	List<TblEmpleado> listar=crud.ListadoEmpleado();
		 	for(TblEmpleado lis:listar){
		 		//imprimimos por pantalla
		 		System.out.println("Codigo " + lis.getIdempleado() + " Nombre " + lis.getNombre() + " Apellido " +
		 		lis.getApellido() + " Sexo " + lis.getSexo() + " Email " + lis.getEmail() + " DNI " + lis.getDni() +
		 		" Telefono " + lis.getTelf() + " Fecha Naci " + lis.getFechanac());
		 		
		 		
		 	}//fin del bucle for   */
		
		// METODO BUSCAR....--------------------
		tblemp.setIdempleado(4);
		TblEmpleado buscod=crud.BuscarEmpleadoCodigo(tblemp);
		//Imprimimos por pantalla
		System.out.println("Codigo " + buscod.getIdempleado() + " Nombre " + buscod.getNombre() + " Apellido " +
				buscod.getApellido() + " Sexo " + buscod.getSexo() + " Email " + buscod.getEmail() + " DNI " + buscod.getDni() +
		 		" Telefono " + buscod.getTelf() + " Fecha Naci " + buscod.getFechanac());
		  
		  
		 

	}// fin del metodo principal
	

} // fin de la clase testempleado
