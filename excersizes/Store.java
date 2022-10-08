package excersizes;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Store {

    @Test
    void everythingWorks(){
        final ShoppingCart shoppingCart = new ShoppingCart();



        final Food bread = new Food("bread", 25, true);
        final Food doplhinEarFiletMignon = new Food("doplhinEarFiletMignon", 100, false);
        final CleaningProduct soap = new CleaningProduct("soap", 17);
        assertEquals(25, bread.getPrice(shoppingCart));
        assertEquals(50, doplhinEarFiletMignon.getPrice(shoppingCart));

        shoppingCart.addItem(soap);
        shoppingCart.addItem(bread);
        shoppingCart.addItem(doplhinEarFiletMignon);
        shoppingCart.addItem(new CleaningProduct("vacuum cleaner", 2500));
        assertEquals(2, shoppingCart.getAmtOfCleaningProducts());
        assertEquals(2592, shoppingCart.getTotalPrice());

        shoppingCart.addItem(soap);
        shoppingCart.addItem(soap);
        shoppingCart.addItem(soap);
        assertEquals(5, shoppingCart.getAmtOfCleaningProducts());
        assertEquals(2386.2, shoppingCart.getTotalPrice());

        shoppingCart.removeProduct(soap);
        assertEquals(4, shoppingCart.getAmtOfCleaningProducts());

        assertEquals(true, shoppingCart.hasProduct(doplhinEarFiletMignon));
    }
}

class ShoppingCart{
    private final ArrayList<Product> products = new ArrayList<>();
    private int cleaningProductAmt = 0;

    public void addItem(Product product){
        if(product instanceof CleaningProduct){
            cleaningProductAmt++;
        }

        products.add(product);
    }

    public int getAmtOfCleaningProducts(){
        return cleaningProductAmt;
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(Product product : products){
            totalPrice += product.getPrice(this);
        }
        return Math.round(totalPrice * 100) / 100d;
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public boolean hasProduct(Product product){
        return products.contains(product);
    }
}

class Product{
    final String name;
    private final double baselinePrice;

    public Product(String name, double baselinePrice) {
        this.name = name;
        this.baselinePrice = baselinePrice;
    }

    public double getPrice(ShoppingCart shoppingCart){
        return baselinePrice;
    }
}


class Food extends Product{
    private final boolean containsGluten;

    public Food(String name, double baselinePrice, boolean containsGluten) {
        super(name, baselinePrice);
        this.containsGluten = containsGluten;
    }

    @Override
    public double getPrice(ShoppingCart shoppingCart) {
        if(containsGluten) return super.getPrice(shoppingCart);
        return super.getPrice(shoppingCart) / 2;
    }

}

class CleaningProduct extends Product{

    public CleaningProduct(String name, double baselinePrice) {
        super(name, baselinePrice);
    }

    @Override
    public double getPrice(ShoppingCart shoppingCart) {
        final int cleaningProductAmt = shoppingCart.getAmtOfCleaningProducts();
        if(cleaningProductAmt > 4) return super.getPrice(shoppingCart) * 0.9;
        return super.getPrice(shoppingCart);
    }

}