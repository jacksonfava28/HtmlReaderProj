import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HTMLReaderProj {

    public static void main(String[] args) {
    HTMLReaderProj html = new HTMLReaderProj();
    }

    public HTMLReaderProj () {

        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://steamcommunity.com/app/2592160");

            URLConnection urlc = url.openConnection();
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlc.getInputStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                if(line.contains("href=")) {

                    int index = 0;
                    int start = 0;
                    int end = 0;
                    start = line.indexOf("href=") +6;
                    //System.out.println(line);
                    String line2 = line.substring(start);
                    // System.out.println(line2);
                    if(line2.contains("\"")){
                        end = line2.indexOf("\"");
                        System.out.println(line2.substring(0,end));
                    }
                    else if (line2.contains("\'")){
                        end = line2.indexOf("\'");
                        System.out.println(line2.substring(0,end));
                    }

                }

                //   System.out.println(line);
            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}
//i spent my inclass time to plan out what i wanted to do functioning wise and layout wise