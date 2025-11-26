public class TextStatement extends Statement {

    @Override
    protected String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    @Override
    protected String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" +
               each.getCharge() + "\n";
    }

    @Override
    protected String footerString(Customer aCustomer) {
        String result = "Amount owed is " + aCustomer.getTotalCharge() + "\n";
        result += "You earned " + aCustomer.getTotalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }
}
