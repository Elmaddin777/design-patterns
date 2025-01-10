package factory;

public class Demo {

    public static void main(String[] args) {
        Printer printer = PrinterFactory.getPrinter(PrinterTypes.HP);
        printer.print();

        Printer printer1 = PrinterFactory.getPrinter(PrinterTypes.Acer);
        printer1.print();
    }

}
