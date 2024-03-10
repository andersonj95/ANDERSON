package proyecto1;

import java.util.Scanner;

public class Añobisiesto {
        public static void main(String[] args) {
            Scanner sn = new Scanner(System.in);

            System.out.print("Ingrese el año: ");
            int anio = sn.nextInt();

            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0))
            {
                System.out.println("el año " + anio + "es bisiesto");

            } else {
                System.out.println("el año " + anio + " no es bisiesto");
            }
        }
    }




