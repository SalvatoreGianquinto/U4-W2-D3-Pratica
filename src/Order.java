import java.time.LocalDate;
import java.util.List;

public class Order {
    private String id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Prodotti> prodotti;
    private Customer customer;

    // Costruttore


    public Order(String id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Prodotti> prodotti, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.prodotti = prodotti;
        this.customer = customer;
    }

    // Getter e Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Prodotti> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotti> prodotti) {
        this.prodotti = prodotti;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", prodotti=" + prodotti +
                ", customer=" + customer +
                '}';
    }
}
