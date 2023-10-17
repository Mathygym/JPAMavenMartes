package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IEmpleadoable;
import model.TblEmpleado;

public class ClassCrudEmpleadoImp implements IEmpleadoable{

	@Override
	public void RegistrarEmpleado(TblEmpleado tblemp) {
		// establecemos la coneccion con la unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejamos la entidades segun unidad de persistencia
		EntityManager entitymanag=conex.createEntityManager();
		//realizamos el proceso iniciar transaccion
		entitymanag.getTransaction().begin();
		//REGISTRAMOS DATOS
		entitymanag.persist(tblemp);
		//confirmamos
		entitymanag.getTransaction().commit();
		//cerramos
		entitymanag.close();
			
	}//fin del metodo registrar

	@Override
	public void ActualizarEmpleado(TblEmpleado tblemp) {
		// establecemos la coneccion con la unidad de persistencia
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
				//manejamos la entidades segun unidad de persistencia
				EntityManager entitymanag=conex.createEntityManager();
				//realizamos el proceso iniciar transaccion
				entitymanag.getTransaction().begin();
				//acccccc
				entitymanag.merge(tblemp);
				//actualizar datos
				entitymanag.getTransaction().commit();
				//cerrais
				entitymanag.close();
		
	}//fin del metood actualizar

	@Override
	public void EliminarEmpleado(TblEmpleado tblemp) {
		// establecemos la coneccion con la unidad de persistencia
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
				//manejamos la entidades segun unidad de persistencia
				EntityManager entitymanag=conex.createEntityManager();
				//realizamos el proceso iniciar transaccion
				entitymanag.getTransaction().begin();
				//recuperar el codigoa eliminar..
				TblEmpleado elim=entitymanag.merge(tblemp);
				//eliminamos el dato de la base de datos
				entitymanag.remove(elim);
				System.out.println("Dato elimonaod de la BD");
				//confirmamos
				entitymanag.getTransaction().commit();
				//cerrais
				entitymanag.close();
				
		
	}//fin del metodo eliminar

	@Override
	public List<TblEmpleado> ListadoEmpleado() {
		// establecemos la coneccion con la unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejamos la entidades segun unidad de persistencia
		EntityManager entitymanag=conex.createEntityManager();
		//realizamos el proceso iniciar transaccion
		entitymanag.getTransaction().begin();
		
		// aplicamos jpql se basa en entidad.....
		List<TblEmpleado> listado=entitymanag.createQuery("select e from TblEmpleado e",TblEmpleado.class).getResultList();
		//confirmamos
		entitymanag.getTransaction().commit();
		//cerrais
		entitymanag.close();
		//retornamos el listado
		return listado;
	}//fin del metodo listar

	@Override
	public TblEmpleado BuscarEmpleadoCodigo(TblEmpleado tblemp) {
		// establecemos la coneccion con la unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejamos la entidades segun unidad de persistencia
		EntityManager entitymanag=conex.createEntityManager();
		//realizamos el proceso iniciar transaccion
		entitymanag.getTransaction().begin();
		
		TblEmpleado buscar=entitymanag.find(TblEmpleado.class,tblemp.getIdempleado());
		//
		//confirmamos
		entitymanag.getTransaction().commit();
		//cerrais
		entitymanag.close();
		
		return buscar;
	}// fin del metood buscar

}
