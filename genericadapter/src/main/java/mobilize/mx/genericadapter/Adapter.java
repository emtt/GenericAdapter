package mobilize.mx.genericadapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * <pre>
 *     author: Efra Morales - emoralest@gmail.com - mobilize.mx
 *     time  : 2019/04/08
 *     desc  : Generic adapter that receives all types of models
 *             firts param set the list
 *             Second param set the item layout.
 *             third param is BR Class
 * </pre>
 */

public class Adapter<T> extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<? extends T> list;
    private int layoutId;
    ItemListener itemListener;
    int brModel;

    public Adapter(List<? extends T> list, int layoutId, ItemListener itemListener, int dataModel) {
        this.list = list;
        this.layoutId = layoutId;
        this.itemListener = itemListener;
        this.brModel = dataModel;
    }

    public static class ViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {
        private V v;

        public ViewHolder(V v) {
            super(v.getRoot());
            this.v = v;
        }

        public V getBinding() {
            return v;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return layoutId;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding bind = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
        return new ViewHolder<>(bind);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        final T model = list.get(position);
        holder.getBinding().setVariable(brModel, model);
        holder.getBinding().executePendingBindings();
        /**
         *Set click listener in whole view passing model as param
         *In activity must have implement the callback
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.onClick(model);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}

