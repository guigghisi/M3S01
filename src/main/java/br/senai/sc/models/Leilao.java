package br.senai.sc.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Leilao {
    private Date dataInicio;
    private Date dataTermino;
    private List<Lance> lances;

    public Leilao(Date dataInicio, Date dataTermino) {
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.lances = new ArrayList<>();
    }

    public void adiciona(Lance lance) {
        this.lances.add(lance);
    }

    public void remove(Lance lance) {
        this.lances.remove(lance);
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public List<Lance> getLances() {
        return lances;
    }

    private Lance ultimoLanceDado() {
        int totalDeLances = this.lances.size();
        return this.lances.get(totalDeLances - 1);
    }
}
