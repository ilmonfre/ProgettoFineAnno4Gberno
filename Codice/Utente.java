public class Utente {
    
    private String email;
    private String nomeCognome;
    private String codFis;
    private String nTel;
    private String dataNascita;
    private String luogoNascita;
    private String indirizzo;
    private String citta;

    Utente(String[] fields){
        
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }
    public void setNome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
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
}
