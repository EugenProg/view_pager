package kz.just_code.viewpagerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kz.just_code.viewpagerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList: MutableList<Fragment> = mutableListOf()
        PhoneType.values().forEach {
            fragmentList.add(PhoneFragment(it))
        }
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, fragmentList)

        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = fragmentList.size / 2
        binding.viewPager.setPageTransformer(ZoomTransformer())

        //binding.viewPager.setPageTransformer(CarouselTransformer())

       // binding.viewPager.setPageTransformer(GalleryTransformer())
       // binding.viewPager.isUserInputEnabled = false
        binding.viewPager.offscreenPageLimit = 1

        TabLayoutMediator(binding.topTab, binding.viewPager) { tab, position ->
            tab.text = getString(PhoneType.values()[position].title)
        }.attach()

        TabLayoutMediator(binding.bottomTab, binding.viewPager) { tab, _ ->
            tab.view.isClickable = false
        }.attach()
    }
}