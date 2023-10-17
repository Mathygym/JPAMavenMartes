package TestEntidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblAuto;
import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// establecer la conexion con la unidad de persistencia....
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
				//gestionar entidades  ENTIDADES COMO registrar actualizar eliminar buscar....
				EntityManager emanager=conex.createEntityManager();
				// iniciamos la transaccion...(iniciar las operaciones como el crud..)
				emanager.getTransaction().begin();
				
				//realisamos una instancia..
				TblCliente cliente=new TblCliente();
				//aplicamos un switch..
				String accion=JOptionPane.showInputDialog("Ingrese la Accion");
				switch(accion){
				
				case "Registrar":
					cliente.setNombre("masiel");
					cliente.setApellido("matias");
					cliente.setEmail("tableta@gmail.com");
					cliente.setDni("14645343");
					cliente.setSexo("f");
					//persist es para agregar datos
					emanager.persist(cliente);
					//amitimos un mensaje por consola
					System.out.println("Datos registrados en la BD");
					//confirmamos
					emanager.getTransaction().commit();
					//cerramos la tranccion
					emanager.close();
					//salimos
					break;
				case "Actualizar":
					cliente.setIdcliente(1);
					cliente.setNombre("abel");
					cliente.setApellido("albino");
					cliente.setEmail("tupapi@gmail.com");
					cliente.setDni("94343543");
					cliente.setSexo("m");
					//merge es para actualizar
					emanager.merge(cliente);
					//amitimos un mensaje por consola
					System.out.println("Datos actualizados en la  BD");
					//confirmamos
					emanager.getTransaction().commit();
					//cerramos la tranccion
					emanager.close();
					//salimos
					
					break;
				case "Eliminar":
					
					//codigo elimnar
					cliente.setIdcliente(7);
					TblCliente elim=emanager.merge(cliente);
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
					//salimos
					
				case "Buscar":
					//en jdbc : select * from tbl_auto where idauto=3;
					TblCliente busc=emanager.find(TblCliente.class,1);
					//aplicamos condicion
					if(busc==null){
						//emiitmos mensaje por pantalla
						System.out.println("Registro no encontrado");
					}else{
						System.out.println("Registro encontrado");
						//imprimimos por pantalla las caracteristicas del registro
						System.out.println(" codigo " +busc.getIdcliente() + " NOMBRE " + busc.getNombre() + " apellido " +
								busc.getApellido() + " email " + busc.getEmail() + " dni " + busc.getDni() + " sexo " +
								busc.getSexo());
					}
					//confirmamos
					emanager.getTransaction().commit();
					//cerrramos
					emanager.close();
					
					
					//salimos
					break;
				case "Listar":
					//salimos
					break;
				case "EliminarII":
				//salimos
				break;
				
				default:
					//amitimos mensaje por pantalla
					System.out.println("Accion no encontrada");
					
					//salimos
					break;
				
				}//fin del switch
				
		
	}//fin del metodo principal

 }//fin de la clase
