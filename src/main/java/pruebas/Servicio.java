package pruebas;

import pruebas.model.Cliente;
import pruebas.model.Telefono;

import javax.persistence.EntityManager;
import java.util.Random;

public class Servicio {
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Cliente getCliente(int id) {
        return entityManager.find(Cliente.class, id);
    }

    public Cliente addPhone(int id) {
        Cliente c = getCliente(id);
        Telefono t = new Telefono();
        t.setNumero(generateRandom(6));
        t.setCliente(c);
        //t.setTipo((short)(c.getTelefonos().size() + 1));
        c.getTelefonos().add(t);
        return c;
    }

    private String generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return new String(digits);
    }
}
