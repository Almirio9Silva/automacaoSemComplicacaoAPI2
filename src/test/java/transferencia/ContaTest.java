package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvioSantos;

    @BeforeEach
    void setUp() {
        xuxa =  new Cliente("xuxa", "12345678900", "1111111");
        silvioSantos = new Cliente("Silvio Santos", "00987654321", "2222222");

        contaXuxa = new Conta("0025", "2254",2500.00,xuxa);
        contaSilvioSantos = new Conta("0026", "2251", 3500.00, silvioSantos);
    }

    @Test
    public void validarProprietario(){
        assertEquals(xuxa.getCpf(), contaXuxa.getProprietario().getCpf());
        assertEquals(xuxa.getNome(), contaXuxa.getProprietario().getNome());
        assertEquals(xuxa.getRg(), contaXuxa.getProprietario().getRg());
    }

    @Test
    public void validarNumeroAgencia(){
        assertEquals("0025", contaXuxa.getAgencia());
    }

    @Test
    public void validarNumeroConta(){
        assertEquals("2254", contaXuxa.getNumeroConta());
    }

    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000.00, contaSilvioSantos);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvioSantos.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida(){

        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvioSantos);
        assertFalse(resultado);
    }

}