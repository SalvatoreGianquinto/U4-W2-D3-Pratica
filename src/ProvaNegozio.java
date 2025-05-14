import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProvaNegozio {

    public static void main(String[] args) {
        Prodotti p1 = new Prodotti(1L, "Book1", "Books", 90);
        Prodotti p2 = new Prodotti(2L, "Book2", "Books", 120);
        Prodotti p3 = new Prodotti(3L, "Book3", "Books", 130);

        Prodotti p4 = new Prodotti(4L, "pallone", "Baby", 25);
        Prodotti p5 = new Prodotti(5L, "peluche", "Baby", 17);
        Prodotti p6 = new Prodotti(6L, "pupazzo", "Not", 59);

        Prodotti p7 = new Prodotti(7L, "Playstation 5", "Boys", 550);
        Prodotti p8 = new Prodotti(8L, "Maglietta Adidas", "Boys", 29);
        Prodotti p9 = new Prodotti(9L, "Scooter", "Not", 4000);

        Customer c1 = new Customer(1L, "Mario", 1);
        Customer c2 = new Customer(2L, "Luigi", 2);
        Customer c3 = new Customer(3L, "Anna", 2);

        Order o1 = new Order(1L, "ordinato", LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 5, 3));

        Order o2 = new Order(1L, "ordinato", LocalDate.of(2021, 3, 1),
                LocalDate.of(2021, 2, 3));

        Order o3 = new Order(1L, "ordinato", LocalDate.of(2021, 2, 12),
                LocalDate.of(2021, 2, 3));

        o1.setCustomer((c1));
        o1.setProdotti(List.of(p1,p2,p3));

        o2.setCustomer((c2));
        o2.setProdotti(List.of(p4,p5));

        o3.setCustomer((c3));
        o3.setProdotti(List.of(p6,p7,p8));

        List<Order> ordini = List.of(o1, o2, o3);


        System.out.println("--------------------------");

        List<Prodotti> product = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9);

        System.out.println("Prodotti");
        product.forEach(System.out::println);

        System.out.println("--------------------------");

        // Esercizio 1
        Prodotti[] prodotti = {p1, p2, p3};

        List<Prodotti> libri = Arrays.stream(prodotti)
                .filter(p -> "Books".equals(p.getCategoria()) && p.getPrice() > 100).toList();

        System.out.println("Libri con prezzo superiore a 100");
        libri.forEach(System.out::println);

        System.out.println("--------------------------");

        // Esercizio 2
        List<Order> ordiniBaby = ordini.stream()
                .filter(order -> order.getProdotti().stream()
                        .anyMatch(prodotto -> prodotto.getCategoria().equals("Baby"))).toList();

        System.out.println("Ordini prodotti Baby");
        ordiniBaby.forEach(System.out::println);

        System.out.println("--------------------------");

        // Esercizio 3
        System.out.println("Prodotti Boys scontati al 10%");

        List<Prodotti> prodottiSconto = product.stream()
                .filter(prodotto -> prodotto.getCategoria().equals("Boys"))
                .map(prodotto -> {
                    double nuovoPrezzo = prodotto.getPrice() * 0.9;
                    prodotto.setPrice(nuovoPrezzo);
                    return prodotto;
                }).toList();

        prodottiSconto.forEach(System.out::println);

        System.out.println("--------------------------");

        // Esercizio 4

       List<Prodotti> esercizio4 = ordini.stream().filter(order -> order.getCustomer().getTier()==2)
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021,2,1))&&
                        order.getOrderDate().isBefore(LocalDate.of(2021,4,1)))
                .flatMap(order -> order.getProdotti().stream()).toList();

        System.out.println(esercizio4);



    }
}
