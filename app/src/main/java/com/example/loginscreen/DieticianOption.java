package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.MimeTypeFilter;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
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

import java.util.HashMap;
import java.util.UUID;

public class DieticianOption extends AppCompatActivity {
  ImageView image;
  Button button;
    private static final int ImageBack = 1;
  private StorageReference Folder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietician_option);

        Folder = FirebaseStorage.getInstance().getReference().child("ImageFolder");

        //image = (ImageView) findViewById(R.id.imageView33);
        //button = (Button) findViewById(R.id.button4);
    }

    //private void openSin(){
    //    Intent intent = new Intent(this, MainActivity.class);
     //   startActivity(intent);
    //}



    public void UploadData(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,ImageBack);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImageBack) {
            if (resultCode == RESULT_OK){
               Uri imageData = data.getData();
               StorageReference Imagename =  Folder.child("image"+imageData.getLastPathSegment());

               Imagename.putFile(imageData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                   @Override
                   public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                       Imagename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                           @Override
                           public void onSuccess(Uri uri) {
                               DatabaseReference imagestore = FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Image");
                               HashMap<String,String> hashMap = new HashMap<>();
                               hashMap.put("imageurl", String.valueOf(uri));
                               imagestore.setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                   @Override
                                   public void onSuccess(Void aVoid) {

                                       Toast.makeText(DieticianOption.this,"تم التحميل بنجاح",Toast.LENGTH_SHORT).show();
                                       startActivity(new Intent(getApplicationContext(), MainActivity.class));


                                   }
                               });
                           }
                       });


                   }
               });
            }
        }
    }
}