package br.com.papodeengenharia.servicos;

import br.com.papodeengenharia.entidades.Locacao;
import br.com.papodeengenharia.entidades.Locatario;
import br.com.papodeengenharia.entidades.Veiculo;

import java.util.HashMap;
import java.util.Map;

public class LocacaoService {

    private static Map<Long, Veiculo> veiculos = new HashMap<>();
    private static Map<Long, Locatario> locatarios = new HashMap<>();
    private static Map<Long, Locacao> locacoes = new HashMap<>();

    public static void instanciarObjetos() {
        Veiculo v1 = new Veiculo();
        v1.setId(1l);
        v1.setMarca("Fiat");
        v1.setModelo("Palio ");
        v1.setValorDiaria(100.0d);
        v1.setValorKmAdicional(5.0d);
        veiculos.put(v1.getId(), v1);

        Veiculo v2 = new Veiculo();
        v2.setId(2l);
        v2.setMarca("Honda");
        v2.setModelo("Civic ");
        v2.setValorDiaria(200.0d);
        v2.setValorKmAdicional(5.0d);
        veiculos.put(v2.getId(), v2);


        Veiculo v3 = new Veiculo();
        v3.setId(3l);
        v3.setMarca("Toyota");
        v3.setModelo("Corolla ");
        v3.setValorDiaria(300.0d);
        v3.setValorKmAdicional(5.0d);
        veiculos.put(v3.getId(), v3);

        Locatario l1 = new Locatario();
        l1.setId(1l);
        l1.setNome("Paulo Mello");
        locatarios.put(l1.getId(), l1);

    }


}
