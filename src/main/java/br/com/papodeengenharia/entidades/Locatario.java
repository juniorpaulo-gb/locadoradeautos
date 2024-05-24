package br.com.papodeengenharia.entidades;

import java.util.Collection;

public class Locatario {
    private Long id;
    private String nome;
    private Collection<Locacao> locacaos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Collection<Locacao> getLocacaos() {
        return locacaos;
    }

    public void setLocacaos(Collection<Locacao> locacaos) {
        this.locacaos = locacaos;
    }

/*    public Double divida(){
        Double totalDivida = 0.0;
        for(Locacao l :locacoesEmAberto()){
            totalDivida += l.valorTotal();

        }
        return totalDivida;
    }*/

    public Double divida(){
        return this.getLocacaos().stream().filter(Locacao::pagamentoEmAberto).mapToDouble(Locacao::valorTotal).sum();
    }


    public Boolean isBomPagador(){
        return divida()==0.0;
    }


}
