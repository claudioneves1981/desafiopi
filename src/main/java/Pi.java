import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


//Desafio pi, achar o primo palindromo de 9 digitos da extensao decimal de pi 

public class Pi {

    public static void main(String[] args) throws IOException {

        boolean eigual = false;
        String numero;
        URL url = new URL("https://www.angio.net/pi/digits/pi1000000.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        //List<Integer> palindromos = new ArrayList<>();
        String pi = reader.readLine();

        for (int i = 0; i < pi.length(); i++) {
            if (i < pi.length() - 9) {
                numero = pi.substring(i, i + 9);
                for (int j = 1; j <= numero.length() / 2; j++) {
                    if (numero.charAt(j - 1) == numero.charAt(numero.length() - j)) {
                        eigual = true;
                    } else {
                        eigual = false;
                        break;
                    }
                }
                if (eigual) {
                    int num = Integer.parseInt(numero) % 2 == 1 ? Integer.parseInt(numero) : 0;
                    if(ehPrimo(num) && num > 0){
                        System.out.println(num);
                        break;
                    }
                }
            }
        }
    }

        public static boolean ehPrimo(Integer numero) {

            /*return (numero <= 2 || numero % 2 != 0)
                    && (numero <= 3 || numero % 3 != 0)
                    && (numero <= 5 || numero % 5 != 0)
                    && (numero <= 7 || numero % 7 != 0)
                    && (numero <= 11 || numero % 11 != 0)
                    && (Math.sqrt(numero) % (int) Math.sqrt(numero) != 0);
                    */
            int cont = 2;


            while (cont < Math.sqrt(numero)) {
                if (numero % cont == 0) {
                     return false;

                }

                cont++;
            }
            return true;


    }
}

