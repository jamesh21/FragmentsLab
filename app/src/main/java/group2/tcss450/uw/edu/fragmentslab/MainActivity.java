package group2.tcss450.uw.edu.fragmentslab;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            if (findViewById(R.id.fragmentContainer) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainer, new FirstFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onFragmentInteraction(int color) {

        StringBuilder sb = new StringBuilder(128);
        sb.append("Red: ");
        sb.append(Color.red(color));
        sb.append(" Green: ");
        sb.append(Color.green(color));
        sb.append(" Blue: ");
        sb.append(Color.blue(color));
        Log.d("ACTIVITY", sb.toString());

        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();

        FlowerFragment flowerFragment;
        flowerFragment = new FlowerFragment();
        Bundle args = new Bundle();
        args.putSerializable(flowerFragment.COLOR, color);
        flowerFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, flowerFragment)
                .addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}
