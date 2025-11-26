public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    // =====================================================
    // getCharge EXTRAÍDO (Passo 1)
    // =====================================================
    public double getCharge(int daysRented) {
        double thisAmount = 0;

        switch (priceCode) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;

            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;

            case CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }

        return thisAmount;
    }

    // =====================================================
    // NOVO MÉTODO EXTRAÍDO (Passo 2)
    // =====================================================
    public int getFrequentRenterPoints(int daysRented) {

        // Regra original:
        // Se NEW_RELEASE e alugado > 1 dia → 2 pontos
        // Senão → 1 ponto

        if (priceCode == NEW_RELEASE && daysRented > 1) {
            return 2;
        }

        return 1;
    }
}
