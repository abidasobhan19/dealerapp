package com.forbitbd.test2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.forbitbd.test2.login.login;
import com.forbitbd.test2.models.Dealer;
import com.forbitbd.test2.api.ApiClient;
import com.forbitbd.test2.api.ServiceGenerator;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    private static final String TAG = "MainActivity";
//
//
//    private SignInButton signInButton;
//    private static final int RC_SIGN_IN = 9001;
private Dealer dealer;
private FirebaseUser mCurrentUser;
private FirebaseMessaging firebaseMessaging;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        signInButton = findViewById(R.id.google_sign_in);
//
//        signInButton.setOnClickListener(this);
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
       if (mCurrentUser ==null){
           finish();
           startActivity(new Intent(getApplicationContext(), login.class));
       }else {
           startActivity(new Intent(getApplicationContext(), LandingPage.class));
       }


        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("hhhh", "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        Log.d("hhhhhh", "onComplete: "+token);


                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
//                        Log.d("hhhh", msg);
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });




    }




    //    private void signIn() {
//        Intent signInIntent = getGoogleApiClient().getSignInIntent();
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RC_SIGN_IN) {
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                GoogleSignInAccount account = task.getResult(ApiException.class);
//                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
//                firebaseAuthWithGoogle(account.getIdToken());
//            } catch (ApiException e) {
//                // Google Sign In failed, update UI appropriately
//                Log.d(TAG, "Google sign in failed", e);
//            }
//        }
//    }
//
//
//
//
//    private void firebaseAuthWithGoogle(String idToken) {
//        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
//        getAuth().signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("tag", "signInWithCredential:success");
//                            FirebaseUser dealer = getAuth().getCurrentUser();
//
//                            if (dealer!=null){
//                                registerToDatabase(dealer);
//                            }
//
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("tag", "signInWithCredential:failure", task.getException());
//                            registerToDatabase(null);
//                        }
//                    }
//                });
//    }
//
//
//
//    @Override
//    public void onClick(View view) {
//       signIn();
////
//    }
//
//
//
//
//
//    private void registerToDatabase(FirebaseUser dealer) {
//        Dealer d = new Dealer();
//
//        if (dealer.getEmail() != null) {
//            d.setEmail(dealer.getEmail());
//        }
//
//        if (dealer.getDisplayName() != null) {
//            d.setName(dealer.getDisplayName());
//        }
//
//        if (dealer.getPhoneNumber() != null) {
//            d.setMobile(dealer.getPhoneNumber());
//        }
//
//        if (dealer.getPhotoUrl() != null) {
//            d.setImage(dealer.getPhotoUrl().toString());
//        }
//
//        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
//
//        Call<Dealer> call = apiClient.register(d);
//
//        call.enqueue(new Callback<Dealer>() {
//            @Override
//            public void onResponse(Call<Dealer> call, Response<Dealer> response) {
//
//                if(response.isSuccessful()){
//                    Log.d(TAG, "onResponse: "+dealer);
//                    startActivity(new Intent(getApplicationContext(),LandingPage.class));
//                    finish();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Dealer> call, Throwable t) {
//                Log.d("YYYY","Not Successfull "+t.getMessage());
//            }
//        });
//
//    }
//
//



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
    }


