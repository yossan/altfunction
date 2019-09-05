package altfunction;

@FunctionalInterface
public interface Supply<T> {
	public T get();

	default <V> Function<V, T> compose(Consumer<V> g) {
		Supply<T> f = this::get;
		return new Function<V, T>() {
			public T apply(V v) {
				g.accept(v);
				return f.get();
			}
		};
	}

	default <R> Supply<R> andThen(Function<? super T,R> g) {
		return () -> g.apply(this.get());
	}

	default Runner andThen(Consumer<? super T> g) {
		return () -> g.accept(this.get());
	}
}


