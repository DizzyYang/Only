package dizzy.only;

import android.app.Activity;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import dizzy.only.annotation.OnlyLayoutType;
import dizzy.only.impl.IOnlyView;
import dizzy.only.state.OnlyStateView;
import dizzy.only.statusbar.OnlyStatusBarView;
import dizzy.only.toolbar.OnlyToolbarView;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：OnlyBuilder
 */
public class OnlyBuilder {

    private IOnlyView mIOnlyView;
    private OnlyStateView.OnFocusListener mOnFocusListener;
    private OnlyStateView.OnEmptyListener mOnEmptyListener;
    private OnlyStateView.OnErrorListener mOnErrorListener;

    public OnlyBuilder(IOnlyView iOnlyView,
                       OnlyStateView.OnFocusListener onFocusListener,
                       OnlyStateView.OnEmptyListener onEmptyListener,
                       OnlyStateView.OnErrorListener onErrorListener) {
        this.mIOnlyView = iOnlyView;
        this.mOnFocusListener = onFocusListener;
        this.mOnEmptyListener = onEmptyListener;
        this.mOnErrorListener = onErrorListener;
    }

    private int mOnlyLayoutType;
    private int mOnlyBackground;
    private boolean mOnlyStatusBarState;
    private boolean mOnlyStatusBarDark;
    private int mOnlyStatusBarColor;
    private boolean mOnlyToolbarState;
    private int mOnlyToolbarColor;
    private boolean mOnlyLayoutState;
    private int mOnlyLoadingId;
    private int mOnlyContentId;
    private int mOnlyEmptyId;
    private int mOnlyErrorId;

    /**
     * 设置根布局类型
     *
     * @param onlyLayoutType
     */
    public void setOnlyLayoutType(@OnlyLayoutType int onlyLayoutType) {
        this.mOnlyLayoutType = onlyLayoutType;
    }

    public int getOnlyLayoutType() {
        return mOnlyLayoutType;
    }

    /**
     * 设置根布局颜色
     *
     * @param onlyBackground
     */
    public void setOnlyBackground(@ColorInt int onlyBackground) {
        this.mOnlyBackground = onlyBackground;
    }

    public int getOnlyBackground() {
        if (mOnlyBackground != 0) {
            return mOnlyBackground;
        }
        return mIOnlyView.onlyBackground();
    }

    /**
     * 控制状态栏状态
     *
     * @param onlyStatusBarState
     */
    public void setOnlyStatusBarState(boolean onlyStatusBarState) {
        this.mOnlyStatusBarState = onlyStatusBarState;
    }

    public boolean getOnlyStatusBarState() {
        return mOnlyStatusBarState;
    }

    /**
     * 设置状态栏色深
     *
     * @param onlyStatusBarDark
     */
    public void setOnlyStatusBarDark(boolean onlyStatusBarDark) {
        this.mOnlyStatusBarDark = onlyStatusBarDark;
    }

    public boolean getOnlyStatusBarDark() {
        return mOnlyStatusBarDark;
    }

    /**
     * 设置状态栏颜色
     *
     * @param onlyStatusBarColor
     */
    public void setOnlyStatusBarColor(@ColorInt int onlyStatusBarColor) {
        this.mOnlyStatusBarColor = onlyStatusBarColor;
    }

    public int getOnlyStatusBarColor() {
        if (mOnlyStatusBarColor != 0) {
            return mOnlyStatusBarColor;
        }
        return mIOnlyView.onlyStatusBarColor();
    }

    /**
     * 控制标题栏状态
     *
     * @param onlyToolbarState
     */
    public void setOnlyToolbarState(boolean onlyToolbarState) {
        this.mOnlyToolbarState = onlyToolbarState;
    }

    public boolean getOnlyToolbarState() {
        return mOnlyToolbarState;
    }

    /**
     * 设置标题栏颜色
     *
     * @param onlyToolbarColor
     */
    public void setOnlyToolbarColor(@ColorInt int onlyToolbarColor) {
        this.mOnlyToolbarColor = onlyToolbarColor;
    }

    public int getOnlyToolbarColor() {
        if (mOnlyToolbarColor != 0) {
            return mOnlyToolbarColor;
        }
        return mIOnlyView.onlyToolbarColor();
    }

    /**
     * 控制状态布局状态
     *
     * @param onlyLayoutState
     */
    public void setOnlyLayoutState(boolean onlyLayoutState) {
        this.mOnlyLayoutState = onlyLayoutState;
    }

