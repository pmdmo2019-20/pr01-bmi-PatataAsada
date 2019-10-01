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
                checkText(texto, label, count, type, mainActivity);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private static void checkText(EditText txt, TextView lbl, int count, String type, MainActivity mainActivity) {
        if (count == 0) {
            switch (type){
                case "Height":
                    txt.setError(mainActivity.getString(R.string.lbl_height));
                    break;
                case "Weight":
                    txt.setError(mainActivity.getString(R.string.lbl_weight));
                    break;
            }
            lbl.setEnabled(false);
        } else {
            lbl.setEnabled(true);
        }
    }
}
