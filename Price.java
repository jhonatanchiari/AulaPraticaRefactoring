public abstract class Price {

    public abstract int getPriceCode();

    // Agora é totalmente abstrato
    public abstract double getCharge(int daysRented);

    // ✔ Este método agora contém a lógica extraída de Movie
    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            return 2; // bônus
        }
        return 1; // padrão
    }
}
