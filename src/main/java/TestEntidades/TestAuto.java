package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblAuto;

public class TestAuto {

	public static void main(String[] args) {
		// establecer la conexion con la unidad de persistencia....
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoMavenLPIIMartes");
		//gestionar entidades  ENTIDADES COMO registrar actualizar eliminar buscar....
		EntityManager emanager=conex.createEntityManager();
		// iniciamos la transaccion...(iniciar las operaciones como el crud..)
		emanager.getTransaction().begin();
		
		//realisamos una instancia..
		TblAuto auto=new TblAuto();
		
		//aplicamos un switch..
		String accion=JOptionPane.showInputDialog("Ingrese la Accion");
		switch(accion){
		
		case "Registrar":
		  //ingresa,os valores a enviar ala base de datos
			auto.setColor("whit");
			auto.setModelo("lambo");
			auto.setMotor("1.2");
			auto.setPrecio(19000);
			auto.setMarca("deportibo");
			auto.setFabricacion("2023");
			//registramos los datos con persist
			emanager.persist(auto);
			//amitimos un mensaje por consola
			System.out.println("Datos registrados en la BD");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos la tranccion
			emanager.close();
		     
			//salimos
			break;
		case "Actualizar":
			auto.setIdauto(4);
			auto.setColor("azul claro");
			auto.setModelo("f1");
			auto.setMotor("1.8");
			auto.setPrecio(30000);
			auto.setMarca("BMW");
			auto.setFabricacion("2023");
			//realizamos al actualizacion
			//update tbl_auto set color="marron"
			emanager.merge(auto);
			//emitimos un mensaje..
			System.out.println("Datos actualizados correctamente");
			//confirmamos
			emanager.getTransaction().commit();
			//cerrramos
			emanager.close();
			//salimos
			break;
			
		case "Eliminar":
			//codigo elimnar
			auto.setIdauto(4);
			TblAuto elim=emanager.merge(auto);
			//realizamos la eliminacion...
			//en jdbc delete from tbl_auto where idauto
			emanager.remove(elim);
			//imprimimos el mensaje por la pantalla...
			System.out.println("Datos eliminados de la base de datos");
			//confirmamos
			emanager.getTransaction().commit();
			//cerrramos
			emanager.close();
			//salimos
			break;
			
			
		case "Buscar":
			//en jdbc : select * from tbl_auto where idauto=3;
			TblAuto busc=emanager.find(TblAuto.class,1);
			//aplicamos condicion
			if(busc==null){
				//emiitmos mensaje por pantalla
				System.out.println("Registro no encontrado");
			}else{
				System.out.println("Registro encontrado");
				//imprimimos por pantalla las caracteristicas del registro
				System.out.println(" codigo " +busc.getIdauto() + " color " + busc.getColor() + " modelo " +
				busc.getModelo() + " motor " + busc.getMotor() + " precio " + busc.getPrecio() + " marca " +
						busc.getMarca() + " fabricacion " + busc.getFabricacion());
			}
			//confirmamos
			emanager.getTransaction().commit();
			//cerrramos
			emanager.close();
			//salimos
			break;
		case "Listar":
			//en sql select * from tbl_auto auto..
			//Tblauto a =new tblasuto();
			//en JPQL select a from tblauto a entronces en la programacion en JPQL es con la entidades
			List<TblAuto> listado=emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
			//mostramos  los datos por consola
			for(TblAuto list:listado){
				//imprimimos 
				System.out.println(" codigo " +list.getIdauto() + " color " + list.getColor() + " modelo " +
						list.getModelo() + " motor " + list.getMotor() + " precio " + list.getPrecio() + " marca " +
						list.getMarca() + " fabricacion " + list.getFabricacion() );
			}//fin del bucle
			
			//confirmamos
			emanager.getTransaction().commit();
			//cerrramos
			emanager.close();
			//salimos
			break;
			
			
			//segunda formna de eliminar en JPA
			
		case "Eliminar2":
			//eliminamos el codigo 3
			TblAuto elimiII=emanager.find(TblAuto.class,4);
			//aplicamos una condicion
			if(elimiII==null){
				//emitimos un mensaje
				System.out.println("El codigo no existe en la BD...");
				
			}else{
				//emitmos un mensaje por pantalla
				System.out.println("Registro encontrado");
				//eliminamos el registro
				emanager.remove(elimiII);
				emanager.getTransaction().commit();
				//cerrramos
				emanager.close();
				//amitimos mensaje por consola
			System.out.println("codigo eliminado de la base de datos");
								
			}
			//salimos
			break;
			
			
			
			default:
				//amitimos mensaje por pantalla
				System.out.println("Accion no encontrada");
				
				//salimos
				break;
			
		}//fin del switch
		

		
		
	}//fin del metodo principal

	
	
}//fin de la clases
