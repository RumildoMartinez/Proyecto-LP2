package py.edu.unasur.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.core.Response;
import py.edu.unasur.services.ResultadoPalindromos;
import py.edu.unasur.services.SegundoParcialService;

public class SegundoParcialResourceTest {

    public static void main(String[] args) {
        testProcesarListaConPalindromos();
        testProcesarListaVacia();
    }

    public static void testProcesarListaConPalindromos() {
        // Crea una instancia del servicio
        SegundoParcialService service = new SegundoParcialService() {
            @Override
            public ResultadoPalindromos contarPalindromos(List<String> lista) {
                // Lógica simulada para la prueba
                int count = (int) lista.stream().filter(SegundoParcialResourceTest::esPalindromo).count();
                List<String> palindromos = lista.stream().filter(SegundoParcialResourceTest::esPalindromo).toList();
                return new ResultadoPalindromos(count, palindromos);
            }
        };

        // Crea la instancia del recurso
        SegundoParcialResource recurso = new SegundoParcialResource();
        recurso.segundoParcialService = service;

        // Datos de prueba
        List<String> lista = Arrays.asList("radar", "level", "texto");
        ResultadoPalindromos resultadoEsperado = new ResultadoPalindromos(2, Arrays.asList("radar", "level"));

        // Ejecuta el método a probar
        Response response = recurso.procesarLista(lista);

        // Verifica los resultados
        if (response.getStatus() == Response.Status.OK.getStatusCode() && response.getEntity().equals(resultadoEsperado)) {
            System.out.println("testProcesarListaConPalindromos: Passed");
        } else {
            System.out.println("testProcesarListaConPalindromos: Failed");
        }
    }