package ptit.cuonghq.hny.detail;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import ptit.cuonghq.hny.R;
import ptit.cuonghq.hny.person.PersonActivity;

public class DetailPersonAdapter extends RecyclerView.Adapter<DetailPersonAdapter.DetailPersonViewHolder> {

    private boolean actorList;
    private List<Crew> mListCrew;
    private List<Cast> mListCast;
    private AppCompatActivity mActivity;

    public DetailPersonAdapter(boolean actorList, AppCompatActivity mActivity) {
        this.actorList = actorList;
        this.mActivity = mActivity;
    }

    public void setListCrew(List<Crew> mList) {
        this.mListCrew = mList;
        notifyDataSetChanged();
    }

    public void setListCast(List<Cast> mList) {
        mListCast = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DetailPersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_detail_rv_person_item, viewGroup, false);
        return new DetailPersonViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailPersonViewHolder detailPersonViewHolder, int i) {
        Person person = (actorList) ? mListCast.get(i) : mListCrew.get(i);
        detailPersonViewHolder.bind(person);
    }

    @Override
    public int getItemCount() {
        return (actorList) ? ((mListCast == null) ? 0 : mListCast.size()) : ((mListCrew == null) ? 0 : mListCrew.size());
    }

    class DetailPersonViewHolder extends RecyclerView.ViewHolder {

        Person mPerson;
        AppCompatImageView mImvProfile;
        AppCompatTextView mTvName;
        AppCompatTextView mTvDescription;
        AppCompatImageButton mBtnFavorite;

        public DetailPersonViewHolder(@NonNull View itemView) {
            super(itemView);
            initView();
            addListener();
        }

        private void addListener() {
            mImvProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = PersonActivity.getInstance(itemView.getContext(), mPerson.getId());
                    mActivity.startActivity(intent);
                }
            });
        }

        private void initView() {
            mImvProfile = itemView.findViewById(R.id.imv_actor);
            mTvName = itemView.findViewById(R.id.tv_name);
            mTvDescription = itemView.findViewById(R.id.tv_role);
            mBtnFavorite = itemView.findViewById(R.id.btn_favorite);
        }

        void setupUI() {
            mTvName.setText(mPerson.getName());
            Picasso.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/h632" + mPerson.getProfilePath())
                    .into(mImvProfile);

            if (mPerson instanceof Cast) {
                Cast mCast = (Cast) mPerson;
                mTvDescription.setText(mCast.getCharacter());
            }

            if (mPerson instanceof Crew) {
                Crew mCrew = (Crew) mPerson;
                mTvDescription.setText(mCrew.getJob());
            }
        }

        void bind(Person mPerson) {
            this.mPerson = mPerson;
            setupUI();
        }
    }
}
