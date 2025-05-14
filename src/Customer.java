public class Customer {
    private String id;
    private String nome;
    private Integer tier;

    public Customer(String id, String nome, Integer tier) {
        this.id = id;
        this.nome = nome;
        this.tier = tier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", tier=" + tier +
                '}';
    }
}
