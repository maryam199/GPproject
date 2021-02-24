package com.example.loginscreen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

import javax.annotation.Nullable;


public class ProfileScreen extends AppCompatActivity {
    TextView  NameC, PasswordC,EmailC,WidthC, HightC,GoalC;
    private TextView UserNameC;
    //FirebaseUser User;
    FirebaseAuth fAuth;
    //DatabaseReference reference;
    FirebaseFirestore fStore;
    String UserID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_profile);


        // اسم المستحدم، الايميل، كلمة المرور

        UserNameC =  findViewById(R.id.textView8); //اسم المستخدم
        NameC =  findViewById(R.id.textView9); //الاسم
        PasswordC =  findViewById(R.id.textView10); //كلمة المرور
        EmailC =  findViewById(R.id.textView11); //البريد الالكتروني
        WidthC =  findViewById(R.id.textView12); //الوزن
        HightC =  findViewById(R.id.textView13); //الطول
        GoalC =  findViewById(R.id.checkedTextView); //الهدف

        UserID =  Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        //Get Database values
        DocumentReference documentReference = fStore.collection("Client").document(UserID);


        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent( @Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                UserNameC.setText(documentSnapshot.getString("UserNameC"));
                NameC.setText(documentSnapshot.getString("NameC"));
                PasswordC.setText(documentSnapshot.getString("PasswordC"));
                EmailC.setText(documentSnapshot.getString("EmailC"));
                WidthC.setText(documentSnapshot.getString("WidthC"));
                HightC.setText(documentSnapshot.getString("HightC"));
                GoalC.setText(documentSnapshot.getString("GoalC"));
            }
        });
        /* مهم افهمه الزر اللي لا ضغطته يفتحلي الكلاس

bModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(c_ViewAccount.this, c_UpdateAccount.class));// It changes if we add the database

            }
        });
 */
    }
}