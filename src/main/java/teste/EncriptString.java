package teste;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EncriptString {

	static String mensagemErro = "";

	// Complete the caesarCipher function below.
	static String caesarCipher(String s, int k, int n) {
		String alph[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z" };
		Map<String, String> alphEncript = new TreeMap<String, String>();
		
		if (validaPalavra(s,n) && validaRotacaoAlfabetica(k)) {
				
				Integer posicao = calculaPosicao(k);				
				novoAlfabetoEncriptado(alph, alphEncript, posicao);
				String[] palavra = explode(s);
				StringBuilder sb = new StringBuilder();
				return rescrevePalavra(alphEncript, palavra, sb);
				
		} else {
			System.out.println(mensagemErro);
		}
		return "";
	}

	private static String rescrevePalavra(Map<String, String> alphEncript, String[] palavra, StringBuilder sb) {
		for (int i = 0; i < palavra.length; i++) {
			boolean letramaiuscula = isUpperCase(palavra[i]);

			if (alphEncript.get(palavra[i]) != null) {
				sb.append(alphEncript.get(palavra[i]));
			} else if (letramaiuscula && alphEncript.get(palavra[i].toLowerCase()) != null) {
				sb.append(alphEncript.get(palavra[i].toLowerCase()).toUpperCase());
			} else {
				sb.append(palavra[i]); 
			}
		}
		return sb.toString();
	}

	private static void novoAlfabetoEncriptado(String[] alph, Map<String, String> alphEncript, Integer posicao) {
		int cont = 0;
		do {
			
			for (int i = posicao; i < alph.length; i++) {
				alphEncript.put(alph[cont], alph[i]);
				cont++;
				if(cont==26) break;
			}
			
			posicao = 0;
			
		} while (cont<26);
	}

	private static Integer calculaPosicao(int k) {
		Integer posicao;
		if(k>26) {
			posicao = (k % 26);
		} else {
			posicao = k;
		}
		return posicao;
	}

	private static boolean validaRotacaoAlfabetica(int k) {
		boolean valida = true;
		if(!(k >= 0 && k <= 100)) {
			valida = false;
			mensagemErro =  "O número de rotação alfabética deve ser entre 0 e 100.";
		}
		return valida;
	}

	public static boolean validaPalavra(String palavra, int n) {
		boolean palavraValida = true;
		
		if(!(n >= 1 && n <= 100)) {
			palavraValida = false;
			mensagemErro = "Erro: a palavra deve ter entre 1 e 100 caracteres.";
		}
		
		for (int i = 0; i < palavra.length(); i++) {
			if (Character.isWhitespace(palavra.charAt(i))) {
				mensagemErro = "Erro: não é permitido vazio na palavra.";
				palavraValida = false;
		    }
		}
			
		return palavraValida;
	}

	public static boolean isUpperCase(String string) {
		return string.toUpperCase().equals(string);
	}


	public static String[] explode(String palavra) {
		String[] arr = new String[palavra.length()];
		for (int i = 0; i < palavra.length(); i++) {
			arr[i] = String.valueOf(palavra.charAt(i));
			
		}
		return arr;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = caesarCipher(s, k, n);

		// bufferedWriter.write(result);
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		System.out.println(result);
		scanner.close();
	}
}
