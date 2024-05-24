package br.com.papodeengenharia.entidades;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Locacao {
    private Long id;
    private Date inicio;
    private Date fim;
    private Long kmRetirada;
    private Long kmDevolucao;
    private Boolean paga;

    private Locatario locatario;
    private Veiculo veiculo;

    public Locacao(Locatario locatario , Veiculo veiculo){
        this.setVeiculo(veiculo);//garantir nao nulo
        this.setLocatario(locatario);//garantir nao nulo
        this.setInicio(new Date());


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Long getKmRetirada() {
        return kmRetirada;
    }

    public void setKmRetirada(Long kmRetirada) {
        this.kmRetirada = kmRetirada;
    }

    public Long getKmDevolucao() {
        return kmDevolucao;
    }

    public void setKmDevolucao(Long kmDevolucao) {
        this.kmDevolucao = kmDevolucao;
    }

    public Boolean getPaga() {
        return paga;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }


    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public boolean isDevolvido(){
        return this.fim != null;
    }

    public Boolean pagamentoEmAberto(){
        return  this.isDevolvido() && !this.getPaga();
    }

    public Double valorTotal(){
        return this.duracaoEmDias() * this.getVeiculo().getValorDiaria();
    }

    public Long duracaoEmDias(){
        return TimeUnit.DAYS.convert(this.duracaoEmMilisegundos(), TimeUnit.MILLISECONDS);
    }

    private long duracaoEmMilisegundos() {
        if (!isDevolvido()){
            return 0;
        }
        return this.getFim().getTime() - this.getInicio().getTime();
    }





}
