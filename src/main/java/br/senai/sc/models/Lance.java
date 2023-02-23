package br.senai.sc.models;

public class Lance implements Comparable<Lance> {
    private double valor;
    private Usuario usuario;

    public Lance(double valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }

    public double getValor() {
        return valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    @Override
    public int compareTo(Lance outro) {
        if (this.valor > outro.valor) {
            return -1;
        } else if (this.valor < outro.valor) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Lance))
            return false;
        Lance other = (Lance) obj;
        if (Double.doubleToLongBits(valor) != Double.
                doubleToLongBits(other.valor))
            return false;
        return true;
    }

}
