public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private int anyo;
    private double precio;
    private int kms;
   // terminar clase
    public Coche(String marca, String modelo, String matricula, int anyo, double precio, int kms) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anyo = anyo;
        this.precio = precio;
        this.kms = kms;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getAnyo() {
        return anyo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getKms() {
        return kms;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", anyo=" + anyo +
                ", precio=" + precio +
                ", kms=" + kms +
                '}';
    }
}
