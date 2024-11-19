public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private int anyo;
    private double precio;
    private int kms;

    public Coche(String marca, String modelo, String matricula, int anyo, double precio, int kms) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anyo = anyo;
        this.precio = precio;
        this.kms = kms;
    }

    public void descuento(int porcentajeDescuento) {
        if (porcentajeDescuento < 1 || porcentajeDescuento > 50) {
            System.out.println("ERROR: Debe especificar un valor entre 1 y 50");
            return;
        }

        double descuento = (porcentajeDescuento / 100.0) * this.precio;
        this.precio -= descuento;
        System.out.println("Nuevo precio después de " + porcentajeDescuento + "% de descuento: " + this.precio + " €");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Año: " + anyo + "\n" +
                "Precio: " + precio + "\n" +
                "Kilómetros: " + kms + "\n" +
                "---------------------------------------------";
    }
}
