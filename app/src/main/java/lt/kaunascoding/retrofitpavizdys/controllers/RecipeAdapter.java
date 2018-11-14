package lt.kaunascoding.retrofitpavizdys.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import lt.kaunascoding.retrofitpavizdys.R;
import lt.kaunascoding.retrofitpavizdys.model.entities.RecipeVO;

public class RecipeAdapter extends ArrayAdapter<RecipeVO> {
    public RecipeAdapter(Context context, List<RecipeVO> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RecipeVO item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_recipe, parent, false);
        }


        TextView labeld = (TextView) convertView.findViewById(R.id.recipeId);
        TextView labeName = (TextView) convertView.findViewById(R.id.recipeName);
        TextView labeDescription = (TextView) convertView.findViewById(R.id.recipeDescription);


        labeld.setText(item.id+"");
        labeName.setText(item.name);
        labeDescription.setText(item.description);


        return convertView;
    }
}
