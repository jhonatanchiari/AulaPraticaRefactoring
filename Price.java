public abstract class Price {
    public abstract int getPriceCode();

    // 👉 Novo método movido da classe Movie
    public double getCharge(int daysRented) {
        double result = 0;
        return result;
    }

    // Já existia no passo anterior
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
