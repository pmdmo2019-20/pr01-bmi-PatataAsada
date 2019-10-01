package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import es.iessaladillo.pedrojoya.pr01.R;
import es.iessaladillo.pedrojoya.pr01.bmi.BmiCalculator;

public class MainActivity extends AppCompatActivity {

    private EditText txtWeight;
    private EditText txtHeight;
    private TextView lblResult;
    private Button btnReset;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setViews();
        setButtons();
    }

    private void setButtons() {
        btnCalculate.setOnClickListener(v -> calculateBmi(Float.parseFloat(txtWeight.getText().toString()),Float.parseFloat(txtHeight.getText().toString())));
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
                resetImg();
                resetResult();
            }
        });
    }

    private void resetResult() {
        //TODO resetear campo de lblResult.
    }

    private void resetImg() {
        //TODO resetear img a inicial.
    }

    private void resetFields() {
        //TODO resetear campos de height y weight.
    }

    private void calculateBmi(float weight, float height) {
        //TODO Cambio de imagen y lblResult segun resultado.
        float result;
        result = BmiCalculator.calculateBmi(weight,height);

        switch (BmiCalculator.getBmiClasification(result)){

            case LOW_WEIGHT:
                break;
            case NORMAL_WEIGHT:
                break;
            case OVERWWEIGHT:
                break;
            case OBESITY_GRADE_1:
                break;
            case OBESITY_GRADE_2:
                break;
            case OBESITY_GRADE_3:
                break;
        }
    }

    private void setViews() {
        btnCalculate = ActivityCompat.requireViewById(this, R.id.btnCalculate);
        btnReset = ActivityCompat.requireViewById(this, R.id.btnReset);
        lblResult = ActivityCompat.requireViewById(this, R.id.lblResult);
        txtHeight = ActivityCompat.requireViewById(this, R.id.txtHeight);
        txtWeight = ActivityCompat.requireViewById(this, R.id.txtWeight);
    }


}