    public boolean getOnlyLayoutState() {
        return mOnlyLayoutState;
    }

    /**
     * 加载布局
     *
     * @param onlyLoadingId
     */
    public void setOnlyLoadingId(@LayoutRes int onlyLoadingId) {
        this.mOnlyLoadingId = onlyLoadingId;
    }

    public int getOnlyLoadingId() {
        if (mOnlyLoadingId != 0) {
            return mOnlyLoadingId;
        }
        return mIOnlyView.onlyLoadingId();
    }

    /**
     * 内容布局
     *
     * @param onlyContentId
     */
    public void setOnlyContentId(@LayoutRes int onlyContentId) {
        this.mOnlyContentId = onlyContentId;
    }

    public int getOnlyContentId() {
        return mOnlyContentId;
    }

    /**
     * 缺省布局
     *
     * @param onlyEmptyId
     */
    public void setOnlyEmptyId(@LayoutRes int onlyEmptyId) {
        this.mOnlyEmptyId = onlyEmptyId;
    }

    public int getOnlyEmptyId() {
        if (mOnlyEmptyId != 0) {
            return mOnlyEmptyId;
        }
        return mIOnlyView.onlyEmptyId();
    }

    /**
     * 错误布局
     *
     * @param onlyErrorId
     */
    public void setOnlyErrorId(@LayoutRes int onlyErrorId) {
        this.mOnlyErrorId = onlyErrorId;
    }

    public int getOnlyErrorId() {
        if (mOnlyErrorId != 0) {
            return mOnlyErrorId;
        }
        return mIOnlyView.onlyErrorId();
    }

    private OnlyStatusBarView mOnlyStatusBarView;
    private OnlyToolbarView mOnlyToolbarView;
    private OnlyStateView mOnlyStateView;

    public OnlyStatusBarView getOnlyStatusBarView() {
        return mOnlyStatusBarView;
    }

    public OnlyToolbarView getOnlyToolbarView() {
        return mOnlyToolbarView;
    }

    public OnlyStateView getOnlyStateView() {
        return mOnlyStateView;
    }

    protected View create(Activity activity) {
        if (getOnlyContentId() != 0) {
            switch (getOnlyLayoutType()) {
                case OnlyLayoutType.NONE:
                    return View.inflate(activity, getOnlyContentId(), null);
                case OnlyLayoutType.LINEAR:
                    if (getOnlyStatusBarState() || getOnlyToolbarState() || getOnlyLayoutState()) {
                        LinearLayout linearLayout = null;
                        if (getOnlyStatusBarState() || getOnlyToolbarState()) {
                            linearLayout = new LinearLayout(activity);
                            linearLayout.setLayoutParams(getMhMhParams());
                            linearLayout.setOrientation(LinearLayout.VERTICAL);
                            linearLayout.setBackgroundColor(getOnlyBackground());
                            linearLayout.setId(R.id.only_root_layout);
                        }
                        if (getOnlyStatusBarState()) {
                            mOnlyStatusBarView = getOnlyStatusBarView(activity);
                            if (linearLayout != null) {
                                linearLayout.addView(mOnlyStatusBarView);
                            }
                        }
                        if (getOnlyToolbarState()) {
                            mOnlyToolbarView = getOnlyToolbarView(activity);
                            if (linearLayout != null) {
                                linearLayout.addView(mOnlyToolbarView);
                            }
                        }
                        if (getOnlyLayoutState()) {
                            mOnlyStateView = getOnlyStateView(activity);
                            if (linearLayout != null) {
                                linearLayout.addView(mOnlyStateView);
                                return linearLayout;
                            } else {
                                mOnlyStateView.setBackgroundColor(getOnlyBackground());
                                return mOnlyStateView;
                            }
                        } else {
                            if (linearLayout != null) {
                                linearLayout.addView(
                                        View.inflate(activity, getOnlyContentId(), null),
                                        getMhMhParams()
                                );
                                return linearLayout;
                            }
                        }
                    } else {
                        return View.inflate(activity, getOnlyContentId(), null);
                    }
                case OnlyLayoutType.FRAME:
                    if (getOnlyStatusBarState() || getOnlyToolbarState() || getOnlyLayoutState()) {
                        FrameLayout frameLayout = null;
                        if (getOnlyStatusBarState() || getOnlyToolbarState()) {
                            frameLayout = new FrameLayout(activity);
                            frameLayout.setLayoutParams(getMhMhParams());
                            frameLayout.setBackgroundColor(getOnlyBackground());
                            frameLayout.setId(R.id.only_root_layout);
                        }
                        LinearLayout linearLayout = null;
                        if (getOnlyStatusBarState() && getOnlyToolbarState()) {
                            linearLayout = new LinearLayout(activity);
                            linearLayout.setLayoutParams(getMhWpParams());
                            linearLayout.setOrientation(LinearLayout.VERTICAL);
                        }
                        if (getOnlyStatusBarState()) {
                            mOnlyStatusBarView = getOnlyStatusBarView(activity);
                            if (linearLayout != null) {
                                linearLayout.addView(mOnlyStatusBarView);
                            } else {
                                if (frameLayout != null) {
                                    frameLayout.addView(mOnlyStatusBarView);
                                }
                            }
                        }
                        if (getOnlyToolbarState()) {
                            mOnlyToolbarView = getOnlyToolbarView(activity);
                            if (linearLayout != null) {
                                linearLayout.addView(mOnlyToolbarView);
                            } else {
                                if (frameLayout != null) {
                                    frameLayout.addView(mOnlyToolbarView);
                                }
                            }
                        }
                        if (linearLayout != null) {
                            if (frameLayout != null) {
                                frameLayout.addView(linearLayout);
                            }
                        }
                        if (getOnlyLayoutState()) {
                            mOnlyStateView = getOnlyStateView(activity);
                            if (frameLayout != null) {
                                frameLayout.addView(mOnlyStateView, 0);
                                return frameLayout;
                            } else {
                                mOnlyStateView.setBackgroundColor(getOnlyBackground());
                                return mOnlyStateView;
                            }
                        } else {
                            if (frameLayout != null) {
                                frameLayout.addView(
                                        View.inflate(activity, getOnlyContentId(), null), 0,
                                        getMhMhParams()
                                );
                                return frameLayout;
                            }
                        }
                    } else {
                        return View.inflate(activity, getOnlyContentId(), null);
                    }
                default:
                    return View.inflate(activity, getOnlyContentId(), null);
            }
        } else {
            return null;
        }
    }

