package br.com.papodeengenharia.entidades;

import java.util.Collection;
import java.util.Optional;

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

    public void pagar(Locacao locacao){
        if(!this.getId().equals(locacao.getLocatario().getId())){
            throw new IllegalArgumentException("A Locacao nao pertence ao locatario");
        }
        if(locacao.getPaga()){
           throw  new IllegalArgumentException("A Locacao já está paga");
        }
        locacao.setPaga(Boolean.TRUE);
    }

    public void pagar2(Locacao locacao){
        Optional<Locacao> l = this.getLocacaos().stream().filter(locacao1 -> locacao1.getId().equals(locacao.getId()) && !locacao1.getPaga()).findAny();
        l.ifPresent(l2 -> l2.setPaga(Boolean.TRUE));
    }


}
