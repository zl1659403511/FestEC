package com.abc.latte.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.abc.latte.Util.file.FileUtil;
import com.abc.latte.app.Latte;
import com.abc.latte.net.callback.IRequest;
import com.abc.latte.net.callback.ISuccess;

import java.io.File;
import java.io.InputStream;
import java.security.interfaces.DSAParams;

import okhttp3.ResponseBody;

/**
 * Created by admin on 2017/8/3.
 */

public class SaveFileTask extends AsyncTask<Object,Void,File> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    public SaveFileTask(IRequest request, ISuccess success) {
        this.REQUEST = request;
        this.SUCCESS = success;
    }


    @Override
    protected File doInBackground(Object... objects) {
         String downloadDir = (String) objects[0];
         String extension = (String) objects[1];
        final ResponseBody body = (ResponseBody) objects[2];
        final String name = (String) objects[3];
        final InputStream is = body.byteStream();
        if (null==downloadDir) {
            downloadDir="down_loads";
        }
        if (TextUtils.isEmpty(extension)) {
            extension="";
        }
        if (null==name) {
            return FileUtil.writeToDisk(is,downloadDir,extension.toUpperCase(),extension);
        }else {
            return FileUtil.writeToDisk(is,downloadDir,name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (null!=SUCCESS) {
            SUCCESS.onSuccess(file.getPath());
        }
        if(REQUEST!=null){
            REQUEST.onRequestEnd();
        }
          autoInstallApk(file);
    }
    private void autoInstallApk(File file){
        if (FileUtil.getExtension(file.getPath()).equals("apk")) {
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
            Latte.getApplicationContext().startActivity(install);
        }
    }
}
