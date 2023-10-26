package AbstractInterface;

public class Derive extends Base {

	public Derive()
	{
		System.out.println("Derive object constructed\n");
	}
	
	@Override
	public void Greetings()
	{
		System.out.println("Derive Greetings\n");
	}
	
	@Override
	public void ImplementMe()
	{
		System.out.println("Derive ImplementMe\n");
	}
}
