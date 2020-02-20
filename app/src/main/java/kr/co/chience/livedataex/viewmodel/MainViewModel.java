package kr.co.chience.livedataex.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import kr.co.chience.livedataex.Interface.MainNavigator;
import kr.co.chience.livedataex.model.User;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<User>> user = new MutableLiveData<>();
    private MainNavigator navigator;

    public void setNavigator(MainNavigator navigator) {
        this.navigator = navigator;
    }

    public MutableLiveData<List<User>> getUser() {
        setUser();
        return user;
    }

    public void setUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("Haerul Muttaqin 1", "haerul.muttagin@gmail.com"));
        users.add(new User("Haerul Muttaqin 2", "haerul.muttagin@gmail.com"));
        users.add(new User("Haerul Muttaqin 3", "haerul.muttagin@gmail.com"));
        users.add(new User("Haerul Muttaqin 4", "haerul.muttagin@gmail.com"));
        users.add(new User("Haerul Muttaqin 5", "haerul.muttagin@gmail.com"));
        this.user.setValue(users);
    }

    public void itemClick(User user) {
        navigator.onItemClick(user);
    }

}
