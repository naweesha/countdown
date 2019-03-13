package lk.ac.kln.countdown;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
       // running = true;
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
                if(running) {
                    counter--;
                }
                handler.postDelayed(this,1000);

            }
        });

    }
    protected void startCounter(View view){
        running = true;
    }

    protected void stopCounter(View view){
        running = false;
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onRestart(){
        super.onRestart();
        running = true; // again count
    }

    @Override
    public void onStop(){
        super.onStop(); //autocounted
        running = false; //stopcounter
    }
}