package com.famous.primeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.famous.primeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.processBtn.setOnClickListener{
            var xEdit = binding.xEdit.text.toString().toInt()
            val yEdit = binding.yEdit.text.toString().toInt()

            if (xEdit > 1 || yEdit > 1) {
                if (xEdit < yEdit){

                    while (xEdit < yEdit) {
                        var flag = false

                        for (i in xEdit..yEdit ) {
                            // condition for nonprime number
                            if (xEdit % i == 0) {
                                flag = true
                                break
                            }
                        }

                        if (!flag)
                            binding.textView2.text = xEdit.toString()

                        ++xEdit
                    }
                }else{
                    Toast.makeText(this, "Value of X must be greater than Y", Toast.LENGTH_LONG).show()
                }

                //if it meet the requirement then proceed to this step
             }else{
                Toast.makeText(this, "Value must be greater than 1", Toast.LENGTH_LONG).show()
                return@setOnClickListener

            }
        }
    }
}