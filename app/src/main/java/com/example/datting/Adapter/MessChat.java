package com.example.datting.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.datting.Model.BaseMessage;
import com.example.datting.R;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessChat extends AppCompatActivity {

    private static final String BROKER_URI = "tcp://broker.hivemq.com:1883";
    private static final String TOPIC = "testtopic/2";
    private static final int QOS = 2;

    EditText editText;
    CircleImageView img_message;
    TextView name_message;
    ImageView comback;

    //username for the chat lấy tên thiết bị
    public static final String USER_NAME = Build.USER;
    public String cliendId = MqttClient.generateClientId();

    //global types
    private MqttAndroidClient client;

    //Khai báo recycle
    ArrayList<BaseMessage> messages = new ArrayList<>();
    MessageListAdapter messageListAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_chat);

        img_message = findViewById(R.id.image_message);
        name_message = findViewById(R.id.name_message);
        recyclerView = findViewById(R.id.recyc_chat);
        editText = findViewById(R.id.edit_message);
        comback = findViewById(R.id.quaylai);

        //Để lấy ra được dữ liệu, tùy thuộc vào kiểu dữ liệu chúng ta truyền đi, sử dụng các phương thức getStringExtra()
        Intent intent = getIntent();
        int imgage = intent.getIntExtra("image", 0);
        String name = intent.getStringExtra("name");

//        img_message.setImageResource(imgage);
        Glide.with(this).load(imgage).into(img_message);
        name_message.setText(name);
        //quay lại
        comeback();
        
        messageListAdapter = new MessageListAdapter(messages,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageListAdapter);
        connect();
    }

    private void comeback(){
        comback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void connect() {
        client = new MqttAndroidClient(this, BROKER_URI, cliendId);
        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true); //clean session in order to don't get duplicate messages each time we connect(làm sạch phiên để không nhận được thông báo trùng lặp mỗi khi chúng tôi kết nối)

            client.connect(options, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(MessChat.this, "Sẵn sàng", Toast.LENGTH_SHORT).show();
                    subcribe();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable throwable) {
                    Toast.makeText(MessChat.this, "Sẵn sàng" + throwable.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        } catch (MqttException e) {
            Toast.makeText(this, "" + BROKER_URI, Toast.LENGTH_LONG).show();
        }
    }

    public void publish(View view){
        //we are in the right view?
        if (view.getId() == R.id.publish){
            //we only publish if connected
            if (null != client && client.isConnected()){
                String message = editText.getText().toString();

                //we only publish if there is message to publish

                //tạo biến để lưu chuỗi editText
                if (!message.isEmpty()) {

                    message = USER_NAME+":"+ message;
                    editText.setText("");
                    MqttMessage mqttMessage = new MqttMessage();
                    mqttMessage.setQos(QOS);
                    mqttMessage.setPayload(message.getBytes()); //getBytes trả về mảng byte của chuỗi.

                    try {
                        client.publish(TOPIC, mqttMessage, null, new IMqttActionListener() {
                            @Override
                            public void onSuccess(IMqttToken asyncActionToken) {
                                Toast.makeText(MessChat.this, "Đã gửi", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(IMqttToken asyncActionToken, Throwable throwable) {
                                Toast.makeText(MessChat.this, "Tin nhắn chưa được gửi" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });

                    }catch (MqttException e) {
                        Toast.makeText(this, " ERROR, an error occurs when publishing", Toast.LENGTH_LONG).show();
                    }
                }
            }else {
                Toast.makeText(this, "WARNING, client not connected", Toast.LENGTH_LONG).show();
            }
        }
    }
    private void subcribe() {
        try {
            client.subscribe(TOPIC, QOS);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    messages.add(new BaseMessage(new String(message.getPayload())));
                    messageListAdapter.notifyDataSetChanged();
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });

        } catch (MqttSecurityException e) {
            Toast.makeText(this, "ERROR, an error occurs when subscribing", Toast.LENGTH_LONG).show();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}