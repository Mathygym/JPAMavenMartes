package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IDocumentoable;
import model.TblDocumento;

public class ClassCrudDocumentoImp implements IDocumentoable{

	@Override
	public void RegistrarDocumento(TblDocumento tbdocumen) {
		// establecemso conexion con la unidad de persitencia
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//PERMITE gestionar las entidades
		EntityManager eman=fabri.createEntityManager();
		//iniciar la transaccion..
		eman.getTransaction().begin();
		//registramos
		eman.persist(tbdocumen);
		//confirmamos
		eman.getTransaction().commit();
		//CERRAMOS LA TRANSACCION
		eman.close();
		
	}//fin del emtodo registear

	@Override
	public void ActualizarDocumento(TblDocumento tbdocumen) {
		// establecemso conexion con la unidad de persitencia
				EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
				//PERMITE gestionar las entidades
				EntityManager eman=fabri.createEntityManager();
				//iniciar la transaccion..
				eman.getTransaction().begin();
				//actualñizar
				eman.merge(tbdocumen);
				//confirmamos
				eman.getTransaction().commit();
				//CERRAMOS LA TRANSACCION
				eman.close();
		
	}//fin del metodo actualiar

	@Override
	public void EliminarDocumento(TblDocumento tbdocumen) {
		// establecemso conexion con la unidad de persitencia
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//PERMITE gestionar las entidades
		EntityManager eman=fabri.createEntityManager();
		//iniciar la transaccion..
		eman.getTransaction().begin();
		
	}//fin del meotod eliminar

	@Override
	public List<TblDocumento> ListadoDoucmento() {
		// establecemso conexion con la unidad de persitencia
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//PERMITE gestionar las entidades
		EntityManager eman=fabri.createEntityManager();
		//iniciar la transaccion..
		eman.getTransaction().begin();
		List<TblDocumento> listado=eman.createQuery("select docu from TblDocumento docu",TblDocumento.class).getResultList();
		//retornamos el listado
		return listado;
	}//fin del metood listar

	@Override
	public TblDocumento BuscarDocuemnto(TblDocumento tbdocumen) {
		// establecemso conexion con la unidad de persitencia
				EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
				//PERMITE gestionar las entidades
				EntityManager eman=fabri.createEntityManager();
				//iniciar la transaccion..
				eman.getTransaction().begin();
				TblDocumento buscadoc=eman.find(TblDocumento.class, tbdocumen.getIddocument());
		return buscadoc;
	}//fin del meotd buscar

}
