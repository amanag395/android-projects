package craterzone.day4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(linearLayout);
    }

    private void init() {
        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(linearLayout1);
        TextView tvFirstName = new TextView(this);
        tvFirstName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvFirstName.setText(R.string.first_name);
        linearLayout1.addView(tvFirstName);
        EditText etFirstName = new EditText(this);
        etFirstName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        etFirstName.setHint(R.string.hint_first_name);
        linearLayout1.addView(etFirstName);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(linearLayout2);
        TextView tvLastName = new TextView(this);
        tvLastName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvLastName.setText(R.string.last_name);
        linearLayout2.addView(tvLastName);
        EditText etLastName = new EditText(this);
        etLastName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        etLastName.setHint(R.string.hint_last_name);
        linearLayout2.addView(etLastName);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(linearLayout3);
        TextView tvGender = new TextView(this);
        tvGender.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvGender.setText(R.string.gender);
        tvGender.setPadding(0, 0, 65, 0);
        linearLayout3.addView(tvGender);
        RadioGroup radioGroupGender = new RadioGroup(this);
        radioGroupGender.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        radioGroupGender.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout3.addView(radioGroupGender);
        RadioButton radioButtonMale = new RadioButton(this);
        radioButtonMale.setText(R.string.male);
        radioButtonMale.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        radioGroupGender.addView(radioButtonMale);
        RadioButton radioButtonFemale = new RadioButton(this);
        radioButtonFemale.setText(R.string.female);
        radioButtonFemale.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        radioGroupGender.addView(radioButtonFemale);
        Button btRegister = new Button(this);
        btRegister.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btRegister.setText(R.string.register);
        btRegister.setAllCaps(false);
        linearLayout.addView(btRegister);

    }


}
