import java.io.File;
import java.io.IOException;

public class Exceptions {

    public static void createMyFile() throws IOException{        
        String nazov = "\\@#$!@-myfile#.#txt";
        File f = new File(nazov);
        f.createNewFile();        
    }

    public static void sleep(){
        try {
            System.out.println("A");
            Thread.sleep(3 * 1000);
            System.out.println("B");
            createMyFile();
        } catch (InterruptedException e){
            System.out.println("prerusenie");
        } catch (IOException e){
            System.out.println("nevytvoril som subor");
        }
    }

    public static void kontrolaCisla(int x) throws VysokeCisloException{
        if (x > 50){
            throw new VysokeCisloException("ahoj ... zadal si vysoke cislo. musis zadat mensie cislo");
        }
    }

    public static void main(String[] args) throws VysokeCisloException {
        //createMyFile();

        String s = null;        
        s.length();        
        


        int a = 55;
        try {

            new NullPointerException();

            
            kontrolaCisla(a);           
            System.out.println("prebieha vypocet");
            System.out.println("....");
            System.out.println("vypocet skoncil");
        } catch (VysokeCisloException e){
            System.out.println(e.getMessage());
        }

        
        
    }
} 