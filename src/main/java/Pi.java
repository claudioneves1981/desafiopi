import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Pi {

    public static void main(String[] args) throws IOException {

        boolean eigual = false;
        String numero;
        URL url = new URL("https://www.angio.net/pi/digits/pi1000000.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        List<String> palindromos = new ArrayList<>();
        String pi = reader.readLine();
        int y;
        int primo;
        for (int i = 0; i < pi.length(); i++) {
            if (i  < pi.length() - 9) {
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
                    palindromos.add(numero);
                }
            }
        }
        for (String s : palindromos) {
            y = 1;
            primo = 0;
            while (y <= Integer.parseInt(s)) {
                if (Integer.parseInt(s) % y == 0) {
                    primo += 1;
                }
                y++;
            }
            if (primo == 2) {
                System.out.print(s);
                break;
            }
        }
    }
}

