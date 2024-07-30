package builderpattern;

public class Computer {
	    private String CPU;
	    private String RAM;
	    private String storage;
	    
	    //Private Constructor
	    private Computer(Builder builder) {
	        this.CPU = builder.CPU;
	        this.RAM = builder.RAM;
	        this.storage = builder.storage;
	        
	    }
		@Override
		public String toString() {
			return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + "]";
		}
		

		//Builder class Implementation
		public static class Builder {
	        private String CPU;
	        private String RAM;
	        private String storage;
	       

	        public Builder setCPU(String CPU) {
	            this.CPU = CPU;
	            return this;
	        }

	        public Builder setRAM(String RAM) {
	            this.RAM = RAM;
	            return this;
	        }

	        public Builder setStorage(String storage) {
	            this.storage = storage;
	            return this;
	        }

	        

	        //  Provide a build() method
	        public Computer build() {
	            return new Computer(this);
	        }

		}
}
