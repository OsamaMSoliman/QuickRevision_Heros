package app.nsr.osama.quickrevision;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final Hero[] HEROS = new Hero[8];

    static {
        HEROS[0] = new Hero("Ironman", R.drawable.ironman);
        HEROS[1] = new Hero("Batman", R.drawable.batman);
        HEROS[2] = new Hero("CapitanAmerica", R.drawable.capitan_america);
        HEROS[3] = new Hero("Hellboy", R.drawable.hellboy);
        HEROS[4] = new Hero("Hulk", R.drawable.hulk);
        HEROS[5] = new Hero("Spiderman", R.drawable.spiderman);
        HEROS[6] = new Hero("Superman", R.drawable.superman);
        HEROS[7] = new Hero("Wolverine", R.drawable.wolverine);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {
        Button b1 = (Button) findViewById(R.id.Main_btn1);
        Button b2 = (Button) findViewById(R.id.Main_btn2);
    }


    public void goToRevision(View view) {
        Intent intentRevision = new Intent(this, Revision.class);
        startActivity(intentRevision);
    }

    public void goToQuiz(View view) {
        Intent intentQuiz = new Intent(this, Quiz.class);
        startActivity(intentQuiz);
    }
}
