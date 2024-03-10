package proyecto1;

import java.util.Scanner;

public class conversion {

    public static void main(String[] args) {
        while(true){
            System.out.println("CONVERSOR DE MONEDA ");
            System.out.println("1 - peso colombiana a dolares\n"
                    + "2 - dolar australiando a dolares \n"
                    + "3 - peso mexicana a dolares\n"
                    + "4 - peso dominicano a dolares\n"
                    + "5 - corona noruega a dolares\n"
                    + "6 - dolar jamaiquino a dolares \n"
                    + "7 - euro a dolades\n"
                    + "8 - sol pereuno a dolares \n"
                    + "9 - salir");
            System.out.print("ingrese una opcion: ");
            Scanner leer = new Scanner(System.in);
            char opcion = leer.next().charAt(0);
            switch (opcion) {
                case '1':
                    convertir(3912.58, "moneda colombiana");
                    break;
                case '2':
                    convertir(1.53, "dolar australiano");
                    break;
                case '3':
                    convertir(17.02, "peso mexicano");
                    break;
                case '4':
                    convertir(58.52, "peso dominicano");
                    break;
                case '5':
                    convertir(10.57, "corona noruega");
                    break;
                case '6':
                    convertir(155.46, "dolar jamaiquino");
                    break;
                case '7':
                    convertir(0.92, "euro");
                    break;
                case '8':
                    convertir(3.77, "sol peruano");
                    break;
                case '9':
                    System.out.println(" cerrando programa");
                    break;
                default:
                    System.out.println("opcion incorreta");
                    break;

            }
        }
    }

    static void convertir(double valorDolar, String pais) {
        Scanner leer = new Scanner(System.in);
        System.out.printf("ingrese la cantidad de %s :", pais);
        double cantidadMoneda = leer.nextDouble();

        double dolares = cantidadMoneda / valorDolar;

        dolares = (double) Math.round(dolares * 100d) / 100;

        System.out.println("---------------------------------");
        System.out.println("|    tienes $" + dolares + "dolares |");
        System.out.println("---------------------------------");


    }
}

