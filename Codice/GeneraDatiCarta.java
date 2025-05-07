import java.util.Random;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.io.*;


class GeneraDatiCarta {

    String IBAN;
    long numeroCarta;
    Date dataScadenza;
    String cvv;
    String pin;

    Random rand = new Random();
    FileWriter file;

    GeneraDatiCarta() {
        this.IBAN = generaIBAN();
        this.numeroCarta = generaNumeroCarta();
        this.dataScadenza = generaDataScadenza();
        this.cvv = generaCVV();
        this.pin = generaPIN();
    }

    // Generazione IBAN
    private String generaIBAN() {
        String paese = "IT";                                                     // Prefisso paese
        String check = String.format("%02d", rand.nextInt(100));    // Due cifre di controllo
        char cin = (char)('A' + rand.nextInt(26));                        // CIN (una lettera maiuscola)
        String abi = String.format("%05d", rand.nextInt(100000));   // ABI (5 cifre)
        String cab = String.format("%05d", rand.nextInt(100000));   // CAB (5 cifre)
        String conto = String.format("%012d", Math.abs(rand.nextLong()) % 1000000000000L);  // Numero conto (12 caratteri numerici)
        return paese + check + cin + abi + cab + conto;
    }

    // Generazione numero carta (16 cifre)
    private long generaNumeroCarta() {
        long base = 1000000000000000L;
        return base + (Math.abs(rand.nextLong()) % 100000000000000L);
    }

    // Generazione data scadenza (tra 1 e 5 anni da oggi)
    private Date generaDataScadenza() {
        Calendar cal = Calendar.getInstance();
        int anno = 1 + rand.nextInt(5);
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

    //Metodo per salvare i dati
    String res = "";
    public String salvaDati() {
        
        System.out.println("IBAN: " + IBAN);
        res += IBAN;
        System.out.println("Numero Carta: " + numeroCarta + "\n");
        res += numeroCarta;
        System.out.println("Data Scadenza: " + dataScadenza + "\n");
        res += dataScadenza;
        System.out.println("CVV: " + cvv + "\n");
        res += cvv;
        System.out.println("PIN: " + pin + "\n");
        res += pin;
        return res;
    }

    public void salvaDatiSuFile() {
        try (FileWriter writer = new FileWriter("save.csv", true)) {
            writer.write(salvaDati());
            writer.write("\n\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
