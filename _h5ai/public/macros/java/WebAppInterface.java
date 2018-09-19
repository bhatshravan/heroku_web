package inc.bs.hubli.misc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Shravan on 15-06-2017.
 */

public class WebAppInterface {
    Context mContext;
    InterstitialAd mInterstitialAd;
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
    public void end()
    {
     //   ((WEBSS))
    }


    public void showDialog(String dialogMsg){
        final AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
        builder.setCancelable(true);
        builder.setTitle("Website");
        builder.setMessage(dialogMsg);
        builder.setNegativeButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.setNeutralButton(
                "Share!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Play great games on Firetap!!");
                        sendIntent.setType("text/plain");
                        mContext.startActivity(sendIntent);
                        dialog.cancel();
                    }
                }
        );

        builder.show();
    }
 }
