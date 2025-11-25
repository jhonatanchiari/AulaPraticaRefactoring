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

            // show figures for this rental
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(each.getCharge())
                    .append("\n");
        }

        // footer
        result.append("Amount owed is ")
                .append(getTotalCharge())
                .append("\n");

        result.append("You earned ")
                .append(getTotalFrequentRenterPoints())
                .append(" frequent renter points");

        return result.toString();
    }

    /** ------ NOVA FEATURE: HTML STATEMENT ------ */
    public String htmlStatement() {
        StringBuilder result = new StringBuilder(
                "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n");

        for (Rental each : rentals) {
            result.append(each.getMovie().getTitle())
                    .append(": ")
                    .append(each.getCharge())
                    .append("<BR>\n");
        }

        result.append("<P>You owe <EM>")
                .append(getTotalCharge())
                .append("</EM><P>\n");

        result.append("On this rental you earned <EM>")
                .append(getTotalFrequentRenterPoints())
                .append("</EM> frequent renter points<P>");

        return result.toString();
    }

    /** Soma o total cobrado */
    private double getTotalCharge() {
        double result = 0;
        for (Rental each : rentals) {
            result += each.getCharge();
        }
        return result;
    }

    /** Soma todos os pontos do cliente */
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental each : rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
