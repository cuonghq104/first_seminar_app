package ptit.cuonghq.hny.addrecipe;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import ptit.cuonghq.hny.R;
import ptit.cuonghq.hny.category.CategoryViewModel;
import ptit.cuonghq.hny.data.models.Category;
import ptit.cuonghq.hny.data.models.Cuisine;

public class AddRecipeActivity extends AppCompatActivity {

    private AddRecipeViewModel viewModel;
    private Spinner spnCategory;
    private Spinner spnPerson;
    private Spinner spnCuisine;

    String[] persons = new String[] {"1", "2", "3", "4", "5", "6+"};
    ArrayAdapter<String> personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        initView();
        setupUI();
    }

    private void setupUI() {
        viewModel = ViewModelProviders.of(this).get(AddRecipeViewModel.class);
        viewModel.getCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {

            }
        });
        viewModel.getCuisines().observe(this, new Observer<List<Cuisine>>() {
            @Override
            public void onChanged(@Nullable List<Cuisine> cuisines) {

            }
        });
    }

    private void initView() {
        spnCategory = findViewById(R.id.spn_category);
        spnCuisine = findViewById(R.id.spn_cuisine);
        spnPerson = findViewById(R.id.spn_persons);

        personAdapter = new ArrayAdapter<String>(AddRecipeActivity.this, android.R.layout.simple_list_item_activated_1, persons);
        spnPerson.setAdapter(personAdapter);
    }
}
