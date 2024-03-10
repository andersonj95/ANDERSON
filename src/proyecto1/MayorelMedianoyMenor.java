package proyecto1;
import java.util.Scanner;
public class MayorelMedianoyMenor {



        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Ingrese tu primer numero: ");
            int num1 = input.nextInt();

            System.out.print("Ingrese tu segundo numero: ");
            int num2 = input.nextInt();

            System.out.print("ingrese tu tercer numero: ");
            int num3 = input.nextInt();

            if (num1 >= num2 && num1 >= num3) {
                if (num2 >= num3) {
                    System.out.println("Numeros enteros en forma ascendente: " + num3 + " " + num2 + " " + num1);
                } else {
                    System.out.println("Numeros enteros en forma ascedente: " + num2 + " " + num3 + " " + num1);
                }
            } else if (num2 >= num1 && num2 >= num3) {
                if (num1 >= num3) {
                    System.out.println("Numeros enteros en forma ascendente: " + num3 + " " + num1 + " " + num2);
                } else {
                    System.out.println("Numeros enteros de forma ascendente: " + num1 + " " + num3 + " " + num2);
                }
            } else {
                if (num1 >= num2) {
                    System.out.println("Numeros enteros en forma ascendente: " + num2 + " " + num1 + " " + num3);
                } else {
                    System.out.println("Numeros enteros en forma ascendente: " + num1 + " " + num2 + " " + num3);
                }
            }
        }
        }
