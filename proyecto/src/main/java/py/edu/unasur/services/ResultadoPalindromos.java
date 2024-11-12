package py.edu.unasur.services;

import java.util.List;

public class ResultadoPalindromos {
    private final int totalPalindromos;
    private final List<String> listaPalindromos;

    public ResultadoPalindromos(int totalPalindromos, List<String> listaPalindromos) {
        this.totalPalindromos = totalPalindromos;
        this.listaPalindromos = listaPalindromos;
    }

    // Getters
    public int getTotalPalindromos() { return totalPalindromos; }
    public List<String> getListaPalindromos() { return listaPalindromos; }
}
