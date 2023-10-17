public class OOP {
    public static void main(String[] args) {
        Keyboard k = new Keyboard();
        Keyboard K = new Keyboard(false, 100F, 50F, 1000, "Ryzen", "RTX12");

        System.out.println(Device.countOfInstances);
    }
}


abstract class Device {

    private int price;
    public String nameOfDevice;
    public String modelOfDevice;
    public static int countOfInstances;

    public Device(int price, String nameOfDevice, String modelOfDevice) {
        this.price = price;
        this.nameOfDevice = nameOfDevice;
        this.modelOfDevice = modelOfDevice;
        Device.countOfInstances++;
    }

    public Device() {
        this.price = -1;
        this.nameOfDevice = "Not assigned";
        this.modelOfDevice = "Not assigned";
        Device.countOfInstances++;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void buyDevice() {
        System.out.println("You have bought this very useful device... but I`m not sure what it is.");
    }

    public void showDetails() {
        System.out.println("As you buying this stuff you have been agreed with our rules," +
                " do not cross the line");
    }


}

class Keyboard extends Device {

    private boolean isLighted;

    public float width;
    public float height;
    private String printedLine;

    public Keyboard(boolean isLighted, float width, float height,
                    int price, String nameOfDevice, String modelOfDevice) {
        super(price, nameOfDevice, modelOfDevice);
        this.isLighted = isLighted;
        this.width = width;
        this.height = height;
        printedLine = "";
    }

    public Keyboard() {
        super();
        this.isLighted = false;
        this.width = 0F;
        this.height = 0F;
        printedLine = "";
    }

    @Override
    public void buyDevice() {
        System.out.println("You have bought this very useful device and it is a keyboard!");
    }

    public String getPrintedLine() {
        return this.printedLine;
    }

    public void editPrintedLine(String s) {
        if (!s.isEmpty()) {
            this.printedLine = this.printedLine.substring(0, printedLine.length()-1);
        }
        else {
            this.printedLine += s;
        }
    }

    public void editPrintedLine() {
        if (!this.printedLine.isEmpty()) {
            this.printedLine = this.printedLine.substring(0, printedLine.length()-1);
        }
    }
}

class Headphones extends Device {

    private boolean isWireless;

    public float frequencyRange;
    public float maxPower;

    public Headphones(boolean isWireless, float frequencyRange, float maxPower,
                        int price, String nameOfDevice, String modelOfDevice) {
        super(price, nameOfDevice, modelOfDevice);
        this.isWireless = isWireless;
        this.frequencyRange = frequencyRange;
        this.maxPower = maxPower;
    }

    public Headphones() {
        super();
        this.isWireless = false;
        this.frequencyRange = 0F;
        this.maxPower = 0F;
    }

    @Override
    public void buyDevice() {
        System.out.println("You have bought this very useful device and there are a headphones!");
    }

    public void listenMusic() {
        System.out.println("Sorry, bro, this headphones can only play songs of Metallica");
    }

}

class GraphicsTablet extends Device {

    public long width;
    public long height;

    public float tabletResolution;


    public GraphicsTablet(long width, long height, float tabletResolution,
                          int price, String nameOfDevice, String modelOfDevice) {
        super(price, nameOfDevice, modelOfDevice);
        this.width = width;
        this.height = height;
        this.tabletResolution = tabletResolution;
    }

    public GraphicsTablet() {
        super();
        this.width = 0;
        this.height = 0;
        this.tabletResolution = 0F;
    }

    @Override
    public void buyDevice() {
        System.out.println("You have bought this very useful device and it is a graphic tablet!");
    }

    public void showNicePict() {
        String s = "..... (¯`v´¯)♥\n" +
                ".......•.¸.•´\n" +
                "....¸.•´\n" +
                "... (\n" +
                "☻/\n" +
                "/▌♥♥\n" +
                "/ \\ ♥♥\n";
        System.out.println(s);
    }

    public void showNotNicePict() {
        String s = "⠄⠄⣿⣿⣿⣿⠘⡿⢛⣿⣿⣿⣿⣿⣧⢻⣿⣿⠃⠸⣿⣿⣿⠄⠄⠄⠄⠄\n" +
                "⠄⠄⣿⣿⣿⣿⢀⠼⣛⣛⣭⢭⣟⣛⣛⣛⠿⠿⢆⡠⢿⣿⣿⠄⠄⠄⠄⠄\n" +
                "⠄⠄⠸⣿⣿⢣⢶⣟⣿⣖⣿⣷⣻⣮⡿⣽⣿⣻⣖⣶⣤⣭⡉⠄⠄⠄⠄⠄\n" +
                "⠄⠄⠄⢹⠣⣛⣣⣭⣭⣭⣁⡛⠻⢽⣿⣿⣿⣿⢻⣿⣿⣿⣽⡧⡄⠄⠄⠄\n" +
                "⠄⠄⠄⠄⣼⣿⣿⣿⣿⣿⣿⣿⣿⣶⣌⡛⢿⣽⢘⣿⣷⣿⡻⠏⣛⣀⠄⠄\n" +
                "⠄⠄⠄⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠙⡅⣿⠚⣡⣴⣿⣿⣿⡆⠄\n" +
                "⠄⠄⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠄⣱⣾⣿⣿⣿⣿⣿⣿⠄\n" +
                "⠄⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⣿⠄\n" +
                "⠄⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠣⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄\n" +
                "⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠑⣿⣮⣝⣛⠿⠿⣿⣿⣿⣿⠄\n" +
                "⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⠄⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠄";
        System.out.println(s);
    }
}