package Biblioteca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class Libro {

        private String codigo, titulo, autor, localizacion, signatura;
        private boolean disponible;

        public Libro(String codigo, String titulo, String autor, String localizacion, String signatura,
                     boolean disponible) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.autor = autor;
            this.localizacion = localizacion;
            this.signatura = signatura;
            this.disponible = disponible;
        }

        public String getLocalizacion() {
            return localizacion;
        }

        public void setLocalizacion(String localizacion) {
            this.localizacion = localizacion;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getSignatura() {
            return signatura;
        }

        public void setSignatura(String signatura) {
            this.signatura = signatura;
        }

        public boolean isDisponible() {
            return disponible;
        }

        public void setDisponible(boolean disponible) {
            this.disponible = disponible;
        }

        @Override
        public String toString() {
            return "Libro{" + "codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", localizacion="
                    + localizacion + ", signatura=" + signatura + ", disponible=" + disponible + '}';
        }

    }

class Usuario {

    private String numero, nombre, direccion;

    public Usuario(String numero, String nombre, String direccion) {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String toString() {
        return "Usuario{" + "numero=" + numero + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }

}

class Prestamo {

    private String codigoLibro, numeroUsuario;
    private LocalDateTime fecha;

    public Prestamo(String codigoLibro, String numeroUsuario, LocalDateTime fecha) {
        this.codigoLibro = codigoLibro;
        this.numeroUsuario = numeroUsuario;
        this.fecha = fecha;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroUsuario(String numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormateada() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter DateTimeFormatter = null;
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        return formateador.format(this.fecha);
    }

    @Override
    public String toString() {
        return "Prestamo{" + "codigoLibro=" + codigoLibro + ", numeroUsuario=" + numeroUsuario + ", fecha="
                + this.getFechaFormateada()+'}';
}

}

