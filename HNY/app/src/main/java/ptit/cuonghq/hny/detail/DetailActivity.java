package ptit.cuonghq.hny.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ptit.cuonghq.hny.R;

public class DetailActivity extends AppCompatActivity implements DetailContract.View{

    public static Intent getInstance(Context context, int id) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("id_movie", id);
        return intent;
    }

    private DetailPresenter mPresenter;
    private View mLayoutStoryline, mLayoutActor, mLayoutInformation, mLayoutCrew;
    private AppCompatTextView mTvTitle, mTvType, mTvProduction, mTvPremiere, mTvDescription;
    private AppCompatTextView mTvStoryline;
    private AppCompatTextView mTvActorTitle, mTvCrewTitle;
    private RecyclerView mRvCast, mRvCrew;
    private DetailPersonAdapter mAdapterCast, mAdapterCrew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        setupUI();
        initData();
    }

    private void setupUI() {
        mTvCrewTitle.setText("Creators");
    }

    private void initData() {

        Intent intent = getIntent();
        int id = intent.getIntExtra("id_movie", 259316);

        mPresenter = new DetailPresenter(DetailActivity.this);

        mPresenter.getMovieDetailInformation(id);
        mPresenter.getMovieCredit(id);
    }

    private void initView() {
        mLayoutStoryline = findViewById(R.id.layout_storyline);
        mLayoutActor = findViewById(R.id.layout_actor);
        mLayoutInformation = findViewById(R.id.layout_information);
        mLayoutCrew = findViewById(R.id.layout_crew);

        mTvTitle = mLayoutInformation.findViewById(R.id.tv_original_title);
        mTvType = mLayoutInformation.findViewById(R.id.tv_type);
        mTvProduction = mLayoutInformation.findViewById(R.id.tv_production);
        mTvPremiere = mLayoutInformation.findViewById(R.id.tv_premiere);
        mTvDescription = mLayoutInformation.findViewById(R.id.tv_description);

        mTvStoryline = mLayoutStoryline.findViewById(R.id.tv_story_line);
        mTvActorTitle = mLayoutActor.findViewById(R.id.tv_title);
        mTvCrewTitle = mLayoutCrew.findViewById(R.id.tv_title);

        mRvCast = mLayoutActor.findViewById(R.id.rv_person);
        mRvCrew = mLayoutCrew.findViewById(R.id.rv_person);

        mAdapterCast = new DetailPersonAdapter(true, DetailActivity.this);
        mAdapterCrew = new DetailPersonAdapter(false, DetailActivity.this);

        mRvCast.setAdapter(mAdapterCast);
        mRvCrew.setAdapter(mAdapterCrew);
    }

    @Override
    public void getMovieDetailInformationSuccess(MovieDetail detail) {
        Log.d("abc", "xyz");
        updateMovieDetailUI(detail);
    }

    private void updateMovieDetailUI(MovieDetail detail) {
        mTvStoryline.setText(detail.getOverview());
        mTvTitle.setText(detail.getOriginalTitle());

        String type = "";
        for (Genres genres : detail.getGenres()) {
            if (!TextUtils.equals(type, "")) {
                type += ", ";
            }
            type += genres.getName();
        }

        mTvType.setText(type);

        String production = "";
        for (ProductionCountries countries : detail.getProductionCountries()) {
            if (!TextUtils.equals(production, "")) {
                production += ", ";
            }
            production += countries.getName();
        }
        mTvProduction.setText(production);

        mTvDescription.setText(detail.getTagline());

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(detail.getReleaseDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        pattern = "dd MMMM yyyy";
        simpleDateFormat = new SimpleDateFormat(pattern);

        mTvPremiere.setText(simpleDateFormat.format(date));

    }

    @Override
    public void getMovieDetailInformationFailed(String msg) {
        Log.d("abc", "xyz");
    }

    @Override
    public void getMovieCreditSuccess(Credit credit) {
        mAdapterCast.setListCast(credit.getCast());
        mAdapterCrew.setListCrew(credit.getCrew());
    }

    @Override
    public void getMovieCreditFailed(String msg) {
        Log.d("getMovieCreditFailed", msg);
    }
}
