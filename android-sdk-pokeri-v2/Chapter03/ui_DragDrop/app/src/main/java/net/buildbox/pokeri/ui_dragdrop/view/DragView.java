package net.buildbox.pokeri.ui_dragdrop.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.DragEvent;

import android.widget.Toast;

public class DragView extends AppCompatImageView {
    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onDragEvent(DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // ドラッグ開始のトースト表示
                Toast.makeText(getContext(), "ドラッグを開始しました", Toast.LENGTH_SHORT).show();
                invalidate();
                break;
        }

        return true;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
