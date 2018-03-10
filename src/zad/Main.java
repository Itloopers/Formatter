package zad;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*Plik CSV zawiera trzy kolumny oddzielone znakiem ,. Pierwsza kolumna zawiera imię, druga liczbę zmiennoprzecinkową
trzecia dzień tygodnia. Twoim zadaniem jest wczytanie zawartości tego pliku i wyświetlenie jej w formie tabeli.
 */

public class Main {
    public static void main(String[] args) throws IOException{
        URL resource = Main.class.getResource(File.separator+"test.csv");
        final InputStream inputStream = resource.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List<Object[]> upperList = new ArrayList<>();
        while(true) {
            String tempLine = reader.readLine();
            if(tempLine==null) break;
            String[] array = tempLine.split(",");
            upperList.add(new Object[]{
                    array[0],
                    Float.valueOf(array[1]),
                    array[2]
            });
        }

        for (Object[] arr:upperList){ //array (row from csv)
            System.out.format("| %-8s | %-7.2f | %-12s |%n",arr);
        }
    }
}
