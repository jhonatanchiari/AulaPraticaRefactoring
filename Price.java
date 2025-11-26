public abstract class Price {
    public abstract int getPriceCode();

    // ✔ Agora é um método abstrato
    public abstract double getCharge(int daysRented);

    // Mantido do passo anterior
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
