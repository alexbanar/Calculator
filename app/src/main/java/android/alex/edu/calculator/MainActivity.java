package android.alex.edu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnNumber;
    private Button btnOperation;
    private TextView tvResult;
    private String buttonNumber;
    private char buttonOperation;
    private double tempSaveCurrentTextViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnNumberClicked(View view) {
        btnNumber = (Button) view;

        String newTextTextViewResult;

        tvResult = (TextView) findViewById(R.id.tvResult);
        String currentContentTextViewResult = tvResult.getText().toString();

        String pressedButtonContent = btnNumber.getText().toString();
        if (pressedButtonContent.equals("▪"))
        {
            if (!currentContentTextViewResult.contains(".")) {
                newTextTextViewResult = currentContentTextViewResult + ".";
                Toast.makeText(this, newTextTextViewResult, Toast.LENGTH_LONG).show();
                tvResult.setText(newTextTextViewResult);
            }
            else
            {
                return;
            }
        }
        else
        {//pressed button content is not "▪"
            if (!currentContentTextViewResult.contains("."))
            {
                Toast.makeText(this, "not ▪ dot", Toast.LENGTH_SHORT).show();
                int pressedButtonNumber = Integer.valueOf(pressedButtonContent);
                int currentNumberTextViewResult = Integer.valueOf(currentContentTextViewResult);
                if (currentNumberTextViewResult != 0) {
                    newTextTextViewResult = String.valueOf(currentNumberTextViewResult) + String.valueOf(pressedButtonNumber);
                    tvResult.setText(newTextTextViewResult);
                } else {
                    tvResult.setText(String.valueOf(pressedButtonNumber));
                }
            }
            else
            {
                newTextTextViewResult = currentContentTextViewResult + pressedButtonContent;
                tvResult.setText(newTextTextViewResult);
            }
         }
    }

    public void btnOperatorClicked(View view)
    {
        btnOperation = (Button) view;
        tvResult = (TextView) findViewById(R.id.tvResult);
        tempSaveCurrentTextViewContent = Double.valueOf(tvResult.getText().toString());
        tvResult.setText(String.valueOf(0));
        Toast.makeText(this, "" + tempSaveCurrentTextViewContent, Toast.LENGTH_LONG).show();
    }
}
