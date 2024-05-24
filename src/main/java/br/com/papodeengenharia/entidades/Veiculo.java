package br.com.papodeengenharia.entidades;

import java.util.Collection;

public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;
    private Double valorDiaria;
    private Double valorKmAdicional;
    private Collection<Locacao> locacaos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Double getValorKmAdicional() {
        return valorKmAdicional;
    }

    public void setValorKmAdicional(Double valorKmAdicional) {
        this.valorKmAdicional = valorKmAdicional;
    }

    public Collection<Locacao> getLocacaos() {
        return locacaos;
    }

    public void setLocacaos(Collection<Locacao> locacaos) {
        this.locacaos = locacaos;
    }
}
