package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

// Головний клас активності, який відкривається при запуску додатку
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        //val rolButton2: Button = findViewById(R.id.button5)

        rollButton.setOnClickListener { rollDice() }
        //rolButton2.setOnClickListener{ rollDice2() }
    }
// Визначаємо функцію, в якій рандомно обираємо кількість позначок на кубику
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        val resultImageView:ImageView = findViewById(R.id.imageView2)
        val resultImageView2:ImageView = findViewById(R.id.imageView3)

        // Використовуємо оператор when для вибору ідентифікатору ресурсу зображення ,
    // виходячи з числа, яке випало у функції roll
        val drawableResource = when(diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        val drawableResource2 = when(diceRoll2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        //Обираємо ресурс зображення, виходячи зі змінної drawableResource  для 1 кубика
        resultImageView.setImageResource(drawableResource)

        // Змінюємо опис файлу ImageView, виходячи з числа, яке випало на кубику 1
        resultImageView.contentDescription = diceRoll.toString()

    //Обираємо ресурс зображення, виходячи зі змінної drawableResource2  для 2 кубика
        resultImageView2.setImageResource(drawableResource2)

    // Змінюємо опис файлу ImageView, виходячи з числа, яке випало на кубику 2
        resultImageView2.contentDescription = diceRoll2.toString()
    }
//    private fun rollDice2() {
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//        val resultImageView:ImageView = findViewById(R.id.imageView3)
//        val drawableResource = when(diceRoll){
//            1->R.drawable.dice_1
//            2->R.drawable.dice_2
//            3->R.drawable.dice_3
//            4->R.drawable.dice_4
//            5->R.drawable.dice_5
//            else->R.drawable.dice_6
//        }
//        resultImageView.setImageResource(drawableResource)
//        resultImageView.contentDescription = diceRoll.toString()
//    }
}
// Клас, який визначає функцію roll , яка рандомно обирає числа від 1 до 6
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}