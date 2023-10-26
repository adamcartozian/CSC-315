package AbstractInterface;

public class HelloWorld implements HelloWorldInterface {

	public HelloWorld()
	{
		System.out.println("HelloWorld object constructed\n");
	}
	@Override
	public void ImplementMe() {
		System.out.println("HelloWorld ImplementMe\n");
	}

	public void Greetings() {
		System.out.println("HelloWorld Greetings\n");
	}
}
