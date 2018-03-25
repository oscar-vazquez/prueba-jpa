package pruebas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pruebas.model.Cliente;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ClienteService {
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private EntityManager entityManager;
    private Servicio servicio;

    @GET
    @Path("{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("numero")int numero) {
        logger.info("GET ClienteResponse {}", numero);

        Cliente c = //entityManager.find(Cliente.class, numero);
            servicio.getCliente(numero);


        return Response.ok(c).build();
    }

    @PUT
    @Path("{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response putCliente(@PathParam("numero")int numero) {
        logger.info("GET ClienteResponse {}", numero);

        Cliente c = servicio.addPhone(numero);


        return Response.ok(c).build();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
