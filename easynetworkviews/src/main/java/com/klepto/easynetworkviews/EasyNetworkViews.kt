package com.klepto.easynetworkviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.Toast

class EasyNetworkViews  @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0):FrameLayout(context, attrs, defStyle) {

    private var mErrorLayoutResId = -1
    private var mContentLayoutResId = -1
    private var mLoadingLayoutResId = -1
    private lateinit var mLoadingLayoutView: View
    private lateinit var mContentLayoutView: View
    private lateinit var mErrorLayoutView: View
    var state = STATE.CONTENT
    private val fadeInAnimation = AnimationUtils.loadAnimation(context,R.anim.fadein)
    init {
        fadeInAnimation.interpolator = AccelerateDecelerateInterpolator()
    }
    enum class STATE{
        ERROR,LOADING,CONTENT
    }

    fun setProgressLayout(resId:Int){
        mLoadingLayoutResId = resId
        mLoadingLayoutView = LayoutInflater.from(context).inflate(mLoadingLayoutResId,null)
    }

    fun getProgressView():View{
        return mLoadingLayoutView
    }

    fun showProgress(overlay:Boolean  = false,animate:Boolean = true){
        if(mLoadingLayoutResId == -1){
            mLoadingLayoutResId = R.layout.progress_layout
            mLoadingLayoutView = LayoutInflater.from(context).inflate(mLoadingLayoutResId,null)
        }
        if(!overlay){
            this.removeAllViews()
        }

        this.addView(mLoadingLayoutView)
        if(animate)
        mLoadingLayoutView.startAnimation(fadeInAnimation)

    }

    fun setContentLayout(resId:Int){
        mContentLayoutResId = resId
        mContentLayoutView = LayoutInflater.from(context).inflate(mContentLayoutResId,null)

    }

    fun getContentView():View{
        return mContentLayoutView

    }

    fun showContent(animate:Boolean = true){
        if(mContentLayoutResId == -1){
            throw ViewNotDefinedException("You have not defined a content layout." +
                    "Use setContentLayout(int resId) to set it")
        }
        this.removeAllViews()
        this.addView(mContentLayoutView)
        if(animate)
            mContentLayoutView.startAnimation(fadeInAnimation)
        state = STATE.CONTENT
    }

    fun setErrorLayout(resId:Int){
        mErrorLayoutResId = resId
        mErrorLayoutView = LayoutInflater.from(context).inflate(mErrorLayoutResId,null)

    }

    fun getErrorView():View?{
        if(mErrorLayoutResId != -1)
            return mErrorLayoutView
        return null
    }

    fun showError(animate:Boolean = true){
        state = STATE.ERROR
        if(mErrorLayoutResId == -1){
            Toast.makeText(context,"An Error has Occured",Toast.LENGTH_SHORT).show()

        }
        else{
            this.removeAllViews()
            this.addView(mErrorLayoutView)
            if(animate)
            mErrorLayoutView.startAnimation(fadeInAnimation)
        }
    }




}