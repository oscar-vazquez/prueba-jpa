package pruebas;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@ApiModel(value = "Cliente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Cliente {
    @ApiModelProperty
    private int numero;

    @ApiModelProperty
    private String nombre;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
