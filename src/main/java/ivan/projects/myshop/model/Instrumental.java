package ivan.projects.myshop.model;

public class Instrumental {

    private Long id;

    private String name;

//    sale
    private boolean hotProduct;

    private Double price;

    private String description;

    private InstrumentalType instrumentalType;

    public Instrumental() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHotProduct() {
        return hotProduct;
    }

    public void setHotProduct(boolean hotProduct) {
        this.hotProduct = hotProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InstrumentalType getInstrumentalType() {
        return instrumentalType;
    }

    public void setInstrumentalType(InstrumentalType instrumentalType) {
        this.instrumentalType = instrumentalType;
    }
}
