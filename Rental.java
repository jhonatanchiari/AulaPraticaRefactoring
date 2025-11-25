public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    // Já criado no Refactoring anterior
    public double getCharge() {
        double result = 0;

        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;
                break;

            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;

            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

    //  NOVO MÉTODO EXTRAÍDO
    public int getFrequentRenterPoints() {
        // Regra: filmes NEW_RELEASE alugados por mais de 1 dia ganham 2 pontos
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
