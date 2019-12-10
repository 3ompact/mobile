package com.yingjia.mobile.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

/**
 * Created by 3ompact on 2019/10/9 15:37
 *
 */
class WelcomeAdapter : PagerAdapter {

    var countNum: Int = 1
    var context: Context? = null

    constructor()
    constructor(count: Int, c: Context) : this() {
        this.countNum = count
        this.context = c
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return view == `object`
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return count
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var iv: ImageView = ImageView(context)

        //TODO 在此处处理欢迎界面  根据position切换内容
        return iv
    }

    /**
     * 默认推荐 移除view
     */
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    /**
     *
     * 关于在recyclerview中使用databinding的示例
     *   @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    ItemSecondBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_second, parent, false);
    return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ItemSecondBinding binding = DataBindingUtil.getBinding(holder.itemView);
    binding.setUser(users.get(position));
    binding.executePendingBindings();
    }
     */

}