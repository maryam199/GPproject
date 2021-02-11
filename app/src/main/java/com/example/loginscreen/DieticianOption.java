package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.MimeTypeFilter;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class DieticianOption extends AppCompatActivity {
   private ImageView image;
   private Uri imageUri;
   private Button button;
   private DatabaseReference root = FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("image");
   private StorageReference reference = FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietician_option);

      image = findViewById(R.id.imageView33);
      button = findViewById(R.id.button4);

      image.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, 2);
            }
        });

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(imageUri != null){
                  uploadToFirebase(imageUri);
                  openSin();
              }else{
                  Toast.makeText(DieticianOption.this,"الرجاء تحميل صورة من شهادتك!", Toast.LENGTH_SHORT).show();
              }
          }
      });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imageUri = data.getData();
            image.setImageURI(imageUri);
        }
    }

    private void uploadToFirebase(Uri uri){
         StorageReference fileRef = reference.child(System.currentTimeMillis() + "." + getFileExtension(uri));
         fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
             @Override
             public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Dietician dietician = new Dietician(uri.toString());
                        String modelId = root.push().getKey();
                        root.child(modelId).setValue(dietician);
                        Toast.makeText(DieticianOption.this,"تم تحميل الصورة بنجاح", Toast.LENGTH_LONG).show();
                    }
                });
             }
         }) .addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 Toast.makeText(DieticianOption.this, "خطأ", Toast.LENGTH_SHORT).show();

             }
         });
    }

    private String getFileExtension(Uri mUri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));
    }

    private void openSin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}