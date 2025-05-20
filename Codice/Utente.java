import java.io.IOException;
import java.util.List;

public class Utente {

    private String nome;
    private String cognome;
    private String codFis;
    private String nTel;
    private String dataNascita;
    private String luogoNascita;
    private String indirizzo;
    private String citta;
    private String email;
    private String password;

    private String IBAN;
    private String nCarta;
    private String cvv;
    private String pin;
    private String dataScadenza;

    private double saldo;

    Utente(String[] fields){
        nome = fields[0];
        cognome = fields[1];
        codFis = fields[2];
        nTel = fields[3];
        dataNascita = fields[4];
        luogoNascita = fields[5];
        indirizzo = fields[6];
        citta = fields[7];
        email = fields[8];
        password = fields[9];

        IBAN = fields[10];
        nCarta = fields[11];
        dataScadenza = fields[12];
        cvv = fields[13];
        pin = fields[14];

        //saldo = Double.parseDouble(fields[15]);
        
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodFis() {
        return codFis;
    }
    public void setCodFis(String codFis) {
        this.codFis = codFis;
    }

    public String getnTel() {
        return nTel;
    }
    public void setnTel(String nTel) {
        this.nTel = nTel;
    }

    public String getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }
    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getIBAN() {
        return IBAN;
    }
    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

    public String getnCarta() {
        return nCarta;
    }
    public void setnCarta(String nCarta) {
        this.nCarta = nCarta;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }
    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }

    // saldo
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void decrementaSaldo(double importo) {
        if(saldo >= importo){
            saldo-=importo;
        }
    }

    public void incrementaSaldo(double importo) {
        saldo+=importo;
    }
}
