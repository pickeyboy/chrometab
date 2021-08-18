package com.example.myapplication

import android.content.ActivityNotFoundException
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            try {
                val openUrl =
                    "javascript:    var targetUrl = 'https://www.google.com';    var params = {'token' : 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9'};    var submitForm = document.createElement('form');    submitForm.method='post';    submitForm.action = targetUrl;    for (var param in params) {        var inputValues = document.createElement('input');        inputValues.setAttribute('type', 'text');        inputValues.setAttribute('name', param);        inputValues.setAttribute('value', params[param]);        submitForm.appendChild(inputValues);    }    document.body.appendChild(submitForm);    submitForm.submit();    document.body.removeChild(submitForm);"
                val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
                builder.build().launchUrl(requireContext(), Uri.parse(openUrl))
            } catch (e: ActivityNotFoundException) {
                Log.e("CustomTab", "There is no browser to open the link")
            }
        }
    }
}