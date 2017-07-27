package com.company.services.sketch.Fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.company.services.sketch.Modelos.Food;
import com.company.services.sketch.Others.FoodAdapter;
import com.company.services.sketch.Others.GridSpacingItemDecoration;
import com.company.services.sketch.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class TabFragment extends Fragment {

    private RecyclerView recyclerView;
    private FoodAdapter adapter;
    private List<Food> foodList;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public TabFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TabFragment newInstance(int sectionNumber) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);

        ImageView backdrop = (ImageView) rootView.findViewById(R.id.backdrop);
        TextView title = (TextView) rootView.findViewById(R.id.titleImg);
        TextView subtitle = (TextView) rootView.findViewById(R.id.subtitleImg);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);

        // initCollapsingToolbar(rootView);

        // TODO: Dependiendo del sectionNumber se generara una lista diferente
        switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
            case 1:
                try {
                    Glide.with(getContext()).load(R.drawable.cover).into(backdrop);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                title.setText("Soups");
                subtitle.setText("Deliciosos");

                foodList = new ArrayList<>();
                adapter = new FoodAdapter(getContext(), foodList);

                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

                prepareFoods();
                break;
            case 2:
                try {
                    Glide.with(getContext()).load(R.drawable.cover).into(backdrop);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                title.setText("Beef");
                subtitle.setText("Rica");

                foodList = new ArrayList<>();
                adapter = new FoodAdapter(getContext(), foodList);

                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

                prepareFoods();
                break;

            case 3:
                try {
                    Glide.with(getContext()).load(R.drawable.cover).into(backdrop);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                title.setText("Beer");
                subtitle.setText("Refrescante");

                foodList = new ArrayList<>();
                adapter = new FoodAdapter(getContext(), foodList);

                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

                prepareFoods();
                break;
        }



        return rootView;
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     *
    private void initCollapsingToolbar(View view) {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }*/

    /**
     * Adding few albums for testing
     */
    private void prepareFoods() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,};

        Food a = new Food("Ramen", 49.90, "Noodles with pork and egg", covers[0]);
        foodList.add(a);

        a = new Food("Makis", 60.59, "Makis perrones :v", covers[1]);
        foodList.add(a);

        a = new Food("Curry", 50.90, "Arroz y algo más xDxDxD", covers[2]);
        foodList.add(a);

        a = new Food("Makis", 60.59, "Más Makis perrones alv", covers[3]);
        foodList.add(a);

        a = new Food("Gyudoon", 70.59, "No se que sea pero ahi esta :v", covers[4]);
        foodList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}