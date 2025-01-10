package factory;

import static factory.PrinterTypes.Acer;
import static factory.PrinterTypes.HP;

public class PrinterFactory {

    public static Printer getPrinter(PrinterTypes printerType) {
        if (HP.equals(printerType) ) {
            return new HpPrinter();
        } else if (Acer.equals(printerType)) {
            return new AcerPrinter();
        }

        throw new IllegalArgumentException("Printer type " + printerType + " is not supported");
    }

}
