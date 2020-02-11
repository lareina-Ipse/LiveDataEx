package kr.co.chience.livedataex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import kr.co.chience.livedataex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActivityMainBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainViewModel viewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);

        viewModel.setUser();
        viewModel.getUser().observe(this, user -> {
            binding.recyclerView.setAdapter(new MainAdapter(user, viewModel));
        });

    }
}
