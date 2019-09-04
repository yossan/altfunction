package altfunction;

@FunctionalInterface
public interface C<T> {
	public void accept(T t);

	default <V> C<V> compoes(F<V, T> g) {
		return (v) -> this.accept(g.apply(v));
	}

	default E compose(S<T> g) {
		return () -> this.accept(g.get());
	}

	default <R> F<T, R> andThen(S<R> g) {
		C<T> f = this::accept;
		return new F<T, R>() {
			public R apply(T t) {
				f.accept(t);
				return g.get();
			}
		};
	}

	default C<T> andThen(E g) {
		C<T> f = this::accept;
		return new C<T>() {
			public void accept(T t) {
				f.accept(t);
				g.run();
			}
		};
	}
}

