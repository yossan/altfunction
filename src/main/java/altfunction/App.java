package altfunction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		F<Integer, Boolean> multipleOf = (a) -> a % 2 == 0;
		F<Integer, Integer> num = (a) -> a;
		var r = multipleOf.compose(num).apply(4);
		System.out.println(r);
    }
}
