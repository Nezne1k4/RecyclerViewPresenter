package net.kibotu.android.recyclerviewpresenter;

import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="https://about.me/janrabe">Jan Rabe</a>.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder implements IBaseViewHolder {

    protected Unbinder unbinder;

    /**
     * Creates a new ViewHolder and calls {@link #onBindViewHolder()} in order to bind the view using {@link ButterKnife}.
     *
     * @param itemView
     */
    public BaseViewHolder(@NonNull final View itemView) {
        super(itemView);
        onBindViewHolder();
    }

    /**
     * Inflates the layout and binds it to the ViewHolder using {@link ButterKnife}.
     */
    public BaseViewHolder(@LayoutRes final int layout, @NonNull final ViewGroup parent) {
        this(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
    }

    /**
     * Binds all views to the ViewHolder using ButterKnife.
     */
    @Override
    public void onBindViewHolder() {
        if (unbinder == null)
            unbinder = ButterKnife.bind(this, itemView);
    }

    /**
     * Is called when it gets detached from the view.
     * It also removes all listeners like click, focusChange listeners and background selectors.
     */
    @CallSuper
    @Override
    public void onViewDetachedFromWindow() {
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}