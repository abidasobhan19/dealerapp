package com.forbitbd.Dealer.ui.landing;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.forbitbd.Dealer.ui.Connected_Fragment.ConnectedFragment;
import com.forbitbd.Dealer.ui.Device_Entry.DeviceEntryFormFragment;
import com.forbitbd.Dealer.ui.Pending_Fragment.Fragment_panding;
import com.forbitbd.Dealer.ui.Profile.ProfileActivity;
import com.forbitbd.Dealer.ViewPagerAdapter;
import com.forbitbd.Dealer.utils.BaseActivity;
import com.forbitbd.Dealer.ui.Main.MainActivity;
import com.forbitbd.Dealer.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;


public class LandingPage extends BaseActivity implements  LandingContract.View {




    private ExtendedFloatingActionButton btnfab;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Fragment_panding fragment_panding;
    private ConnectedFragment connectedFragment;


    private LandingPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        mPresenter = new LandingPresenter(this);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        fragment_panding  = new Fragment_panding();
        connectedFragment = new ConnectedFragment();
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragment(fragment_panding, "Pending Device");
        viewPagerAdapter.addFragment(connectedFragment, "Connected Device");
        viewPager.setAdapter(viewPagerAdapter);


        setupToolbar(R.id.toolbar);
        mPresenter.updateFirebaseToken();

        btnfab = findViewById(R.id.req);
        btnfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceEntryFormFragment dialogboxFragment = new DeviceEntryFormFragment();
                dialogboxFragment.setCancelable(true);
                dialogboxFragment.show(getSupportFragmentManager(), "abcd");
            }
        });

    }






    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public void googlelogout() {
        signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile) {
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
          googlelogout();
        }
        return super.onOptionsItemSelected(item);
    }


}