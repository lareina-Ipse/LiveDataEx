package kr.co.chience.livedataex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import kr.co.chience.livedataex.Interface.MainNavigator;
import kr.co.chience.livedataex.adapter.MainAdapter;
import kr.co.chience.livedataex.databinding.ActivityMainBinding;
import kr.co.chience.livedataex.model.User;
import kr.co.chience.livedataex.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements MainNavigator {

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

        viewModel.setNavigator(this);
        viewModel.setUser();
        viewModel.getUser().observe(this, user -> {
            binding.recyclerView.setAdapter(new MainAdapter(user, viewModel));
        });

    }

    @Override
    public void onItemClick(User user) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(user.name + "\n" + user.email);

        if (user.isMark.get()) {
            alert.setPositiveButton("UNMARK", (dialog, which) -> {
               user.isMark.set(false);
               dialog.dismiss();
            });
        } else {
            alert.setPositiveButton("MARK", (dialog, which) -> {
                user.isMark.set(true);
                dialog.dismiss();
            });
        }

        alert.show();
    }
}
