package craterzone.ems.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import craterzone.ems.R;
import craterzone.ems.activity.MainActivity;

/**
 * Created by aMAN GUPTA on 3/2/2017.
 */

public class MyDiglog extends Dialog implements View.OnClickListener {
    MainActivity mainActivity;
    public MyDiglog(Context context) {
        super(context);
        this.mainActivity = (MainActivity) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diglog);
        findViewById(R.id.bt_yes).setOnClickListener(this);
        findViewById(R.id.bt_no).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bt_yes){
            mainActivity.finish();
        }else if (v.getId()==R.id.bt_no){
            this.dismiss();
        }
    }
}
