package com.starlingsoftwares.mymanagement.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.starlingsoftwares.mymanagement.R;
import com.starlingsoftwares.mymanagement.fragment.BillingFragment;
import com.starlingsoftwares.mymanagement.fragment.CrossBillingFragment;
import com.starlingsoftwares.mymanagement.fragment.SeriesBillingFragment;

public class BillingsActivity extends AppCompatActivity {
    public static BillingsActivity mInstance;
    LinearLayout llBilling, llCrossBilling, llSeriesBilling;
    ImageView back_billing;

    public static BillingsActivity getInstace() {
        return mInstance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billings);

        llBilling = findViewById(R.id.ll_billing);
        llCrossBilling = findViewById(R.id.ll_cross_billing);
        llSeriesBilling = findViewById(R.id.ll_series_billing);
        back_billing = findViewById(R.id.back_billing);


        llBilling.setBackgroundColor(getResources().getColor(R.color.orange));
        Fragment fragment = new BillingFragment();
        FragmentManager frgManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = frgManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, fragment).commitAllowingStateLoss();
        frgManager.executePendingTransactions();

        back_billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BillingsActivity.this, MenuActivity.class));
            }
        });

        llBilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBilling.setBackgroundColor(getResources().getColor(R.color.orange));
                llCrossBilling.setBackgroundColor(getResources().getColor(R.color.red));
                llSeriesBilling.setBackgroundColor(getResources().getColor(R.color.red));
                replaceFragment(new BillingFragment(), BillingFragment.class.getSimpleName());

            }
        });
        llCrossBilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBilling.setBackgroundColor(getResources().getColor(R.color.red));
                llCrossBilling.setBackgroundColor(getResources().getColor(R.color.orange));
                llSeriesBilling.setBackgroundColor(getResources().getColor(R.color.red));
                replaceFragment(new CrossBillingFragment(), CrossBillingFragment.class.getSimpleName());

            }
        });
        llSeriesBilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBilling.setBackgroundColor(getResources().getColor(R.color.red));
                llCrossBilling.setBackgroundColor(getResources().getColor(R.color.red));
                llSeriesBilling.setBackgroundColor(getResources().getColor(R.color.orange));
                replaceFragment(new SeriesBillingFragment(), SeriesBillingFragment.class.getSimpleName());

            }
        });


        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = getFragment();
            }
        });


    }

    private Fragment getFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.frame);
    }

    private void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStackImmediate(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

    }

    private void replaceFragment(Fragment newFragment, String transactionTag) {
        if (newFragment != null) {
            FragmentManager frgManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = frgManager.beginTransaction();

            fragmentTransaction.setReorderingAllowed(false);
            fragmentTransaction.addToBackStack(transactionTag);
            fragmentTransaction.replace(R.id.frame, newFragment).commitAllowingStateLoss();
            frgManager.executePendingTransactions();
        }
    }
}
