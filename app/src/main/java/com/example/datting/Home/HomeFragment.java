package com.example.datting.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import com.example.datting.Meet.CardStackCallback;
import com.example.datting.Meet.MeetAdapter;
import com.example.datting.Model.Meet;
import com.example.datting.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    private CardStackLayoutManager mng;
    private MeetAdapter adapter;
    private TextView tv;
    ArrayList<Meet> meets = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.meet_fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addList();

        CardStackView cardStackView = view.findViewById(R.id.CardStackView);

        mng = new CardStackLayoutManager(getContext(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d(TAG, "onCardDragging: d=" + direction.name() + "ratio" + ratio);
            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardDragging: p=" + mng.getTopPosition() + "d=" + direction);
                if (direction == Direction.Right){}
                if (direction == Direction.Left){}

                // Paginating(Phân trang)
                if (mng.getTopPosition() == adapter.getItemCount() - 5){
                    paginate();
                }
            }

            @Override
            public void onCardRewound() {
                Log.d(TAG, "onCardRewound: " + mng.getTopPosition());
                addList();
            }

            @Override
            public void onCardCanceled() {
                Log.d(TAG, "onCardCanceled: " + mng.getTopPosition());
                addList();
            }

            @Override
            public void onCardAppeared(View view, int position) {
                tv = view.findViewById(R.id.item_name);
                Log.d(TAG, "onCardCanceled: " + position + ", name" + tv.getText());
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                tv = view.findViewById(R.id.item_name);
                Log.d(TAG, "onCardCanceled: " + position + ", name" + tv.getText());
            }
        });

        //Xử lí lướt ảnh CardStackView
        mng.setStackFrom(StackFrom.None);
        mng.setVisibleCount(3);
        mng.setTranslationInterval(8.0f);
        mng.setScaleInterval(0.95f);
        mng.setSwipeThreshold(0.3f);
        mng.setMaxDegree(20.0f);
        mng.setDirections(Direction.HORIZONTAL);
        mng.setCanScrollHorizontal(true);
        mng.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        mng.setOverlayInterpolator(new LinearInterpolator());

        adapter = new MeetAdapter(meets, getContext());
        cardStackView.setLayoutManager(mng);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
        //=======================================
    }

    //xử lí phân trang
    private void paginate(){
        ArrayList<Meet> old = adapter.getMeets();
        ArrayList<Meet> baru = new ArrayList<>(meets);
        CardStackCallback callback = new CardStackCallback(old,baru);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapter.setMeets(baru);
        hasil.dispatchUpdatesTo(adapter);
     //==================================================================
    }

    private void addList(){
        meets.add(new Meet(R.drawable.avt, "Ji Soo", "20", "Korea"));
        meets.add(new Meet(R.drawable.avt32, "Nam Nguyen", "24", "Viet Nam"));
        meets.add(new Meet(R.drawable.avt9, "Kim Anh", "21", "Viet Nam"));
        meets.add(new Meet(R.drawable.avt10, "Kiều Anh", "30", "Indian"));
        meets.add(new Meet(R.drawable.avt11, "Nam Anh", "40", "Korea"));
        meets.add(new Meet(R.drawable.avt12, "Johny", "25", "America"));
        meets.add(new Meet(R.drawable.avt13, "Jack", "25", "Italia"));
        meets.add(new Meet(R.drawable.avt14, "Ji Soo", "25", "Australia"));
        meets.add(new Meet(R.drawable.avt15, "Ji Soo", "25", "Combodia"));
        meets.add(new Meet(R.drawable.avt16, "Ji Soo", "25", "Thai Lan"));
        meets.add(new Meet(R.drawable.avt17, "Ji Soo", "25", "Laos"));
        meets.add(new Meet(R.drawable.avt18, "Maria Ozawa", "25", "Singapore"));
        meets.add(new Meet(R.drawable.avt19, "Marria Rivera", "25", "England"));
        meets.add(new Meet(R.drawable.avt20, "Park Hang Seo", "25", "France"));
        meets.add(new Meet(R.drawable.avt21, "Périasa", "25", "Virtue"));
        meets.add(new Meet(R.drawable.avt22, "Ji Soo", "25", "Poland"));
        meets.add(new Meet(R.drawable.avt23, "Ji Soo", "25", "Belgium"));
        meets.add(new Meet(R.drawable.avt24, "Ji Soo", "25", "Austria"));
        meets.add(new Meet(R.drawable.avt25, "Ji Soo", "25", "Netherlands"));
        meets.add(new Meet(R.drawable.avt26, "Ji Soo", "25", "New ZeaLand"));
        meets.add(new Meet(R.drawable.avt27, "Ji Soo", "25", "China"));
        meets.add(new Meet(R.drawable.avt28, "Ji Soo", "25", "Hong Kong"));
        meets.add(new Meet(R.drawable.avt29, "Ji Soo", "25", "North Korea"));
        meets.add(new Meet(R.drawable.avt30, "Ji Soo", "25", "Japan"));
        meets.add(new Meet(R.drawable.avt31, "Ji Soo", "25", "Korea"));
    }
}
