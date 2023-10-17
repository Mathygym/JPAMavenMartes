package TestEntidades;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblDocumento;
import model.TblTipoducumento;
import sun.dc.DuctusRenderingEngine;

public class TestDocumento {

	public static void main(String[] args) {
		// establecemso conexion con la unidad de persitencia
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//PERMITE gestionar las entidades
		EntityManager eman=fabri.createEntityManager();
		//iniciar la transaccion..
		eman.getTransaction().begin();
		//INSTACIAMOS LAS RESPECTIVAS ENTIDADES-....
		TblTipoducumento tipodocu=new TblTipoducumento();
		TblDocumento  docum=new TblDocumento();
		//ingresamos nuevos valores
		/*tipodocu.setNomdocum("boleta");
		tipodocu.setDescripdocum("comprobante de pago");
		eman.persist(tipodocu);
		docum.setNrodocument("534453455");
		docum.setProvedocument("vetrianaria e.i.r.l");
		docum.setRucdocumen("2078876669");
		Date fecha=new Date();
		Date fechasql=new Date();
		docum.setFecha(fechasql);
		docum.setDescridocumen("RECOLECTAR IGV para la sunat");
		docum.setTblTipoducumento(tipodocu);
		eman.persist(docum);
		//amitimos un mensaj epor consola
		System.out.println("Dato Registrado");
		eman.getTransaction().commit();
		//CERRAMOS
		eman.close();*/
		
		//ACTUALIZAR......................
		/*tipodocu.setIdtipodocum(1);
		tipodocu.setNomdocum("ticket");
		tipodocu.setDescripdocum("para llevar control interno");
		eman.merge(tipodocu);
		docum.setIddocument(1);
		docum.setNrodocument("77566755");
		docum.setProvedocument("pliclinico lima");
		docum.setRucdocumen("2020201012");
		Date fecha=new Date();
		Date fechaact= new Date(fecha.getTime());
		docum.setFecha(fechaact);
		docum.setDescridocumen("comprovante de pago");
		docum.setTblTipoducumento(tipodocu);
		eman.merge(docum);
		//amitimos un mensaje por cosnola
		//amitimos un mensaj epor consola
        System.out.println("Dato actualizado");
		eman.getTransaction().commit();
		//CERRAMOS
		eman.close();*/
		
		//*******LISTADO
		/*List<TblDocumento>listado=eman.createQuery("select docu from TblDocumento docu",TblDocumento.class).getResultList();
		//APLICAMOS UN BUCLE
		for(TblDocumento lis:listado){
			System.out.println("codido " + lis.getIddocument() + " nro documento " + lis.getNrodocument() + " nombre proveedor " + lis.getProvedocument()+ " ruc de docum " + lis.getRucdocumen()
			+ " fecha " + lis.getFecha() + " descrip docu " + lis.getDescridocumen()+ "codigo tipo documento " +
			lis.getTblTipoducumento().getIdtipodocum() + " NOMBRE DOCUEMNTO "+ lis.getTblTipoducumento().getNomdocum()+
			" descrip tipo documento " + lis.getTblTipoducumento().getDescripdocum());
		}//fin del bucle for*/
		
		// buscar por codigo
		TblDocumento buscarcodigo=eman.find(TblDocumento.class,3);
		System.out.println("codido " + buscarcodigo.getIddocument() + " nro documento " + buscarcodigo.getNrodocument() + " nombre proveedor " + buscarcodigo.getProvedocument()+ " ruc de docum " + buscarcodigo.getRucdocumen()
			+ " fecha " + buscarcodigo.getFecha() + " descrip docu " + buscarcodigo.getDescridocumen()+ "codigo tipo documento " +
			buscarcodigo.getTblTipoducumento().getIdtipodocum() + " NOMBRE DOCUEMNTO "+ buscarcodigo.getTblTipoducumento().getNomdocum()+
			" descrip tipo documento " + buscarcodigo.getTblTipoducumento().getDescripdocum());
		

	}//fin del metodo pprincipal
	

}//fin del test documento
