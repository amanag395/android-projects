package craterzone.tictactoe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import craterzone.tictactoe.R;
import craterzone.tictactoe.constants.Constants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isplayer;
    private boolean isGameOver;
    private ImageView imageView00;
    private ImageView imageView01;
    private ImageView imageView02;
    private ImageView imageView10;
    private ImageView imageView11;
    private ImageView imageView12;
    private ImageView imageView20;
    private ImageView imageView21;
    private ImageView imageView22;

    private void newGmae() {
        imageView00.setImageDrawable(null);
        imageView01.setImageDrawable(null);
        imageView02.setImageDrawable(null);
        imageView10.setImageDrawable(null);
        imageView11.setImageDrawable(null);
        imageView12.setImageDrawable(null);
        imageView20.setImageDrawable(null);
        imageView21.setImageDrawable(null);
        imageView22.setImageDrawable(null);
    }

    private void checkWin() {
        if (imageView00.getDrawable() != null &&
                imageView01.getDrawable() != null &&
                imageView02.getDrawable() != null &&
                (imageView00.getDrawable().getConstantState() == imageView01.getDrawable().getConstantState()) &&
                (imageView00.getDrawable().getConstantState() == imageView02.getDrawable().getConstantState())) {
            Toast.makeText(getApplicationContext(), Constants.GAME_OVER, Toast.LENGTH_SHORT).show();
            isGameOver = !isGameOver;
        } else if (imageView10.getDrawable() != null && imageView11.getDrawable() != null && imageView12.getDrawable() != null && (imageView10.getDrawable().getConstantState() == imageView11.getDrawable().getConstantState()) && (imageView10.getDrawable().getConstantState() == imageView12.getDrawable().getConstantState())) {
            Toast.makeText(getApplicationContext(), Constants.GAME_OVER, Toast.LENGTH_SHORT).show();
            isGameOver = !isGameOver;
        } else if (imageView20.getDrawable() != null && imageView21.getDrawable() != null && imageView22.getDrawable() != null && (imageView20.getDrawable().getConstantState() == imageView21.getDrawable().getConstantState()) && (imageView20.getDrawable().getConstantState() == imageView22.getDrawable().getConstantState())) {
            Toast.makeText(getApplicationContext(), Constants.GAME_OVER, Toast.LENGTH_SHORT).show();
            isGameOver = !isGameOver;
        } else if (imageView00.getDrawable() != null && imageView10.getDrawable() != null && imageView20.getDrawable() != null && (imageView00.getDrawable().getConstantState() == imageView10.getDrawable().getConstantState()) && (imageView00.getDrawable().getConstantState() == imageView20.getDrawable().getConstantState())) {
            Toast.makeText(getApplicationContext(), Constants.GAME_OVER, Toast.LENGTH_SHORT).show();
            isGameOver = !isGameOver;
        } else if (imageView01.getDrawable() != null && imageView11.getDrawable() != null && imageView21.getDrawable() != null && (imageView01.getDrawable().getConstantState() == imageView11.getDrawable().getConstantState()) && (imageView01.getDrawable().getConstantState() == imageView21.getDrawable().getConstantState())) {
            Toast.makeText(getApplicationContext(), Constants.GAME_OVER, Toast.LENGTH_SHORT).show();
            isGameOver = !isGameOver;
        } else if (imageView02.getDrawable() != null && imageView12.getDrawable() != null && imageView22.getDrawable() != null && (imageView02.getDrawable().getConstantState() == imageView12.getDrawable().getConstantState()) && (imageView02.getDrawable().getConstantState() == imageView22.getDrawable().getConstantState())) {
            Toast.makeText(getApplicationContext(), Constants.GAME_OVER, Toast.LENGTH_SHORT).show();
            isGameOver = !isGameOver;
        } else if (imageView00.getDrawable() != null && imageView11.getDrawable() != null && imageView22.getDrawable() != null && (imageView00.getDrawable().getConstantState() == imageView11.getDrawable().getConstantState()) && (imageView00.getDrawable().getConstantState() == imageView22.getDrawable().getConstantState())) {
            Toast.makeText(getApplicationContext(), Constants.GAME_OVER, Toast.LENGTH_SHORT).show();
            isGameOver = !isGameOver;
        } else if (imageView02.getDrawable() != null && imageView11.getDrawable() != null && imageView20.getDrawable() != null && (imageView02.getDrawable().getConstantState() == imageView11.getDrawable().getConstantState()) && (imageView02.getDrawable().getConstantState() == imageView20.getDrawable().getConstantState())) {
            Toast.makeText(getApplicationContext(), Constants.GAME_OVER, Toast.LENGTH_SHORT).show();
            isGameOver = !isGameOver;
        }
    }

    private void draw() {
        if (!isGameOver && imageView00.getDrawable() != null && imageView01.getDrawable() != null && imageView02.getDrawable() != null && imageView10.getDrawable() != null && imageView11.getDrawable() != null && imageView12.getDrawable() != null && imageView20.getDrawable() != null && imageView21.getDrawable() != null && imageView22.getDrawable() != null) {
            Toast.makeText(getApplicationContext(), Constants.DRAW, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isplayer = true;
        isGameOver = false;
        imageView00 = (ImageView) findViewById(R.id.iv_00);
        imageView01 = (ImageView) findViewById(R.id.iv_01);
        imageView02 = (ImageView) findViewById(R.id.iv_02);
        imageView10 = (ImageView) findViewById(R.id.iv_10);
        imageView11 = (ImageView) findViewById(R.id.iv_11);
        imageView12 = (ImageView) findViewById(R.id.iv_12);
        imageView20 = (ImageView) findViewById(R.id.iv_20);
        imageView21 = (ImageView) findViewById(R.id.iv_21);
        imageView22 = (ImageView) findViewById(R.id.iv_22);
        findViewById(R.id.iv_00).setOnClickListener(this);
        findViewById(R.id.iv_01).setOnClickListener(this);
        findViewById(R.id.iv_02).setOnClickListener(this);
        findViewById(R.id.iv_10).setOnClickListener(this);
        findViewById(R.id.iv_11).setOnClickListener(this);
        findViewById(R.id.iv_12).setOnClickListener(this);
        findViewById(R.id.iv_20).setOnClickListener(this);
        findViewById(R.id.iv_21).setOnClickListener(this);
        findViewById(R.id.iv_22).setOnClickListener(this);
        findViewById(R.id.bt_new_game).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!isGameOver) {
            if (v.getId() == R.id.iv_00 && imageView00.getDrawable() == null) {
                if (isplayer) {
                    imageView00.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView00.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            } else if (v.getId() == R.id.iv_01 && imageView01.getDrawable() == null) {
                if (isplayer) {
                    imageView01.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView01.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            } else if (v.getId() == R.id.iv_02 && imageView02.getDrawable() == null) {
                if (isplayer) {
                    imageView02.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView02.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            } else if (v.getId() == R.id.iv_10 && imageView10.getDrawable() == null) {
                if (isplayer) {
                    imageView10.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView10.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            } else if (v.getId() == R.id.iv_11 && imageView11.getDrawable() == null) {
                if (isplayer) {
                    imageView11.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView11.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            } else if (v.getId() == R.id.iv_12 && imageView12.getDrawable() == null) {
                if (isplayer) {
                    imageView12.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView12.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            } else if (v.getId() == R.id.iv_20 && imageView20.getDrawable() == null) {
                if (isplayer) {
                    imageView20.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView20.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            } else if (v.getId() == R.id.iv_21 && imageView21.getDrawable() == null) {
                if (isplayer) {
                    imageView21.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView21.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            } else if (v.getId() == R.id.iv_22 && imageView22.getDrawable() == null) {
                if (isplayer) {
                    imageView22.setImageResource(R.drawable.circle);
                    isplayer = !isplayer;
                } else {
                    imageView22.setImageResource(R.drawable.cross);
                    isplayer = !isplayer;
                }
            }
            checkWin();
        }
        if (v.getId() == R.id.bt_new_game) {
            newGmae();
            if (isGameOver) {
                isGameOver = !isGameOver;
            }

        }
        draw();
    }

}
