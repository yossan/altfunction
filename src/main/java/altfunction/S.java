package altfunction;

@FunctionalInterface
public interface S<T> {
	public T get();

	default <V> F<V, T> compose(C<V> g) {
		S<T> f = this::get;
		return new F<V, T>() {
			public T apply(V v) {
				g.accept(v);
				return f.get();
			}
		};
	}

	default <R> S<R> andThen(F<? super T,R> g) {
		return () -> g.apply(this.get());
	}

	default E andThen(C<? super T> g) {
		return () -> g.accept(this.get());
	}
}


