package teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sum5 {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        
        List<Long> resultados = new ArrayList();
		
		for (int i = 0; i < arr.length; i++) {
			resultados.add(somanumerosexcetoum(i, arr));
		}
		
          Collections.sort(resultados);

		  System.out.println(resultados.get(0)+" "+resultados.get(4));
        
    }
    
    private static Long somanumerosexcetoum(int posicao, int[] arrNumeros) {
		Long soma = 0L;
		for (int j = 0; j < arrNumeros.length; j++) {
			if(j!=posicao) {
				soma = soma + arrNumeros[j];		
			}
		}		
		return soma;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
