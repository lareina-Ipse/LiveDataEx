package kr.co.chience.livedataex.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.co.chience.livedataex.R;
import kr.co.chience.livedataex.databinding.ItemListBinding;
import kr.co.chience.livedataex.model.User;
import kr.co.chience.livedataex.viewmodel.MainViewModel;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<User> users;
    private MainViewModel viewModel;

    public MainAdapter(List<User> users, MainViewModel viewModel) {
        this.users = users;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemListBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list, parent, false);

        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        User user = users.get(position);
        holder.setBinding(user, viewModel);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        ItemListBinding binding;

        public MainViewHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setBinding(User user, MainViewModel viewModel) {
            binding.setUser(user);
            binding.setViewmodel(viewModel);
            binding.executePendingBindings();
        }
    }

}
