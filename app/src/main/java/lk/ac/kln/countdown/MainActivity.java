package lk.ac.kln.countdown;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private  int counter =99;
    private static  final String CURRENT_COUNTER = "counter";
    private boolean wasRunning;
    private boolean running = false;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        if (saveInstanceState != null){
            counter = saveInstanceState.getInt(CURRENT_COUNTER);
        }
        running = true;
        countDown();
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt(CURRENT_COUNTER,counter);
    }

    private void countDown(){
        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView textView = findViewById(R.id.textView);
                textView.setText(Integer.toString(counter));

                if (counter == 0) {
                    counter = 99;

                }
                counter--;
                handler.postDelayed(this,1000);

            }
        });

    }

    @Override
    public void onStop(){
        super.onStop(); //autocounted
    }
}