package gjzs.kotlin.ice.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.topjohnwu.superuser.Shell
import gjzs.kotlin.ice.R

class InitActivity: AppCompatActivity() {

    init {
        Shell.setDefaultBuilder(
            Shell.Builder.create()
                .setFlags(Shell.FLAG_REDIRECT_STDERR)
                .setTimeout(10)
        )
    }

    private lateinit var infoText: TextView

    private fun addInfo(info: String) {
        runOnUiThread {
            infoText.append(info)
            infoText.append("\n")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)
        infoText = findViewById(R.id.splash_info)

        Shell.getShell { shell ->
            if (shell.isRoot) {
                addInfo("成功获取root权限")
                gotoMain()
            } else {
                addInfo("获取root权限失败")
            }
        }
    }
    
    private fun gotoMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}