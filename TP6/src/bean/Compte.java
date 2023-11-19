package bean;

public class Compte {
    private String rib;
    private double solde;
    private boolean ouvert;

    public Compte() {
    }

    public Compte(String rib, double solde) {
        this.rib = rib;
        this.solde = solde;
    }

    public Compte(String rib, double solde, boolean ouvert) {
        this.rib = rib;
        this.solde = solde;
        this.ouvert = ouvert;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "rib='" + rib + '\'' +
                ", solde=" + solde +
                ", ouvert=" + ouvert +
                '}';
    }
}
