import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bonifico {
    private String ibanDestinatario;
    private String ibanMittente;
    private String pin;
    private double importo;
    private String causale;

    public Bonifico(String ibanDestinatario, String ibanMittente, String pin, double importo, String causale) {
        this.ibanDestinatario = ibanDestinatario;
        this.ibanMittente = ibanMittente;
        this.pin = pin;
        this.importo = importo;
        this.causale = causale;
    }

    // Salva il bonifico su file CSV (aggiunge una riga)
    public void salvaSuFile(String filename) throws IOException {
        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            // Scrive i campi separati da virgola, con escape semplice se necessario
            out.printf("%s ; %s ; %s ; %.2f ; %s ; %n",
                    escapeCSV(ibanDestinatario),
                    escapeCSV(ibanMittente),
                    escapeCSV(pin),
                    importo,
                    escapeCSV(causale));
        }
    }

    // Legge tutti i bonifici dal file CSV
    public static List<Bonifico> leggiDaFile(String filename) throws IOException {
        List<Bonifico> bonifici = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            return bonifici; // ritorna lista vuota se file non esiste
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ; ", 5); // massimo 5 elementi
                if (parts.length == 5) {
                    String ibanDest = unescapeCSV(parts[0]);
                    String ibanMitt = unescapeCSV(parts[1]);
                    String pin = unescapeCSV(parts[2]);
                    double importo = Double.parseDouble(parts[3]);
                    String causale = unescapeCSV(parts[4]);
                    bonifici.add(new Bonifico(ibanDest, ibanMitt, pin, importo, causale));
                }
            }
        }
        return bonifici;
    }

    // Escape semplice per CSV (aggiunge virgolette se contiene virgole o doppi apici)
    private static String escapeCSV(String campo) {
        if (campo.contains(",") || campo.contains("\"") || campo.contains("\n")) {
            campo = campo.replace("\"", "\"\"");
            return "\"" + campo + "\"";
        }
        return campo;
    }

    // Unescape CSV (rimuove virgolette e doppie virgolette)
    private static String unescapeCSV(String campo) {
        campo = campo.trim();
        if (campo.startsWith("\"") && campo.endsWith("\"")) {
            campo = campo.substring(1, campo.length() - 1).replace("\"\"", "\"");
        }
        return campo;
    }

    // Getters (se servono)
    public String getIbanDestinatario() { return ibanDestinatario; }
    public String getIbanMittente() { return ibanMittente; }
    public String getPin() { return pin; }
    public double getImporto() { return importo; }
    public String getCausale() { return causale; }

    /*@Override
    public String toString() {
        return "Bonifico{" +
                "ibanDestinatario='" + ibanDestinatario + '\'' +
                ", ibanMittente='" + ibanMittente + '\'' +
                ", pin='" + pin + '\'' +
                ", importo=" + importo +
                ", causale='" + causale + '\'' +
                '}';
    }*/
}

