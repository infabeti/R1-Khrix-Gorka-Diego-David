package ModAD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "hashes", uniqueConstraints = {@UniqueConstraint(columnNames = "nomEstacion"),@UniqueConstraint(columnNames = "hash")})
public class Hashes {

	@Id
	@Column(name = "nomEstacion", unique = true, nullable = false)
	private String nomEstMet;
	
	@Column(name = "hash", unique = true, nullable = false)
	private String hash;
	
	public Hashes() {

	}

	public Hashes(String nomEstMet, String hash) {
		this.nomEstMet = nomEstMet;
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "Hashes [nomEst=" + nomEstMet + ", hash=" + hash + "]";
	}

	public String getNomEstMet() {
		return nomEstMet;
	}

	public void setNomEstMet(String nomEstMet) {
		this.nomEstMet = nomEstMet;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
}
