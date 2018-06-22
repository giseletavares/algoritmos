package teste;

import junit.framework.TestCase;

public class EncriptStringTest extends TestCase {

	public void testPadraoHackerHankOK() {
		int tamanho = 11;
		String palavra = "middle-Outz";
		int rotacao = 2;
		assertEquals("okffng-Qwvb", EncriptString.caesarCipher(palavra, rotacao, tamanho));
	}
	
	public void testPadraoHackerHankComEspacoFail() {
		int tamanho = 11;
		String palavra = "middle Outz ";
		int rotacao = 2;
		assertEquals("", EncriptString.caesarCipher(palavra, rotacao, tamanho));

	}
	
	public void testPadraoHackerHankComRotacaoExcedidaFail() {
		int tamanho = 11;
		String palavra = "middle-Outz";
		int rotacao = 101;
		assertEquals("", EncriptString.caesarCipher(palavra, rotacao, tamanho));
	}
	
	public void testPadraoHackerHankComTamanhoExcedidoFail() {
		int tamanho = 101;
		String palavra = "middle-Outz";
		int rotacao = 2;
		assertEquals("", EncriptString.caesarCipher(palavra, rotacao, tamanho));
	}
	
	public void testPadraoHackerHankComNumerosFail() {
		int tamanho = 15;
		String palavra = "middle-Outz2345";
		int rotacao = 2;
		assertEquals("okffng-Qwvb2345", EncriptString.caesarCipher(palavra, rotacao, tamanho));
	}
	
	public void testPalavraMaiorQueAlfabeto27() {
		int tamanho = 3;
		String palavra = "abc";
		int rotacao = 26;
		assertEquals("abc", EncriptString.caesarCipher(palavra, rotacao, tamanho));
	}
	
	
}

