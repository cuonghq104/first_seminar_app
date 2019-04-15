package ptit.cuonghq.hny.category;

import android.content.Context;

import java.util.List;

import ptit.cuonghq.hny.data.models.Category;

public class CategoryContract {

    interface MainView {
        void loadData(List<Category> categories);
        Context getContext();
    }

    interface ViewModel {
        void destroy();
    }
}
