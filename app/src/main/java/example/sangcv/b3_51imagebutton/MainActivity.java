package example.sangcv.b3_51imagebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageButton btn1,btn2;
    RadioButton rbtn1,rbtn2,rbtn3,rbRed,rbYellow,rbBlue;
    ToggleButton tgbtn1,tgbtn2,tgbtn3;
    RadioGroup toggleGroup,radioGroup;
    Button setcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        //5.1 Doi mau TextView voi 2 Button
        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn1.setOnClickListener(new setColor(R.color.red));
        btn2.setOnClickListener(new setColor(R.color.blue));
        //5.2 Doi mau TextView voi 3 Radio Button
        rbtn1 = (RadioButton) findViewById(R.id.rbtn1);
        rbtn2 = (RadioButton) findViewById(R.id.rbtn2);
        rbtn3 = (RadioButton) findViewById(R.id.rbtn3);
        rbtn1.setOnClickListener(new setColor(R.color.red));
        rbtn2.setOnClickListener(new setColor(R.color.yellow));
        rbtn3.setOnClickListener(new setColor(R.color.blue));
        //5.3 Doi mau TextView voi 3 Toggle Button
        toggleGroup = (RadioGroup) findViewById(R.id.toggle_group);
        tgbtn1 = (ToggleButton) findViewById(R.id.tgbtn1);
        tgbtn2 = (ToggleButton) findViewById(R.id.tgbtn2);
        tgbtn3 = (ToggleButton) findViewById(R.id.tgbtn3);
        toggleGroup.setOnCheckedChangeListener(ToggleListener);
        //5.4 Doi Mau TextView voi 3 Radio Button va Button Set Color
        rbRed = (RadioButton) findViewById(R.id.rbRed);
        rbYellow = (RadioButton) findViewById(R.id.rbYellow);
        rbBlue = (RadioButton) findViewById(R.id.rbBlue);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
    }
    //Doi mau TextView
    private void changeColor(int color) {
        tv.setBackgroundResource(color);
    }
    //5.1 & 5.2
    private class setColor implements View.OnClickListener {
        private int regionColor;
        public setColor (int regionColor) {
            this.regionColor = regionColor;
        }
        public void onClick(View v) {
            changeColor(regionColor);
        }
    }
    //5.3
    RadioGroup.OnCheckedChangeListener ToggleListener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            for (int j = 0; j < radioGroup.getChildCount(); j++) {
                ToggleButton view = (ToggleButton) radioGroup.getChildAt(j);
                view.setChecked(view.getId() == i);
            }
        }
    };
    public void changeColorToggleButton(View v) {
        ((RadioGroup)v.getParent()).check(v.getId());
        if(v == tgbtn1 && tgbtn1.isChecked()) tv.setBackgroundResource(R.color.red);
        else if(v == tgbtn2 && tgbtn2.isChecked()) tv.setBackgroundResource(R.color.yellow);
        else if(v == tgbtn3 && tgbtn3.isChecked()) tv.setBackgroundResource(R.color.blue);
        else tv.setBackgroundResource(R.color.black);
    }
    //5.4
    public void setColor(View v) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rbRed:
                tv.setBackgroundResource(R.color.red);
                break;
            case R.id.rbYellow:
                tv.setBackgroundResource(R.color.yellow);
                break;
            case R.id.rbBlue:
                tv.setBackgroundResource(R.color.blue);
                break;
        }
    }
}