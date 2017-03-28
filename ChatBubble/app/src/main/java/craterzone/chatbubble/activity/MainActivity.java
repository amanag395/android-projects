package craterzone.chatbubble.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;

import craterzone.chatbubble.R;
import craterzone.chatbubble.adapter.MyRecycleViewAdpeter;
import craterzone.chatbubble.model.ChatItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyRecycleViewAdpeter.MyClickListener {

    private EditText message;
    private RecyclerView recyclerViewChat;
    private MyRecycleViewAdpeter myRecycleViewAdpeter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (EditText) findViewById(R.id.et_message);
        recyclerViewChat = (RecyclerView) findViewById(R.id.rv_chat);
        recyclerViewChat.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerViewChat.setLayoutManager(layoutManager);
        myRecycleViewAdpeter = new MyRecycleViewAdpeter();
        myRecycleViewAdpeter.setOnItemClickListener(this);
        recyclerViewChat.setAdapter(myRecycleViewAdpeter);
        findViewById(R.id.bt_send).setOnClickListener(this);
        myRecycleViewAdpeter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                recyclerViewChat.smoothScrollToPosition(0);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_send && !message.getText().toString().equals("")) {
            ChatItem chatItem = new ChatItem(message.getText().toString().trim(), Calendar.getInstance().getTime().toString());
            myRecycleViewAdpeter.addMessage(chatItem);
            myRecycleViewAdpeter.addMessage(new ChatItem("Hello" + Math.random() * 23, Calendar.getInstance().getTime().toString()));
            message.setText("");
        }
    }

    @Override
    public void onItemClick(String time) {
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show();
    }
}
