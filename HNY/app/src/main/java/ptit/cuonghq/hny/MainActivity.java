package ptit.cuonghq.hny;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnHNY;
    private TextView tvMessage;
    private ConstraintLayout clContainer;

    private String[] messageColors = new String[] {"#E91E63", "#673AB7", "#009688", "#8BC34A", "#FFC107", "#4CAF50", "#536DFE"};
    private String[] containerColors = new String[] {"#FFEB3B", "#FFEB3B", "#448AFF", "#448AFF", "#607D8B"};

    private int cursor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addListener();
    }

    private void addListener() {
        btnHNY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mc = messageColors[cursor % messageColors.length];
                String cc = containerColors[cursor % containerColors.length];
                cursor++;

                tvMessage.setTextColor(Color.parseColor(mc));
                clContainer.setBackgroundColor(Color.parseColor(cc));
            }
        });
    }

    private void initView() {
        btnHNY = findViewById(R.id.btn_hny);
        tvMessage = findViewById(R.id.tv_message);
        clContainer = findViewById(R.id.cl_container);
    }
}
