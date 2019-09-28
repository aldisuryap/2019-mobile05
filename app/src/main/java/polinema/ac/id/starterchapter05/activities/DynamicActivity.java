package polinema.ac.id.starterchapter05.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import java.nio.file.Files;

import polinema.ac.id.starterchapter05.R;
import polinema.ac.id.starterchapter05.fragments.BlueFragment;
import polinema.ac.id.starterchapter05.fragments.RedFragment;

public class DynamicActivity extends AppCompatActivity {

    public static final String RED_TAG = "RED_FRAGMENT";
    public static final String BLUE_TAG = "BLUE_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
    }

    public void handleClickLoadRedFragment(View view) {
        Fragment fragmentTransaction = getSupportFragmentManager().findFragmentById(R.id.dynamic_fragment_placeholder);

        if (fragmentTransaction == null || fragmentTransaction instanceof BlueFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.exit_from_left, R.anim.exit_from_right)
                    .replace(R.id.dynamic_fragment_placeholder, new RedFragment(), "RED_FRAGMENT")
                    .addToBackStack(null)
                    .commit();
        }

    }

    public void handleClickLoadBlueFragment(View view) {
        Fragment fragmentTransaction = getSupportFragmentManager().findFragmentById(R.id.dynamic_fragment_placeholder);

        if (fragmentTransaction == null || fragmentTransaction instanceof RedFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.exit_from_left, R.anim.exit_from_right)
                    .replace(R.id.dynamic_fragment_placeholder, new BlueFragment(), "BLUE_FRAGMENT")
                    .addToBackStack(null)
                    .commit();
        }
    }
}
