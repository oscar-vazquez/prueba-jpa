package pruebas.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "numero_cliente")
    private int Id;

    private String  nombre;

    @OneToMany(mappedBy = "id.parentId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//@OneToMany(mappedBy = "id.parentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "id.parentId", cascade = CascadeType.ALL)
    private List<Telefono> telefonos;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Telefono> getTelefonos() {
        if (telefonos == null) {
            telefonos = new ArrayList<Telefono>();
        }
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "ClienteResponse{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
