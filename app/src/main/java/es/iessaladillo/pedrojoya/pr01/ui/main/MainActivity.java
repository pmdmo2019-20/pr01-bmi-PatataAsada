package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import es.iessaladillo.pedrojoya.pr01.R;
import es.iessaladillo.pedrojoya.pr01.bmi.BmiCalculator;
import es.iessaladillo.pedrojoya.pr01.utils.TextChangedListener;

public class MainActivity extends AppCompatActivity {

    private TextView lblHeight;
    private TextView lblWeight;
    private EditText txtWeight;
    private EditText txtHeight;
    private TextView lblResult;
    private ImageView imgBmi;
    private Button btnReset;
    private Button btnCalculate;
    private BmiCalculator bmiCalculator = new BmiCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setViews();
        setButtons();
        setTxtListeners();
    }

    private void setTxtListeners() {
        TextChangedListener.is_changed(txtHeight, lblHeight, lblHeight.getText().toString(), this);
        TextChangedListener.is_changed(txtWeight, lblWeight, lblWeight.getText().toString(), this);
    }

    private void setButtons() {
        btnCalculate.setOnClickListener(v -> calculateBmi(txtWeight.getText().toString(),txtHeight.getText().toString()));
        btnReset.setOnClickListener(v -> {
            reset();
        });
    }

    private void reset() {
        resetFields();
        resetImg();
        resetResult();
    }

    private void resetResult() {
        lblResult.setText("");
    }

    private void resetImg() {
        imgBmi.setImageResource(R.drawable.bmi);
    }

    private void resetFields() {
        txtWeight.setText("");
        txtHeight.setText("");
    }

    private void calculateBmi(String weight, String height) {

        boolean check = checkEmptyFields();
        if(!check){
            float h = Float.parseFloat(txtHeight.getText().toString());
            float w = Float.parseFloat(txtWeight.getText().toString());
            float result;
            result = bmiCalculator.calculateBmi(w, h);
            BmiCalculator.BmiClasification clasification = bmiCalculator.getBmiClasification(result);

            switch (clasification) {

                case LOW_WEIGHT:
                    lblResult.setText(getString(R.string.main_bmi,result,getString(R.string.main_low_weight)));
                    imgBmi.setImageResource(R.drawable.underweight);
                    break;
                case NORMAL_WEIGHT:
                    lblResult.setText(getString(R.string.main_bmi,result,getString(R.string.main_normal_weight)));
                    imgBmi.setImageResource(R.drawable.normal_weight);
                    break;
                case OVERWWEIGHT:
                    lblResult.setText(getString(R.string.main_bmi,result,getString(R.string.main_overweight)));
                    imgBmi.setImageResource(R.drawable.overweight);
                    break;
                case OBESITY_GRADE_1:
                    lblResult.setText(getString(R.string.main_bmi,result,getString(R.string.main_obesity_grade_one)));
                    imgBmi.setImageResource(R.drawable.obesity1);
                    break;
                case OBESITY_GRADE_2:
                    lblResult.setText(getString(R.string.main_bmi,result,getString(R.string.main_obesity_grade_two)));
                    imgBmi.setImageResource(R.drawable.obesity2);
                    break;
                case OBESITY_GRADE_3:
                    lblResult.setText(getString(R.string.main_bmi,result,getString(R.string.main_obesity_grade_three)));
                    imgBmi.setImageResource(R.drawable.obesity3);
                    break;
            }
        }else{
            txtHeight.setText("0");
            txtWeight.setText("0");
            txtHeight.setText("");
            txtWeight.setText("");
        }
    }

    private boolean checkEmptyFields() {
        return txtHeight.getText().toString().equals("") || txtWeight.getText().toString().equals("") ||
                txtHeight.getText().toString().equals("0") || txtWeight.getText().toString().equals("0");
    }

    private void setViews() {
        btnCalculate = ActivityCompat.requireViewById(this, R.id.btnCalculate);
        btnReset = ActivityCompat.requireViewById(this, R.id.btnReset);
        lblResult = ActivityCompat.requireViewById(this, R.id.lblResult);
        txtHeight = ActivityCompat.requireViewById(this, R.id.txtHeight);
        txtWeight = ActivityCompat.requireViewById(this, R.id.txtWeight);
        lblHeight = ActivityCompat.requireViewById(this, R.id.lblHeight);
        lblWeight = ActivityCompat.requireViewById(this, R.id.lblWeight);
        imgBmi = ActivityCompat.requireViewById(this, R.id.imgBmi);
    }


}
