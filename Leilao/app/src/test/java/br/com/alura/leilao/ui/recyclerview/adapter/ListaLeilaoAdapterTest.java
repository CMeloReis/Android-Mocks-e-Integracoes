package br.com.alura.leilao.ui.recyclerview.adapter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.alura.leilao.model.Leilao;

@RunWith(MockitoJUnitRunner.class)//faz a chamado do initMocks ao rodar o teste
public class ListaLeilaoAdapterTest {

//       o metodo mock cria um objeto a partir de uma referencia de uma classe
//       o objeto mock nao executa nada do codigo fonte da classe que esta sendo simulada
//       o objeto spy executa os metodos reais

    @Mock //inicializar o objeto Mock
    private Context context;
    @Spy
    private ListaLeilaoAdapter adapter = (new ListaLeilaoAdapter(context));

    @Test
    public void deve_AtualizarListaDeLeiloes_QuandoReceberListaDeLeiloes () {
//        MockitoAnnotations.initMocks(this);
        doNothing().when(adapter).atualizaLista();

        adapter.atualiza(new ArrayList<>(Arrays.asList(
                new Leilao("Computador"),
                new Leilao("Console")
        )));
        int quantidadeLeiloesDevolvida = adapter.getItemCount();

        verify(adapter).atualizaLista();

        assertThat(quantidadeLeiloesDevolvida, is(2));
    }

}