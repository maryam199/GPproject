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