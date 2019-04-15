package ptit.cuonghq.hny.person;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.makeramen.roundedimageview.RoundedImageView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

import ptit.cuonghq.hny.R;
import ptit.cuonghq.hny.RoundedCornersTransformation;
import ptit.cuonghq.hny.data.networks.models.PersonImage;
import ptit.cuonghq.hny.data.networks.models.PersonInfo;
import ptit.cuonghq.hny.data.networks.models.PersonMovieCredit;
import ptit.cuonghq.hny.data.networks.models.Profiles;

public class PersonActivity extends AppCompatActivity implements PersonContract.View {

    private static final String TAG = PersonActivity.class.toString();

    public static Intent getInstance(Context context, int id) {
        Intent intent = new Intent(context, PersonActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id_person", id);
        intent.putExtras(bundle);
        return intent;
    }

    private RecyclerView mRvFilm;
    private PersonMovieCreditAdapter mAdapter;

    private AppCompatTextView mTvBiography, mTvName, mTvDateOfBirth, mTvPlaceOfBirth, mTvDepartment;
    private AppCompatImageView mImvActor;

    private View mLayoutPhoto, mLayoutHeader;
    private RoundedImageView[] mImvPersons;
    private AppCompatButton mBtnViewMore;

    private PersonPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        initView();
        initData();
        addListener();
    }

    private void addListener() {

    }

    private void initData() {
        int idPerson = 0;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            idPerson = bundle.getInt("id_person");
        }

        mPresenter = new PersonPresenter(PersonActivity.this);
        mPresenter.loadInformation(idPerson);
        mPresenter.loadImages(idPerson);
        mPresenter.loadRelatedMovies(idPerson);

        mAdapter = new PersonMovieCreditAdapter(PersonActivity.this);
        mRvFilm.setAdapter(mAdapter);
    }

    private void initView() {
        mRvFilm = findViewById(R.id.rv_film);
        mTvBiography = findViewById(R.id.tv_biography);
        mLayoutPhoto = findViewById(R.id.layout_image);
        mLayoutHeader = findViewById(R.id.layout_header);

        mImvPersons = new RoundedImageView[5];
        mImvPersons[0] = mLayoutPhoto.findViewById(R.id.imv_person_1);
        mImvPersons[1] = mLayoutPhoto.findViewById(R.id.imv_person_2);
        mImvPersons[2] = mLayoutPhoto.findViewById(R.id.imv_person_3);
        mImvPersons[3] = mLayoutPhoto.findViewById(R.id.imv_person_4);
        mImvPersons[4] = mLayoutPhoto.findViewById(R.id.imv_person_5);
        mBtnViewMore = mLayoutPhoto.findViewById(R.id.btn_see_more);

        mTvName = mLayoutHeader.findViewById(R.id.tv_name);
        mTvDateOfBirth = mLayoutHeader.findViewById(R.id.tv_date_of_birth);
        mTvPlaceOfBirth = mLayoutHeader.findViewById(R.id.tv_place_of_birth);
        mTvDepartment = mLayoutHeader.findViewById(R.id.tv_type);
        mImvActor = mLayoutHeader.findViewById(R.id.imv_actor);
    }

    @Override
    public void loadInformationSuccess(PersonInfo info) {
        mTvBiography.setText(info.getBiography());
        mTvName.setText(info.getName());
        mTvPlaceOfBirth.setText(info.getPlaceOfBirth());
        mTvDateOfBirth.setText(info.getBirthday());
        mTvDepartment.setText(info.getKnownForDepartment());
        Picasso.with(PersonActivity.this)
                .load("https://image.tmdb.org/t/p/w780" + info.getProfilePath())
                .into(mImvActor);
    }

    @Override
    public void loadInformationFailed(String msg) {
        Log.d(TAG + ".loadInformationFailed", msg);
    }

    @Override
    public void loadImagesSuccess(PersonImage image) {
        List<Profiles> profiles = image.getProfiles();

        if (profiles.size() < 5) {
            for (int i = profiles.size(); i < 5; i++) {

                mImvPersons[i].setVisibility(View.GONE);
            }
            mBtnViewMore.setVisibility(View.GONE);
        } else {
            if (profiles.size() == 5) mBtnViewMore.setVisibility(View.GONE);
            else {
                mBtnViewMore.setText("View more " + profiles.size() + " photos");
            }
        }

        int limit = Math.min(5, profiles.size());
        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(3)
                .cornerRadiusDp(30)
                .oval(false)
                .build();

        for (int i = 0; i < limit; i++) {
            Picasso.with(PersonActivity.this)
                    .load("https://image.tmdb.org/t/p/h632" + profiles.get(i).getFilePath())
                    .transform(transformation)
                    .into(mImvPersons[i]);

        }

    }

    @Override
    public void loadImagesFailed(String msg) {

    }

    @Override
    public void loadRelatedMoviesSuccess(PersonMovieCredit movieCredit) {
        mAdapter.setList(movieCredit.getCast());
    }

    @Override
    public void loadRelatedMovieFailed(String msg) {
        Log.d(TAG + ".loadRelatedMovieFailed", msg);
    }
}
