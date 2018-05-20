package ch.deletescape.lawnchair.override

import android.annotation.SuppressLint
import android.content.Context
import ch.deletescape.lawnchair.iconpack.IconPackManager
import com.android.launcher3.ShortcutInfo

class ShortcutInfoProvider(private val context: Context) : CustomInfoProvider<ShortcutInfo>() {

    override fun getTitle(info: ShortcutInfo): String {
        return (info.customTitle ?: info.title) as String
    }

    override fun getDefaultTitle(info: ShortcutInfo): String {
        return info.title as String
    }

    override fun getCustomTitle(info: ShortcutInfo): String? {
        return info.customTitle as String?
    }

    override fun setTitle(info: ShortcutInfo, title: String?) {
        info.setTitle(context, title)
    }

    override fun setIcon(info: ShortcutInfo, entry: IconPackManager.CustomIconEntry?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var INSTANCE: ShortcutInfoProvider? = null

        fun getInstance(context: Context): ShortcutInfoProvider {
            if (INSTANCE == null) {
                INSTANCE = ShortcutInfoProvider(context.applicationContext)
            }
            return INSTANCE!!
        }
    }
}