package Biblioteca;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;

public class ControladorPrestamos {

    private static final String NOMBRE_ARCHIVO = "prestamos.txt";
    private static final String SEPARADOR_CAMPO = ";";
    private static final String SEPARADOR_REGISTRO = "\n";

    public static void registrar(Prestamo prestamo) {
        ControladorLibros.marcarComoPrestado(prestamo.getCodigoLibro());
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true));
            bufferedWriter.write(prestamo.getCodigoLibro() + SEPARADOR_CAMPO + prestamo.getNumeroUsuario()
                    + SEPARADOR_CAMPO + prestamo.getFechaFormateada() + SEPARADOR_REGISTRO);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }

    public static ArrayList<Prestamo> obtener() {
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(NOMBRE_ARCHIVO);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] prestamoComoArreglo = linea.split(SEPARADOR_CAMPO);
                prestamos.add(new Prestamo(prestamoComoArreglo[0], prestamoComoArreglo[1],
                        LocalDateTime.parse(prestamoComoArreglo[2],
                                new DateTimeFormatterBuilder().parseCaseInsensitive()
                                        .append(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toFormatter())));
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
        }
        return prestamos;
    }

    public static int cantidadLibrosPrestados(String numeroUsuario, ArrayList<Prestamo> prestamos) {
        int cantidad = 0;
        for (int x = 0; x < prestamos.size(); x++) {
            Prestamo prestamo = prestamos.get(x);
            if (prestamo.getNumeroUsuario().equals(numeroUsuario)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public static void imprimirPrestamos(ArrayList<Prestamo> prestamos) {
        System.out
                .println("+-----+------------------------------+------------------------------+--------------------+");
        System.out.printf("|%-5s|%-30s|%-30s|%-20s|\n", "No", "Codigo libro", "No. Usuario", "Fecha");
        System.out
                .println("+-----+------------------------------+------------------------------+--------------------+");

        for (int x = 0; x < prestamos.size(); x++) {
            Prestamo prestamo = prestamos.get(x);
            System.out.printf("|%-5d|%-30s|%-30s|%-20s|\n", x, prestamo.getCodigoLibro(), prestamo.getNumeroUsuario(),
                    prestamo.getFechaFormateada());
            System.out.println(
                    "+-----+------------------------------+------------------------------+--------------------+");
        }
    }

    public static void solicitarDatosYCrearPrestamo() {
        Libro libro = ControladorLibros.imprimirLibrosYPedirSeleccion();
        Usuario usuario = ControladorUsuarios.imprimirUsuariosYPedirSeleccion();
        ControladorPrestamos.registrar(new Prestamo(libro.getCodigo(), usuario.getNumero(), LocalDateTime.now()));
        System.out.println("Prestamo registrado correctamente");
}
}


