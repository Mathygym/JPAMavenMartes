package TestEntidades;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblCategoria;
import model.TblProducto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//establecemos coneccion con la uniodad de persistencia
		EntityManagerFactory facto=Persistence.createEntityManagerFactory("BDAutoJPA");
		//MENJADOR DE ENTIODADES
		EntityManager eman=facto.createEntityManager();
		//proceso registrar, actualizar , listar etc....
		//inicmaos tranccion
		eman.getTransaction().begin();
		//ISNTACIAMOS LAS RESPECTIVAS ENTIDADES...
		TblCategoria tblcat=new TblCategoria();
		TblProducto tblprod=new TblProducto();
		//*************registar*****
		/*tblcat.setNomcateg("Otros");
		tblcat.setDescrip("producto de alto y bajo precio");
		
		//******ingresamos datos ala tabla producto**********
		tblprod.setMonprod("Panadol");
		tblprod.setPrecio(20);
		Date fech=new Date();
		Date fechasql=new Date(fech.getTime());
		tblprod.setFechavenc(fechasql);
		tblprod.setCodbarras("777876");
		tblprod.setNrolote("L968854");
		//asignamos al objeto tblcat
		tblprod.setTblCategoria(tblcat);
		eman.persist(tblprod);
		//amitimos mensaje por pantalla
		System.out.print("Dato Registrado");
		//confirnmamo
		eman.getTransaction().commit();
		//cerramos
		eman.close();*/
		
		//******actualizarr*******
		tblcat.setIdcategoria(1);
		tblcat.setNomcateg("Generico");
		tblcat.setDescrip("Recomendado pro el ministro de salud");
		tblprod.setIdproducto(1);
		tblprod.setMonprod("Paracetamol");
		tblprod.setPrecio(8);
		Date fech=new Date();
		Date fechasql=new Date(fech.getTime());
		tblprod.setFechavenc(fechasql);
		tblprod.setCodbarras("9992939");
		tblprod.setNrolote("L99821");
		tblprod.setTblCategoria(tblcat);
		eman.merge(tblprod);
		//amitimos mensaje por pantalla
		System.out.print("Dato Actualizado");
		//confirnmamo
		eman.getTransaction().commit();
		//cerramos
		eman.close();
		

	}//fin del main

}//fin del tast producto
