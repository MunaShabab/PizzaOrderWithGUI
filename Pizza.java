
public class Pizza{

	//attributes
	private String size;
	private String crust;
	private boolean hasPepperoni;
	
	public Pizza(String argSize, String argCrust, boolean argPepperoni) throws Exception{
		this.setSize(argSize);
		this.setCrust(argCrust);
		this.setHasPepperoni(argPepperoni);
	}
	
	public Pizza(String argSize, String argCrust)throws Exception{
		this.setSize(argSize);
		this.setCrust(argCrust);
		this.setHasPepperoni(true);
	}
	//setSize method throws an exception if the valu is not acceptable
	public void setSize(String arg) throws Exception{
		String argSize=arg.trim();
		if(argSize.equals("S")||argSize.equals("M")||argSize.equals("L")){
			size=argSize;
		}
		else{
			throw new Exception(arg+" is not a valid pizza size");
		}
		
	}
	public void setCrust(String arg)throws Exception{
		String argCrust=arg.trim();
		if(argCrust.equals("thin")||argCrust.equals("thick")){
			crust=argCrust;
		}
		else{
			throw new Exception( arg+ " is not a valid crust");
		}
		
	}
	public void setHasPepperoni(boolean arg){
		hasPepperoni=arg;
	}

	public String getSize(){
		return size;
	}

	public String getCrust(){
		return crust;
	}

	public boolean getHasPepperoni(){
		return hasPepperoni;
	}

	public double calculateBakeTime(){
		double bakeTime=0;
		if (crust.equals("thin")){
			bakeTime= 10;
		}
		else{
			bakeTime= 16;
		}
		return bakeTime;
	}
	
	public double calculateCost(){
		double cost=0;
		
		if (size.equals("S")){
			cost=6;
		}
		
		if (size.equals("M")){
			cost=8;
		}
		
		if (size.equals("L")){
			cost=10;
		}
		
		if(hasPepperoni){
			cost=cost+2;
			
		}
		
		return cost;
	}

	public String toString(){
			String result;
			
			result="Crust: "+ crust +
					", Size: "+ size +
					", Pepperoni: "+ hasPepperoni +
					", Cost " + calculateCost();
					
			return result;
	}
}

