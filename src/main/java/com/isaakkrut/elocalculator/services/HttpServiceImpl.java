package com.isaakkrut.elocalculator.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

@Service
public class HttpServiceImpl implements HttpService {
    @Override
    public int getResponse(String urlAddress, Map<String, String> parameters) {
        try {
            urlAddress = urlAddress + '?';
            for (var parameter : parameters.entrySet()){
                urlAddress+= parameter.getKey() + '=' + parameter.getValue() + '&';
            }
            urlAddress = urlAddress.replaceAll(".$", "");
            URL url = new URL(urlAddress);

            // Get the input stream through URL Connection


            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();

            // Once you have the Input Stream, it's just plain old Java IO stuff.

            // For this case, since you are interested in getting plain-text web page
            // I'll use a reader and output the text content to System.out.

            // For binary content, it's better to directly read the bytes from stream and write
            // to the target file.

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;

            int counter = 0;
            boolean found = false;
            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                if (line.matches(".*<td><i class=\".*flag\" data-toggle=\"tooltip\" data-placement=\"top\" title=\".*</td>.*")){
                    found = true;
                }
                if(found){
                    counter++;
                }
                if (counter == 4){
                    return Integer.parseInt(line.trim());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
