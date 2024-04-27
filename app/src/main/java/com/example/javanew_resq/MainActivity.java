package com.example.javanew_resq;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    Button button2;
    TextView textView;
    FirebaseUser user;
    BottomSheetDialog sheetDialog;

    Button callbtn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            textView.setText(user.getEmail());
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetStyle);

                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.bottomsheet_dialog,
                        (LinearLayout) findViewById(R.id.sheet));

                sheetDialog.setContentView(view);

                sheetDialog.show();
                dialog();
            }

            private void dialog() {

                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.bottomsheet_dialog,
                        (LinearLayout) findViewById(R.id.sheet));

                callbtn = findViewById(R.id.buttoncall);

                callbtn.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:09682008068"));
                    startActivity(intent);
                }

                });

            }

        });
    }
}

//            Intent intent = new Intent(Intent.ACTION_CALL);
//            intent.setData(Uri.parse("tel:09682008068"));
//            startActivity(intent);
//
//            callbtn.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_CALL);
//                    intent.setData(Uri.parse("tel:09682008068"));
//                    startActivity(intent);
//                }
//            });




//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getApplicationContext(), Login.class);
//                startActivity(intent);
//                finish();
//
//            }