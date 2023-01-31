
public class UnitTest{
	public static void main(String[] args) {
		//p1 is thin crust test case
		//p2 is thick crust test case
		Pizza p1=null;
		Pizza p2=null;
		try {
			p1=new Pizza("   L   ","thin",false);
			//p1.setSize("L");
			//p1.setCrust("thin");
			//p1.setHasPepperoni(false);
			System.out.println("Crust is: " + p1.getCrust() + " Bake time is " + p1.calculateBakeTime());
			System.out.println("Size is: " + p1.getSize() + " has pepperoni " + p1.getHasPepperoni()+ " Cost is " + p1.calculateCost());
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		try{
			p2=new Pizza("L","thick", true);
			//p2.setSize("L");
			//p2.setCrust("thick");
			//p2.setHasPepperoni(false);
			System.out.println("Crust is: " + p2.getCrust() + " Bake time is " + p2.calculateBakeTime());
			System.out.println("Size is: " + p2.getSize() + " has pepperoni " + p2.getHasPepperoni()+ " Cost is " + p2.calculateCost());

		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
	
		Order o=null;
		try{
			o=new Order("Mike","440-366-4796");
			o.addPizza(p1);
			o.addPizza(p2);
			o.printReceipt();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}

