package pruebas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pruebas.model.Cliente;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ClienteService {
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private EntityManager entityManager;

    @GET
    @Path("{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("numero")int numero) {
        logger.info("GET ClienteResponse {}", numero);

        ClienteResponse cliente = new ClienteResponse();
        /*
        cliente.setNumero(numero);
        cliente.setNombre("Pepe");
        */

        Cliente c = entityManager.find(Cliente.class, numero);
        cliente.setNumero(c.getId());
        cliente.setNombre(c.getNombre());

        return Response.ok(cliente).build();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
