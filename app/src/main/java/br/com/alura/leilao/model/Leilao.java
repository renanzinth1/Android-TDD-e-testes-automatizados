package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private Double maiorlance = Double.NEGATIVE_INFINITY;
    private Double menorLance = Double.POSITIVE_INFINITY;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void propoe(Lance lance) {
        this.lances.add(lance);
        Collections.sort(lances);
        double valorLance = lance.getValor();

        calculaMaiorLance(valorLance);
        calculaMenorLance(valorLance);
    }

    private void calculaMaiorLance(double valorLance) {
        if(valorLance > maiorlance)
            maiorlance = valorLance;
    }

    private void calculaMenorLance(double valorLance) {
        if (valorLance < menorLance)
            menorLance = valorLance;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getMaiorlance() {
        return maiorlance;
    }

    public Double getMenorLance() {
        return menorLance;
    }

    public List<Lance> tresMaioresLances() {
        int tamanhoLista = getTamanhoLista();

        return lances.subList(0, tamanhoLista);
    }

    public List<Lance> tresMenoresLances() {
        int tamanhoLista = getTamanhoLista();

        Collections.reverse(lances);

        return lances.subList(0, tamanhoLista);
    }

    private int getTamanhoLista() {
        int tamanhoLista = this.lances.size();

        if (tamanhoLista > 3)
            tamanhoLista = 3;
        return tamanhoLista;
    }
}
