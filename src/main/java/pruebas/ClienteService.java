package pruebas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ClienteService {
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @GET
    @Path("{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("numero")int numero) {
        logger.info("GET Cliente {}", numero);
        
        Cliente cliente = new Cliente();
        cliente.setNumero(numero);
        cliente.setNombre("Pepe");
        
        return Response.ok(cliente).build();
    }
}
