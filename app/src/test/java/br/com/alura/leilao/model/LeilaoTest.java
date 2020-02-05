package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {


    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("CONSOLE");
    private final Usuario RENAN = new Usuario("Renan");

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao() {
        String descricaoDevolvida = CONSOLE.getDescricao();

        assertEquals("CONSOLE", descricaoDevolvida);
    }

    //[nome do método][estado de teste][resultado esperado] public void getMaiorLance_QuandoRecebeApenasUmLance_DevolveMaiorLance() {}
    //[deve][resultado esperado][estado de teste]

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(RENAN, 200));

        Double maiorlanceDevolvido = CONSOLE.getMaiorlance();

        assertEquals(200, maiorlanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(RENAN, 200));
        CONSOLE.propoe(new Lance(new Usuario("Francisca"), 400));

        Double maiorLanceDevolvido = CONSOLE.getMaiorlance();

        assertEquals(400, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(RENAN, 400));
        CONSOLE.propoe(new Lance(new Usuario("Francisca"), 200));

        Double maiorLanceDevolvido = CONSOLE.getMaiorlance();

        assertEquals(400, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(RENAN, 200));

        Double menorlanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200, menorlanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(RENAN, 200));
        CONSOLE.propoe(new Lance(new Usuario("Francisca"), 400));

        Double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(new Usuario("Francisca"), 400));
        CONSOLE.propoe(new Lance(RENAN, 200));

        Double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeApenasTresLances() {
        CONSOLE.propoe(new Lance(RENAN, 200));
        CONSOLE.propoe(new Lance(new Usuario("Francisca"), 300));
        CONSOLE.propoe(new Lance(RENAN, 400));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();


        assertEquals(3, tresMaioresLancesDevolvidos.size());

        assertEquals(400,
                tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300,
                tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200,
                tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);

    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoNaoRecebeLance() {

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();


        assertEquals(0, tresMaioresLancesDevolvidos.size());
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(RENAN, 200));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();


        assertEquals(1, tresMaioresLancesDevolvidos.size());

        assertEquals(200,
                tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeApenasDoisLances() {
        CONSOLE.propoe(new Lance(RENAN, 300));
        CONSOLE.propoe(new Lance(new Usuario("Francisca"), 400));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();


        assertEquals(2, tresMaioresLancesDevolvidos.size());

        assertEquals(400,
                tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300,
                tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeMaisDeTresLances() {
        final Usuario FRANCISCA = new Usuario("Francisca");

        CONSOLE.propoe(new Lance(RENAN, 300));
        CONSOLE.propoe(new Lance(FRANCISCA, 400));
        CONSOLE.propoe(new Lance(RENAN, 500));
        CONSOLE.propoe(new Lance(FRANCISCA, 600));

        List<Lance> tresMaioresLancesDevolvidosParaQuatroLances = CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidosParaQuatroLances.size());

        assertEquals(600, tresMaioresLancesDevolvidosParaQuatroLances.get(0).getValor(), DELTA);
        assertEquals(500, tresMaioresLancesDevolvidosParaQuatroLances.get(1).getValor(), DELTA);
        assertEquals(400, tresMaioresLancesDevolvidosParaQuatroLances.get(2).getValor(), DELTA);
        
        CONSOLE.propoe(new Lance(RENAN, 700));

        List<Lance> tresMaioresLancesDevolvidosParaCincoLances = CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidosParaCincoLances.size());

        assertEquals(700, tresMaioresLancesDevolvidosParaCincoLances.get(0).getValor(), DELTA);
        assertEquals(600, tresMaioresLancesDevolvidosParaCincoLances.get(1).getValor(), DELTA);
        assertEquals(500, tresMaioresLancesDevolvidosParaCincoLances.get(2).getValor(), DELTA);

        List<Lance> tresMenoresLances = CONSOLE.tresMaioresLances();
    }

    @Test
    public void deve_DevolverTresMenoresLances_QuandoRecebeQuatroLances() {
        CONSOLE.propoe(new Lance(RENAN, 700));
        CONSOLE.propoe(new Lance(new Usuario("Francisca"), 1000));
        CONSOLE.propoe(new Lance(RENAN, 1100));
        CONSOLE.propoe(new Lance(new Usuario("Francisca"), 2000));

        List<Lance> tresMenoresLancesDevolvidos = CONSOLE.tresMenoresLances();

        assertEquals(3, tresMenoresLancesDevolvidos.size());

        assertEquals(700, tresMenoresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(1000, tresMenoresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(1100, tresMenoresLancesDevolvidos.get(2).getValor(), DELTA);
    }
}