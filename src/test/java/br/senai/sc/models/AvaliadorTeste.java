package br.senai.sc.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AvaliadorTeste {
    @Test
    public void deveEncontrarOMaiorEMenorLance() {
        Usuario guilherme = new Usuario("Guilherme", 21, "111.222.333-45");
        Lance l1 = new Lance(200.0, guilherme);
        Lance l2 = new Lance(300.0, guilherme);
        Lance l3 = new Lance(400.0, guilherme);
        Leilao leilao = new Leilao(new Date(2023, 01, 18), new Date(2021, 01, 20));
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        Assert.assertEquals(400, leiloeiro.getMaiorLance(), 0);
        Assert.assertEquals(200, leiloeiro.getMenorLance(), 0);
    }

    @Test
    public void naoDeveAvaliarLeilaoSemLances() {
        Usuario guilherme = new Usuario("Guilherme", 21, "111.222.333-45");
        Lance l1 = new Lance(200.0, guilherme);
        Lance l2 = new Lance(300.0, guilherme);
        Lance l3 = new Lance(400.0, guilherme);
        Leilao leilao = new Leilao(new Date(2023, 01, 18), new Date(2021, 01, 20));
        Avaliador leiloeiro = new Avaliador();
        Assert.assertThrows(IllegalArgumentException.class, () -> leiloeiro.avalia(leilao));
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario guilherme = new Usuario("Guilherme", 21, "111.222.333-45");
        Lance l1 = new Lance(200.0, guilherme);
        Lance l2 = new Lance(300.0, guilherme);
        Lance l3 = new Lance(400.0, guilherme);
        Lance l4 = new Lance(150, guilherme);
        Lance l5 = new Lance(500, guilherme);
        Leilao leilao = new Leilao(new Date(2023, 01, 18), new Date(2021, 01, 20));
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        leilao.adiciona(l4);
        leilao.adiciona(l5);
        Avaliador leiloeiro = new Avaliador();
        List<Lance> tresMaiores = leiloeiro.getTresMaiores(leilao);
        Assert.assertEquals(tresMaiores.size(), 3);
        Assert.assertEquals(tresMaiores.get(0).getValor(), 500, 0);
        Assert.assertEquals(tresMaiores.get(1).getValor(), 400, 0);
        Assert.assertEquals(tresMaiores.get(2).getValor(), 300, 0);

    }

    @Test
    void naoDeveAceitarLancesConsecutivos() {
        Usuario guilherme = new Usuario("Guilherme", 21, "111.222.333-45");
        Lance l1 = new Lance(200.0, guilherme);
        Lance l2 = new Lance(300.0, guilherme);
        Leilao leilao = new Leilao(new Date(2023, 01, 18), new Date(2021, 01, 20));
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        List<Lance> lances = leilao.getLances();
        int tamanhoDaLista = lances.size();
        Assert.assertEquals(1, tamanhoDaLista);
    }

    @Test
    void naoDeveAceitarMaisDeUmLanceComValoresIguais() {
        Usuario guilherme = new Usuario("Guilherme", 21, "111.222.333-45");
        Lance l1 = new Lance(200.0, guilherme);
        Lance l2 = new Lance(300.0, guilherme);
        Lance l3 = new Lance(200.0, guilherme);
        Leilao leilao = new Leilao(new Date(2023, 01, 18), new Date(2021, 01, 20));
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        List<Lance> lances = leilao.getLances();
        List<Lance> lancesIguais = new ArrayList<Lance>();
        lances.forEach(lance -> {
            if (lance.getValor() == 200) {
                lancesIguais.add(lance);
            }
        });
        int tamanhoDaLista = lancesIguais.size();
        Assert.assertEquals(1, tamanhoDaLista);
    }
}
