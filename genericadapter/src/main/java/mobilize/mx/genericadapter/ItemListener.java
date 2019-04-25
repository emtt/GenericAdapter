package mobilize.mx.genericadapter;

import android.view.View;

/**
 * Callback for clicks on AppAdapter's item
 * @param <T>
 */
public interface ItemListener<T> {
    void onClick(T model, View v, int position);
}