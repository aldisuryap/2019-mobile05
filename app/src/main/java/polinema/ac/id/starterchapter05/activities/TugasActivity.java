package polinema.ac.id.starterchapter05.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import polinema.ac.id.starterchapter05.R;
import polinema.ac.id.starterchapter05.fragments.DipsFragment;
import polinema.ac.id.starterchapter05.fragments.HandstandFragment;
import polinema.ac.id.starterchapter05.fragments.PushupFragment;

public class TugasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);


        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(R.id.konten, new HandstandFragment(), "Handstand")
                .commit();


    }

    public void handlerHandstand(View view) {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.konten);
        if (frag == null || frag instanceof DipsFragment || frag instanceof PushupFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.konten, new HandstandFragment(), "Handstand")
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void handlerDips(View view) {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.konten);
        if (frag == null || frag instanceof HandstandFragment || frag instanceof PushupFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.konten, new DipsFragment(), "Dips")
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void handlerPushup(View view) {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.konten);
        if (frag == null || frag instanceof HandstandFragment || frag instanceof DipsFragment) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.konten, new PushupFragment(), "Pushup")
                    .addToBackStack(null)
                    .commit();
        }
    }
}
