package facade;

class Inventory {

    public boolean checkStock(String item) {
        System.out.println("Checking stock for item: " + item);
        return true; // Assume the item is always in stock
    }

}

class Payment {

    public boolean processPayment(String item) {
        System.out.println("Processing payment for item: " + item);
        return true; // Assume payment is always successful
    }

}

class Shipping {

    public boolean processShipping(String item) {
        System.out.println("Shipping item: " + item);
        return true; // Assume shipping is always successful
    }

}

/*
 *  Simplified interface for complex subsystem -
 *  provides loose coupling, single interface for end user
 *
 *  1. If becomes too large could lead to monolithic arch
 *  2. Should expose all subsystem func for end user
 *
 * */
class ShoppingFacade {

    private Inventory inventory;
    private Payment payment;
    private Shipping shipping;

    public ShoppingFacade(Inventory inventory, Payment payment, Shipping shipping) {
        this.inventory = inventory;
        this.payment = payment;
        this.shipping = shipping;
    }

    public void placeOrder(String item) {
        if (inventory.checkStock(item)) {
            System.out.println("Item found");
            if (payment.processPayment(item)) {
                System.out.println("Payment successfully processed for item: " + item);
                shipping.processShipping(item);
                System.out.println("Order complete");
            }
        } else {
            System.out.println("Sorry, not enough items for " + item);
        }

    }

}

public class ShoppingSystem {

    public static void main(String[] args) {
        var inventory = new Inventory();
        var payment = new Payment();
        var shipping = new Shipping();

        var shoppingFacade = new ShoppingFacade(inventory, payment, shipping);
        shoppingFacade.placeOrder("someItem");
    }

}
