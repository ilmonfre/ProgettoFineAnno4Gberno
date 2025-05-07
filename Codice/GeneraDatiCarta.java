import java.util.Random;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;

class GeneraDatiCarta {

    String IBAN;
    long numeroCarta;
    Date dataScadenza;
    String cvv;
    String pin;

    Random rand = new Random();
    static FileWriter writer;

    GeneraDatiCarta() {
        this.IBAN = generaIBAN();
        this.numeroCarta = generaNumeroCarta();
        this.dataScadenza = generaDataScadenza();
        this.cvv = generaCVV();
        this.pin = generaPIN();
    }

    // Generazione IBAN
    private String generaIBAN() {
        String paese = "IT";    // Prefisso paese
        String check = String.format("%02d", rand.nextInt(100));    // Due cifre di controllo
        char cin = (char)('A' + rand.nextInt(26));  // CIN (una lettera maiuscola)
        String abi = String.format("%05d", rand.nextInt(100000));   // ABI (5 cifre)
        String cab = String.format("%05d", rand.nextInt(100000));   // CAB (5 cifre)
        String conto = String.format("%012d", Math.abs(rand.nextLong()) % 1000000000000L);  // Numero conto (12 caratteri numerici)
        return paese + check + cin + abi + cab + conto;
    }

    // Generazione numero carta (16 cifre)
    private long generaNumeroCarta() {
        long base = 4000000000000000L;
        return base + (Math.abs(rand.nextLong()) % 100000000000000L);
    }

    // Generazione data scadenza (tra 5 anni da oggi)
    private Date generaDataScadenza() {
        Calendar cal = Calendar.getInstance();
        int anno = 5;
        cal.add(Calendar.YEAR, anno);
        return cal.getTime();
    }

    // Generazione CVV (3 cifre)
    private String generaCVV() {
        return String.format("%03d", rand.nextInt(1000));
    }

    // Generazione PIN (5 cifre)
    private String generaPIN() {
        return String.format("%05d", rand.nextInt(100000));
    }

    //Metodo per stampare i dati
    public String stampaDati() {
        String res = "";

        res += generaIBAN() + " ; ";
        res += generaNumeroCarta() + " ; ";
        res += generaDataScadenza() + " ; "; 
        res += generaCVV() + " ; ";     
        res += generaPIN() + "\n\n";

        return res;
    }
  
    void salvaSulFile(){
        try(FileWriter writer = new FileWriter("save.csv", true)){
            writer.write(stampaDati());
            writer.write("\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
