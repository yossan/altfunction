package altfunction;

import java.util.function.Function;

@FunctionalInterface
public interface F<T, R> {
	public R apply(T t);


	default <V> F<V, R> compose(F<? super V, ? extends T> g) {
		return (v) -> this.apply(g.apply(v));
	}

	default S<R> compose(S<? extends T> g) {
		return () -> this.apply(g.get());
	}

	default <V> F<T, V> andThen(F<? super R, ? extends V> g) {
		return (v) -> g.apply(this.apply(v));
	}

	default C<T> andThen(C<? super R> g) {
		return (t) -> g.accept(this.apply(t));
	}

}
