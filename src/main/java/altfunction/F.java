package altfunction;

import java.util.function.Function;

@FunctionalInterface
public interface F<T, R> {
	public R apply(T t);


	default <V> F<V, R> compose(F<? super V, ? extends T> g) {
		F<T, R> f = this::apply;
		return (a) -> f.apply(g.apply(a));
	}
}
