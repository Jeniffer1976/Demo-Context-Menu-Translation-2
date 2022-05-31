package sg.edu.rp.c346.id21025290.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedText, tvTranslatedText2;
    String wordClicked ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(v == tvTranslatedText) {
            wordClicked = "hello";
        } else if(v == tvTranslatedText2) {
            wordClicked = "bye";
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if (wordClicked.equals("hello")) {
            if (id == R.id.EnglishSelection) {
                tvTranslatedText.setText("Hello ");
                return true;
            } else if (id == R.id.italianSelection) {
                tvTranslatedText.setText("Ciao");
                return true;
            } else {
                tvTranslatedText.setText("Error translation");
            }
        }
        if (wordClicked.equals("bye")) {
            if (id == R.id.EnglishSelection) {
                tvTranslatedText2.setText("Bye");
                return true;
            } else if (id == R.id.italianSelection) {
                tvTranslatedText2.setText("Adios");
                return true;
            } else {
                tvTranslatedText2.setText("Error translation");
            }
        }

        return super.onContextItemSelected(item);
    }



}