    private OnlyStatusBarView getOnlyStatusBarView(Activity activity) {
        OnlyStatusBarView onlyStatusBarView = new OnlyStatusBarView(activity);
        onlyStatusBarView.setLayoutParams(getMhWpParams());
        onlyStatusBarView.openStatusBarTransparent(activity);
        onlyStatusBarView.setBackgroundColor(getOnlyStatusBarColor(), getOnlyStatusBarDark());
        onlyStatusBarView.setId(R.id.only_statusbar_view);
        return onlyStatusBarView;
    }

    private OnlyToolbarView getOnlyToolbarView(Activity activity) {
        OnlyToolbarView onlyToolbarView = new OnlyToolbarView(activity);
        onlyToolbarView.setLayoutParams(getMhWpParams());
        onlyToolbarView.setBackgroundColor(getOnlyToolbarColor());
        onlyToolbarView.setId(R.id.only_toolbar_view);
        return onlyToolbarView;
    }

    private OnlyStateView getOnlyStateView(Activity activity) {
        OnlyStateView onlyStateView = new OnlyStateView(activity);
        onlyStateView.setLayoutParams(getMhMhParams());
        onlyStateView.setOnFocusListener(mOnFocusListener);
        onlyStateView.setOnEmptyListener(mOnEmptyListener);
        onlyStateView.setOnErrorListener(mOnErrorListener);
        onlyStateView.setLoadingView(getOnlyLoadingId());
        onlyStateView.setContentView(getOnlyContentId());
        onlyStateView.setEmptyView(getOnlyEmptyId());
        onlyStateView.setErrorView(getOnlyErrorId());
        onlyStateView.showLoading();
        onlyStateView.setId(R.id.only_state_view);
        return onlyStateView;
    }

    private ViewGroup.LayoutParams mMhMhParams;
    private ViewGroup.LayoutParams mMhWpParams;

    private ViewGroup.LayoutParams getMhMhParams() {
        if (mMhMhParams == null) {
            mMhMhParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
        }
        return mMhMhParams;
    }

    private ViewGroup.LayoutParams getMhWpParams() {
        if (mMhWpParams == null) {
            mMhWpParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
        } else {
            mMhWpParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            mMhWpParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        return mMhWpParams;
    }

}
