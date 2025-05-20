public class MainApertura {
    
    public static void main(String[] args) {
        
        Budget budget = new Budget(-1, -1, -1, 0, 0, 0);
        Movimenti movimenti = new Movimenti(0, 0, 0, 0, budget);
        new Apertura(movimenti);
    }
}