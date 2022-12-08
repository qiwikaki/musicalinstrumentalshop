package ivan.projects.myshop.entity.enums;

public enum InstrumentType {

    GUITAR("guitar"), DRUM("drum"), PIANO("piano");

    private String instrumentType;

    InstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getInstrumentTypeString() {
        return instrumentType;
    }

    public static void main(String[] args) {

        System.out.println(InstrumentType.GUITAR.getInstrumentTypeString());
    }

}
