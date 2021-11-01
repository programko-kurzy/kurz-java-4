import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Jsoup
 */
public class Parser {

    public static void simple() throws IOException{
        File input = new File("simple.html");
        Document document = Jsoup.parse(input, "UTF-8");

        Element body = document.body();
        Elements elements = body.children();
        for (Element e: elements){
            String tag = e.tagName();
            String obsah = e.text();            
            System.out.println("tag: " + tag);
            System.out.println("textovy obsah: " + obsah);
            if ("a".equals(tag)){
                String link = e.attr("href");
                System.out.println("link: " + link);    
            }            
            System.out.println("---");
        }
    }
    
    public static void update() throws IOException{
        File input = new File("simple.html");
        Document document = Jsoup.parse(input, "UTF-8");

        Element e = document.getElementsByTag("a").first();
        e.text("novy text linku");
        e.attr("href", "www.novylink.sk");

        System.out.println(document.toString());
    }    

    public static void links() throws IOException{
        File input = new File("links.html");
        Document document = Jsoup.parse(input, "UTF-8");

        Element div = document.getElementById("main");
        Elements links = div.getElementsByTag("a");
        for (Element e: links){            
            System.out.println(e.text() + ": " + e.attr("href"));                        
        }
    }

    public static void wiki() throws IOException{
        Document doc = Jsoup.connect("http://www.wikipedia.org").get();
        System.out.println(doc.toString());
    }

    public static void main(String[] args) throws IOException {
        wiki();
   
    }
}  
