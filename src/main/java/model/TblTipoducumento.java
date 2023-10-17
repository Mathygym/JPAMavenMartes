package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_tipoducumento database table.
 * 
 */
@Entity
@Table(name="tbl_tipoducumento")
@NamedQuery(name="TblTipoducumento.findAll", query="SELECT t FROM TblTipoducumento t")
public class TblTipoducumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipodocum;

	private String descripdocum;

	private String nomdocum;

	//bi-directional many-to-one association to TblDocumento
	@OneToMany(mappedBy="tblTipoducumento")
	private List<TblDocumento> tblDocumentos;

	public TblTipoducumento() {
	}

	public int getIdtipodocum() {
		return this.idtipodocum;
	}

	public void setIdtipodocum(int idtipodocum) {
		this.idtipodocum = idtipodocum;
	}

	public String getDescripdocum() {
		return this.descripdocum;
	}

	public void setDescripdocum(String descripdocum) {
		this.descripdocum = descripdocum;
	}

	public String getNomdocum() {
		return this.nomdocum;
	}

	public void setNomdocum(String nomdocum) {
		this.nomdocum = nomdocum;
	}

	public List<TblDocumento> getTblDocumentos() {
		return this.tblDocumentos;
	}

	public void setTblDocumentos(List<TblDocumento> tblDocumentos) {
		this.tblDocumentos = tblDocumentos;
	}

	public TblDocumento addTblDocumento(TblDocumento tblDocumento) {
		getTblDocumentos().add(tblDocumento);
		tblDocumento.setTblTipoducumento(this);

		return tblDocumento;
	}

	public TblDocumento removeTblDocumento(TblDocumento tblDocumento) {
		getTblDocumentos().remove(tblDocumento);
		tblDocumento.setTblTipoducumento(null);

		return tblDocumento;
	}

}