package app.nsr.osama.quickrevision;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

public class Quiz extends AppCompatActivity {

    private ProgressBar progressBar;
    private ImageView imageView;
    private ListView listView;
    private ArrayAdapter<Hero> heroArrayAdapter;
    private Random random;
    private int randomNum;
    private AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.Quiz_progressBar);
        imageView = (ImageView) findViewById(R.id.Quiz_imageView1);
        listView = (ListView) findViewById(R.id.Quiz_listView);

        random = new Random();
        progressBar.setMax(MainActivity.HEROS.length);
        heroArrayAdapter = new ArrayAdapter<Hero>(this, R.layout.element_adapter_in_listview, MainActivity.HEROS);
        listView.setAdapter(heroArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int score = 0;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (((Hero) parent.getItemAtPosition(position)).getHeroId() == MainActivity.HEROS[randomNum].getHeroId()) {
                    progressBar.setProgress(++score);
                    Toast.makeText(Quiz.this, "+1", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Quiz.this, "+0", Toast.LENGTH_SHORT).show();
                }
                if (progressBar.getProgress() == progressBar.getMax()) {
                    if (builder == null) {
                        builder = new AlertDialog.Builder(Quiz.this);
                        builder.setMessage("Congratz! :D");
                        builder.setPositiveButton("thanks", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                    }
                    builder.show();
                }
                updateTheView();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar.setProgress(0);
        updateTheView();
    }

    private void updateTheView() {
        randomNum = random.nextInt(MainActivity.HEROS.length);
        imageView.setImageResource(MainActivity.HEROS[randomNum].getHeroId());
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}