package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_documento database table.
 * 
 */
@Entity
@Table(name="tbl_documento")
@NamedQuery(name="TblDocumento.findAll", query="SELECT t FROM TblDocumento t")
public class TblDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddocument;

	private String descridocumen;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nrodocument;

	private String provedocument;

	private String rucdocumen;

	//bi-directional many-to-one association to TblTipoducumento
	@ManyToOne
	@JoinColumn(name="idtipodocum")
	private TblTipoducumento tblTipoducumento;

	public TblDocumento() {
	}

	public int getIddocument() {
		return this.iddocument;
	}

	public void setIddocument(int iddocument) {
		this.iddocument = iddocument;
	}

	public String getDescridocumen() {
		return this.descridocumen;
	}

	public void setDescridocumen(String descridocumen) {
		this.descridocumen = descridocumen;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNrodocument() {
		return this.nrodocument;
	}

	public void setNrodocument(String nrodocument) {
		this.nrodocument = nrodocument;
	}

	public String getProvedocument() {
		return this.provedocument;
	}

	public void setProvedocument(String provedocument) {
		this.provedocument = provedocument;
	}

	public String getRucdocumen() {
		return this.rucdocumen;
	}

	public void setRucdocumen(String rucdocumen) {
		this.rucdocumen = rucdocumen;
	}

	public TblTipoducumento getTblTipoducumento() {
		return this.tblTipoducumento;
	}

	public void setTblTipoducumento(TblTipoducumento tblTipoducumento) {
		this.tblTipoducumento = tblTipoducumento;
	}

}