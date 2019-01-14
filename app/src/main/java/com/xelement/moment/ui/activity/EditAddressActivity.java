package com.xelement.moment.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.AddressEntity;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.util.ToastUtil;
import com.xelement.moment.widget.custom.PublicTitleView;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/14.
 */
public class EditAddressActivity extends BaseActivity {

    @BindView(R.id.mNameValue)
    EditText mNameValue;
    @BindView(R.id.mMobileValue)
    EditText mMobileValue;
    @BindView(R.id.mRegionLabel)
    TextView mRegionLabel;
    @BindView(R.id.mDetailAddressValue)
    EditText mDetailAddressValue;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("新增地址");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_edit_address;
    }

    @Override
    protected void process() {

    }

    @OnClick(R.id.mUpdateAddressAction)
    public void addAddressAction() {
        String name = mNameValue.getText().toString().trim();
        String mobile = mMobileValue.getText().toString().trim();
        String region = mRegionLabel.getText().toString().trim();
        String detailAddress = mDetailAddressValue.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            ToastUtil.show(mContext, "请输入收件人姓名");
        } else if (TextUtils.isEmpty(mobile) || mobile.length() != 11 || !mobile.startsWith("1")) {
            ToastUtil.show(mContext, "请填写正确的手机号码");
        } else if (TextUtils.isEmpty(detailAddress)) {
            ToastUtil.show(mContext, "请输入详细地址");
        }

        AddressEntity entity = new AddressEntity();
        entity.province = "广东省";
        entity.city = "深圳市";
        entity.district = "南山区";
        entity.address_street = "粤海街道";
        entity.address_detail = detailAddress;
        entity.true_name = name;
        entity.mobile_num = mobile;


        List<AddressEntity> entities;
        String cache = PreferenceHelper.getString(Constants.ADDRESS_DATA);
        if(!TextUtils.isEmpty(cache)) {
             entities = GsonUtil.json2Array(cache, new TypeToken<List<AddressEntity>>(){});
        } else {
            entities = new ArrayList<>();
        }
        entities.add(entity);
        PreferenceHelper.putString(Constants.ADDRESS_DATA, GsonUtil.array2Json(entities));
        ToastUtil.show(mContext, "保存成功");
        finish();
    }

}
