import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Movimenti {
    
    ArrayList<Movimento> movimentiList;
    ArrayList<Movimento> entrateList;
    ArrayList<Movimento> usciteList;
    private double totaleEntrate;
    private double totaleUscite;
    private double soldiConto;

    public Movimenti(double totaleEntrate, double totaleUscite, double soldiConto){

        movimentiList = new ArrayList<>();
        entrateList = new ArrayList<>();
        usciteList = new ArrayList<>();
        this.totaleEntrate=totaleEntrate;
        this.totaleUscite=totaleUscite;
        this.soldiConto=soldiConto;
    }

    public ArrayList<Movimento> getMovimentiList() {
        return movimentiList;
    }

    public void setMovimentiList(ArrayList<Movimento> movimentiList) {
        this.movimentiList = movimentiList;
    }

    public double getTotaleEntrate() {
        return totaleEntrate;
    }

    public void setTotaleEntrate(double totaleEntrate) {
        this.totaleEntrate = totaleEntrate;
    }

    public double getTotaleUscite() {
        return totaleUscite;
    }

    public void setTotaleUscite(double totaleUscite) {
        this.totaleUscite = totaleUscite;
    }

    public double getSoldiConto() {
        return soldiConto;
    }

    public void setSoldiConto(double soldiConto) {
        this.soldiConto = soldiConto;
    }

    public boolean nuovaEntrata(double costo, LocalDate data, String tipo, String categoria, String utente){

        if(costo<=0 || tipo==null || categoria==null || data==null || utente==null){

            return false;
        }

        Movimento nuovo = new Movimento(costo, data, tipo, categoria, utente);
        movimentiList.add(nuovo);
        entrateList.add(nuovo);
        setSoldiConto(getSoldiConto()+costo);
        fileMovimenti(nuovo);
        fileEntrate(nuovo);

        return true;
    }

    public boolean nuovaUscite(double costo, LocalDate data, String tipo, String categoria, String utente){

        if(costo<=0 || tipo==null || categoria==null || data==null || utente==null){

            return false;
        }

        Movimento nuovo = new Movimento(costo, data, tipo, categoria, utente);
        movimentiList.add(nuovo);
        usciteList.add(nuovo);
        setSoldiConto(getSoldiConto()-costo);
        fileMovimenti(nuovo);
        fileUscite(nuovo);

        return true;
    }

    public void fileMovimenti(Movimento aggiunta){

        String file = "movimenti.csv";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){

            String costoString = String.valueOf(aggiunta.getCosto());
            String dataString = aggiunta.getData().toString();
            String[] nuovo = {costoString, dataString, aggiunta.getTipo(), aggiunta.getCategoria(), aggiunta.getUtente()};

            writer.write(String.join(";", nuovo));
            writer.newLine();
        }catch(IOException e){

            e.printStackTrace();
        }
    }

    public void fileEntrate(Movimento aggiunta){

        String file = "entrate.csv";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){

            String costoString = String.valueOf(aggiunta.getCosto());
            String dataString = aggiunta.getData().toString();
            String[] nuovo = {costoString, dataString, aggiunta.getTipo(), aggiunta.getCategoria(), aggiunta.getUtente()};

            writer.write(String.join(";", nuovo));
            writer.newLine();
        }catch(IOException e){

            e.printStackTrace();
        }
    }

    public void fileUscite(Movimento aggiunta){

        String file = "uscite.csv";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){

            String costoString = String.valueOf(aggiunta.getCosto());
            String dataString = aggiunta.getData().toString();
            String[] nuovo = {costoString, dataString, aggiunta.getTipo(), aggiunta.getCategoria(), aggiunta.getUtente()};

            writer.write(String.join(";", nuovo));
            writer.newLine();
        }catch(IOException e){

            e.printStackTrace();
        }
    }

    public double calcolaEntrateUMese(){

        LocalDate oggi = LocalDate.now();
        LocalDate meseFa = oggi.minusMonths(1);

        double entrateUMese=0;

        for(int i=0;i<entrateList.size();i++){

            if(entrateList.get(i).getData().isAfter(meseFa) || entrateList.get(i).getData().isEqual(meseFa) && entrateList.get(i).getData().isBefore(oggi.plusDays(1))){

                entrateUMese+=entrateList.get(i).getCosto();
            }
        }

        return entrateUMese;
    }

    public double calcolaUsciteUMese(){

        LocalDate oggi = LocalDate.now();
        LocalDate meseFa = oggi.minusMonths(1);

        double usciteUMese=0;

        for(int i=0;i<usciteList.size();i++){

            if(usciteList.get(i).getData().isAfter(meseFa) || usciteList.get(i).getData().isEqual(meseFa) && usciteList.get(i).getData().isBefore(oggi.plusDays(1))){

                usciteUMese+=usciteList.get(i).getCosto();
            }
        }

        return usciteUMese;
    }

    public Movimento calcoloPrimo(){

        movimentiList.add(new Movimento(100, null, "entrata", "Tecnologia", "Apple"));
        if(movimentiList.size()<1){

            return null;
        }
        return movimentiList.get(0);
    }

    public Movimento calcoloSecondo(){

        if(movimentiList.size()<2){

            return null;
        }
        return movimentiList.get(1);
    }

    public Movimento calcoloTerzo(){

        if(movimentiList.size()<3){

            return null;
        }

        return movimentiList.get(2);
    }

    public double trovaCostoso(){

        double max=0;
        for(int i=0;i<movimentiList.size();i++){

            if(movimentiList.get(i).getCosto()>max){

                max=movimentiList.get(i).getCosto();
            }
        }

        return max;
    }
}
