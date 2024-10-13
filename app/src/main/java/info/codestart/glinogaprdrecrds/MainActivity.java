package info.codestart.glinogaprdrecrds;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PersonDBHelper dbHelper;
    private PersonAdapter adapter;
    private String filter = "";
    private Button createRecord, viewRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        ConstraintLayout constraintLayout = findViewById(R.id.mainbackground);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        createRecord = findViewById(R.id.addBtn);
        createRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddUserActivity();
            }
        });

        viewRecord = findViewById(R.id.viewBtn);
        viewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToviewListActivity();
            }
        });
    }

    private void goToAddUserActivity(){
        Intent intent = new Intent(MainActivity.this, info.codestart.glinogaprdrecrds.AddRecordActivity.class);
        startActivity(intent);
    }

    private void goToviewListActivity(){
        Intent intent = new Intent(MainActivity.this, viewList.class);
        startActivity(intent);
    }
}
