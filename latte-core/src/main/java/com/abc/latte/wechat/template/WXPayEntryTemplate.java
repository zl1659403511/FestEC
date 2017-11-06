package com.abc.latte.wechat.template;
import android.widget.Toast;
import com.abc.latte.activitys.ProxyActivity;
import com.abc.latte.delegate.LetteDelegate;
public class WXPayEntryTemplate extends ProxyActivity {

   /* @Override
    protected void onPaySuccess() {
        Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onPayFail() {
        Toast.makeText(this, "支付失败", Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onPayCancel() {
        Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }
*/
    @Override
    public LetteDelegate setRootDelegate() {
        return null;
    }
}
