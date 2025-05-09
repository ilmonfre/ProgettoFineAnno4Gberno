public class Budget{

    private double maxSett;
    private double maxMen;
    private double maxAnn;

    private double correnteSett;
    private double correnteMen;
    private double correnteAnn;

    public Budget(double maxSett, double maxMen, double maxAnn, double correnteSett, double correnteMen, double correnteAnn) {
        
        this.maxSett = maxSett;
        this.maxMen = maxMen;
        this.maxAnn = maxAnn;
        this.correnteSett = correnteSett;
        this.correnteMen = correnteMen;
        this.correnteAnn = correnteAnn;
    }
    public double getMaxSett() {
        return maxSett;
    }
    public void setMaxSett(double maxSett) {
        this.maxSett = maxSett;
    }
    public double getMaxMen() {
        return maxMen;
    }
    public void setMaxMen(double maxMen) {
        this.maxMen = maxMen;
    }
    public double getMaxAnn() {
        return maxAnn;
    }
    public void setMaxAnn(double maxAnn) {
        this.maxAnn = maxAnn;
    }
    public double getCorrenteSett() {
        return correnteSett;
    }
    public void setCorrenteSett(double correnteSett) {
        this.correnteSett = correnteSett;
    }
    public double getCorrenteMen() {
        return correnteMen;
    }
    public void setCorrenteMen(double correnteMen) {
        this.correnteMen = correnteMen;
    }
    public double getCorrenteAnn() {
        return correnteAnn;
    }
    public void setCorrenteAnn(double correnteAnn) {
        this.correnteAnn = correnteAnn;
    }

    public void visualizzaLimiti(){

        if(getMaxSett()==0){

            setMaxSett(-1);
        }

        if(getMaxMen()==0){

            setMaxMen(-1);
        }

        if(getMaxAnn()==0){

            setMaxAnn(-1);
        }
    }

    public boolean controllaSettimanale(double aggiunta){

        if(getCorrenteSett()+aggiunta > getMaxSett()){

            return false;
        }

        return true;
    }

    public boolean controllaMensile(double aggiunta){

        if(getCorrenteMen()+aggiunta > getMaxMen()){

            return false;
        }

        return true;
    }

    public boolean controllaAnnuale(double aggiunta){

        if(getCorrenteAnn()+aggiunta > getMaxAnn()){

            return false;
        }

        return true;
    }

    public boolean controlloNumero(RoundedTextField textField){

        try {

            Double.parseDouble(textField.getText());
            return true;
        } catch (NumberFormatException e) {

            return false;
        }
    }
}