package data;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static final String SHARE_PREFERENCES_APP = "sharedPreferences";
    public static final String KEY_USER = "key_user";
    public static final String KEY_USER_PROFILE = "key_user_profile";

    public static final String KEY_MONEY = "key_money";

    public static Bitmap convertToBitmapFromAssets(Context context, String nameImage){
        AssetManager assetManager= context.getAssets();
        try{
            InputStream inputStream= assetManager.open("images/"+nameImage);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
