package com.cursoandroidudemy.telalogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterUserList extends ArrayAdapter<Usuario> {

    private final List<Usuario> list;

    public AdapterUserList(@NonNull Context context, List<Usuario> lista) {
        super(context, 0, lista);
        this.list = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            Context ctx = getContext();
            LayoutInflater layoutInflater =
                    (LayoutInflater)ctx.
                            getSystemService(Context.
                                    LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_user_item_layout,parent, false);
        }
        Usuario users = list.get(position);
        TextView userName = view.findViewById(R.id.txtViewUserEmail);
        userName.setText(users.getEmail());

        return view;
    }
}


