package es.iessaladillo.pedrojoya.pr01.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import es.iessaladillo.pedrojoya.pr01.R;
import es.iessaladillo.pedrojoya.pr01.ui.main.MainActivity;

public class TextChangedListener {
    private TextChangedListener(){

    }

    public static void is_changed(EditText texto, TextView label, String type, MainActivity mainActivity){
        texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkText(texto, label, s, type, mainActivity);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private static void checkText(EditText txt, TextView lbl, CharSequence word, String type, MainActivity mainActivity) {
        boolean empty = (word.length() == 0 || word.toString().equals("0"));
        if (empty) {
            switch (type){
                case "Height":
                    txt.setError(mainActivity.getString(R.string.main_invalid_height));
                    break;
                case "Weight":
                    txt.setError(mainActivity.getString(R.string.main_invalid_weight));
                    break;
            }
            lbl.setEnabled(false);
        } else {
            lbl.setEnabled(true);
        }
    }
}
