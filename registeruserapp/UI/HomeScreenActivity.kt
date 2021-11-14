package com.example.registeruserapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registeruserapp.Model.HomePage
import com.example.registeruserapp.R
import com.example.registeruserapp.SliderAdapter
import com.example.registeruserapp.databinding.ActivityHomeScreenBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

import com.smarteist.autoimageslider.SliderView




class HomeScreenActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images= listOf(
            HomePage("https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.ytimg.com%2Fvi%2FyQ47FT4DlEU%2Fmaxresdefault.jpg&imgrefurl=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DyQ47FT4DlEU&tbnid=0O50xtJXm8fsuM&vet=12ahUKEwji45rWxZf0AhWSwoUKHY3zDUEQMygCegUIARCyAQ..i&docid=c3r2AfzqrWnV-M&w=1280&h=720&itg=1&q=beautiful%20african%20women&ved=2ahUKEwji45rWxZf0AhWSwoUKHY3zDUEQMygCegUIARCyAQ"),
            HomePage("https://www.google.com/imgres?imgurl=https%3A%2F%2Fafrogistmedia.com%2Fwp-content%2Fuploads%2F2021%2F06%2FWhich-10-African-countries-have-the-most-beautiful-girls.jpg&imgrefurl=https%3A%2F%2Fafrogistmedia.com%2Fthese-10-african-countries-have-the-most-beautiful-women&tbnid=HYUunBC8lpG0NM&vet=12ahUKEwji45rWxZf0AhWSwoUKHY3zDUEQMygGegUIARC7AQ..i&docid=6obQadFUWKqyEM&w=1137&h=1200&itg=1&q=beautiful%20african%20women&ved=2ahUKEwji45rWxZf0AhWSwoUKHY3zDUEQMygGegUIARC7AQ"),
            HomePage("https://www.google.com/imgres?imgurl=https%3A%2F%2Fi1.wp.com%2Fwww.fashionghana.com%2Fwp-content%2Fuploads%2F2018%2F11%2FScreenshot_20181123-195823.png&imgrefurl=https%3A%2F%2Fwww.fashionghana.com%2Fsite%2Fsee-images-of-beautiful-african-women-that-served-viral-bride-squad-goals%2F&tbnid=nJgFHkO00TAKAM&vet=12ahUKEwji45rWxZf0AhWSwoUKHY3zDUEQMyg4egQIARAz..i&docid=GnVzYavlaqCpUM&w=1200&h=800&itg=1&q=beautiful%20african%20women&ved=2ahUKEwji45rWxZf0AhWSwoUKHY3zDUEQMyg4egQIARAz"),
            HomePage("https://www.google.com/imgres?imgurl=https%3A%2F%2Fimg.pixers.pics%2Fpho_wat(s3%3A700%2FFO%2F26%2F65%2F63%2F56%2F700_FO26656356_2bdb22c97bcc24851ab794563b722c5c.jpg%2C700%2C467%2Ccms%3A2018%2F10%2F5bd1b6b8d04b8_220x50-watermark.png%2Cover%2C480%2C417%2Cjpg)%2Fstickers-beautiful-african-woman-with-natural-make-up-laughing.jpg.jpg&imgrefurl=https%3A%2F%2Fpixers.hk%2Fstickers%2Fbeautiful-african-woman-with-natural-make-up-laughing-26656356&tbnid=_OS4bBBzrUf4vM&vet=10CLUBEDMosAFqFwoTCLDokZTGl_QCFQAAAAAdAAAAABAC..i&docid=YOf2nfmygKzuZM&w=700&h=467&itg=1&q=beautiful%20african%20women&ved=0CLUBEDMosAFqFwoTCLDokZTGl_QCFQAAAAAdAAAAABAC"),
        )
//
//   sliderView = findViewById(R.id.image_item);
//
//  var  sliderAdapter: SliderAdapter=new SliderAdapter(images);
//
// sliderView.setSliderAdapter(SliderAdapter);
//   sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
//    sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
//    sliderView.startAutoCycle();

}
}
