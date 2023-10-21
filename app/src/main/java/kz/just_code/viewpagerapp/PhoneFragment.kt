package kz.just_code.viewpagerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.just_code.viewpagerapp.databinding.FragmentPhoneBinding

class PhoneFragment(private val phoneType: PhoneType?) : Fragment() {
    private lateinit var binding: FragmentPhoneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        phoneType?.let {
            binding.image.setImageResource(it.image)
            binding.title.text = getString(it.title)
        }
    }
}