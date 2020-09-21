package streams;

public interface Scalable {
	
	// implicitly public abstract
	void setScale(double scale);
	
	// implicitly public static final
	double DEFAULT_SCALE = 1.0;
	
	
	// implicitly public
	static boolean isScalable(Object obj) {
		return obj instanceof Scalable;
	}
	
	// implicitly public
	default void resetScale() {
		setScale(DEFAULT_SCALE);
	}
}