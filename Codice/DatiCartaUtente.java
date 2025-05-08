public class DatiCartaUtente {
    
    private String IBAN;
    private String nCarta;
    private String cvv;
    private String pin;
    private String dataScadenza;
    

    DatiCartaUtente(String[] fields){
        
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
}
