package net.buildbox.pokeri.graph_drawcircle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.buildbox.pokeri.graph_drawcircle.view.GraphView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphView(this));
    }
}
