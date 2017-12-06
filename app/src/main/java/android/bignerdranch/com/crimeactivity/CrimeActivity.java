package android.bignerdranch.com.crimeactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by UBanit on 12/6/2017.
 */

public class CrimeActivity extends SingleFragmentActivity{
      @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
