package builderpattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating different configurations of Computer using the Builder pattern
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        Computer budgetComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();

        // Display the configurations
        System.out.println(gamingComputer);
        System.out.println(officeComputer);
        System.out.println(budgetComputer);

	}

}
