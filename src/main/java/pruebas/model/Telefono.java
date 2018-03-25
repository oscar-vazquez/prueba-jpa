package pruebas.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefono")
public class Telefono {
    @Embeddable
    public static class PK implements Serializable {
        @Column(name = "numero_cliente", nullable=false, updatable=false)
        private Integer parentId;

        @Column(name = "tipo", nullable=false, updatable=false)
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Short tipo;
    }

    @EmbeddedId
    private PK id;

    @Column
    private String numero;

    /*
    @ManyToOne
    @JoinColumn(tipo="numero_cliente", insertable = false, updatable = false)
    private Cliente cliente;
*/

    /*
    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
*/

    public Short getTipo() {
        return id.tipo;
    }
    /*
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    */

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
