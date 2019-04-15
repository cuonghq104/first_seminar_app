package ptit.cuonghq.hny.person;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import ptit.cuonghq.hny.R;
import ptit.cuonghq.hny.data.networks.models.Cast;
import ptit.cuonghq.hny.detail.DetailActivity;


public class PersonMovieCreditAdapter extends RecyclerView.Adapter<PersonMovieCreditAdapter.PersonMovieCreditViewHolder>{

    private List<Cast> mList;
    private AppCompatActivity mActivity;

    public PersonMovieCreditAdapter(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void setList(List<Cast> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonMovieCreditViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_person_movie_credit_item, viewGroup, false);
        return new PersonMovieCreditViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonMovieCreditAdapter.PersonMovieCreditViewHolder holder, int i) {
        Cast cast = mList.get(i);
        holder.bind(cast);
    }

    @Override
    public int getItemCount() {
        return (mList == null) ? 0 : mList.size();
    }

    class PersonMovieCreditViewHolder extends RecyclerView.ViewHolder {

        private Cast cast;
        private AppCompatTextView mTvMovie, mTvRole;
        private AppCompatImageView mImvMovie;

        public PersonMovieCreditViewHolder(@NonNull View itemView) {
            super(itemView);
            initView();
            addListener();
        }

        private void addListener() {
            mImvMovie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = DetailActivity.getInstance(itemView.getContext(), cast.getId());
                    mActivity.startActivity(intent);
                }
            });
        }

        private void initView() {
            mTvMovie = itemView.findViewById(R.id.tv_movie);
            mTvRole = itemView.findViewById(R.id.tv_role);
            mImvMovie = itemView.findViewById(R.id.imv_movie);
        }

        public void bind(Cast cast) {
            this.cast = cast;
            setupUI();
        }

        private void setupUI() {
            Picasso.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w780" + cast.getPosterPath())
                    .into(mImvMovie);
            mTvMovie.setText(cast.getTitle());
            mTvRole.setText(cast.getCharacter());
        }
    }
}
