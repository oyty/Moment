package com.xelement.moment.widget.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.entity.AddressEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2018/8/31.
 */
public class AddressItemView extends FrameLayout {
    private Context mContext;

    @BindView(R.id.mStateImg)
    ImageView mStateImg;
    @BindView(R.id.mNicknameLabel)
    TextView mNicknameLabel;
    @BindView(R.id.mMobileLabel)
    TextView mMobileLabel;
    @BindView(R.id.mDefaultView)
    TextView mDefaultView;
    @BindView(R.id.mDetailAddressLabel)
    TextView mDetailAddressLabel;
    @BindView(R.id.mBaseAction)
    View mBaseAction;
    private AddressEntity entity;

    public AddressItemView(@NonNull Context context) {
        this(context, null);
    }

    public AddressItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddressItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_address_item, this);
        ButterKnife.bind(this, view);

        // long click to delete

        // short click to choose
    }


    public void refresh(AddressEntity entity) {
        this.entity = entity;
        mNicknameLabel.setText(entity.true_name);
        mMobileLabel.setText(entity.mobile_num);
        mDefaultView.setVisibility(entity.isDefault() ? VISIBLE : GONE);
        mDetailAddressLabel.setText(String.format("%s%s%s%s%s", entity.province, entity.city, entity.district, TextUtils.isEmpty(entity.address_street) ? "" : entity.address_street, entity.address_detail));
    }

    @OnClick(R.id.mEditAction)
    public void editAction() {
//        Intent intent = new Intent(mContext, EditAddressActivity.class);
//        intent.putExtra(Constants.ADDRESS_ENTITY, entity);
//        mContext.startActivity(intent);
    }

}
