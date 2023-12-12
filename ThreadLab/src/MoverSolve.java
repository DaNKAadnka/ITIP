public class MoverSolve {

    public static void main (String[] args) {

        Product chair = new Product(61, "Ikea nice chair");
        Product yellowChair = new Product(55, "New Ikea yellow chair");
        Product greenTable = new Product(20, "Table that comfortable in use");
        Product refregerator = new Product(100, "Cold");
        Product sofa = new Product(150, "Pretty heavy sofa");

        Storage in = new Storage();
        in.addToStorage(chair);
        in.addToStorage(yellowChair);
        in.addToStorage(yellowChair);
        in.addToStorage(yellowChair);
        in.addToStorage(greenTable);
        in.addToStorage(refregerator);
        in.addToStorage(sofa);

        Storage out = new Storage();

        Car mark = new Car();

        for (Product x : in.getProductsFromStorage()) {
            System.out.print(x.getName());
            System.out.print(" ");
            System.out.println(x.getWeight());
        }

        Mover firstMover = new Mover(in, out, mark);
        Mover secondMover = new Mover(in, out, mark);
        Mover thirdMover = new Mover(in, out, mark);

        firstMover.start();
        secondMover.start();
        thirdMover.start();

        try{
            firstMover.join();
            secondMover.join();
            thirdMover.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("------Our StorageOut------");
        for (Product x : out.getProductsFromStorage()) {
            System.out.print(x.getName());
            System.out.print(" ");
            System.out.println(x.getWeight());
        }
        System.out.println("----Our StorageIn----");
        for (Product x : in.getProductsFromStorage()) {
            System.out.print(x.getName());
            System.out.print(" ");
            System.out.println(x.getWeight());
        }
    }
}
