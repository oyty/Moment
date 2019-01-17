package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.AddressEntity;
import com.xelement.moment.ui.activity.AddressActivity;
import com.xelement.moment.ui.activity.EditAddressActivity;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2018/8/31.
 */
public class OrderAddressView extends FrameLayout {

    private static final int PROGRESS = 0x01;
    private static final int ADD_ADDRESS = 0x02;
    private static final int ADDRESS_DATA = 0x03;
    private Context mContext;

    @BindView(R.id.mNicknameLabel)
    TextView mNicknameLabel;
    @BindView(R.id.mMobileLabel)
    TextView mMobileLabel;
    @BindView(R.id.mDefaultView)
    TextView mDefaultView;
    @BindView(R.id.mDetailAddressLabel)
    TextView mDetailAddressLabel;
    @BindView(R.id.mProgressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.mAddAddressAction)
    TextView mAddAddressAction;
    @BindView(R.id.mAddressLayout)
    View mAddressLayout;
    @BindView(R.id.mArrowImg)
    View mArrowImg;
    @BindView(R.id.mBaseAction)
    View mBaseAction;
    @BindView(R.id.mBaseLineView)
    View mBaseLineView;

    private int currentState = PROGRESS;
    private AddressEntity choosedEntity;
    private boolean allUpdate;

    public OrderAddressView(@NonNull Context context) {
        this(context, null);
    }

    public OrderAddressView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderAddressView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_order_address, this);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.mAddAddressAction)
    public void addAddressAction() {
        Intent intent = new Intent(mContext, EditAddressActivity.class);
        mContext.startActivity(intent);
    }

    @OnClick(R.id.mBaseAction)
    public void baseAction() {
        if(currentState == ADDRESS_DATA && mAddressLayout.isEnabled() && choosedEntity != null) {
            Intent intent = new Intent(mContext, AddressActivity.class);
            mContext.startActivity(intent);
        }
    }

    public void refresh() {

        String cache = PreferenceHelper.getString(Constants.ADDRESS_DATA);
        if(!TextUtils.isEmpty(cache)) {
            List<AddressEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<AddressEntity>>(){});
            updateAddress(entities.get(0));
        } else {
            currentState = ADD_ADDRESS;
            mAddAddressAction.setVisibility(VISIBLE);
            mAddressLayout.setVisibility(GONE);
        }

    }

    private void updateOrderAddressDefault(List<AddressEntity> entities) {
        for(AddressEntity entity : entities) {
            if(entity.equals(choosedEntity) && entity.isDefault()) {
                mDefaultView.setVisibility(VISIBLE);
                break;
            }
        }
        // 提交订单后，控制这条线
        if(allUpdate) {
            // 地址线，重新查询邮费
        }
    }

    private void updateAddress(AddressEntity entity) {
        choosedEntity = entity;
        currentState = ADDRESS_DATA;
        mAddressLayout.setVisibility(VISIBLE);
        mAddAddressAction.setVisibility(GONE);
        mNicknameLabel.setText(entity.true_name);
        mMobileLabel.setText(entity.mobile_num);
        mDefaultView.setVisibility(entity.isDefault() ? VISIBLE : GONE);
        mDetailAddressLabel.setText(String.format("%s%s%s%s", entity.province, entity.city, entity.district, entity.address_detail));
        // 地址线，重新查询邮费
    }

    public void updateChoosedAddress(AddressEntity entity) {
        if(entity == null) {
            choosedEntity = null;
            currentState = ADD_ADDRESS;
            mAddressLayout.setVisibility(GONE);
            mAddAddressAction.setVisibility(VISIBLE);
        } else {
            updateAddress(entity);
        }
    }

    public boolean isAvailable() {
        return currentState == ADDRESS_DATA;
    }

    public AddressEntity getAddress() {
        return choosedEntity;
    }

    /**
     * 提交后的订单
     */
    public void refresh(AddressEntity entity, boolean allowUpdate) {
        choosedEntity = entity;
        choosedEntity.isOrderAddress = true;
        this.allUpdate = allowUpdate;
        mProgressBar.setVisibility(GONE);
        currentState = ADDRESS_DATA;
        mAddressLayout.setVisibility(VISIBLE);
        mAddAddressAction.setVisibility(GONE);
        mNicknameLabel.setText(entity.true_name);
        mMobileLabel.setText(entity.mobile_num);
        mDefaultView.setVisibility(GONE);
        mBaseLineView.setVisibility(GONE);
        mDetailAddressLabel.setText(String.format("%s%s%s%s", entity.province, entity.city, entity.district, entity.address_detail));
        if(!allowUpdate) {
            mArrowImg.setVisibility(GONE);
            mAddressLayout.setEnabled(false);
        } else {
            // 此处只用来初始化订单里面的地址是否是默认地址
        }
    }

}
