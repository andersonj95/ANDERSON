package proyecto1;
import java.util.Random;
import java.util.Scanner;
public class DigitoRepetido {

    public static void main(String[] args) {

    int N, num, cout=0;
    N=10;
    int[] a=new int[N];
        Random rd = new Random();
        Scanner leer= new Scanner(System.in);

    for (int i=0; i<N; i++){
        a[i]= rd.nextInt(10-1) +1;
        System.out.println(a[i]);
    }

        System.out.println("Ingresa un numero entre 1 y 10: ");
    num = leer.nextInt();

    while ((num < 1) || (num > 10)){
        System.out.println("Debes ingresar un numero en el rango");
        num = leer.nextInt();
    }

        int count = 0;
        for (int i = 0; i < N; i++){
        if(a[i] == num){
            count ++;
        }
    }
        System.out.println("El numero"+num+" Se repite " + count + "veces");
    }
}





