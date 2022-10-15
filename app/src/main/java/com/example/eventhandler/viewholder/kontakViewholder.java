package com.example.eventhandler.viewholder;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eventhandler.R;

public class kontakViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView _txtNama, _txtNoHP;
    ImageView _foto;
    Context _context;

    public kontakViewholder(@NonNull View itemView) {
        super(itemView);
        _context = itemView.getContext();
        _txtNama = itemView.findViewById(R.id.txViewNama);
        _txtNoHP = itemView.findViewById(R.id.txNoHp);
        _txtNoHP.setOnClickListener(this);
        _foto = itemView.findViewById(R.id.imFoto);
    }

    @Override
    public void onClick(View view) {

        Uri uri = Uri.parse("tel:"+ _txtNoHP.getText().toString());
        Intent noHp = new Intent(Intent.ACTION_DIAL, uri);
        _context.startActivity(noHp);
    }

    public TextView get_txtNama() {
        return _txtNama;
    }

    public TextView get_txtNoHP() {
        return _txtNoHP;
    }

    public ImageView get_foto() {
        return _foto;
    }

    public Context get_context() {
        return _context;
    }
}
