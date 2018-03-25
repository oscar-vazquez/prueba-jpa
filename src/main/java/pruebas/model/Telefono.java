package pruebas.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefono")
public class Telefono {
    @Embeddable
    public static class PK implements Serializable {
        @Column(name = "numero_cliente", nullable=false, updatable=false)
        private int parentId;

        @Column(name = "tipo", nullable=false, updatable=false)
        private int tipo;
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

    public Short getTipo() {
        return id.tipo;
    }
*/
    /*
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTipo(short i) {
        if (id == null) {
            id = new PK();
        }
        id.tipo = i;
    }
    */

    public int getSeqno() {
        return id.tipo;
    }

    public void setCliente(Cliente c) {
        if (id == null) {
            id = new PK();
        }
        id.parentId = c.getId();
        id.tipo = c.getTelefonos().size() + 1;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
