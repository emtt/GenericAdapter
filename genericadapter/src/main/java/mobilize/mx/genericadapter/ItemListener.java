package mobilize.mx.genericadapter;

/**
 * Callback for clicks on AppAdapter's item
 * @param <T>
 */
public interface ItemListener<T> {
    void onClick(T model);
}