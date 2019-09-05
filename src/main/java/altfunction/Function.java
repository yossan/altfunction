package altfunction;

@FunctionalInterface
public interface Function<T, R> {
	public R apply(T t);

	default <V> Function<V, R> compose(Function<? super V, ? extends T> g) {
		return (v) -> this.apply(g.apply(v));
	}

	default Supply<R> compose(Supply<? extends T> g) {
		return () -> this.apply(g.get());
	}

	default <V> Function<T, V> andThen(Function<? super R, ? extends V> g) {
		return (v) -> g.apply(this.apply(v));
	}

	default Consumer<T> andThen(Consumer<? super R> g) {
		return (t) -> g.accept(this.apply(t));
	}

}
