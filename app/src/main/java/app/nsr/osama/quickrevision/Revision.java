package app.nsr.osama.quickrevision;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Revision extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button btn1;
    private int herosCount = 0;
    private AlertDialog.Builder dialogBox = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revision);
        init();
    }

    private void init() {
        imageView = (ImageView) findViewById(R.id.Revision_imageView1);
        textView = (TextView) findViewById(R.id.Revision_textView);
        btn1 = (Button) findViewById(R.id.Revision_btn1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateTheView(herosCount);
    }

    private void updateTheView(int index) {
        imageView.setImageResource(MainActivity.HEROS[index].getHeroId());
        textView.setText(MainActivity.HEROS[index].getHeroName());
    }

    public void nextHero(View view) {
        herosCount = (herosCount < MainActivity.HEROS.length - 1) ? herosCount + 1 : 0;

        //msgbox = "r u ready for the challenge ?" , "yes">start Quiz Activity , "Not yet">go back to Main Activity
        if (herosCount == 0) {
            if (dialogBox == null) {
                dialogBox = new AlertDialog.Builder(this);
                dialogBox.setTitle("Bro");
                dialogBox.setMessage("r u ready for the challenge ?");
                dialogBox.setNegativeButton("Not Yet :-(", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialogBox.setPositiveButton("Yep ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Revision.this, Quiz.class);
                        startActivity(intent);
                    }
                });
            }
            dialogBox.show();

        }
        updateTheView(herosCount);
    }
}
