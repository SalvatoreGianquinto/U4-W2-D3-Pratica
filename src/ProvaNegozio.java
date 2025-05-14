import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProvaNegozio {

    public static void main(String[] args) {
        Prodotti p1 = new Prodotti("123", "Book1", "Books", 90);
        Prodotti p2 = new Prodotti("456", "Book2", "Books", 120);
        Prodotti p3 = new Prodotti("789", "Book3", "Books", 130);

        Prodotti pbaby1 = new Prodotti("987", "pallone", "Baby", 25);
        Prodotti pbaby2 = new Prodotti("654", "peluche", "Baby", 17);
        Prodotti pbaby3 = new Prodotti("321", "pupazzo", "Not", 59);

        Prodotti pBoys1 = new Prodotti("100", "Playstation 5", "Boys", 550);
        Prodotti pBoys2 = new Prodotti("200", "Maglietta Adidas", "Boys", 29);
        Prodotti pBoys3 = new Prodotti("300", "Scooter", "Not", 4000);

        Customer c1 = new Customer("C1", "Mario", 1);
        Customer c2 = new Customer("C2", "Luigi", 2);
        Customer c3 = new Customer("C3", "Anna", 2);

        List<Prodotti> product = new ArrayList<>();
        product.add(p1);
        product.add(p2);
        product.add(p3);
        product.add(pbaby1);
        product.add(pbaby2);
        product.add(pbaby3);
        product.add(pBoys1);
        product.add(pBoys2);
        product.add(pBoys3);

        System.out.println("Prodotti");
        product.forEach(System.out::println);

        System.out.println("--------------------------");

        Prodotti[] prodotti = {p1, p2, p3};

        List<Prodotti> libri = Arrays.stream(prodotti)
                .filter(p -> "Books".equals(p.getCategoria()) && p.getPrice() > 100).toList();

        System.out.println("Libri con prezzo superiore a 100");
        libri.forEach(System.out::println);

        System.out.println("--------------------------");

        Order o1 = new Order("1", "Shipped",
                LocalDate.now(),
                LocalDate.now().plusDays(2),
                Arrays.stream(new Prodotti[]{pbaby1, pbaby2}).toList(),
                c1);

        Order o2 = new Order("2", "Pending",
                LocalDate.now(),
                LocalDate.now().plusDays(3),
                Arrays.stream(new Prodotti[]{pbaby3, pbaby1}).toList(),
                c2);

        Order o3 = new Order("3", "Shipped",
                LocalDate.now(),
                LocalDate.now().plusDays(4),
                Arrays.stream(new Prodotti[]{pbaby2}).toList(),
                c3);


        Order[] ordine = {o1, o2, o3};
        List<Order> ordini = Arrays.stream(new Order[]{o1, o2, o3}).toList();

        List<Order> ordiniBaby = ordini.stream()
                .filter(order -> order.getProdotti().stream()
                        .anyMatch(prodotto -> "Baby".equals(prodotto.getCategoria()))).toList();

        System.out.println("Ordini prodotti Baby");
        ordiniBaby.forEach(System.out::println);

        System.out.println("--------------------------");

        System.out.println("Prodotti Boys scontati al 10%");
        List<Prodotti> prodottiBoys = Arrays.stream(new Prodotti[]{pBoys1, pBoys2, pBoys3}).toList();
        List<Prodotti> prodottiSconto = prodottiBoys.stream()
                .filter(prodotto -> "Boys".equals(prodotto.getCategoria()))
                .map(prodotto -> {
                    double nuovoPrezzo = prodotto.getPrice() * 0.9;
                    prodotto.setPrice(nuovoPrezzo);
                    return prodotto;
                }).toList();

        prodottiSconto.forEach(System.out::println);

        System.out.println("--------------------------");

    }
}
