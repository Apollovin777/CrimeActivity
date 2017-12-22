package android.bignerdranch.com.crimeactivity;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import java.io.File;

public class PhotoFragment extends DialogFragment {
    private ImageView mImageView;
    private File mFile;

    public static PhotoFragment newInstance(File file){
        PhotoFragment fragment = new PhotoFragment();
        fragment.mFile = file;
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.requestWindowFeature(Window.FEATURE_SWIPE_TO_DISMISS);
        return dialog;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_photo,null);
        mImageView = view.findViewById(R.id.dialog_photo_id);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.outHeight = mImageView.getMaxHeight();
        options.outWidth = mImageView.getMaxWidth();
        Bitmap bitMap = BitmapFactory.decodeFile(mFile.getPath(), options);
        mImageView.setImageBitmap(bitMap);

        //mImageView.setImageBitmap(PictureUtils.getScaledBitmap(mFile.getPath(),getActivity()));
        return view;
    }
}
