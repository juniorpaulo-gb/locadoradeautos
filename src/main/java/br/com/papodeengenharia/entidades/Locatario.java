package br.com.papodeengenharia.entidades;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Collection<Locacao> locacoesEmAberto(){
        return this.getLocacaos().stream().filter(Locacao::pagamentoEmAberto).collect(Collectors.toList());
    }

/**
    public String categoria(){
        String resultado = "BRONZE";
        if(this.getLocacoes().size() >= 100)
            resultado = "OURO";
        if (this.getLocacoes().size() >= 50 && this.getLocacoes().size()< 100)
            resultado = "PRATA";

        return resultado;
    }
 */

    public String categoria(){
        if(this.getLocacaos().size() >= 100)
            return "OURO";
        if(this.getLocacaos().size()>= 50 )
            return "PRATA";
        return "BRONZE";
    }

    /**
    public String categoria2(){
        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(100, "OURO");
        mapa.put(50, "PRATA");
        mapa.put(0,"BRONZE");
        return mapa.entrySet().stream().filter(m -> this.getLocacaos().size() >= m.getKey()).findFirst().map(Map.Entry::getValue).orElse(null);
    }
    */

    public String categoria2(){
        return Stream.of(Categoria.values()).filter(categoria -> categoria.isValido(this.getLocacaos().size())).toString();
    }

}
