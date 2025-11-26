public abstract class Price {
    public abstract int getPriceCode();
    public abstract double getCharge(int daysRented);

    //Método genérico para todos os preços (exceto NEW_RELEASE)
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
