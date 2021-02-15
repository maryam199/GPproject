package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProfileScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

    }
}
/*package com.example.profilescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.profilescreen.adapter.CollectionAdapter;
import com.example.profilescreen.adapter.PostAdapter;
import com.example.profilescreen.api.MyretrofitClient;
import com.example.profilescreen.model.UserCollection;
import com.example.profilescreen.model.UserData;
import com.example.profilescreen.model.UserPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ImageView profileimage;
TextView username,userinfo,userpost,userfollower,userfollowing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profileimage=(ImageView)findViewById(R.id.profile_image);
        username=(TextView)findViewById(R.id.username);
        userpost=(TextView)findViewById(R.id.posts);
        userinfo=(TextView)findViewById(R.id.about);
        userfollower=(TextView)findViewById(R.id.follower);
        userfollowing=(TextView)findViewById(R.id.following);


        getuserdata();



    }
private void getuserdata() {
        Call<UserData>call= MyretrofitClient.getInstance().getMyApi().geuserdata();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                String name=response.body().getUsername();
                String profileimg=response.body().getProfile_image();
                String about=response.body().getUserinfo();
                String post=response.body().getPosts();
                String followers=response.body().getFollowers();
                String following=response.body().getFollowing();
                username.setText(name);
                userinfo.setText(about);
                userfollower.setText(followers);
                userfollowing.setText(following);
                userpost.setText(post);
                Glide.with(getApplicationContext())
                        .load(profileimg)
                        .apply(RequestOptions.circleCropTransform())
                        .into(profileimage);
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {

            }
        });
    }



}

 */

/*setContentView(R.layout.activity_profile);
logout=(Button)findViewById(R.id.signOut);
logout.setOnClickListener(new View.OnClickListener(){
public void onClick(View v){
FirebaseAuth.getInstance().signOut();
startActivity(new Intent(packageContext: profileActivity.this, MainActivity.class));
}
});
user=...
reference= ...
userID= user.getUid();
final TextView username=(TextView)findViewById(R.id.username);

reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener);



                username.setText(name);
                fillNameTextView.setText(fillName);
                emailTextView.setText(email);
            ageTextView.setText(age);

 */

/*
package com.androidveteran.android.materialprofile;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //no inspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
 */


/*
package com.couchbase.userprofile.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.couchbase.lite.Blob;
import com.couchbase.userprofile.R;
import com.couchbase.userprofile.login.LoginActivity;
import com.couchbase.userprofile.util.DatabaseManager;

import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class UserProfileActivity extends AppCompatActivity implements UserProfileContract.View {

    private UserProfileContract.UserActionsListener mActionListener;

    EditText nameInput;
    EditText emailInput;
    EditText addressInput;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        addressInput = findViewById(R.id.addressInput);
        imageView = findViewById(R.id.imageView);

        mActionListener = new UserProfilePresenter(this);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mActionListener.fetchProfile();
            }
        });
    }

    public static final int PICK_IMAGE = 1;

    public void onUploadPhotoTapped(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Uri selectedImage = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException ex) {
                    Log.i("SelectPhoto", ex.getMessage());
                }
            }
        }
    }

    public void onLogoutTapped(View view) {
        DatabaseManager.getSharedInstance().closeDatabaseForUser();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void onSaveTapped(View view) {
        // tag::userprofile[]
        Map<String, Object> profile = new HashMap<>();
        profile.put("name", nameInput.getText().toString());
        profile.put("email", emailInput.getText().toString());
        profile.put("address", addressInput.getText().toString());

        byte[] imageViewBytes = getImageViewBytes();

        if (imageViewBytes != null) {
            profile.put("imageData", new com.couchbase.lite.Blob("image/jpeg", imageViewBytes));
        }
        // end::userprofile[]

        mActionListener.saveProfile(profile);

        Toast.makeText(this, "Successfully updated profile!", Toast.LENGTH_SHORT).show();
    }

    private byte[] getImageViewBytes() {
        byte[] imageBytes = null;

        BitmapDrawable bmDrawable = (BitmapDrawable) imageView.getDrawable();

        if (bmDrawable != null) {
            Bitmap bitmap = bmDrawable.getBitmap();

            if (bitmap != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                imageBytes = baos.toByteArray();
            }
        }

        return imageBytes;
    }

    @Override
    public void showProfile(Map<String, Object> profile) {
        nameInput.setText((String)profile.get("name"));
        emailInput.setText((String)profile.get("email"));
        addressInput.setText((String)profile.get("address"));

        Blob imageBlob = (Blob)profile.get("imageData");

        if (imageBlob != null) {
            Drawable d = Drawable.createFromStream(imageBlob.getContentStream(), "res");
            imageView.setImageDrawable(d);
        }
    }
}

 */

/*

public class Usermanager {


    @Entity
    @Table(name="USER")
    public class User implements Serializable {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        int iduser;
        String username;
        String password;
        int idprofile;
        int accountstatus;

        public int getIduser() {
            return iduser;
        }
        public void setIduser(int iduser) {
            this.iduser = iduser;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public int getIdprofile() {
            return idprofile;
        }
        public void setIdprofile(int idprofile) {
            this.idprofile = idprofile;
        }
        public int getAccountstatus() {
            return accountstatus;
        }
        public void setAccountstatus(int accountstatus) {
            this.accountstatus = accountstatus;
        }

    }

    @Entity
    @Table(name="PROFILE")
    public class Profile implements Serializable {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        int idprofile;
        String nomprofile;
        String prenprofile;
        String mailprofile;
        String adressprofile;
        int phoneprofile;
        Date datenaissanceprofile;
        char sexeuser;
        String imagepath;

        public int getIdprofile() {
            return idprofile;
        }
        public void setIdprofile(int idprofile) {
            this.idprofile = idprofile;
        }
        public String getNomprofile() {
            return nomprofile;
        }
        public void setNomprofile(String nomprofile) {
            this.nomprofile = nomprofile;
        }
        public String getPrenprofile() {
            return prenprofile;
        }
        public void setPrenprofile(String prenprofile) {
            this.prenprofile = prenprofile;
        }
        public String getMailprofile() {
            return mailprofile;
        }
        public void setMailprofile(String mailprofile) {
            this.mailprofile = mailprofile;
        }
        public String getAdressprofile() {
            return adressprofile;
        }
        public void setAdressprofile(String adressprofile) {
            this.adressprofile = adressprofile;
        }
        public int getPhoneprofile() {
            return phoneprofile;
        }
        public void setPhoneprofile(int phoneprofile) {
            this.phoneprofile = phoneprofile;
        }
        public Date getDatenaissanceprofile() {
            return datenaissanceprofile;
        }
        public void setDatenaissanceprofile(Date datenaissanceprofile) {
            this.datenaissanceprofile = datenaissanceprofile;
        }
        public char getSexeuser() {
            return sexeuser;
        }
        public void setSexeuser(char sexeuser) {
            this.sexeuser = sexeuser;
        }
        public String getImagepath() {
            return imagepath;
        }
        public void setImagepath(String imagepath) {
            this.imagepath = imagepath;
        }

    }

    //from profile where profile.idprofile=(select u.idprofile from User u where u.username = :username)
 */