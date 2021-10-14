package br.com.alura.leilao.ui.activity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ListaLeilaoActivityTest {

    @Test
    public void deve_AtualizarListaDeLeiloes_QuandoBuscarLeiloesDaApi() throws InterruptedException {

        ListaLeilaoActivity activity = new ListaLeilaoActivity();

        activity.configuraAdapter();
        activity.buscaLeiloes();
        Thread.sleep(2000);
        int quantidadeDeLeiloesDevolvida = activity.getAdapter().getItemCount();

        assertThat(quantidadeDeLeiloesDevolvida, is(3));

    }

}