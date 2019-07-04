package company.OOP.Encapsulation;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplexPrinter;

    public Printer(int tonerLevel, boolean duplexPrinter) {
        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else
            this.tonerLevel = 0;

        this.duplexPrinter = duplexPrinter;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount < 100) {
            if (tonerLevel + tonerAmount > 100 || tonerLevel + tonerAmount < 0)
                tonerLevel += tonerAmount;
            return tonerAmount;
        } else {
            return 0;
        }
    }

    public void printPaper(int pages) {
        if (tonerLevel - (pages * 0.30) >= 0) {
            tonerLevel -= (pages * 0.30);
            System.out.println("New Toner Level: " + tonerLevel);

            if (this.duplexPrinter) {
                pages /= 2;
            }
            pagesPrinted += pages;
            System.out.println("Pages printed: " + pages);
        } else {
            System.out.println("Not enough toner in the machine to print!");
        }
    }
}

