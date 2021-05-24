package com.forbitbd.test2;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";


    private SignInButton signInButton;
    private static final int RC_SIGN_IN = 9001;
    private Button logoutbtn;
    String personName,personGivenName,personEmail,personId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton = findViewById(R.id.google_sign_in);
        logoutbtn = findViewById(R.id.logout);
        signInButton.setOnClickListener(this);
        logoutbtn.setOnClickListener(this);

//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();


    }


    private void signIn() {
        Intent signInIntent = getGoogleApiClient().getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.d(TAG, "Google sign in failed", e);
            }
        }
    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            updateUI(currentUser);
//        }
//
//    }

    private void updateUI(FirebaseUser currentUser) {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null) {
            personName = account.getDisplayName();
            Log.d(TAG, "updateUI: "+personName);
            personGivenName = account.getGivenName();
            Log.d(TAG, "updateUI: "+personGivenName);
            personEmail = account.getEmail();
            Log.d(TAG, "updateUI: "+personEmail);
            personId = account.getId();
            Log.d(TAG, "updateUI: "+personId);
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        getAuth().signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("tag", "signInWithCredential:success");
                            FirebaseUser dealer = getAuth().getCurrentUser();
                            registerToDatabase(dealer);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("tag", "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.google_sign_in:
                signIn();
                break;

            case  R.id.logout:
                signOut();

        }
    }





    private void registerToDatabase(FirebaseUser dealer) {
        Dealer d = new Dealer();

        if (dealer.getEmail() != null) {
            d.setEmail(dealer.getEmail());
        }

        if (dealer.getDisplayName() != null) {
            d.setName(dealer.getDisplayName());
        }

        if (dealer.getPhoneNumber() != null) {
            d.setContact(dealer.getPhoneNumber());
        }

        if (dealer.getPhotoUrl() != null) {
            d.setImage(dealer.getPhotoUrl().toString());
        }

        ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);

        Call<Dealer> call = apiClient.register(d);

        call.enqueue(new Callback<Dealer>() {
            @Override
            public void onResponse(Call<Dealer> call, Response<Dealer> response) {

                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+dealer);
                }
            }

            @Override
            public void onFailure(Call<Dealer> call, Throwable t) {
                Log.d("YYYY","Not Successfull "+t.getMessage());
            }
        });

    }
    }


