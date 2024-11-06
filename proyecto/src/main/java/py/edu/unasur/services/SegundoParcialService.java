package py.edu.unasur.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SegundoParcialService {

    public ResultadoPalindromos contarPalindromos(List<String> lista) {
        List<String> palindromos = new ArrayList<>();
        int totalPalindromos = 0;

        for (String elemento : lista) {
            if (esPalindromo(elemento)) {
                palindromos.add(elemento);
                totalPalindromos++;
            }
        }

        return new ResultadoPalindromos(totalPalindromos, palindromos);
    }

    private boolean esPalindromo(String texto) {
        String textoLimpiado = texto.replaceAll("\s+", "").toLowerCase();
        return new StringBuilder(textoLimpiado).reverse().toString().equals(textoLimpiado);
    }
}