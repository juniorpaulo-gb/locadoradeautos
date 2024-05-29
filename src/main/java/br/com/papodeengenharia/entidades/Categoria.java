package br.com.papodeengenharia.entidades;

import java.util.Objects;

public enum Categoria {
    BRONZE(0,49),
    PRATA(50,99),
    OURO(100,null);


    private final Integer limiteMinimo;
    private final Integer limiteMaximo;

     Categoria(Integer limiteMinimo, Integer limiteMaximo){
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
    }

    public boolean isValido(Integer valor){
         return valor >= this.limiteMinimo  && (Objects.isNull(this.limiteMaximo) ||  valor <= this.limiteMaximo);
    }



    public Integer getLimiteMinimo() {
        return limiteMinimo;
    }

    public Integer getLimiteMaximo() {
        return limiteMaximo;
    }

}
