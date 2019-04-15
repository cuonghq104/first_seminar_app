package ptit.cuonghq.hny.addrecipe;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import ptit.cuonghq.hny.data.models.Category;
import ptit.cuonghq.hny.data.models.Cuisine;

public class AddRecipeViewModel extends ViewModel {

    private MutableLiveData<List<Category>> categories = new MutableLiveData<>();
    private MutableLiveData<List<Cuisine>> cuisines = new MutableLiveData<>();

    public LiveData<List<Cuisine>> getCuisines() {
        return cuisines;
    }

    public LiveData<List<Category>> getCategories() {
        return categories;
    }
}
