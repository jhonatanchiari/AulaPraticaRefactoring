import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {

        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : rentals) {

            // mostra valores deste aluguel
            result.append("\t")
                  .append(each.getMovie().getTitle())
                  .append("\t")
                  .append(each.getCharge())
                  .append("\n");
        }

        // rodapé
        result.append("Amount owed is ")
              .append(getTotalCharge())
              .append("\n");

        result.append("You earned ")
              .append(getTotalFrequentRenterPoints())
              .append(" frequent renter points");

        return result.toString();
    }

    /** Soma o total cobrado do cliente */
    private double getTotalCharge() {
        double result = 0;
        for (Rental each : rentals) {
            result += each.getCharge();
        }
        return result;
    }

    /** Soma todos os pontos ganhos */
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental each : rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
