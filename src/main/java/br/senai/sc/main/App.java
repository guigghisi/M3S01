package br.senai.sc.main;

import br.senai.sc.models.Avaliador;
import br.senai.sc.models.Lance;
import br.senai.sc.models.Leilao;
import br.senai.sc.models.Usuario;

import java.util.Date;

public class App {
    public static void main(String[] args) {
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
        System.out.println("Maior lance encontrado: " + leiloeiro.getMaiorLance());
        System.out.println("Menor lance encontrado: " + leiloeiro.getMenorLance());
    }
}
