package AbstractInterface;

public class Main {

	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		
		hw.Greetings();
		hw.ImplementMe();
		
		Base b = new Base();
		Derive d = new Derive();
		
		b.ImplementMe();
		d.ImplementMe();
		
		Base bRef = d;
		bRef.ImplementMe();

	}

}
