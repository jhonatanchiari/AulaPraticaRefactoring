import java.util.Enumeration;

public abstract class Statement {

    // TEMPLATE METHOD → agora centralizado aqui
    public String value(Customer aCustomer) {

        String result = headerString(aCustomer);

        Enumeration rentals = aCustomer.getRentals();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRentalString(each);
        }

        result += footerString(aCustomer);

        return result;
    }

    // HOOK METHODS — subclasses implementam
    protected abstract String headerString(Customer aCustomer);

    protected abstract String eachRentalString(Rental each);

    protected abstract String footerString(Customer aCustomer);
}
