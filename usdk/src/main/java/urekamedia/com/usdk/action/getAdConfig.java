package urekamedia.com.usdk.action;

import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import urekamedia.com.usdk.UrekaSdk;
import urekamedia.com.usdk.api.ApiService;
import urekamedia.com.usdk.interfaces.iConfig;
import urekamedia.com.usdk.model.adConfig;

public class getAdConfig {
    public static void call(int time, String id) {
        getConfig(time, id);
    }

    public static void getConfig(final int time, final String android_id){
        ApiService.apiservice.getAdConfig(time, android_id).enqueue(new Callback<adConfig>() {
            @Override
            public void onResponse(Call<adConfig> call, Response<adConfig> response) {
                adConfig config = response.body();
                if(config!= null) {
                    String type = config.getType();
                    if(type.equals("banner")){
                        getAdBanner.init(time, android_id);
                    }else{
                    }
                }
            }

            @Override
            public void onFailure(Call<adConfig> call, Throwable t) {
                Log.d("TAG-adConfig-onFailure", "onFailure: "+t.getMessage());
                Toast.makeText(UrekaSdk.getContext(),"Error request API",Toast.LENGTH_LONG).show();
            }
        });
    }

    public static void getConfigAds(final int time, final String android_id, @Nullable final iConfig callback){
        ApiService.apiservice.getAdConfig(time, android_id).enqueue(new Callback<adConfig>() {
            @Override
            public void onResponse(Call<adConfig> call, Response<adConfig> response) {
                adConfig config = response.body();
                if(config!= null) callback.onSuccess(config);
            }

            @Override
            public void onFailure(Call<adConfig> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
