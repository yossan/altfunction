package altfunction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		C c = (num) -> System.out.println(num);
		C c2 = c.andThen(() -> System.out.println("hello"));
		c2.accept(4);
    }
}
