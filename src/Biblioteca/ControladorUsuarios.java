package Biblioteca;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladorUsuarios {

    private static final String NOMBRE_ARCHIVO = "usuarios.txt";
    private static final String SEPARADOR_CAMPO = ";";
    private static final String SEPARADOR_REGISTRO = "\n";

    public static void solicitarDatosParaRegistrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero de usuario: ");
        String numero = sc.nextLine();
        System.out.println("Ingrese nombre de usuario: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese direccion de usuario: ");
        String direccion = sc.nextLine();
        ControladorUsuarios.registrar(new Usuario(numero, nombre, direccion));
        System.out.println("Registrado exitosamente");
    }

    public static void registrar(Usuario usuario) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true));
            bufferedWriter.write(usuario.getNumero() + SEPARADOR_CAMPO + usuario.getNombre() + SEPARADOR_CAMPO
                    + usuario.getDireccion() + SEPARADOR_REGISTRO);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }

    public static ArrayList<Usuario> obtener() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(NOMBRE_ARCHIVO);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] usuarioComoArreglo = linea.split(SEPARADOR_CAMPO);
                usuarios.add(new Usuario(usuarioComoArreglo[0], usuarioComoArreglo[1], usuarioComoArreglo[2]));
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            return usuarios;
        }
    }

    public static void imprimirUsuarios(ArrayList<Usuario> usuarios) {
        ArrayList<Prestamo> prestamos = ControladorPrestamos.obtener();
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", "#", "No. usuario", "Nombre", "Direccion",
                "Libros prestados");
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        for (int x = 0; x < usuarios.size(); x++) {
            Usuario usuario = usuarios.get(x);
            System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", x + 1, usuario.getNumero(), usuario.getNombre(),
                    usuario.getDireccion(), ControladorPrestamos.cantidadLibrosPrestados(usuario.getNumero(), prestamos));
            System.out.println(
                    "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        }
    }

    public static void imprimirUsuariosNoFiables(ArrayList<Usuario> usuarios) {
        ArrayList<Prestamo> prestamos = ControladorPrestamos.obtener();
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", "#", "No. usuario", "Nombre", "Direccion",
                "Libros prestados");
        System.out.println(
                "+--------+-------------+----------------------------------------+----------------------------------------+--------------------+");
        for (int x = 0; x < usuarios.size(); x++) {
            Usuario usuario = usuarios.get(x);
            int librosPrestados = (int) ControladorPrestamos.cantidadLibrosPrestados(usuario.getNumero(), prestamos);
            if (librosPrestados < 10) {
                continue;
            }
            System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", x + 1, usuario.getNumero(), usuario.getNombre(),
                    usuario.getDireccion(), librosPrestados);
            System.out.println(
                    "+-------+--------------+----------------------------------------+----------------------------------------+--------------------+");
        }
    }

    public static int buscarUsuarioPorNumero(String numero, ArrayList<Usuario> usuarios) {
        for (int x = 0; x < usuarios.size(); x++) {
            Usuario usuario = usuarios.get(x);
            if (usuarios.getFirst().equals(numero)) {
                return x;
            }
        }
        return -1;
    }

    public static Usuario imprimirUsuariosYPedirSeleccion() {
        ArrayList<Usuario> usuarios = ControladorUsuarios.obtener();
        Scanner sc = new Scanner(System.in);
        while (true) {
            ControladorUsuarios.imprimirUsuarios(usuarios);
            System.out.println("Ingrese el numero del usuario: ");
            String numero = sc.nextLine();
            int indice = ControladorUsuarios.buscarUsuarioPorNumero(numero, usuarios);
            if (indice == -1) {
                System.out.println("No existe el usuario con ese numero");
            } else {
                return usuarios.get(indice);
            }
        }
    }
}



