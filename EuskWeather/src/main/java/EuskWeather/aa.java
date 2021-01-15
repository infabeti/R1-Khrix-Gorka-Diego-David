package EuskWeather;


import javax.persistence.*;
import org.hibernate.annotations.OptimisticLockType;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true, optimisticLock = OptimisticLockType.ALL)
@Table(name = "Tabla1", uniqueConstraints = {@UniqueConstraint(columnNames = "Numero"),@UniqueConstraint(columnNames = "dato1"),
		@UniqueConstraint(columnNames = "dato2"),
		@UniqueConstraint(columnNames = "dato3")})

public class aa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Numero", unique = true, nullable = false)
	private Integer Numero;
	
	@Column(name = "dato1", unique = false, nullable = false, length = 20)
	private String dato1;

	@Column(name = "dato2", unique = false, nullable = false, length = 20)
	private String dato2;
	
	@Column(name = "dato3", unique = false, nullable = false, length = 20)
	private String dato3;

	public void setNumero(Integer numero) {
		Numero = numero;
	}

	public void setDato1(String dato1) {
		this.dato1 = dato1;
	}

	public void setDato2(String dato2) {
		this.dato2 = dato2;
	}

	public void setDato3(String dato3) {
		this.dato3 = dato3;
	}
	


}
