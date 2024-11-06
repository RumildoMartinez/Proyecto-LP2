package py.edu.unasur.resources;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response; // Importación de SegundoParcialService
import py.edu.unasur.services.SegundoParcialService; // Importación de List

@Path("/segundo-parcial")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SegundoParcialResource {

    @Inject
    SegundoParcialService segundoParcialService; // Cambia a mayúscula inicial

    @POST
    public Response procesarLista(List<String> lista) {
        if (lista == null || lista.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("La lista no puede estar vacía.")
                    .build();
        }

        var resultado = segundoParcialService.contarPalindromos(lista);
        return Response.ok(resultado).build();
    }
}