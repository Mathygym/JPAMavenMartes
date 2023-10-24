package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IAutoable;
import model.TblAuto;

public class ClassCrudAutoImp  implements IAutoable{

	@Override
	public void RegistrarAuto(TblAuto tblauto) {
		// establecer coneccion con la uniodad de persistencia
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("ProyectoMavenLPIIMartes");
		//PERMITE gestionar las entidades
		EntityManager manager=factory.createEntityManager();
		//iniciar la transaccion..
		manager.getTransaction().begin();
		//registramos
		manager.persist(tblauto);
		//confirmamo
		manager.getTransaction().commit();
		//cerrramos
		manager.close();
		
	}//fin de registrar

	@Override
	public void ActualizarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}//fin del metood actualizar

	@Override
	public void EliminarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}//fin del metood eliminar

	@Override
	public List<TblAuto> ListadoAuto() {
		// 
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("ProyectoMavenLPIIMartes");
		//PERMITE gestionar las entidades
		EntityManager manager=factory.createEntityManager();
		//iniciar la transaccion..
		manager.getTransaction().begin();
		List<TblAuto> ListaAuto=manager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
		//confirmamos
		manager.getTransaction().commit();
		//cerramos
		manager.close();
		return ListaAuto;
	}//fin del metodo listar

	@Override
	public TblAuto BuscarAuto() {
		// TODO Auto-generated method stub
		return null;
	}// fi del metodo listar

}
