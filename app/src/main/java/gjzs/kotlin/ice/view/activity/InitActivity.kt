package gjzs.kotlin.ice.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import gjzs.kotlin.ice.R
import kotlin.concurrent.thread

class InitActivity: AppCompatActivity() {

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
        thread {
            addInfo("init start")
            for (i in 1..100) {
                addInfo("init ${i shl i} ${i shl i}")
                Thread.sleep(50)
            }
            Thread.sleep(1000)
            addInfo("init end")
            Thread.sleep(1000)
            startActivity(Intent(this@InitActivity, MainActivity::class.java))
            finish()
        }
    }

}