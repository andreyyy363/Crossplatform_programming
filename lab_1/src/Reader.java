import java.util.*;

public class Reader {
    int i;
    int k;

    public void Scan() {
        System.out.println("Vvedite 1-е chislo");
        Scanner scn1 = new Scanner(System.in);
        i = scn1.nextInt();
        System.out.println("Vvedite 2-е chislo");
        Scanner scn2 = new Scanner(System.in);
        k = scn2.nextInt();
    }
}