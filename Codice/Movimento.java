import java.time.LocalDate;

public class Movimento{

    private double costo;
    private LocalDate data;
    private String tipo;
    private String categoria;
    private String utente;

    public Movimento(double costo, LocalDate data, String tipo, String categoria, String utente){

        this.costo=costo;
        this.data=data;
        this.tipo=tipo;
        this.categoria=categoria;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }
}