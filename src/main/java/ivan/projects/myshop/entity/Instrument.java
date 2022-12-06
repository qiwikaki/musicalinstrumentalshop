package ivan.projects.myshop.entity;

public class Instrument {

    private int id;
    private InstrumentType instrumentType;
    private String brand;
    private String model;
    private int price;

    public Instrument() {
    }

    public Instrument(int id ,InstrumentType instrumentType, String brand, String model ,int price) {
        this.id = id;
        this.instrumentType = instrumentType;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", instrumentType=" + instrumentType +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                "}" + "\r\n";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public static void main(String[] args) {
        Instrument yamahaGuitar = new Instrument(4, InstrumentType.GUITAR, "Yamaha", "F310" ,13990);

        Instrument zimmermannPiano = new Instrument(5, InstrumentType.PIANO, "Zimmermann","S6",710000);

        System.out.println(yamahaGuitar.getInstrumentType().getInstrumentTypeString());

        System.out.println(zimmermannPiano);

        System.out.println(yamahaGuitar.getPrice() + zimmermannPiano.getPrice());

        System.out.println(zimmermannPiano.getId());

    }

}
