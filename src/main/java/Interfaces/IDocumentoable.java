package Interfaces;

import java.util.List;

import model.TblDocumento;

public interface IDocumentoable {
	//declaramos sus metodos
	public void RegistrarDocumento(TblDocumento tbdocumen);
	public void ActualizarDocumento(TblDocumento tbdocumen);
	public void EliminarDocumento(TblDocumento tbdocumen);
	public List<TblDocumento> ListadoDoucmento();
	public TblDocumento BuscarDocuemnto(TblDocumento tbdocumen);
	
	
}//fin de la intewrface


