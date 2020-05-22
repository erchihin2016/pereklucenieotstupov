package com.example.pereklucenieotstupov;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.lang.annotation.Retention;
import java.util.Locale;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class MainActivity extends AppCompatActivity {
    private Spinner languageSpinner;
    private Spinner indentSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initViews();
        initSpinnerLanguage();
        initSpinnerIndent();
    }

    private void initViews() {
        languageSpinner = findViewById(R.id.languageSpinner);
        indentSpinner = findViewById(R.id.indentSpinner);

        Button btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String[] languages = getResources().getStringArray(R.array.language);
                int i = languageSpinner.getSelectedItemPosition();
                switch (languages[i]) {
                    case "Английский":
                        Locale localeEn = new Locale("en");
                        Configuration configEn = new Configuration();
                        configEn.setLocale(localeEn);
                        getResources().updateConfiguration(configEn, getBaseContext().getResources().getDisplayMetrics());
                        break;
                    case "Russian":
                        Locale localeRu = new Locale("ru");
                        Configuration configRu = new Configuration();
                        configRu.setLocale(localeRu);
                        getResources().updateConfiguration(configRu, getBaseContext().getResources().getDisplayMetrics());
                        break;
                }



                String[] indents = getResources().getStringArray(R.array.indent);
                @Margin int j = indentSpinner.getSelectedItemPosition();

                switch (j) {
                    case Margin.Small:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                        break;
                    case Margin.Middle:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MIDDLE);
                        break;
                    case Margin.Big:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BIG);
                        break;
                }
            }
        });
    }

    private void initSpinnerLanguage() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLanguage);
    }

    private void initSpinnerIndent() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this, R.array.indent, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        indentSpinner.setAdapter(adapterLanguage);
    }

    @Retention(SOURCE)
    @IntDef({Margin.Small, Margin.Middle, Margin.Big})
    public @interface Margin {
        int Small = 0;
        int Middle = 1;
        int Big = 2;
    }
}
