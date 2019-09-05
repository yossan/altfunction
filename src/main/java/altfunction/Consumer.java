package altfunction;

@FunctionalInterface
public interface Consumer<T> {
	public void accept(T t);

	default <V> Consumer<V> compoes(Function<V, T> g) {
		return (v) -> this.accept(g.apply(v));
	}

	default Runner compose(Supply<T> g) {
		return () -> this.accept(g.get());
	}

	default <R> Function<T, R> andThen(Supply<R> g) {
		Consumer<T> f = this::accept;
		return new Function<T, R>() {
			public R apply(T t) {
				f.accept(t);
				return g.get();
			}
		};
	}

	default Consumer<T> andThen(Runner g) {
		Consumer<T> f = this::accept;
		return new Consumer<T>() {
			public void accept(T t) {
				f.accept(t);
				g.run();
			}
		};
	}
}

